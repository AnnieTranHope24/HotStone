package hotstone.standard.cards.deck.deckbuilders;

import hotstone.framework.Player;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.deck.decks.DeckImpl;

public class AlphaStoneDeckBuilder implements DeckBuilder {
    
    @Override
    public Deck getDeck(Player player) {
        return new DeckImpl(new Hand(), player);
    }
}
