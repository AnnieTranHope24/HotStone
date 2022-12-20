package hotstone.standard.cards;

import hotstone.framework.Player;
import hotstone.standard.cards.cardeffects.CardEffect;
import hotstone.standard.game.GameMutator;

public class CardImpl implements CardMutator {
    private String name;
    private int manaCost;
    private int attack;
    private int health;
    private boolean isActive;
    private Player owner;
    private CardEffect cardEffect;
    private boolean isTaunt;
    
    
    //add boolean parameter for taunt attribute?
    public CardImpl(String name, int manaCost, int attack, int health, boolean isActive, Player owner, CardEffect cardEffect){ 
        this.name = name;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.isActive = isActive;
        this.owner = owner;
        this.cardEffect= cardEffect;
    }

    public CardImpl(String name, int manaCost, int attack, int health, boolean isActive, Player owner, CardEffect cardEffect, boolean isTaunt){ 
        this.name = name;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.isActive = isActive;
        this.owner = owner;
        this.cardEffect= cardEffect;
        this.isTaunt = isTaunt;
    }

    public boolean isTaunt() {
        return isTaunt;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
    
    @Override
    public void changeAttack(int amount) {
        this.attack += amount;
    }

    @Override
    public void changeHealth(int amount) {
        this.health += amount;
    }

    public void useEffect(GameMutator game){
        cardEffect.useEffect(game);
    }
}
