package hotstone.standard.hero.heropower;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static hotstone.framework.Status.NOT_ENOUGH_MANA;
import static hotstone.framework.Status.NOT_PLAYER_IN_TURN;
import static hotstone.framework.Status.OK;
import static hotstone.standard.GameConstants.HERO_POWER_COST;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Status;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.factories.GammaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.standard.hero.HeroMutator;
import hotstone.standard.mana.AlphaStoneManaManipulator;
import hotstone.standard.hero.HeroImpl;

public class TestThaiChef {
    private static final int DAMAGE_AMOUNT = 2;
    private static final String HERO_NAME = "Thai Chef";
    private static final String POWER_NAME = "Chili";
    
    private HeroPower thaiChef;
    private HeroMutator heroMutator1;
    private HeroMutator heroMutator2;

    @BeforeEach
    public void setup() {
        thaiChef = new ThaiChef();
        heroMutator1 = new HeroImpl(FINDUS, 21, new AlphaStoneManaManipulator(), thaiChef, new Field(), new DeckImpl(new Hand(), FINDUS));
        heroMutator2 = new HeroImpl(PEDDERSEN, 21, new AlphaStoneManaManipulator(), thaiChef, new Field(), new DeckImpl(new Hand(), PEDDERSEN));
    }

    @Test
    public void shouldReturnThaiChef() {
        String result = thaiChef.getHeroName();

        assertThat(result, is(HERO_NAME));
    }

    @Test
    public void shouldReturn2() {
        int result = thaiChef.getManaCost();

        assertThat(result, is(HERO_POWER_COST));
    }

    @Test
    public void shouldReturnDamageAmount() {
        int result = thaiChef.getDamgeAmount();

        assertThat(result, is(DAMAGE_AMOUNT));
    }

    @Test
    public void shouldReturnOK() {
        GameMutator game = new StandardHotStoneGame(new GammaStoneFactory());

        int healthBefore = game.getTarget().getHealth();
        int manaBefore = heroMutator1.getMana();
        Status result = thaiChef.usePower(game, heroMutator1);

        assertThat(heroMutator1.getMana(), is(manaBefore - HERO_POWER_COST));
        assertThat(game.getTarget().getHealth(), is(healthBefore - DAMAGE_AMOUNT));
        assertThat(result, is(OK));
    }

    @Test
    public void shouldReturnNotPlayerInTurn() {
        Status result = thaiChef.usePower(new StandardHotStoneGame(new GammaStoneFactory()), heroMutator2);

        assertThat(result, is(NOT_PLAYER_IN_TURN));
    }

    @Test
    public void shouldReturnNotEnoughMana() {
        heroMutator1.dealMana(7);
        Status result = thaiChef.usePower(new StandardHotStoneGame(new GammaStoneFactory()), heroMutator1);

        assertThat(result, is(NOT_ENOUGH_MANA));
    }

    @Test
    public void shouldReturnChili() {
        String result = thaiChef.getPowerName();

        assertThat(result, is(POWER_NAME));
    }
}
