import java.util.ArrayList; 
import java.util.Scanner;
public class Character {

  int health;
  String name;
  double coins;

  //constructor with attributes such as health, name, and coins
  public Character (int health, String name, double coins){
    this.health = health;
    this.name = name;
    this.coins = coins;
  }

  //accessor method for health
  public int getHealth(){
    return health;
  }

  //accessor method for name
  public String getName(){
    return name;
  }

  //accessor method for coins
  public double getCoins(){
    return coins;
  }

  //sets coins - debth
  public void setCoins(double debt){
    coins -= debt;
  }

  //sets coins + income
  public void setCoins(int income){
    coins += income;
  }

  //sets Health - damage
  public void setHealth(int damage){
    health -= damage;
  }

  //sets helaht + recovery
  public void setHealth(double recovery){
    health += recovery;
  }

  public void displayStatus (){
    System.out.println("Name: " + name);
    System.out.println("Health: " + health);
    //System.out.println("Abilities: " + ability.getName());
  }

  public String setName(){
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
  }


}
