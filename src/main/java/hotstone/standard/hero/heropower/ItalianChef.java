package hotstone.standard.hero.heropower;

import hotstone.framework.Card;
import hotstone.framework.Status;
import hotstone.standard.game.GameMutator;
import hotstone.standard.cards.CardMutator;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Status.NOT_ENOUGH_MANA;
import static hotstone.framework.Status.NOT_PLAYER_IN_TURN;
import static hotstone.framework.Status.OK;
import static hotstone.standard.GameConstants.HERO_POWER_COST;
import static hotstone.standard.GameConstants.ITALIAN_CHEF_HERO_TYPE;

import java.util.ArrayList;
import java.util.List;

import hotstone.standard.hero.HeroMutator;

public class ItalianChef implements HeroPower {
    private static final String HERO_NAME = "Italian Chef";
    private static final String POWER_NAME = "Pasta";
    private static final int INCREASE_ATTACK_AMOUNT = 2;

    @Override
    public String getHeroName() {
        return HERO_NAME;
    }

    @Override
    public String getHeroType() {
        return ITALIAN_CHEF_HERO_TYPE;
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
            return NOT_PLAYER_IN_TURN;
        }
        if(attacker.getMana() < getManaCost()) {
            return NOT_ENOUGH_MANA;
        }

        List<Card> attackersCards = new ArrayList<>();

        for (Card card : gameMutator.getField(FINDUS)) {
            if (card.getOwner() == attacker.getOwner()) {
                attackersCards.add(card);
            }
        }

        if(!attackersCards.isEmpty()) {
            int randomIndex = (int)(Math.random() * attackersCards.size()) + 0;
            ((CardMutator)attackersCards.get(randomIndex)).changeAttack(INCREASE_ATTACK_AMOUNT);
        }
    
        return OK;
    }

    @Override
    public String getPowerName() {
        return POWER_NAME;
    }
    
}
