package hotstone.standard.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDeltaStoneManaManipulator {
    
    private ManaManipulator deltaStoneManaGenerator;

    @BeforeEach
    public void setUp(){
        deltaStoneManaGenerator = new DeltaStoneManaManipulator();
    }

    @Test
    public void shouldReturn7Mana(){
        int mana = deltaStoneManaGenerator.generateMana(3);
        assertThat(mana, is(7));
    }

    @Test
    public void shouldReturn7ManaInitially() {
        int result = deltaStoneManaGenerator.getInitialMana();

        assertThat(result, is(7));
    }
}
