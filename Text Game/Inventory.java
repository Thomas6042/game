
/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Inventory
{
    private Weapon[] weapons;
    private Armor[] armor;
    private Item[] items;
    private int potion;
    private Player hero;

    public Inventory(Player p)
    {
        //weapons
        //fists, broken sword
        weapons = new Weapon[]{new Weapon("fist", "Your two fists", true, 0), 
            new Weapon("broken sword", "The rusted edge of this broken weapon is still sharp", false, 5)};

        //armor
        armor = new Armor[]{new Armor("rags", "They might be better than nothing", true, 0),
            new Armor("leather armor", "Old but thick armor made from the hide of an animal", false, 10)};

        //items
        //cell key, stone
        items = new Item[]{new Item("cell key", "This key opens all cells in the dungeon", false),
            new Item("stone", "A small rock that could be thrown", false)};
        potion = 0;

        //hero
        hero = p;
    }

    public void getInv()
    {
        System.out.print("\f");
        Scanner scoobs = new Scanner(System.in);
        String answer = "";
        boolean again = true;
        boolean repeat = true;
        boolean back = true;
        boolean haveToRepeat = true;
        while(back)
        {
            again = true;
            repeat = true;
            back = true;
            back = false;
            System.out.println("\fEquipped weapon: " + hero.getEquippedWeapon() + "\t\tEquipped Armor: " + hero.getEquippedArmor() + "\n");
            //while(again)
            //{
            again = true;
            repeat = true;
            back = true;
            again = false;

            System.out.println("1. weapons\n2. armor\n3. exit");
            System.out.print("Input: ");
            answer = scoobs.nextLine();
            System.out.println();
            if(answer.equals("1") || answer.equalsIgnoreCase("weapons"))
            {
                System.out.println("\fYou have...\n");
                for(int x = 0; x < weapons.length; x++)
                {
                    if(weapons[x].getHave())
                    {
                        System.out.println(weapons[x]);
                    }
                }
                System.out.println("exit");
                while(repeat)
                {
                    repeat = false;
                    haveToRepeat = true;
                    System.out.print("Equip the: ");
                    answer = scoobs.nextLine();
                    System.out.println();
                    if(!answer.equalsIgnoreCase("exit"))
                    {
                        for(int x = 0; x < weapons.length; x++)   
                        {
                            if(answer.equalsIgnoreCase(weapons[x].getName()) && weapons[x].getHave()) 
                            {
                                hero.setEquippedWeapon(weapons[x]);
                                System.out.println("\fYou equip the " + hero.getEquippedWeapon() + "\n");
                                haveToRepeat = false;
                            }
                        }
                        back = false;
                        again = false;
                        repeat = false;

                        if(haveToRepeat)
                        {
                            System.out.println("Input invalid");
                            repeat = true;
                        }
                    }
                    else
                    {
                        back = true;
                        again = true;
                    }
                }
            }
            else if(answer.equals("2") || answer.equalsIgnoreCase("armor"))
            {
                System.out.println("\fYou have...\n");
                for(int x = 0; x < armor.length; x ++)
                {
                    if(armor[x].getHave())
                    {
                        System.out.println(armor[x]);
                    }
                }
                System.out.println("exit");
                while(repeat)
                {
                    repeat = false;
                    haveToRepeat = true;
                    System.out.print("Equip the: ");
                    answer = scoobs.nextLine();
                    System.out.println();
                    if(!answer.equalsIgnoreCase("exit"))
                    {
                        for(int x = 0; x < armor.length; x++)   
                        {
                            if(answer.equalsIgnoreCase(armor[x].getName()) && armor[x].getHave()) 
                            {
                                hero.setHealth(hero.getHealth() + (armor[x].getDefense() - hero.getEquippedArmorType().getDefense()));
                                hero.setEquippedArmor(armor[x]);
                                hero.setEquippedArmor(armor[x]);
                                System.out.println("\fYou equip the " + hero.getEquippedArmor() + "\n");
                                haveToRepeat = false;
                            }
                        }
                        back = false;
                        again = false;
                        repeat = false;

                        if(haveToRepeat)
                        {
                            repeat = true;
                            System.out.println("Input invalid");
                        }
                    }
                    else
                    {
                        back = true;
                        again = true;
                    }
                }
            }
            else if(answer.equals("3") || Search.check(answer, "exit"))
            {
                System.out.print("\f");
                back = false;
            }
            else
            {
                System.out.println("Input invalid");
                again = true;
            }
        }

    }
    
    public boolean getInvBattle()
    {
        System.out.print("\f");
        Scanner scoobs = new Scanner(System.in);
        String answer = "";
        boolean again = true;
        boolean repeat = true;
        boolean back = true;
        boolean haveToRepeat = true;
        while(back)
        {
            again = true;
            repeat = true;
            back = true;
            back = false;
            System.out.println("\fEquipped weapon: " + hero.getEquippedWeapon() + "\t\tEquipped Armor: " + hero.getEquippedArmor() + "\n");
            //while(again)
            //
            again = true;
            repeat = true;
            back = true;
            again = false;

            System.out.println("1. weapons\n2. armor\n3. exit");
            System.out.print("Input: ");
            answer = scoobs.nextLine();
            System.out.println();
            if(answer.equals("1") || answer.equalsIgnoreCase("weapons"))
            {
                System.out.println("\fYou have...\n");
                for(int x = 0; x < weapons.length; x++)
                {
                    if(weapons[x].getHave())
                    {
                        System.out.println(weapons[x]);
                    }
                }
                System.out.println("exit");
                while(repeat)
                {
                    repeat = false;
                    haveToRepeat = true;
                    System.out.print("Equip the: ");
                    answer = scoobs.nextLine();
                    System.out.println();
                    if(!answer.equalsIgnoreCase("exit"))
                    {
                        for(int x = 0; x < weapons.length; x++)   
                        {
                            if(answer.equalsIgnoreCase(weapons[x].getName()) && weapons[x].getHave()) 
                            {
                                hero.setEquippedWeapon(weapons[x]);
                                System.out.println("\fYou equip the " + hero.getEquippedWeapon() + "\n");
                                return true; 
                            }
                        }
                        back = false;
                        again = false;
                        repeat = false;

                        if(haveToRepeat)
                        {
                            System.out.println("Input invalid");
                            repeat = true;
                        }
                    }
                    else
                    {
                        back = true;
                        again = true;
                    }
                }
            }
            else if(answer.equals("2") || answer.equalsIgnoreCase("armor"))
            {
                System.out.println("\fYou have...\n");
                for(int x = 0; x < armor.length; x ++)
                {
                    if(armor[x].getHave())
                    {
                        System.out.println(armor[x]);
                    }
                }
                System.out.println("exit");
                while(repeat)
                {
                    repeat = false;
                    haveToRepeat = true;
                    System.out.print("Equip the: ");
                    answer = scoobs.nextLine();
                    System.out.println();
                    if(!answer.equalsIgnoreCase("exit"))
                    {
                        for(int x = 0; x < armor.length; x++)   
                        {
                            if(answer.equalsIgnoreCase(armor[x].getName()) && armor[x].getHave()) 
                            {
                                hero.setHealth(hero.getHealth() + (armor[x].getDefense() - hero.getEquippedArmorType().getDefense()));
                                hero.setEquippedArmor(armor[x]);
                                System.out.println("\fYou equip the " + hero.getEquippedArmor() + "\n");
                                return true;
                            }
                        }
                        back = false;
                        again = false;
                        repeat = false;

                        if(haveToRepeat)
                        {
                            repeat = true;
                            System.out.println("Input invalid");
                        }
                    }
                    else
                    {
                        back = true;
                        again = true;
                    }
                }
            }
            else if(answer.equals("3") || Search.check(answer, "exit"))
            {
                System.out.print("\f");
                return false;
            }
            else
            {
                System.out.println("Input invalid");
                again = true;
            }
            //}
        }
        return false;
    }

    public void getItems()
    {
        System.out.println("You have...");
        System.out.println("Potions: " + potion);
        for(int x = 0; x < items.length; x++)
        {
            if(items[x].getHave())
            {
                System.out.println(items[x]);
            }
        }
        if(!items[0].getHave())
            System.out.println("You have no items. Loser");
    }

    //setters
    public void setWeapon(int x, boolean b)
    {
        weapons[x].setHave(b);
    }

    public void setArmor(int x, boolean b)
    {
        armor[x].setHave(b);
    }

    public void setItem(int x, boolean b)
    {
        items[x].setHave(b);
    }
    //getters
    public Weapon getWeapon(int x)
    {
        return weapons[x];
    }

    public Armor getArmor(int x)
    {
        return armor[x];
    }

    public Item getItem(int x)
    { 
        return items[x];
    }
}