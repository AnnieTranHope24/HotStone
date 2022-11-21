package hotstone.standard.hero.herobuilder;

import static hotstone.framework.Player.FINDUS;

import hotstone.framework.Player;
import hotstone.standard.hero.heropower.DanishChef;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.hero.heropower.ThaiChef;

public class GammaStoneHeroBuilder implements HeroBuilder{

    @Override
    public HeroPower generateHeroPower(Player player) {
        if(player == FINDUS){
            return new ThaiChef();
        }
        
        return new DanishChef();
    }
    
}
