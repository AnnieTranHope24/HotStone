package hotstone.standard.mana;

public class AlphaStoneManaManipulator implements ManaManipulator{

    @Override
    public int generateMana(int turn) {
        return 3;
    }

    @Override
    public int getInitialMana() {
        return 3;
    } 
}