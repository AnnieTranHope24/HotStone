package hotstone.standard.cards.cardeffects;

import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;

public class BrownRiceEffect implements CardEffect {
    
    private static final int DAMAGE = -1;
    
    @Override
    public void useEffect(GameMutator game) {
        HeroMutator opponent = game.getTarget();
        opponent.changeHealth(DAMAGE);
    }
}
