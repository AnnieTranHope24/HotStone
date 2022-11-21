package hotstone.standard.cards.cardeffects;

import static hotstone.framework.Player.FINDUS;

import java.util.ArrayList;
import java.util.List;

import hotstone.framework.Card;
import hotstone.standard.cards.CardMutator;
import hotstone.standard.game.GameMutator;

public class BeefBurgerEffect implements CardEffect {

    private static final int ATTACK_INCREMENT = 2;
    
    @Override
    public void useEffect(GameMutator game) {
        List <Card> newOpponentCards = new ArrayList<>();
        for(Card card : game.getField(FINDUS)){
            if(card.getOwner() == game.getTarget().getOwner()){
                newOpponentCards.add(card);
            }
        }
        if(!newOpponentCards.isEmpty()){
            int fieldSize = game.getFieldSize(FINDUS);
            int randomIndex = (int)(Math.random() * fieldSize) + 0;
            CardMutator c = ((CardMutator)newOpponentCards.get(randomIndex));
            c.changeAttack(ATTACK_INCREMENT);
            }        
    }
}
