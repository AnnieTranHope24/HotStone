package hotstone.standard.cards.cardeffects.cardeffecthandler;

import hotstone.standard.cards.CardImpl;
import hotstone.standard.game.GameMutator;

public class EtaStoneCardEffectHandler implements CardEffectHandler {

    @Override
    public void useEffect(GameMutator game, CardImpl card) {
        card.useEffect(game);
    }
}
