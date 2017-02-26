
/**
 * Write a description of class Armor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armor extends Item
{
    private int defense;
    private boolean have;
    
    public Armor(String n, String d, boolean h, int def)
    {
        super(n, d, h);
        defense = def;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    
}
