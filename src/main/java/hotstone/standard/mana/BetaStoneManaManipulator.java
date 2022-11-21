package hotstone.standard.mana;

public class BetaStoneManaManipulator implements ManaManipulator{

    @Override
    public int generateMana(int turn) {
        int mana;

        if((turn%2)==0){
            mana = turn/2 +1;
          }
          else {
            mana = (turn-1)/2 + 1;
          }
      
          if(mana > 7){
            mana = 7;
          }

          return mana;
    }

    @Override
    public int getInitialMana() {
        return 1;
    } 
}
