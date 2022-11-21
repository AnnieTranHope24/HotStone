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

package hotstone.standard;

/**
 * Skeleton class for AlphaStone test cases
 *
 *    This source code is from the book
 *      "Flexible, Reliable Software:
 *        Using Patterns and Agile Development"
 *      2nd Edition
 *    Author:
 *      Henrik Bærbak Christensen
 *      Department of Computer Science
 *      Aarhus University
 */

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.factories.AlphaStoneFactory;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.framework.Hero;
import hotstone.standard.cards.cardeffects.NullCardEffect;

import org.junit.jupiter.api.*;
import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static hotstone.standard.GameConstants.DOS_CARD;
import static hotstone.standard.GameConstants.TRES_CARD;
import static hotstone.standard.GameConstants.UNO_CARD;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import hotstone.framework.Game;

/** Template for your own ongoing TDD process.
 * Fill it out until you have covered all
 * requirements for the alpha stone game.
 */
public class TestAlphaStone {
  private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame(new AlphaStoneFactory());
  }

  @Test
  public void shouldReturnFindusForTurn0() {
    Player actual = game.getPlayerInTurn();
    assertThat(actual, is(FINDUS));
  }

  @Test
  public void shouldReturnPeddersenForTurn1() {
    game.endTurn();
    Player actual = game.getPlayerInTurn();
    assertThat(actual, is(PEDDERSEN));
  }

  @Test
  public void shouldReturnRightHero() {
    Hero hero1 = game.getHero(FINDUS);
    Hero hero2 = game.getHero(PEDDERSEN);
    assertThat(hero1.getOwner(), is(FINDUS));
    assertThat(hero2.getOwner(), is(PEDDERSEN));
  }

  @Test
  public void shouldReturnFindusForWinner() {
    assertThat(game.getWinner(), is(FINDUS));
  }

  @Test
  public void shouldReturnZeroForInitialTurn() {
    assertThat(game.getTurnNumber(), is(0));
  }

  @Test
  public void shouldReturnOneForSecondTurn(){
    game.endTurn();
    assertThat(game.getTurnNumber(), is(1));
  }

  @Test
  public void shouldReturnDeckSize4Initially() {
    assertThat(game.getDeckSize(FINDUS), is(4));
    assertThat(game.getDeckSize(PEDDERSEN), is(4));
  }
  
  @Test
  public void shouldReturnTres(){
    Card card = game.getCardInHand(PEDDERSEN, 0);

    assertThat(card.getName(), is(TRES_CARD));
  }

  @Test
  public void shouldReturnDos(){
    Card card = game.getCardInHand(PEDDERSEN, 1);

    assertThat(card.getName(), is(DOS_CARD));
  }

  @Test
  public void shouldReturnUno(){
    Card card = game.getCardInHand(PEDDERSEN, 2);

    assertThat(card.getName(), is(UNO_CARD));
  }

  /*
   * 
   * Need to make this more specific!!
   * 
   */
  @Test
  public void shouldReturnHandWithThreeCards() {
    Iterable<? extends Card> result = game.getHand(FINDUS);

    assertThat(result, notNullValue());
  }

  @Test
  public void shouldReturnHandSizeOfThreeInitially() {
    int handSizeF = game.getHandSize(FINDUS);
    int handSizeP = game.getHandSize(PEDDERSEN);

    assertThat(handSizeF, is(3));
    assertThat(handSizeP, is(3));
  }

  @Test
  public void shouldReturnFieldWithNoCardsIntially() {
    Iterable<? extends Card> result = game.getField(FINDUS);

    assertThat(result, notNullValue());
  }

  @Test
  public void shouldReturnZeroForFieldSizeInitially(){
    int result = game.getFieldSize(FINDUS);

    assertThat(result, is(0));
  }

  @Test
  public void shoudldEndTurn() {
    int before = game.getTurnNumber();
    game.endTurn();

    assertThat(game.getTurnNumber(), is(before+1));
  }
  //Start tests for playCard()
  @Test
  public void shoudldReturnOKPlayCard() {
    Player pl = game.getPlayerInTurn();
    int fieldSizeBefore = game.getFieldSize(pl);

    assertThat(game.playCard(pl, game.getCardInHand(pl, 0) ), is(Status.OK));
    assertThat(game.getFieldSize(pl), is(fieldSizeBefore + 1));
  } 
  //For AlphaStone there's always enough mana to play a card 
  // @Test
  // public void shoudldReturnNotEnoughManaPlayCard() {
  //   Player pl = game.getPlayerInTurn();
  //   Card c = new CardImpl("Hello", 10, 1, 2, false);
  //   assertThat(game.playCard(pl, c ), is(Status.NOT_ENOUGH_MANA));
  // }  
  @Test
  public void shoudldReturnNotOwnerPlayCard() {
    Player pl;
    if(game.getPlayerInTurn() == FINDUS){
      pl = PEDDERSEN;
    }
    else{
      pl=FINDUS;
    }
    Card c = new CardImpl("Hello", 10, 1, 2, false, pl, new NullCardEffect());
    assertThat(game.playCard(game.getPlayerInTurn(), c), is(Status.NOT_OWNER));
  }  
  @Test
  public void shoudldReturnNotPlayerInTurnPlayCard() {

    Player pl;
    if(game.getPlayerInTurn() == FINDUS){
      pl = PEDDERSEN;
    }
    else{
      pl=FINDUS;
    }
    assertThat(game.playCard(pl, game.getCardInHand(pl, 0) ), is(Status.NOT_PLAYER_IN_TURN));
  }  
  //End tests for playCard()

  //Start tests for usePower()
  public void shouldUsePower(){
    Status result1 = game.usePower(PEDDERSEN);
    Status result2 = game.usePower(FINDUS);

    assertThat(result1, is(Status.NOT_PLAYER_IN_TURN));
    assertThat(result2, is(Status.OK));
  }
  //Need to tests if all the cards in field of the player in turn are inactive
  //when the turn ends and the cards in field of the other player 
  //are active for the next turn

  //Need tests for attackCard

  //Need tests for attackHero
}
