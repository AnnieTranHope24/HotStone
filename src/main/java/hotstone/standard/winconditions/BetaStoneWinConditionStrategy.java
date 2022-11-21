package hotstone.standard.winconditions;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class BetaStoneWinConditionStrategy implements WinConditionStrategy {

    @Override
    public Player getWinner(Hero hero1, Hero hero2) {
        if(hero1.getHealth() == 0) return hero2.getOwner();
        else if (hero2.getHealth() == 0) return hero1.getOwner();
        else return null;
    }
    
}
