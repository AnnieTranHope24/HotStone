package hotstone.standard.cards.cardeffects;

import hotstone.framework.Hero;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;

public class NoodleSoupEffect implements CardEffect {
    
    @Override
    public void useEffect(GameMutator game) {
        HeroMutator hero = game.getHeroM(game.getPlayerInTurn());
        hero.dealCard();

    }
}
