package hotstone.standard.cards;

import hotstone.framework.Card;
import hotstone.standard.game.GameMutator;

public interface CardMutator extends Card {
    
    public void changeHealth(int amount);

    public void changeAttack(int amount);

    public void useEffect(GameMutator game);

    public void setActive(boolean isActive);
}
