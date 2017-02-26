
/**
 * Write a description of class RatRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RatRoom extends Location
{
    private boolean doorLocked = true;
    private boolean keySeen = false;
    public RatRoom(String n, String d, String ld, Inventory i, Player p, boolean o, Location[][] locat)
    {
        super(n, d, ld, i, p, o, locat);
    }

    public void run(String answer)
    {
        /*
         * remember to make the body go away after going into a specified room
         */
        if((Search.check(answer, "look") || Search.check(answer, "search")) && (Search.check(answer, "surroundings") ||Search.check(answer, "enviornment") || Search.check(answer, "room") || Search.check(answer, "cell") || Search.check(answer, "around")))
        {
            System.out.println(locationDescription());
        }
        //body stuff
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "body"))
        {
            System.out.println("The body seems to be that of a jailer who didn't expect to meet the starving rat when he came in to check on you. Although the rat did a number on the man,"
                + "\nonly chunks of flesh are missing.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && (Search.check(answer, "body") || Search.check(answer, "jailer")))
        {
            System.out.println("You don't have any room to take the body.");
        }
        else if((Search.check(answer, "search") || Search.check(answer, "loot")) && (Search.check(answer, "body") || Search.check(answer, "jailer") || Search.check(answer, "man")))
        {
            if(!getInventory().getItem(0).getHave())
            {
                System.out.println("You disturb the rest of the dead body, but you succeed in finding out that he had a key.");
                keySeen = true;
            }
            else
                System.out.println("You've already searched the jailer. It's best not to disturb the body again.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && Search.check(answer, "key"))
        {
            if(getInventory().getItem(0).getHave())
                System.out.println("You already have the key");
            else if(keySeen)
            {
                System.out.println("You take the key from the body. He hopefully won't need it anymore.");
                getInventory().setItem(0, true);
            }
            else
                System.out.println("If you knew where the key was, I'm sure you would pick it up. Unfortunately you don't know where it is.");
        }

        //getting out/door
        else if(Search.check(answer, "open") && Search.check(answer, "door"))
        {
            if(doorLocked)
            {
                System.out.println("The door is locked.");
            }
            else 
            {
                System.out.println("Which way is the door?");
            }
        }
        else if(Search.check(answer, "unlock") && Search.check(answer, "door"))
        {
            if(getInventory().getItem(0).getHave())
            {
                System.out.println("You use the cell key and unlock the door.");
                doorLocked = false;
                getLocation()[2][5].setOpen(true);
            }
            else if(doorLocked == false)
            {
                System.out.println("The door is already unlocked.");
            }
            else
                System.out.println("You don't have the key.");
        }
        else if(Search.check(answer, "lock") && Search.check(answer, "door"))
        {
            if(doorLocked)
                System.out.println("The door is already locked.");
            else
            {
                System.out.println("You lock the door.");
                getLocation()[2][5].setOpen(false);
                doorLocked = true;
            }
        }

        //rat stuff
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "rat"))
        {
            System.out.println("The rat still lays bleeding on the floor. You don't know how it got in the cell, but you best not question it.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pickup") || Search.check(answer, "grab")) && Search.check(answer, "rat"))
        {
            System.out.println("You have no need for a dead rat.");
        }
        else if((Search.check(answer, "search") || Search.check(answer, "loot")) && Search.check(answer, "rat"))
        {
            System.out.println("The rat has nothing of value.");
        }

        //worthless things
        else if(Search.check(answer, "pick") && Search.check(answer, "lock"))
        {
            System.out.println("You haven't the skills or materials to do that.");
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && Search.check(answer, "chain"))
        {
            System.out.println("You pull on the chains as hard as you can, but unfortunately they are all connected to the stone walls."); 
        }
        else if((Search.check(answer, "take") || Search.check(answer, "pick up") || Search.check(answer, "grab")) && Search.check(answer, "bone"))
        {
            System.out.println("The bones are old and frail. It's best you leave them alone and keep your load light.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "door"))
        {
            System.out.println("The door is solid iron with a small opening at eye level.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "through opening"))
        {
            System.out.println("The opening in the iron door is barred.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "opening"))
        {
            System.out.println("Looking through the small opening, you observe that the next room is a cellblock filled with doors similar to this one."); 
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "chain"))
        {
            System.out.println("The chains are rusty but solid.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && Search.check(answer, "bone"))
        {
            System.out.println("The bones of past prisoners are scattered across the floor. You hope you won't meet the same fate they did.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && (Search.check(answer, "floor") || Search.check(answer, "ground")))
        {
            System.out.println("The bland color of the bones scattered across the floor is only contrasted by the rat's blood and the blood of the fresh body.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && (Search.check(answer, "wall")))
        {
            System.out.println("The only things connected to the walls are the chains.");
        }
        else if((Search.check(answer, "look") || Search.check(answer, "observe")) && (Search.check(answer, "ceiling") || Search.check(answer, "roof")))
        {
            System.out.println("There's nothing up there.");
        }
        else if(Search.check(answer, "smell") && Search.check(answer, "body"))
        {
            System.out.println("The body doesn't smell much. It must have been killed recently.");
        }
        else if(Search.check(answer, "smell") && Search.check(answer, "rat"))
        {
            System.out.println("Smells like a dead rat.");
        }
        else if(Search.check(answer, "smell"))
        {
            System.out.println("You'd rather not think about the smell of the room.");
        }
        else if((Search.check(answer, "hit") || Search.check(answer, "attack") || Search.check(answer, "break down")) && Search.check(answer, "door"))
        {
            System.out.println("You try your best to break down the door but end up only hurting yourself in the process.\nYou take 1 point of damage.");
            getPlayer().setHealth(getPlayer().getHealth() - 1);
            if(getPlayer().getHealth() <= 0)
                System.out.println("\nYou've lost the fight against the door. You are beaten and you know it. You die alone in your cell.");
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
