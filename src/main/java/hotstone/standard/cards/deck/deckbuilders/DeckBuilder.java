package hotstone.standard.cards.deck.deckbuilders;

import hotstone.framework.Player;
import hotstone.standard.cards.deck.decks.Deck;

public interface DeckBuilder {
    
    Deck getDeck(Player player);
}
