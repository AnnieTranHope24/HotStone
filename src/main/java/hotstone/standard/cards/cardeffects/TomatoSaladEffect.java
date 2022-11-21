package hotstone.standard.cards.cardeffects;

import static hotstone.framework.Player.FINDUS;

import java.util.ArrayList;
import java.util.List;

import hotstone.framework.Card;
import hotstone.standard.cards.CardMutator;
import hotstone.standard.game.GameMutator;

public class TomatoSaladEffect implements CardEffect {

    private static final int ATTACK_INCREMENT = 1;
    
    @Override
    public void useEffect(GameMutator game) {
        List <Card> newAttackerCards = new ArrayList<>();
        for(Card card : game.getField(FINDUS)){
            if(card.getOwner() != game.getTarget().getOwner()){
                newAttackerCards.add(card);
            }
        }
        if(!newAttackerCards.isEmpty()){
            int fieldSize = game.getFieldSize(FINDUS);
            int randomIndex = (int)(Math.random() * fieldSize) + 0;
            CardMutator c = ((CardMutator)newAttackerCards.get(randomIndex));
            c.changeAttack(ATTACK_INCREMENT);
            }        
    }
}
