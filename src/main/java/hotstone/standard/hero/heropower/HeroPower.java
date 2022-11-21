package hotstone.standard.hero.heropower;

import hotstone.framework.Status;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;

public interface HeroPower {

    String getHeroName();

    String getHeroType();

    int getManaCost();

    int getDamgeAmount();

    Status usePower(GameMutator gameMutator, HeroMutator attacker);

    String getPowerName();
}