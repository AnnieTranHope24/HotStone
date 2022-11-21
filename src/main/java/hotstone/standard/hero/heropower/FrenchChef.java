package hotstone.standard.hero.heropower;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;
import static hotstone.standard.GameConstants.FRENCH_CHEF_HERO_TYPE;
import static hotstone.standard.GameConstants.HERO_POWER_COST;
import hotstone.standard.cards.CardMutator;

import java.util.ArrayList;
import java.util.List;;

public class FrenchChef implements HeroPower{
    private static final String HERO_NAME = "French Chef";
    private static final String POWER_NAME = "Redwine";

    @Override
    public String getHeroName() {
        return HERO_NAME;
    }

    @Override
    public String getHeroType() {
        return FRENCH_CHEF_HERO_TYPE;
    }

    @Override
    public int getManaCost() {
        return HERO_POWER_COST;
    }

    @Override
    public int getDamgeAmount() {
        return 0;
    }

    @Override
    public Status usePower(GameMutator gameMutator, HeroMutator attacker) {
        if(!attacker.isActive()) {
            return Status.NOT_PLAYER_IN_TURN;
        }
        if(attacker.getMana() < getManaCost()) {
            return Status.NOT_ENOUGH_MANA;
        }    
        List <Card> newopponentCards = new ArrayList<>();
        for(Card card : gameMutator.getField(Player.FINDUS)){
            if(card.getOwner() == gameMutator.getTarget().getOwner()){
                newopponentCards.add(card);
            }
        }
        if(!newopponentCards.isEmpty()){
            int fieldSize = gameMutator.getFieldSize(attacker.getOwner());
            int randomIndex = (int)(Math.random() * fieldSize) + 0;
            CardMutator c = ((CardMutator)newopponentCards.get(randomIndex));
            c.changeHealth(-2);
            if(c.getHealth() <= 0){
                attacker.removeCardFromField(c);
            }
          
        }



        return Status.OK;
    }

    @Override
    public String getPowerName() {
        return POWER_NAME;
    }
    
}
