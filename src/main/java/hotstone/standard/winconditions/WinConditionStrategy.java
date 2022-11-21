package hotstone.standard.winconditions;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public interface WinConditionStrategy {

    Player getWinner(Hero hero1, Hero hero2);
}