import java.util.ArrayList;
/**
 * Write a description of class RoomTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomTwo extends Location
{
    private boolean locked = true;
    private ArrayList<String> list = new ArrayList<String>();
    private String[] fate = new String[4];
    public RoomTwo(String n, String d, String ld, Inventory i, Player p, boolean o, Location[][] locat)
    {
        super(n, d, ld, i, p, o, locat);
        list.add("death");
        list.add("death");
        list.add("death");
        list.add("life");
        for(int x = 0; x <= 3; x++)
        {
            fate[x] = list.remove((int)(Math.random() * list.size()));
        }
    }

    public void run(String answer)
    {
        if(Search.check(answer, "look around") || (Search.check(answer, "look") && (Search.check(answer, "room") || Search.check(answer, "area"))))
        {
            System.out.println("Cell doors and torches line the walls of the long room. There is a small table near the stairs where someone is obviously supposed to stand guard.");
        }

        //cell doors: listening and looking and knocking
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && (Search.check(answer, "doors") || Search.check(answer, "cells")))
        {
            System.out.println("The room is filled with doors like the one from your cell. Each one is labeled one to five.");
        }
        else if((Search.check(answer, "look") && Search.check(answer, "through") || Search.check(answer, "in")) && (Search.check(answer, "one") || Search.check(answer, "1") || Search.check(answer, "3") || Search.check(answer, "three") || Search.check(answer, "four") ||Search.check(answer, "4") || Search.check(answer, "five") || Search.check(answer, "5")))
        {
            System.out.println("There is almost no light in the cell. There is no way you can see anything inside.");
        }
        else if(Search.check(answer, "look") && Search.check(answer, "through") && (Search.check(answer, "opening") || Search.check(answer, "window")) && (Search.check(answer, "two") || Search.check(answer, "2")))
        {
            System.out.println("Looking through the opening of cell two, you can see a dead body and a dead rat.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "cell") && (Search.check(answer, "one") || Search.check(answer, "1")))
        {
            System.out.println("The cell labeled with a one has a thick metal door.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "cell") && (Search.check(answer, "two") || Search.check(answer, "2")))
        {
            System.out.println("The cell labeled with a two has a thick metal door.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "cell") && (Search.check(answer, "three") || Search.check(answer, "3")))
        {
            System.out.println("The cell labeled with a three has a thick metal door. It has a small window.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "cell") && (Search.check(answer, "four") || Search.check(answer, "4")))
        {
            System.out.println("The cell labeled with a four has a thick metal door.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "cell") && (Search.check(answer, "five") || Search.check(answer, "5")))
        {
            System.out.println("The cell labeled with a five has a thick metal door.");
        }
        else if(Search.check(answer, "look") && Search.check(answer, "into") && Search.check(answer, "cell"))
        {
            System.out.println("How will you do that?");
        }
        else if(Search.check(answer, "listen") && (Search.check(answer, "one") || Search.check(answer, "1")))
        {
            if(fate[0].equals("death"))
                System.out.println("Putting your ear against the iron door, you hear the faint sound of breathing inside the cell.");
            else
                System.out.println("Putting your ear against the iron door, you hear nothing.");
        }
        else if(Search.check(answer, "listen") && (Search.check(answer, "two") || Search.check(answer, "2")))
        {
            if(fate[1].equals("death"))
                System.out.println("Putting your ear against the iron door, you hear the faint sound of breathing inside the cell.");
            else
                System.out.println("Putting your ear against the iron door, you hear nothing.");
        }
        else if(Search.check(answer, "listen") && (Search.check(answer, "four") || Search.check(answer, "4")))
        {
            if(fate[2].equals("death"))
                System.out.println("Putting your ear against the iron door, you hear the faint sound of breathing inside the cell.");
            else
                System.out.println("Putting your ear against the iron door, you hear nothing.");
        }
        else if(Search.check(answer, "listen") && (Search.check(answer, "five") || Search.check(answer, "5")))
        {
            if(fate[3].equals("death"))
                System.out.println("Putting your ear against the iron door, you hear the faint sound of breathing inside the cell.");
            else
                System.out.println("Putting your ear against the iron door, you hear nothing.");
        }
        
        
        else if(Search.check(answer, "knock") && (Search.check(answer, "one") || Search.check(answer, "1")))
        {
            if(fate[0].equals("death"))
                System.out.println("You take your fist and knock on door one. The sound echoes through the dungeon...then a moment later a faint, slow knock can barely be heard coming from the other side of" +
                    "\nthe door");
            else
                System.out.println("You take your fist and knock on door one. The sound echoes through the dungeon...then silence");
        }
        else if(Search.check(answer, "knock") && (Search.check(answer, "two") || Search.check(answer, "2")))
        {
            if(fate[1].equals("death"))
                System.out.println("You take your fist and knock on door two. The sound echoes through the dungeon...then a moment later a faint, slow knock can barely be heard coming from the other side of" +
                    "\nthe door");
            else
                System.out.println("You take your fist and knock on door two. The sound echoes through the dungeon...then silence");
        }
        else if(Search.check(answer, "knock") && (Search.check(answer, "four") || Search.check(answer, "4")))
        {
            if(fate[2].equals("death"))
                System.out.println("You take your fist and knock on door four. The sound echoes through the dungeon...then a moment later a faint, slow knock can barely be heard coming from the other side of" +
                    "\nthe door");
            else
                System.out.println("You take your fist and knock on door four. The sound echoes through the dungeon...then silence");
        }
        else if(Search.check(answer, "knock") && (Search.check(answer, "five") || Search.check(answer, "5")))
        {
            if(fate[3].equals("death"))
                System.out.println("You take your fist and knock on door five. The sound echoes through the dungeon...then a moment later a faint, slow knock can barely be heard coming from the other side of" +
                    "\nthe door");
            else
                System.out.println("You take your fist and knock on door five. The sound echoes through the dungeon...then silence");
        }
        else if(Search.check(answer, "knock") && (Search.check(answer, "3") || Search.check(answer, "three")))
            System.out.println("You take your fist and knock on door three. The sound echoes through the dungeon...then silence");
        
        
        else if(Search.check(answer, "listen") && Search.check(answer, "3") || Search.check(answer, "three"))
        {
            System.out.println("Putting your ear against the iron door, you hear nothing in the cell.");
        }

        //cell doors
        else if(Search.check(answer, "unlock") && (Search.check(answer, "one") || Search.check(answer, "1")))
        {
            if(fate[0].equals("death"))
            {
                if(!getPlayer().getEquippedWeapon().equals("fist"))
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\ngets on top of you, takes your weapon, and plunges it into your chest. You are left to bleed on the dungeon floor.");
                else
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\nwraps around your throat. You struggle for oxygen, but soon everything turns black.");
                getPlayer().setHealth(0);
            }
            else
            {
                System.out.println("You unlock the door and it swings open, revealing a completely caved in room. Only a single loose stone falls at your feet.");
                locked = false;
            }
        }
        
        else if(Search.check(answer, "unlock") && (Search.check(answer, "two") || Search.check(answer, "2")))
        {
            if(fate[1].equals("death"))
            {
                if(!getPlayer().getEquippedWeapon().equals("fist"))
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\ngets on top of you, takes your weapon, and plunges it into your chest. You are left to bleed on the dungeon floor.");
                else
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\nwraps around your throat. You struggle for oxygen, but soon everything turns black.");
                getPlayer().setHealth(0);
            }
            else
            {
                System.out.println("You unlock the door and it swings open, revealing a completely caved in room. Only a single loose stone falls at your feet.");
                locked = false;
            }
        }
        
        else if(Search.check(answer, "unlock") && (Search.check(answer, "four") || Search.check(answer, "4")))
        {
            if(fate[2].equals("death"))
            {
                if(!getPlayer().getEquippedWeapon().equals("fist"))
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\ngets on top of you, takes your weapon, and plunges it into your chest. You are left to bleed on the dungeon floor.");
                else
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\nwraps around your throat. You struggle for oxygen, but soon everything turns black.");
                getPlayer().setHealth(0);
            }
            else
            {
                System.out.println("You unlock the door and it swings open, revealing a completely caved in room. Only a single loose stone falls at your feet.");
                locked = false;
            }
        }
        
        else if(Search.check(answer, "unlock") && (Search.check(answer, "5") || Search.check(answer, "five")))
        {
            if(fate[3].equals("death"))
            {
                if(!getPlayer().getEquippedWeapon().equals("fist"))
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\ngets on top of you, takes your weapon, and plunges it into your chest. You are left to bleed on the dungeon floor.");
                else
                    System.out.println("You unlock the door, but as soon as the cell key is fully turned the door is flung open and you are pushed to the ground. Completely dazed, you try to get up but something"
                        + "\nwraps around your throat. You struggle for oxygen, but soon everything turns black.");
                getPlayer().setHealth(0);
            }
            else
            {
                System.out.println("You unlock the door and it swings open, revealing a completely caved in room. Only a single loose stone falls at your feet.");
                locked = false;
            }
        }
        
        else if((Search.check(answer, "check") || Search.check(answer, "search") || Search.check(answer, "look") || Search.check(answer, "open")) && (Search.check(answer, "3") || Search.check(answer, "three")) && !locked)
        {
            System.out.println("Opening the door, you realise the cell was empty because it is completely caved in. Only a single loose stone falls at your feet.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && Search.check(answer, "stone") && !locked)
        {
            if(!getInventory().getItem(1).getHave())
            {
                System.out.println("You pick up the sizable stone off the ground.");
                getInventory().setItem(1, true);
            }
            else
                System.out.println("There is no stone.");
        }
        else if((Search.check(answer, "open") || Search.check(answer, "unlock")) && Search.check(answer, "cell"))
        {
            System.out.println("Which one?");
        }

        //locking your cell
        
        else if(Search.check(answer, "unlock") && (Search.check(answer, "three") || Search.check(answer, "3")))
        {
            if(!getLocation()[2][4].getOpen())
            {
                System.out.println("You unlock the door.");
                getLocation()[2][4].setOpen(true);
            }
            else
                System.out.println("The door is already unlocked.");
        }
        else if(Search.check(answer, "lock") && (Search.check(answer, "three") || Search.check(answer, "3")))
        {
            if(getLocation()[2][4].getOpen())
            {
                System.out.println("You lock the door.");
                getLocation()[2][4].setOpen(false);
            }
            else
                System.out.println("The door is already locked.");
        }
        //guard station and books
        else if((Search.check(answer, "look") || Search.check(answer, "observe") || Search.check(answer, "search")) && (Search.check(answer, "station") || Search.check(answer, "table")))
        {
            System.out.print("On the table are a few books to pass time.");
            if(!getInventory().getArmor(1).getHave())
                System.out.print(" Draped on the chair is an old set of leather armor.");
            System.out.println();
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe") || Search.check(answer, "search")) && Search.check(answer, "books"))
        {
            System.out.println("The following books are on the table: \"The Sword Manual\", \"The Undead Scourge\", \"Creatures\", \"Holy Rituals\", \"Tales of Adventure\", and a ruined book.");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "the sword manual"))
        {
            System.out.println("\"The sword, although simple in design, must be mastered to be used effectively. Make sure your opponent never knows your next move. If you are fighting against an"
                + "\n experianced adversary, you must keep him guessing. Hacking and slashing will only result in the battle being lost quickly...\"");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "the undead scourge"))
        {
            System.out.println("\"For hundreds of years the curse of the undead has plagued our lands. Any disturbed body may come back to life after a period of time, especially if their death was"
                + "\nuntimely. The undead, although not powerful or fast, are formidable in battle due to their excessive resilience...\"");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "creatures"))
        {
            System.out.println("\"The beasts of our world are fantastic and magical. No matter how amazing they are, you will most likely die if you confront one. From the rats found in the deepest"
                + "\ndungeons to the dragons that live high above us, we must fear for our lives if we come across any creature...\"");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "holy rituals"))
        {
            System.out.println("The book is written in a clerical language. You don't understand it.");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "tales of adventure"))
        {
            System.out.println("\"Throughout my travels, I have found that there is no enemy more dangerous than one that hides in the shadows. Always be listening for an assassin that can not be seen...\"");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && Search.check(answer, "book"))
        {
            System.out.println("You will have no need to bring any books with you.");
        }
        else if(Search.check(answer, "read") && Search.check(answer, "book"))
        {
            System.out.println("Which one?");
        }
        
        //Leather armor
        else if((Search.check(answer, "look") || Search.check(answer, "observe") || Search.check(answer, "check")) && Search.check(answer, "leather armor"))
        {
            System.out.println("The armor looks as if it's seen its fair share of battle in its day.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "grab") || Search.check(answer, "pick up")) && Search.check(answer, "leather armor"))
        {
            System.out.println("You pick up the set of leather armor.");
            getInventory().setArmor(1, true);
        }
        
        //worthless things
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "torch"))
        {
            System.out.println("The wooden torches on each wall keep the room dimly lit.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "grab") || Search.check(answer, "pick up")) && Search.check(answer, "torch"))
        {
            System.out.println("All the torches are attached to the wall. They won't budge.");
        }
        else if(Search.check(answer, "unlock") && Search.check(answer, "door"))
        {
            System.out.println("Unlock which door?");
        }
        else if(Search.check(answer, "listen"))
        {
            System.out.println("You hear nothing.");
        }
        else
        {
            System.out.println("Input invalid.");
        }
    }
}
