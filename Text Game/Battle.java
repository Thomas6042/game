
/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Battle
{ 
    
    public Battle()
    {
    }
    
    public void prompt(Player p, Enemy e)
    {
        System.out.println("Hero \t\t\t\t" + e.getName()
            + "\nHP: " + p.getHealth() + "   Dam: " + p.getAttack() + "  \t\tHP: " + e.getHealth() 
            + "\n1. Attack"
            + "\n2. Defend"
            + "\n3. Items"
            + "\n4. Inventory"
            + "\n5. observe"
            + "\n6. run");
    }
}
