package hotstone.standard.hero.herobuilder;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.hero.heropower.FrenchChef;
import hotstone.standard.hero.heropower.ItalianChef;
import hotstone.standard.hero.heropower.HeroPower;

public class TestEpsilonStoneHeroBuilder {
    
    private HeroBuilder heroBuilder;

    @BeforeEach
    public void setup() {
        heroBuilder = new EpsilonStoneHeroBuilder();
    }

    @Test
    public void shouldReturnBaby() {
        HeroPower result1 = heroBuilder.generateHeroPower(FINDUS);
        HeroPower result2 = heroBuilder.generateHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof FrenchChef);
        assertTrue(result2 instanceof ItalianChef);
    }

}
