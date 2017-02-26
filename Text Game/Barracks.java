
/**
 * Write a description of class Barracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barracks extends Location
{
    boolean first;
    boolean inCell;
    boolean cellLocked;
    Enemy captain = new Enemy("Captain of the Guard", "A great warrior dressed in sturdy steel armor.", 7, 30);
    CaptainEncounter capFight = new CaptainEncounter();
    public Barracks(String n, String d, String ld, Inventory i, Player p, boolean o, Location[][] locat)
    {
        super(n, d, ld, i, p, o, locat);
        inCell = false;
        cellLocked = false;
        first = true;
    }
    
    public void run(String answer)
    {
        if(first)
        {
            System.out.println("You walk up the stairs and enter a large room and before you can do anything you see there is a heavily-armored man standing with his back to you in the middle of the room." +
                               "\nSo as to not attract attention to yourself, you hide behind a nearby crate.\n");
            first = false;
        }
        else if(!inCell && !cellLocked)
        {
            System.out.println("There is a heavily-armored man standing with his back to you in the middle of the room. So as to not attract attention to yourself, you hide behind a nearby crate.\n");
                               
            if((Search.check(answer, "look") || Search.check(answer, "search"))  && (Search.check(answer, "around") || Search.check(answer, "room") || Search.check(answer, "barrack")))
            {
                System.out.println("Peering over the crate, you see the armored man standing in the middle of the room looks as if he is expecting a fight, almost to the point where he jumps at his own" +
                            "\nshadow and inspects any noise he hears. The room is filled with tables and chairs as well as a large chest up against the wall. There is a small holding cell against the" +
                            "\nwestern wall.");
            }
            else if((Search.check(answer, "look") || Search.check(answer, "search")) && Search.check(answer, "cell"))
            {
                System.out.println("You look over the crate and see that the holding cell is small, but has a thick iron door which is wide open.");
            }
            else if((Search.check(answer, "look") || Search.check(answer, "observe") || Search.check(answer, "study")) && (Search.check(answer, "man") || Search.check(answer, "captain") || Search.check(answer, "guard")))
            {
                System.out.println("The man looks powerful and experianced. The quality of his armor seems to suggest that he is the captain of the guard. Although obviously a great man, he looks skittish.");
            }
            else if((Search.check(answer, "look") || Search.check(answer, "search") || Search.check(answer, "observe") || Search.check(answer, "study")) && (Search.check(answer, "stairs") || Search.check(answer, "table") || Search.check(answer, "chair") || Search.check(answer, "chest")))
            {
                System.out.println("You shouldn't peek your head out and risk being seen to look at things you don't have to look at.");
            }
            //alerting the guard
            else if((Search.check(answer, "attack") || Search.check(answer, "fight") || Search.check(answer, "sneak")) && (Search.check(answer, "man") || Search.check(answer, "captain")))
            {
                System.out.println("\fYou try to sneak up on the man, but as soon as you take your first few steps he hears you, turns around, and gets ready to fight.");
                if(!capFight.run(getPlayer(), getInventory(), captain))
                    System.out.println("\nYour opponent was too skilled and too well-equipped. You have no more fight left in you, and once the final blow is struck you're left to die on the cold dungeon floor.");
            }
        }
    }
}
