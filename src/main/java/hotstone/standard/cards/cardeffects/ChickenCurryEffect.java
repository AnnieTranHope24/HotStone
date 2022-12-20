package hotstone.standard.cards.cardeffects;

import static hotstone.framework.Player.FINDUS;
import static java.lang.Math.random;

import java.util.ArrayList;
import java.util.List;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.CardMutator;
import hotstone.standard.game.GameMutator;
public class ChickenCurryEffect implements CardEffect {
    
    @Override
    public void useEffect(GameMutator game) {
        List <Card> newopponentCards = new ArrayList<>();
        for(Card card : game.getField(FINDUS)){
            if(card.getOwner() == game.getTarget().getOwner()){
                newopponentCards.add(card);
            }
        }
        if(!newopponentCards.isEmpty()){
            int fieldSize = game.getFieldSize(FINDUS);
            int randomIndex = (int)(random() * fieldSize) + 0;
            CardMutator c = ((CardMutator)newopponentCards.get(randomIndex));
            int opponentCardHealth = c.getHealth();
            c.changeHealth(opponentCardHealth*(-1));
            Player player = game.getPlayerInTurn();
            game.getHeroM(player).removeCardFromField(c);;
        } 
    }
}
