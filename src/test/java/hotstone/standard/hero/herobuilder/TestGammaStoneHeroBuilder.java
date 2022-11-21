package hotstone.standard.hero.herobuilder;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.hero.heropower.DanishChef;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.hero.heropower.ThaiChef;

public class TestGammaStoneHeroBuilder {

    private HeroBuilder heroBuilder;

    @BeforeEach
    public void setup() {
        heroBuilder = new GammaStoneHeroBuilder();
    }

    @Test
    public void shouldReturnBaby() {
        HeroPower result1 = heroBuilder.generateHeroPower(FINDUS);
        HeroPower result2 = heroBuilder.generateHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof ThaiChef);
        assertTrue(result2 instanceof DanishChef);
    }
}
