
/**
 * Write a description of class NamedThing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NamedThing
{
    private String name;
    private String description;
    
    public NamedThing(String n, String d)
    {
        name = n;
        description = d;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String toString()
    {
        return name + "- " + description;
    }
}
