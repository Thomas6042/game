
/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Location extends NamedThing
{
    private String locationDescription;
    private Player hero;
    private Inventory inv;
    private Location[][] loc;
    boolean open;
    
    public Location(String n, String d, String ld, Inventory i, Player p, boolean o, Location[][] locat)
    {
        super(n, d);
        locationDescription = ld;
        inv = i;
        hero = p;
        open = o;
        loc = locat;
    }
    
    public Inventory getInventory()
    {
        return inv;
    }
    
    public Player getPlayer()
    {
        return hero;
    }
    
    public Location[][] getLocation ()
    {
        return loc;
    }
    
    public String locationDescription()
    {
        return locationDescription;
    }
    
    public boolean getOpen()
    {
        return open;
    }
    
    public void setOpen(boolean x)
    {
        open = x;
    }
    
    public String toString()
    {
        return "\fYou are now in " + getName() + ". " + getDescription() +"\n";
    }
    
    public abstract void run(String answer);
}
