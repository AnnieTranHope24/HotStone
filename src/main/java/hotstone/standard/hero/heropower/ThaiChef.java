package hotstone.standard.hero.heropower;

import static hotstone.framework.Status.NOT_ENOUGH_MANA;
import static hotstone.framework.Status.NOT_PLAYER_IN_TURN;
import static hotstone.standard.GameConstants.HERO_POWER_COST;
import static hotstone.standard.GameConstants.THAI_CHEF_HERO_TYPE;

import hotstone.framework.Status;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.HeroMutator;

public class ThaiChef implements HeroPower{
    private static final int DAMAGE_AMOUNT = 2;
    private static final String HERO_NAME = "Thai Chef";
    private static final String POWER_NAME = "Chili";

    @Override
    public String getHeroName() {
        return HERO_NAME;
    }

    @Override
    public int getManaCost() {
        return HERO_POWER_COST;
    }

    @Override
    public String getHeroType() {
        return THAI_CHEF_HERO_TYPE;
    }

    @Override
    public int getDamgeAmount() {
        return DAMAGE_AMOUNT;
    }

    @Override
    public String getPowerName() {
        return POWER_NAME;
    }

    @Override
    public Status usePower(GameMutator gameMutator, HeroMutator attacker) {
        if(!attacker.isActive()) {
            return NOT_PLAYER_IN_TURN;
        }
        if(attacker.getMana() < getManaCost()) {
            return NOT_ENOUGH_MANA;
        }

        gameMutator.getTarget().dealDamage(getDamgeAmount());
        attacker.dealMana(getManaCost());
        return Status.OK;
    }

}
