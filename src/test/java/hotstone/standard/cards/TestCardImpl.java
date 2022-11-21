package hotstone.standard.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static hotstone.framework.Player.FINDUS;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.cardeffects.NullCardEffect;

public class TestCardImpl {

    private Card card;
    
    @BeforeEach
    public void setup() {
        this.card = new CardImpl("Uno", 1, 1, 1, false, Player.FINDUS, new NullCardEffect());
    }

    @Test
    public void shouldReturnUnoForCardName() {
        String actual = card.getName();

        assertThat(actual, is("Uno"));
    }

    @Test
    public void shouldReturn1ForManaCost() {
        int actual = card.getManaCost();

        assertThat(actual, is(1));
    }

    @Test
    public void shouldReturn1ForAttack() {
        int actual = card.getAttack();

        assertThat(actual, is(1));
    }

    @Test
    public void shouldReturn1ForHealth() {
        int actual = card.getHealth();

        assertThat(actual, is(1));
    }

    @Test
    public void shouldReturnFalseWhenCardIsNotActive() {
        boolean actual = card.isActive();

        assertThat(actual, is(false));
    }

    @Test
    public void shouldReturnTrueWhenCardIsActive() {
        ((CardImpl) card).setActive(true);
        boolean actual = card.isActive();
        
        assertThat(actual, is(true));
    }

    @Test
    public void shouldReturnFindusForPlayer() {
        Player actual = card.getOwner();

        assertThat(actual, is(FINDUS));
    }

    @Test
    public void shouldDecreaseHealth() {
        int initalHealth = card.getHealth();

        ((CardMutator)card).changeHealth(-1);

        assertThat(card.getHealth(), is(initalHealth-1));
    }

    @Test
    public void shouldIncreaseAttack() {
        int initalAttack = card.getAttack();

        ((CardMutator)card).changeAttack(1);

        assertThat(card.getAttack(), is(initalAttack+1));
    }
}
