
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    public static void main(String[] args)
    {
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover();
        
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        r1.rotate(3);
        r1.move(1);
        r1.rotate(3);
        System.out.println(r1);
        
        r2.rotate(1);
        r2.rotate(5);
        r2.move(2);
        r2.rotate(2);
        r2.move(5);
        System.out.println(r2);
        
        r3.move(1);
        System.out.println(r3);
        r3.setName("Jake");
        r3.move(1);
        r3.takePic();
        r3.rotate(1);
        r3.takePic();
        r3.move(4);
        r3.takePic();
        System.out.println(r3);
        
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        System.out.println(r2);
        
        r3.move(3);
        r3.attack(r2);
        System.out.println(r3);
        r1.teleport(0,0);
        System.out.println(r1);
    }
}
