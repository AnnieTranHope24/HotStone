package hotstone.standard.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBetaStoneManaManipulator {
    
    private ManaManipulator betaStoneManaGenerator;

    @BeforeEach
    public void setUp(){
        betaStoneManaGenerator = new BetaStoneManaManipulator();
    }

    @Test
    public void shouldReturn1Mana(){
        int result1 = betaStoneManaGenerator.generateMana(0);
        int result2 = betaStoneManaGenerator.generateMana(1);

        assertThat(result1, is(1));
        assertThat(result2, is(1));
    }

    @Test
    public void shouldReturn4Mana(){
        int result1 = betaStoneManaGenerator.generateMana(8);
        int result2 = betaStoneManaGenerator.generateMana(9);

        assertThat(result1, is(5));
        assertThat(result2, is(5));
    }

    @Test
    public void shouldReturn7Mana(){
        int result1 = betaStoneManaGenerator.generateMana(20);
        int result2 = betaStoneManaGenerator.generateMana(21);

        assertThat(result1, is(7));
        assertThat(result2, is(7));
    }

    @Test
    public void shouldReturn3ManaInitially() {
        int result = betaStoneManaGenerator.getInitialMana();

        assertThat(result, is(1));
    }
}
