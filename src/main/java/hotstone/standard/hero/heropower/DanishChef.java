package hotstone.standard.hero.heropower;

import static hotstone.standard.GameConstants.HERO_POWER_COST;
import static hotstone.framework.Status.NOT_ENOUGH_MANA;
import static hotstone.standard.GameConstants.DANISH_CHEF_HERO_TYPE;

import hotstone.framework.Card;
import hotstone.framework.Status;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;
import hotstone.standard.cards.cardeffects.NullCardEffect;

public class DanishChef implements HeroPower {
    private static final int DAMAGE_AMOUNT = 1;
    private static final String HERO_NAME = "Danish Chef";
    private static final String POWER_NAME = "Sovs";
    private static final int CARD_MANA_COST = 0; 
    private static final int CARD_HEALTH = 1;

    @Override
    public String getHeroName() {
        return HERO_NAME;
    }

    @Override
    public int getManaCost() {
        return HERO_POWER_COST;
    }

    @Override
    public String getPowerName() {
        return POWER_NAME;
    }

    @Override
    public String getHeroType() {
        return DANISH_CHEF_HERO_TYPE;
    }

    @Override
    public int getDamgeAmount() {
        return DAMAGE_AMOUNT;
    }

    @Override
    public Status usePower(GameMutator gameMutator, HeroMutator attacker) {
        if(attacker.getMana() < getManaCost()) {
            return NOT_ENOUGH_MANA;
        }

        attacker.dealMana(getManaCost());  
        Card card = new CardImpl("Sovs", CARD_MANA_COST, DAMAGE_AMOUNT, CARD_HEALTH, attacker.isActive(), attacker.getOwner(), new NullCardEffect());
        attacker.addCardToHand(card);

        return gameMutator.playCard(attacker.getOwner(), card);
    }
}
