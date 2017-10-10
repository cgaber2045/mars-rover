
/**
 * Write a description of class Rover here.
 * 
 * @author Chris Gaber 
 * @version September 30, 2017
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Rover
{
    // fields
    private String name;
    private String input;
    private int numPics;
    private double x;
    private double y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private boolean isAlive;
    private boolean hasPower;
    private int health;
    private int maxhealth;
    private int damage;
    private int level;
    private int exp;
    private int energy;
    private int maxPics = 5;
    
    // constructor(s)
    public Rover() {
        this.isAlive = true; 
        this.health = 100;
        this.damage = 10;
        this.energy = 100;
        this.hasPower = true;
    }
    
    public Rover(String name)
    {
        this.name = name;
        this.isAlive = true;
        this.health = 100;
        this.damage = 10;
        this.energy = 100;
        this.hasPower = true;
    }
    
    //Methods
    
    //Method to round decimals accurately (used in pythagorean math)
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
     
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public void transmitPictures() {
        levelUp(100*numPics);
        this.numPics = 0;
    }
    
    public void moveTo(int x, int y) {
            rotate(-this.dir);
            move(y - this.y);
            rotate(2);
            move(x - this.x);
    }
    
    public void goHome() {
        moveTo(0, 0);
    }
    
    public void spendEnergy() {
        energy -= 5;
        if (energy <= 0) {
            energy = 0;
            hasPower = false;
        }
    }
    
    public void charge(int amps) {
        if (!(energy > 100+(10*level)) && !((amps + energy) > 100+(10*level))) {
            energy += amps;
            System.out.println(name + " is charging for " + amps + " power!");
            levelUp(2*amps);
        } else {
            System.out.println(name + " cannot charge past their limit of " + (100+(10*level)));
        }
    }
    
    public void levelUp(int xp) {      
        if(isAlive) {
        this.exp += xp; 
        this.damage = 10 + (3 * level);
        
        System.out.println(name + " has gained " + xp + " xp!");
        if (exp >= (level * 100 + 100)) {
            System.out.println(name + " has leveled up to level " + (level+1) + "!");
            this.level++;
            this.exp = 0;
            health = (100+(10*level));
        }
    }
    }
    
    public void checkHealth() {
        if (this.health <= 0) {
           this.health = 0;
           this.isAlive = false; 
           System.out.println(name + " has died!");
        }
    }
    
    public void takePic() {
        if(hasPower) {
            if(isAlive) {
                if (numPics <= maxPics) {
                this.numPics++;
                System.out.println(name + " took a picture at " + "[" + x + ", " + y + "] facing " + setDirectionName() + ".");
                levelUp(100);
                } else  System.out.println(name + " has reached the picture limit!");
            } else {
                System.out.println("ERROR: " + name + " is dead!");
            }
    }
    }
    
    public void setName(String name) {
        System.out.println(this.name + " has changed their name to " + name + ".");
        this.name = name;
    }
    
    public void move(double n) {
        double root = Math.sqrt(2);
        if(hasPower) {
            if(isAlive) {
                spendEnergy();
                if (dir == 0) //north
                {
                    y += n;
                }
                else if (dir == 1) //northeast
                {
                    y += n*root;
                    x += n*root;
                }
                else if (dir == 2) //east
                {
                    x += n;
                }
                else if (dir == 3) //southeast
                {
                    x += n*root;
                    y -= n*root;
                }
                else if (dir == 4) //south
                {
                    y -= n;
                }
                else if (dir == 5) //southwest
                {
                    y -= n*root;
                    x -= n*root;
                }
                else if (dir == 6) //west
                {
                    x -= n;
                }
                else // northwest
                {
                    x -= n*root;
                    y += n*root;
                }
                levelUp(100);
                if (dir % 2 == 0) {
                System.out.println(name + " moved " + n + " units in direction " + setDirectionName() + ".");
                } else 
                    System.out.println(name + " moved " + (Double.toString(n*root)).substring(0,5) + " units in direction " + setDirectionName() + ".");
                } 
            else 
            {
                    System.out.println("ERROR: " + name + " cannot move while dead!");
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    private String setDirectionName() {
        String[] directionArray = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
        return directionArray[this.dir];
    }
    
    public void rotate(int n) {
        if(hasPower){
            if(isAlive) {
                this.dir += n;
                spendEnergy();
                if (this.dir >= 8) {
                    this.dir = (dir % 8);
                    System.out.println(name + " turned to the right " + Math.abs(n) + " to face " + setDirectionName() + "."); 
                } else if (this.dir < 0) {
                    this.dir = 8 - (Math.abs(dir) % 8);
                    System.out.println(name + " turned to the left " + Math.abs(n) + " to face " + setDirectionName() + "."); 
                } else {
                    System.out.println(name + " turned to the right " + Math.abs(n) + " to face " + setDirectionName() + "."); 
                }
                levelUp(100); 
            }
            else {
                System.out.println("ERROR: " + name + " cannot rotate while dead!");
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    public void teleport (int x, int y) {
        spendEnergy();
        if(hasPower) {
            if(isAlive) {
                this.x = x;
                this.y = y;
                System.out.println(name + " has teleported to " + x + ", " + y + ".");
                levelUp(200);
                spendEnergy();
            } else {
                System.out.println("ERROR: " + name + " cannot teleport while dead!");    
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    public void attack(Rover other) {
        spendEnergy();
        if(hasPower) {
            if(this.isAlive && other.isAlive == false) {
                System.out.println("ERROR: " + this.name + " tried to kill " + other.name + ", but it is already dead.");
            } else if (isAlive) {
                spendEnergy();
                other.health -= this.damage;
                System.out.println(this.name + " has attacked " + other.name + " for " + damage + 
                " damage.\n >" + other.name + " current health: " + other.health);
                checkHealth();
                other.checkHealth();
                this.levelUp(10 * damage); 
            }
            else {
                other.health-= this.damage;
                System.out.println(this.name + " has killed " + other.name + " from beyond the grave!");
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    public String getName() {
        return name;
    }
    
    // To String
    public String toString() {
        return "Rover[Name: " + name + ", x: " + round(x, 2) + ", y: " + round(y, 2) + ", dir: " + dir + ", picsTaken: " +  numPics + ", isAlive: " + isAlive + 
        "]\n [Health: " + health + "/" + (100+(10*level)) + " Level: " + level + " Exp: " + exp + "/" + (level * 100 + 100) + " Energy: " + energy + "/" + (100+(10*level)) + "]\n";
    }
}
