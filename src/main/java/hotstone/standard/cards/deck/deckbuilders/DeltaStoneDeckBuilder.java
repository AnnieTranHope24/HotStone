package hotstone.standard.cards.deck.deckbuilders;

import hotstone.framework.Player;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.deck.decks.DishDeck;

public class DeltaStoneDeckBuilder implements DeckBuilder {
    
    @Override
    public Deck getDeck(Player player) {
        return new DishDeck(new Hand(), player);
    }
}
