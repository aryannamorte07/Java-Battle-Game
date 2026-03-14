import java.util.ArrayList; 
import java.util.Scanner;

public class GameWorld{
  //variables
  private ArrayList<Player> players;
  private Creature newCreature;

  //constructor with players and creatures
  public GameWorld (ArrayList<Player> players, Creature newCreature){
    this.players = players;
    this.newCreature = newCreature;
  }

  //accessor method for list of players
  public ArrayList<Player> getPlayers(){
    return players;
  }

  //accessor method for creatures
  public Creature getCreatures(){
    return newCreature;
  }

  /*
  * Precondition: Characters is not null, valid list, user must input someone from list
  * Postcondiiton: removes the character the user does not want as an option and returns newly revised characterList
 * Parameters: characters
  */
  
    public ArrayList<Player> removeCharacters(ArrayList<Player> characters){
    System.out.println("Here are your list of characters.");
    System.out.println("What characters would you like to remove?");
    String result = "";
    Scanner input = new Scanner(System.in); //uses scanner class here
    String userInput = input.nextLine();
    for(int i = 0; i < characters.size(); i++){
      //if input is contained in characters, remove character
      if(userInput.contains(characters.get(i).getName())){
        characters.remove(i);
        i--;
      }
        //utilizes the substring method, claiming that user probably spelled something wrong
      else if(userInput.substring(0, 3).equals(characters.get(i).getName().substring(0,3))){
        System.out.println("You might have misspelled the name.");
        characters.remove(i);
        i--;
      }
      else {
        //name is not there
        System.out.println("This is not this name.");
      }
    }
      return characters;
  }

  /*
  * Precondition: player and character start with their health above 0, player and creature are valid objects in parameters
  * Postcondition: at the end of the fight, function will state who won
  * parameters: player a and creature, they will be gihting each other
  */
    public void fight(Player a, Creature b){
    Scanner input = new Scanner(System.in);
    while(a.getHealth() > 0 && b.getHealth() > 0){
      ArrayList<Ability> player = a.getPlayerAbilities();
      ArrayList<Ability> creature = b.getCreatureAbilities();
      Ability playerAbility = chooseAbility(player);
      int playerHealth = a.getHealth();
      int creatureHealth = b.getHealth();
      Ability creatureAbility = creature.get((int)(Math.random() * creature.size())); //utilized math class
      
      a.setHealth(creatureAbility.getDamage());
      b.setHealth(playerAbility.getDamage());

      System.out.println("Player used " + playerAbility.getName() + " on creature. Creature Health: " + b.getHealth());
      System.out.println("Creature used " + creatureAbility.getName() + " on player. Player health: " + a.getHealth());

      //if user wants to regenerate their health
      if(a.getHealth() < 10){
         manaRegenerate(a);
         System.out.println("Player regenerated his health. Player Health: " + a.getHealth());
      }
      
      a.displayStatus();
      System.out.println(" ");
      b.displayStatus();
   }

    if(a.getHealth() == 0){
      System.out.println("Creature wins!");
    }
    else{
      System.out.println("Player wins!");
    }
  }

  // user choose power for player
  /*
  * Precondition: characterAbilities is not null
  * Postcondition: returns character abilitiy that will be used
  * Parameter: List of character abilities
  */
  public Ability chooseAbility (ArrayList<Ability> characterAbilities){
    Scanner input = new Scanner(System.in);
    Ability one = new Ability("null", 0);
    System.out.println("Choose your power: ");
    String userInput = input.nextLine();
    for(int i = 0; i < characterAbilities.size(); i++){
      if(userInput.equals(characterAbilities.get(i).getName())){ // use of string class
         Ability a = new Ability(characterAbilities.get(i).getName(), characterAbilities.get(i).getDamage());
         return a; //returns a if ability is in characterABilities constructor
      }
    }
    return one; //returns null if user power was not on the list
  }

  /*
  * Precondition: regenerates mana health if user says yes
  *Poscondition: health is increased by however much user wanted it to be increased
  Paramenters: player that health will be affected
  */
  public void manaRegenerate(Player a){
    Scanner input = new Scanner(System.in);
    System.out.println("Would you like to regenerate health?");
    String userInput = input.nextLine();
      if(userInput.equals("yes")){
        System.out.println("How much health would you like to regenerate?");
        double doubleInput = input.nextDouble();
        a.setCoins(doubleInput);
        a.setHealth(doubleInput);
      }
  }

  /*
  *Precondition: characters is not null
  *sorts characters as weak and strong based off thier stats
  *Postcondition: applies powerUps to character accordingly, and sets their stats
  */
  public static void applyPowerUps(ArrayList<Player> characters){
    ArrayList<Player> weakCharacters = new ArrayList<Player>();
    ArrayList<Player> strongCharacters = new ArrayList<Player>();
    for(int i = 0; i < characters.size(); i++){
      int health = characters.get(i).getHealth();
      double coins = characters.get(i).getCoins();

      if(health > 50){ //user healht substracts by 20
        characters.get(i).setHealth(20);
        weakCharacters.add(characters.get(i));
      }
      else if(coins > 50){ //user coins substracts by 10
        characters.get(i).setCoins(10.0);
        weakCharacters.add(characters.get(i));
      }
      else{
        characters.get(i).setHealth(30.0); //user health is added 30
        characters.get(i).setCoins(30); // user coins is added 30
        strongCharacters.add(characters.get(i));
      }
      
    }
  }

  /*
  * Precondition: allPlayers is not null, creature is valid object
  * Postcondition: creates story, applying all the methods in Gameworkd class here. The method had two players fight with applyPowerups and removecharacters
  */

  public void createStory(ArrayList<Player> allPlayers, Creature b){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Battle Galatica!");
    allPlayers.add(new Player(100, "Aryanna", 100));
    allPlayers.add(new Player(50, "Arya", 30));
    allPlayers.add(new Player(40, "Preesha", 75));

    applyPowerUps(removeCharacters(allPlayers));
    Player a = allPlayers.get((int) Math.random() * allPlayers.size()); //utilized math class
    fight(a, b); //creature and player fight     
  }
}
