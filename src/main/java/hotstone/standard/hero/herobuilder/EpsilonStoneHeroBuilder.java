package hotstone.standard.hero.herobuilder;

import static hotstone.framework.Player.FINDUS;

import hotstone.framework.Player;
import hotstone.standard.hero.heropower.ItalianChef;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.hero.heropower.FrenchChef;

public class EpsilonStoneHeroBuilder implements HeroBuilder {
    
    @Override
    public HeroPower generateHeroPower(Player player) {
        if(player == FINDUS){
            return new FrenchChef();
        }
        
        return new ItalianChef();
    }

}
