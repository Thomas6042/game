
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends NamedThing
{
    private boolean have;
    
    public Item(String n, String d, boolean h)
    {
        super (n, d);
        have = h;
    }
    
    public void setHave(boolean h)
    {
        have = h;
    }
    
    public boolean getHave()
    {
        return have;
    }
}
