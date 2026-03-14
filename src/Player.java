import java.util.ArrayList; 
import java.util.Scanner;
public class Player extends Character {

  private static final int inventorySpace = 5;
 // private static final int mana = 10;
  private ArrayList<Ability> playerAbilities;

  //constructor with player attrubutes 
  public Player(int health, String name, int coins){
    super(health,name,coins);
    //player abilities are added to list
    playerAbilities = new ArrayList<Ability>();
    playerAbilities.add(new Ability("sword slash", 10));
    playerAbilities.add(new Ability("hell blaster", 30));
    playerAbilities.add(new Ability("body smasher", 20));
  }

  //accesor method for player abilities
  public ArrayList<Ability> getPlayerAbilities (){
    return playerAbilities;
  }

  //displays status with playerABiliities
  //overriden method
  public void displayStatus(){
    super.displayStatus();
    System.out.println(playerAbilities);
  }


  
  }
