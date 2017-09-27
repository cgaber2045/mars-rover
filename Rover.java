
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    // fields
    private String name;
    private int numPics;
    private double x;
    private double y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private String nesw;
    private boolean isAlive;
    private double root = Math.sqrt(2);
    
    // constructor(s)
    public Rover() {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.isAlive = true;        
    }
    
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.isAlive = true;
    }
    
    // methods - stuff the Rover can do
    public void takePic() {
        if(isAlive) {
            this.numPics++;
            System.out.println(name + " took a picture at " + "[" + x + ", " + y + "] facing " + nesw + ".");
        } else {
            System.out.println("ERROR: " + name + " is dead!");
        }
    }
    
    public void setName(String name) {
        System.out.println(this.name + " has changed their name to " + name + ".");
        this.name = name;
    }
    

    public void move(double n)
    {
        if(isAlive) {
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
            getDirectionName();
            
            if (dir % 2 == 0) {
            System.out.println(name + " moved " + n + " units in direction " + nesw + ".");
            } else 
                System.out.println(name + " moved " + (Double.toString(n*root)).substring(0,5) + " units in direction " + nesw + ".");
            } 
            
        else 
        {
                System.out.println("ERROR: " + name + " cannot move while dead!");
        }
    }
    
    private void getDirectionName() {
        String[] directionArray = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
        this.nesw = directionArray[this.dir];
    }
    
    public void rotate(int n)
    {
        if(isAlive) {
            this.dir += n;
            
            if (this.dir >= 8) {
                this.dir = (dir % 8);
                getDirectionName();
                System.out.println(name + " turned to the right " + Math.abs(n) + " to face " + nesw + "."); 
            } else if (this.dir < 0) {
                this.dir = 8 - (Math.abs(dir) % 8);
                getDirectionName();
                System.out.println(name + " turned to the left " + Math.abs(n) + " to face " + nesw + "."); 
            } else {
                getDirectionName();
                System.out.println(name + " turned to the right " + Math.abs(n) + " to face " + nesw + "."); 
            }
        }
        else {
            System.out.println("ERROR: " + name + " cannot rotate while dead!");
        }
    }
    
    public void teleport (int x, int y) {
        if(isAlive) {
        this.x = x;
        this.y = y;
        System.out.println(name + " has teleported to " + x + ", " + y + ".");
        } else {
        System.out.println("ERROR: " + name + " cannot teleport while dead!");    
        }
    }
    
    public void kill(Rover other) 
    {
        if(this.isAlive && other.isAlive == false) {
            System.out.println("ERROR: " + this.name + " tried to kill " + other.name + ", but it is already dead.");
        } else if (isAlive) {
            other.isAlive = false;
            System.out.println(this.name + " has killed " + other.name + ".");
        }
        else{
            other.isAlive = false;
            System.out.println(this.name + " has killed " + other.name + " from beyond the grave!");
        }
    }
    
    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + ", picsTaken=" +  numPics + ", isAlive=" + isAlive + "]\n";
    }
}
