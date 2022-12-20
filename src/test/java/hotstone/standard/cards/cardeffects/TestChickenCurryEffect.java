package hotstone.standard.cards.cardeffects;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.cards.Field;
import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;

import static org.hamcrest.CoreMatchers.is;

public class TestChickenCurryEffect {
    
    private CardEffect cardEffect;
    private GameMutator game;
    private Player player;

    @BeforeEach
    public void setup() {
        cardEffect = new ChickenCurryEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    // @Test
    // public void shouldKillARandomMinion() {
    //     player = game.getPlayerInTurn();

    //     Card dummy1 = new CardImpl("dummy", 0, 0, 10, true, player, new NullCardEffect());
    //     Card dummy2 = new CardImpl("dummy", 0, 0, 10, true, player, new NullCardEffect());
    //     game.getHeroM(player).addCardToHand(dummy1);
    //     game.getHeroM(player).addCardToHand(dummy2);

    //     game.playCard(player, game.getCardInHand(player, 0));
    //     game.playCard(player, game.getCardInHand(player, 0));

    //     game.endTurn();
    //     player = game.getPlayerInTurn();

    //     Card dummy3 = new CardImpl("dummy", 0, 0, 10, true, player, new NullCardEffect());
    //     Card dummy4 = new CardImpl("dummy", 0, 0, 10, true, player, new NullCardEffect());
    //     game.getHeroM(player).addCardToHand(dummy3);
    //     game.getHeroM(player).addCardToHand(dummy4);

    //     game.playCard(player, game.getCardInHand(player, 0));
    //     game.playCard(player, game.getCardInHand(player, 0));

    //     int fieldSize = game.getFieldSize(player);
    //     cardEffect.useEffect(game);
    //     // assertThat(fieldSize, is(4));
    //     assertThat(game.getFieldSize(player), is(fieldSize-1));
    // }
}
