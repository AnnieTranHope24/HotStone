package hotstone.standard.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Player;
import hotstone.standard.cards.cardeffects.NullCardEffect;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestField {
    private Field field;

    @BeforeEach
    public void setUp() {
      field = new Field();
      field.addCard(new CardImpl("Uno", 11, 3, 21, false, Player.FINDUS, new NullCardEffect()));
      field.addCard(new CardImpl("Tres", 11, 3, 21, false, Player.FINDUS, new NullCardEffect()));
      field.addCard(new CardImpl("Dos", 11, 3, 21, false, Player.FINDUS, new NullCardEffect()));
    }
  
    @Test
    public void shouldReturn3forFieldSize() {
      assertThat(field.getFieldSize(), is(3));
    }   

    @Test
    public void shouldReturnRightCardByIndex() {
      assertThat(field.getCardInField(0).getName(), is("Dos"));
      assertThat(field.getCardInField(1).getName(), is("Tres"));
      assertThat(field.getCardInField(2).getName(), is("Uno"));
    }      

    @Test
    public void shouldAddNewCardRightPostition() {
        field.addCard(new CardImpl("Cuatro", 2, 3, 1, false, Player.FINDUS, new NullCardEffect()));
        assertThat(field.getCardInField(0).getName(), is("Cuatro"));
    }     
  
}
