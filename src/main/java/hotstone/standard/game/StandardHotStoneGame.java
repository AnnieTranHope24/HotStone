/*
 * Copyright (C) 2022. Henrik Bærbak Christensen, Aarhus University.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package hotstone.standard.game;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import hotstone.framework.*;
import hotstone.observer.GameObserver;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.cardeffects.cardeffecthandler.CardEffectHandler;
import hotstone.standard.factories.Factory;
import hotstone.standard.hero.HeroImpl;
import hotstone.standard.hero.HeroMutator;
import hotstone.standard.winconditions.WinConditionStrategy;

/** This is the 'temporary test stub' in TDD
 * terms: the initial empty but compilable implementation
 * of the game interface.
 *
 * It already includes a bit of FAKE-IT code for the first
 * test case about hand management.
 *
 * Start solving the AlphaStone exercise by
 * following the TDD rythm: pick a one-step-test
 * from your test list, quickly add a test,
 * run it to see it fail, and then modify this
 * implementing class (and supporting classes)
 * to make your test case run. Refactor and repeat.
 *
 * While this is the implementation of Game for
 * the AlphaStone game, you will constantly
 * refactor it over the course of the exercises
 * to become the 'core implementation' which will
 * enable a lot of game variants. This is also
 * why it is not called 'AlphaGame'.
 */
public class StandardHotStoneGame implements GameMutator {

  private int turn;
  private HeroMutator hero1;
  private HeroMutator hero2;
  private WinConditionStrategy conditionStrategy;
  private Field field;
  private CardEffectHandler cardEffectHandler;
  // private GameMutator gameMutator;

  public StandardHotStoneGame(Factory factory) {
    this.conditionStrategy = factory.getConditionStrategy();
    this.turn = 0;
    this.field = new Field();
    this.cardEffectHandler = factory.getCardEffectHandler();

    hero1 = new HeroImpl(FINDUS, 21, factory.getManaManipulatorStrategy(), factory.getHeroPower(FINDUS), field, factory.getDeck(FINDUS));
    hero2 = new HeroImpl(PEDDERSEN, 21, factory.getManaManipulatorStrategy(), factory.getHeroPower(PEDDERSEN), field, factory.getDeck(PEDDERSEN));
  }

  @Override
  public Player getPlayerInTurn() {
    if (turn % 2 == 0) {
      return FINDUS;
    } else {
      return PEDDERSEN;
    }
  }

  @Override
  public Hero getHero(Player who) {
      if(who == FINDUS) return hero1;
      else return hero2;
    }
  //this method returns a HeroMutator so that
  //we can access the mutator methods
  public HeroMutator getHeroM(Player who){
    if(who == FINDUS) return hero1;
    else return hero2;    
  }

  @Override
  public Player getWinner() {
    return conditionStrategy.getWinner(hero1, hero2);
  }

  @Override
  public int getTurnNumber() {
    return turn;
  }

  @Override
  public int getDeckSize(Player who) {
    return getHeroM(who).getDeckSize();
  }

  @Override
  public Card getCardInHand(Player who, int indexInHand) {
    return getHeroM(who).getCardInHand(indexInHand);
  }

  @Override
  public Iterable<? extends Card> getHand(Player who) {
    return getHeroM(who).getHand();
  }

  @Override
  public int getHandSize(Player who) {
    return getHeroM(who).getHandSize();
  }

  @Override
  public Card getCardInField(Player who, int indexInField) {
    return getHeroM(who).getCardInField(indexInField);
  }

  @Override
  public Iterable<? extends Card> getField(Player who) {
    return getHeroM(who).getField();
    
  }

  @Override
  public int getFieldSize(Player who) {
    return getHeroM(who).getFieldSize();
  }

  @Override
  public void endTurn() {
    HeroMutator hero = getHeroM(getPlayerInTurn());
    hero.dealCard();
    hero.setManaAtBeginningOfTurn(this.turn);
    //set all the cards in field of the player in next turn to be active
    //and the cards in field of the current player in turn to be inactive
    for(Card card : getField(Player.FINDUS)){
      if(card.getOwner()!=getPlayerInTurn()){
        ((CardImpl) card).setActive(true);
      }
      else{
        ((CardImpl) card).setActive(false);
      }
      
  }    
    turn++;
  }

  @Override
  public Status playCard(Player who, Card card) {
    if(card.getOwner()!=who) {
      return Status.NOT_OWNER;
    }

    if(getPlayerInTurn() != who) {
      return Status.NOT_PLAYER_IN_TURN;
    }

    HeroMutator hero = getHeroM(who);
    if(hero.getMana() >= card.getManaCost()) {
      hero.playCard(card);
      cardEffectHandler.useEffect(this, (CardImpl)card);
      return Status.OK;
    }

    return Status.NOT_ENOUGH_MANA;
  }

  @Override
  public Status attackCard(Player playerAttacking, Card attackingCard, Card defendingCard) {
    HeroMutator hero = getHeroM(playerAttacking);
    if(attackingCard.getOwner() != playerAttacking){
      return Status.NOT_OWNER;
    }
    if(getPlayerInTurn() != playerAttacking){
      return Status.NOT_PLAYER_IN_TURN;
    }
    if(!attackingCard.isActive()){
      return Status.ATTACK_NOT_ALLOWED_FOR_NON_ACTIVE_MINION;
    }
    if(defendingCard.getOwner() == playerAttacking){
      return Status.ATTACK_NOT_ALLOWED_ON_OWN_MINION;
    }

    ((CardImpl) defendingCard).changeHealth(-attackingCard.getAttack());
    ((CardImpl) attackingCard).setActive(false);
    ((CardImpl) attackingCard).changeHealth(-defendingCard.getAttack());
    if(((CardImpl) defendingCard).getHealth()<=0){
      hero.removeCardFromField(defendingCard);
    }
    if(((CardImpl) attackingCard).getHealth()<=0){
      hero.removeCardFromField(attackingCard);
    }
    return Status.OK;
  }

  @Override
  public Status attackHero(Player playerAttacking, Card attackingCard) {
    if(attackingCard.getOwner() != playerAttacking){
      return Status.NOT_OWNER;
    }
    if(getPlayerInTurn() != playerAttacking){
      return Status.NOT_PLAYER_IN_TURN;
    }
    if(!attackingCard.isActive()){
      return Status.ATTACK_NOT_ALLOWED_FOR_NON_ACTIVE_MINION;
    }
    Player defender;
    if(playerAttacking == FINDUS){
      defender = PEDDERSEN;
    }
    else{
      defender = FINDUS;
    }
    HeroMutator heroDefender = getHeroM(defender);
    heroDefender.changeHealth(-attackingCard.getAttack());
    return Status.OK;
  }

  @Override
  public HeroMutator getTarget() {
    if(getPlayerInTurn() == FINDUS){
      return hero2;
    } else {
      return hero1;
    }
  }

  @Override
  public Status usePower(Player who) {
    HeroMutator attacker = getHeroM(who) ;
    
    return attacker.usePower(this, attacker );
  }

  @Override
  public void addObserver(GameObserver observer) {
    
  }
  @Override
  public Field getTheField(){
    return field;
  }
}
