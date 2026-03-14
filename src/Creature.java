import java.util.ArrayList; 
import java.util.Scanner;
public class Creature extends Character {
//variables
  String type;
  //private static final int mana = 10;
  private ArrayList<Ability> creatureAbilities;

  //constructor with creature attributes, helaht, name, coins
  public Creature (int health, String name, double coins){
    super(health, name, coins);
    creatureAbilities = new ArrayList<Ability>();
    creatureAbilities.add(new Ability("punch", 10));
    creatureAbilities.add(new Ability("kick", 15));
    creatureAbilities.add(new Ability("fireball", 20));
  }

//accessor method for creature abilities
  public ArrayList<Ability> getCreatureAbilities(){
    return creatureAbilities;
  }

  //displays status with their abilities
  public void displayStatus(){
    super.displayStatus();
    System.out.println(creatureAbilities);
  }
  
}
