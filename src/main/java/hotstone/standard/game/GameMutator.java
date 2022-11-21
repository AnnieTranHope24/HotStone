package hotstone.standard.game;

import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.standard.cards.Field;
import hotstone.standard.hero.HeroMutator;

public interface GameMutator extends Game{

    HeroMutator getTarget();
    HeroMutator getHeroM(Player who);
    Field getTheField();

}
