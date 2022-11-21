package hotstone.standard.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Player;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.mana.AlphaStoneManaManipulator;

import static hotstone.framework.Player.PEDDERSEN;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHeroImpl {
    private static final String HERO_BABY_TYPE = "Baby";
    
    private HeroImpl hero;

    /** Fixture for HeroImpl testing. */
    @BeforeEach
    public void setup() {   
        hero = new HeroImpl(PEDDERSEN, 21, new AlphaStoneManaManipulator(), new Baby(), new Field(), new DeckImpl(new Hand(), PEDDERSEN));
    }

    @Test
    public void shouldHave3ManaInitially() {
        int actual = hero.getMana();

        assertThat(actual, is(3));
    }

    @Test
    public void shouldHaveMaximumHealthInitially() {
        int actual = hero.getHealth();

        assertThat(actual, is(21));
    }


    @Test
    public void shouldReturnTrueWhenIsPlayersTurn() {
        boolean actual = hero.isActive();

        assertThat(actual, is(false));
    }

    @Test
    public void shouldReturnBabyForHeroType() {
        String actual = hero.getType();

        assertThat(actual, is(HERO_BABY_TYPE));
    }

    @Test
    public void shouldReturnPeddersenWhenPlayerIsPeddersen() {
        Player actual = hero.getOwner();

        assertThat(actual, is(Player.PEDDERSEN));
    }

    // @Test
    // public void shouldReturnOK(){
    //     hero.setActive();
    //     Status status = hero.usePower();
    //     assertThat(status, is(Status.OK));
    // }

    // @Test
    // public void shouldReturnPlayerNotInTurn(){
    //     Status status = hero.usePower();
    //     assertThat(status, is(Status.NOT_PLAYER_IN_TURN));
    // } 

    // @Test
    // public void shouldReturnNotEnoughMana(){
    //     hero.setActive();
    //     hero.setMana(3);
    //     Status status = hero.usePower();
    //     assertThat(status, is(Status.NOT_ENOUGH_MANA));
    // }

    // @Test
    // public void shouldReturnPeddersonWhenPlayerIsPedderson() {
    //     Player actual = hero.getOwner();

    //     assertThat(actual, is(Player.PEDDERSEN));
    // }
}
