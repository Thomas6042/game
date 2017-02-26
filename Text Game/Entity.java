
/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entity extends NamedThing 
{
    //attack
    private int attack;
    
    //health
    private int health, maxHealth;
    
    public Entity(String nm, String desc, int s, int h)
    {
        super(nm, desc);
        attack = s;
        health = h;
        maxHealth = h;
    }
    
    public void setMaxHealth(int mh)
    {
        maxHealth = mh;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public void setAttack(int x)
    {
        attack = x;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int x)
    {
        health = x;
    }
    
}
