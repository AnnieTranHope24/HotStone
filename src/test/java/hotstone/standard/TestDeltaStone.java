package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.factories.DeltaStoneFactory;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.framework.Hero;
import hotstone.standard.cards.cardeffects.NullCardEffect;

import org.junit.jupiter.api.*;
import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import hotstone.framework.Game;

public class TestDeltaStone {
    private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame(new DeltaStoneFactory());
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
  public void shouldReturnDeckSize18Initially() {
    assertThat(game.getDeckSize(FINDUS), is(18));
    assertThat(game.getDeckSize(PEDDERSEN), is(18));
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
    assertThat(game.playCard(pl, game.getCardInHand(pl, 0) ), is(Status.OK));
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

  
}
