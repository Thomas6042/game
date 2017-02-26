
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Entity
{
    private boolean alive;
    public Enemy(String nm, String desc, int s, int h)
    {
        super(nm, desc, s, h);
        alive = true;
    }
    
    public boolean getAlive()
    {
        return alive;
    }
    
    public void setAlive(boolean a)
    {
        alive = a;
    }
}
