package hotstone.standard.winconditions;

import static hotstone.framework.Player.FINDUS;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class AlphaStoneWinConditionStrategy implements WinConditionStrategy{

    @Override
    public Player getWinner(Hero hero1, Hero hero2) {
        return FINDUS;
    }
}

