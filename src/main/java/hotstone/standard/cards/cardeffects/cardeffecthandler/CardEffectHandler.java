package hotstone.standard.cards.cardeffects.cardeffecthandler;

import hotstone.standard.cards.CardImpl;
import hotstone.standard.game.GameMutator;

public interface CardEffectHandler {

    void useEffect(GameMutator game, CardImpl card);
}
