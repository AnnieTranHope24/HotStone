package hotstone.standard.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAlphaStoneManaManipulator {
    
    private ManaManipulator alphaStoneManaGenerator;

    @BeforeEach
    public void setUp(){
        alphaStoneManaGenerator = new AlphaStoneManaManipulator();
    }

    @Test
    public void shouldReturn3Mana(){
        int mana = alphaStoneManaGenerator.generateMana(3);
        assertThat(mana, is(3));
    }

    @Test
    public void shouldReturn3ManaInitially() {
        int result = alphaStoneManaGenerator.getInitialMana();

        assertThat(result, is(3));
    }
}
