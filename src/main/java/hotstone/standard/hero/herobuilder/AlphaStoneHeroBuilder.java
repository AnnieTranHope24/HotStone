package hotstone.standard.hero.herobuilder;

import hotstone.framework.Player;
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.hero.heropower.HeroPower;

public class AlphaStoneHeroBuilder implements HeroBuilder {

    @Override
    public HeroPower generateHeroPower(Player player) {
        return new Baby();
    }
    
}
