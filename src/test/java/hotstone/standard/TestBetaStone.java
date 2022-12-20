package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.factories.BetaStoneFactory;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.framework.Hero;

import org.junit.jupiter.api.*;
import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static hotstone.standard.GameConstants.DOS_CARD;
import static hotstone.standard.GameConstants.TRES_CARD;
import static hotstone.standard.GameConstants.UNO_CARD;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import hotstone.framework.Game;

public class TestBetaStone {
    private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame(new BetaStoneFactory());
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
  public void shouldReturnNullForWinner() {
    assertThat(game.getWinner(), nullValue());
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

  @Test
  public void shoudldReturnOKPlayCard() {
    // Idk why I couldnt use a for loop here?? Would error
    for (int i = 0; i < 6; i++) {
        game.endTurn();
    }

    Player pl = game.getPlayerInTurn();
    assertThat(game.playCard(pl, game.getCardInHand(pl, 0) ), is(Status.OK));
  }  

  public void shouldUsePower(){
    Status result1 = game.usePower(PEDDERSEN);
    Status result2 = game.usePower(FINDUS);

    assertThat(result1, is(Status.NOT_PLAYER_IN_TURN));
    assertThat(result2, is(Status.OK));
  }
}
