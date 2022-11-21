package hotstone.standard.hero;
import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.standard.cards.CardPlayer;
import hotstone.standard.cards.CardPlayerImpl;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.game.GameMutator;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.ManaManipulator;

public class HeroImpl implements HeroMutator{

    private int mana;
    private int health;
    private boolean isActive;
    private Player owner;
    private CardPlayer cp;
    private ManaManipulator manaManipulator;
    private HeroPower hero;

    //empty constructor used for testing
    public HeroImpl(){
    }

    public HeroImpl(Player owner, int health, ManaManipulator manaManipulator, HeroPower hero, Field field, Deck deck) {
      this.owner = owner;
      this.mana = manaManipulator.getInitialMana();
      this.health = health;
      this.manaManipulator = manaManipulator;
      this.hero = hero;
      this.cp = new CardPlayerImpl(this, field, deck);
      cp.initalDeal();

      if(owner == Player.FINDUS){
        this.isActive = true;
      }
      else {this.isActive = false;}
    }

    // public void setHeroType(String heroType){
    //    this.heroType = heroType;
    //  }

    public void setActive() {
      this.isActive = !this.isActive;
    }
    
    public void changeHealth(int health) {
      this.health +=
      health;
    }

    public void damageToHealth(int damage) {
      this.health -= damage;
    }

     /** Get the amount of mana this hero has available
   * for playing cards to the field.
   *
   * @return amount of mana available
   */
  public int getMana() {
    return this.mana;
  }

  /** Get the value of health of this hero.
   *
   * @return the value of health
   */
  public int getHealth() {
    return this.health;
  }

  /** Get the active state of this hero.
   * Only if active is true, is the hero allowed
   * any actions
   * @return true if the hero is active
   */
  public boolean isActive() {
    return this.isActive;
  }

  /** Get the type of the hero. Type is a
   * string value to be open for new hero types.
   * Default hero types are defined in GameConstants.
   *
   * @return the type of hero
   */
  public String getType() {
    return this.hero.getHeroType();
  }

  /** Get the owner of this hero.
   *
   * @return the player having this hero
   */
  public Player getOwner() {
    return owner;
  }


  public void setManaAtBeginningOfTurn(int turn){
    this.mana = manaManipulator.generateMana(turn);
  }

  public void dealCard(){
    cp.dealCard();
  }

  public void playCard(Card card){
    cp.playCard(card);
  }

  public int getDeckSize(){
    return cp.getDeckSize();
  }

  public int getHandSize(){
    return cp.getHandSize();
  }

  public Card getCardInField(int index){
    return cp.getCardInField(index);
  }

  public int getFieldSize(){
    return cp.getFieldSize();
  }

  public Card getCardInHand(int index){
    return cp.getCardInHand(index);
  }

  public Iterable<? extends Card> getHand(){
    return cp.getHand();
  }

  public Iterable<? extends Card> getField(){
    return cp.getField();
  }

  @Override
  public Status usePower(GameMutator gameMutator, HeroMutator attacker) {

    return hero.usePower(gameMutator, this);
  }

  @Override
  public void dealDamage(int amount) {
    this.health -= amount;  
  }

  @Override
  public void dealMana(int amount) {
    this.mana -= amount;
  }
  @Override
  public void addCardToHand(Card card) {
      cp.addCardToHand(card);   
  }

  @Override
  public void removeCardFromField(Card card) {
    cp.removeCardFromField(card);
    
  }

  @Override
  public void setHealth(int health) {
    this.health = health;
    
  }
}
