
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
    
    public void dir() {
        String[] directionArray = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
        this.nesw = directionArray[this.dir];
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
            dir();
            
            if (dir % 2 == 0) {
            System.out.println(name + " moved " + n + " units in direction " + nesw + ".");
            } else 
                System.out.println(name + " moved " + (Double.toString(n*root)).substring(0,5) + " units in direction " + nesw + ".");
            } 
            
        else 
        {
                System.out.println("ERROR: " + name + " is dead!");
        }
    }
    
    public void rotateLeft() 
    {
        if(isAlive) {
            dir -= 1;
            
            if (dir < 0)
            {
                dir = 8;
            }
            dir();
            System.out.println(name + " turned to the left. (Facing " + nesw + ")");   
        } else {
            System.out.println("ERROR: " + name + " is dead!");
        }
    }
    
    public void rotateRight()
    {
        if(isAlive) {
            dir += 1;
            
            if (dir == 9)
            {
                dir = 0;
            }
            dir();
            System.out.println(name + " turned to the right. (Facing " + nesw + ")"); 
        }
        else {
            System.out.println("ERROR: " + name + " is dead!");
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
