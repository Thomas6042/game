
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Item
{
    private int attack;
    private boolean have;
    public Weapon(String n, String d, boolean h, int a)
    {
        super(n, d, h);
        attack = a;
    }
    
    public int getAttack()
    {
        return attack;
    }
}
