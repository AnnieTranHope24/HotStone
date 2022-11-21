package hotstone.standard.cards.cardeffects;

import hotstone.framework.Hero;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;

public class PokeBowlEffect implements CardEffect {

    private static final int HEALTH_INCREMENT = 2;
    
    @Override
    public void useEffect(GameMutator game) {
        Hero activeHero = game.getHero(game.getPlayerInTurn());

        ((HeroMutator) activeHero).changeHealth(HEALTH_INCREMENT);
    }
}
