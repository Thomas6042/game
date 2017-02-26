
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    //items
    private Weapon weapon;
    private Armor armor;
    
    public Player(String nm, String desc, int s, int h)
    {
        super(nm, desc, s, h);
    }

    //setters
    public void setEquippedWeapon(Weapon w)
    {
        weapon = w;
    }
    
    public void setEquippedArmor(Armor a)
    {
        armor = a;
    }
    //getters
    public int getMaxHealth()
    {
        return super.getMaxHealth() + armor.getDefense();
    }

    public int getAttack()
    {
        return super.getAttack() + weapon.getAttack();
    }
    
    public Weapon getEquippedWeaponType()
    {
        return weapon;
    }
    
    public String getEquippedWeapon()
    {
        return weapon.getName();
    }
    
    public Armor getEquippedArmorType()
    {
        return armor;
    }
    
    public String getEquippedArmor()
    {
        return armor.getName();
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////
    public void getStats()
    {
        System.out.println("------HERO------"
            + "\nHealth: " + getHealth() + "/" + getMaxHealth()
            + "\nAttack: " + getAttack()
            + "\nWeapon: " + weapon
            + "\nArmor: " + armor);
    }
}
