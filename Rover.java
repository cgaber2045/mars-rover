
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    // fields
    String name;
    int numPics;
    int x;
    int y;
    int dir; // 0=North, 1=East, 2=South, 3=West
    String nesw;
    
    
    // constructor(s)
    public Rover() {
        
    }
    
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }
    
    // methods - stuff the Rover can do
    public void takePic() {
        this.numPics++;
        
        System.out.println(name + " took a picture at " + "[" + x + ", " + y + "] facing " + nesw + ".");
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void dir() {
        String[] directionArray = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
        this.nesw = directionArray[this.dir];
    }
    
    public void move(int n)
    {
        if (dir == 0) //north
        {
            y += n;
        }
        else if (dir == 1) //northeast
        {
            y += n;
        }
        else if (dir == 2) //east
        {
            //x += n;
            y -= n;
        }
        else if (dir == 3) //southeast
        {
            x -= n;
        }
        else if (dir == 4) //south
        {
            //y -= n;
            x += n;
        }
        else if (dir == 5) //southwest
        {
            y -= n;
        }
        else if (dir == 6) //west
        {
            //x += n;
            x -= n;
        }
        else // northwest
        {
            x -= n;
        }

        
        dir();
        System.out.println(name + " moved " + n + " units in direction " + nesw + ".");
    }
    
    public void rotateLeft() 
    {
        dir -= 1;
        
        if (dir < 0)
        {
            dir = 8;
        }
        dir();
        System.out.println(name + " turned to the left. (Facing " + nesw + ")");        
    }
    
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 9)
        {
            dir = 0;
        }
        dir();
        System.out.println(name + " turned to the right. (Facing " + nesw + ")");        
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + ", picsTaken=" +  numPics + "]\n";
    }
}
