import java.util.ArrayList; 
import java.util.Scanner;
public class Ability {

  String name;
  int damage;

  //construtor for ability
  public Ability (String name, int damage){
    this.name = name;
    this.damage = damage;
  }

  //accessor method for ability name
  public String getName(){
    return name;
  }

  //accessor method for ability damage
  public int getDamage(){
    return damage;
  }

  //set method to change ability name
  public void updateName(String newName){
    name = newName;
  }

  //accessor mehtod to change ability damage
  public void updateDamage(int newDamage){
    damage = newDamage;
  }


}
