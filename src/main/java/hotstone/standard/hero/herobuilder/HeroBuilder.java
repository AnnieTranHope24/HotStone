package hotstone.standard.hero.herobuilder;

import hotstone.framework.Player;
import hotstone.standard.hero.heropower.HeroPower;

public interface HeroBuilder {

    HeroPower generateHeroPower(Player player);
    
}
