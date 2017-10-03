
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
        SimpleScanner input = new SimpleScanner();
        
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover();
        
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        
        boolean running = true;
        String exitCommand = "quit";
        
        while (running) {
            // Input name
            System.out.print("Enter the name of the Rover to act: ");
            String name = input.readString();
            
            // Select Rover with matching name
            Rover actor = group.find(name);
            
            if (actor != null) {
                // If the rover is found
                System.out.print("Enter a command: ");
                String command = input.readString();
                
                if (command.equals("move")) {
                    System.out.print("Enter distance to move: ");
                    int distance = input.readInt();
                    actor.move(distance);
                }
                else if (command.equals("rotate")) {
                    System.out.print("Enter amount to rotate, (-) for opposite: ");
                    int n = input.readInt();
                    actor.rotate(n);
                }
                else if (command.equals("kill")) {
                    System.out.print("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    
                    if (target != null) {
                        actor.attack(target);
                        System.out.println(target);
                    }
                    else {
                        System.out.println("Error: No such target.");
                    }
                }
                else {
                    System.out.println("Error: Invalid command.");
                }
                
                System.out.println(actor);
            }
            else if (name.equals(exitCommand)) {
                running = false; // set flag to exit loop
            }
            else {
                System.out.println("Error: " + name + " doesn't exist.");
            }
            
            // just a blank line
            System.out.println();
        }
        
        System.out.println("Goodbye.");
    }
    
    /*
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
        r2.charge(110);
        System.out.println(r2);
        
        r3.move(3);
        r3.attack(r2);
        System.out.println(r3);
        r1.teleport(0,0);
        r1.moveTo(-3,4);
        System.out.println(r1);
        r1.goHome();
        System.out.println(r1);
        */
}
