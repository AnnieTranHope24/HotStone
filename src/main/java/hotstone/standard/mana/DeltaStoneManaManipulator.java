package hotstone.standard.mana;

public class DeltaStoneManaManipulator implements ManaManipulator {

    @Override
    public int generateMana(int turn) {
        return 7;
    }

    @Override
    public int getInitialMana() {
        return 7;
    }   
}
