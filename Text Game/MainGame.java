
/**
 * Write a description of class MainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class MainGame
{

    public static void main(String[] args)
    throws InterruptedException {
        boolean playing = true;
        Scanner scoobs = new Scanner(System.in);
        String answer = "";

        System.out.println("\f _______  ______            _______  _       _________          _______  _______                 _______  _______  _______ ");
        System.out.println("(  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\      |\\     /|(  ____ \\(  ____ )(  ___  )");
        System.out.println("| (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/      | )   ( || (    \\/| (    )|| (   ) |");
        System.out.println("| (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__          | (___) || (__    | (____)|| |   | |");
        System.out.println("|  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)         |  ___  ||  __)   |     __)| |   | |");
        System.out.println("| (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (            | (   ) || (      | (\\ (   | |   | |");
        System.out.println("| )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\      | )   ( || (____/\\| ) \\ \\__| (___) |");
        System.out.println("|/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/      |/     \\|(_______/|/   \\__/(_______)");
        System.out.println("\n");
        while(!Search.check(answer, "yes"))
        {
            System.out.print("Start game?: ");
            answer = scoobs.nextLine();

            if(Search.check(answer, "no"))
                System.out.println("\fPlease?");
            else if(!Search.check(answer, "yes"))
                System.out.println("\fPlease just say yes or no.");
        }
        while(playing)
        {        
            int x = 2;
            int y = 4;

            //player and inventory
            Player hero = new Player("Hero", "The protagonist of the game.", 5, 10);
            Inventory inv = new Inventory(hero);
            hero.setEquippedWeapon(inv.getWeapon(0));
            hero.setEquippedArmor(inv.getArmor(0));
            boolean living = true;

            //enemy encounters
            RatEncounter rat = new RatEncounter();

            //locations
            Location[][] loc = new Location[7][7];
            loc[2][4] = new RatRoom("the cell", "There is a door to the east", "The dark cell is large and mostly empty except for bones and chains. Light only enters the room through a small opening in the cell's door, but you can still\nsee the rat bleeding on the floor. The remnants of what looks and smells like an eaten body is on the other side of the room.", inv, hero, true, loc);
            loc[2][5] = new RoomTwo("the cellblock", "The door to your cell is to west and there are stairs to the south.", "Cell doors and torches line the walls of the long room. There is a small table near the stairs where someone s obviously supposed to stand guard.", inv, hero, false, loc);
            loc[3][5] = new Barracks("the barracks", "There are stairs to the north and doors to the east and south.", "The room is large and made for soldiers to relax in after a day of patroling. The well-lit room is full of tables and chiars as well as a large chest.", inv, hero, true, loc);

            living = rat.run(hero, inv);
            while(living)
            {
                System.out.print("\nInput: ");
                answer = scoobs.nextLine();

                System.out.println(loc[x][y]);
                if(Search.check(answer, "inv"))
                {
                    inv.getInv();
                    System.out.println(loc[x][y]);
                }
                else if(Search.check(answer, "stat"))
                {
                    hero.getStats();
                }
                else if(Search.check(answer, "north"))
                {
                    if(x - 1 < 0 || loc[x - 1][y].equals(null))
                        System.out.println("There are no rooms to the north.");
                    else if(!loc[x - 1][y].getOpen())
                        System.out.println("The door to the north is locked.");
                    else
                    {
                        x -= 1;

                        System.out.println(loc[x][y]);
                    }
                }
                else if(Search.check(answer, "east"))
                {
                    if(y + 1 == loc[y].length || loc[x][y + 1].equals(null))
                        System.out.println("There are no rooms to the east.");
                    else if(!loc[x][y + 1].getOpen())
                        System.out.println("The door to the east is locked.");
                    else
                    {
                        y += 1;
                        System.out.println(loc[x][y]);
                    }
                }
                else if(Search.check(answer, "south"))
                {
                    if(x + 1 == loc.length || loc[x + 1][y].equals(null))
                        System.out.println("There are no rooms to the south.");
                    else if(!loc[x + 1][y].getOpen())
                        System.out.println("The door to the south is locked.");
                    else
                    {
                        x += 1;
                        System.out.println(loc[x][y]);
                    }
                }
                else if(Search.check(answer, "west"))
                {
                    if(y - 1 < 0 || loc[x][y - 1].equals(null))
                        System.out.println("There are no rooms to the west.");
                    else if(!loc[x][y - 1].getOpen())
                        System.out.println("The door to the west is locked.");
                    else
                    {
                        y -= 1;
                        System.out.println(loc[x][y]);
                    }
                }
                else if(Search.check(answer, "items"))
                {
                    inv.getItems();
                }
                else if(Search.check(answer, "sonic") || Search.check(answer, "sanic"))
                {
                    System.out.println("Gotta go fast.");
                }
                else if(Search.check(answer, "rest"))
                {
                    System.out.println("You rest to get back your strength.");
                    hero.setHealth(hero.getMaxHealth());
                }
                else
                    loc[x][y].run(answer);

                if(hero.getHealth() <= 0)
                    living = false;
            }
            Thread.sleep(1000);
            System.out.println("\n\n _______  _______  _______  _______        _______           _______  _______ ");
            Thread.sleep(1000);
            System.out.println("(  ____ \\(  ___  )(       )(  ____ \\      (  ___  )|\\     /|(  ____ \\(  ____ )");
            Thread.sleep(1000);
            System.out.println("| (    \\/| (   ) || () () || (    \\/      | (   ) || )   ( || (    \\/| (    )|");
            Thread.sleep(1000);
            System.out.println("| |      | (___) || || || || (__          | |   | || |   | || (__    | (____)|");
            Thread.sleep(1000);
            System.out.println("| | ____ |  ___  || |(_)| ||  __)         | |   | |( (   ) )|  __)   |     __)");
            Thread.sleep(1000);
            System.out.println("| | \\_  )| (   ) || |   | || (            | |   | | \\ \\_/ / | (      | (\\ (   ");
            Thread.sleep(1000);
            System.out.println("| (___) || )   ( || )   ( || (____/\\      | (___) |  \\   /  | (____/\\| ) \\ \\__");
            Thread.sleep(1000);
            System.out.println("(_______)|/     \\||/     \\|(_______/      (_______)   \\_/   (_______/|/   \\__/");
            Thread.sleep(1000);
            System.out.print("Try again?: ");
            answer = scoobs.nextLine();
            if((!Search.check(answer, "yes")) && (!Search.check(answer, "yep")) && (!Search.check(answer, "yeah")) && (!Search.check(answer, "mhm")))
            {
                if(!Search.check(answer, "no") && !Search.check(answer, "nope") && !Search.check(answer, "nah"))
                    System.out.println("I don't know what that means. Bye.");
                playing = false;
            }
        }
    }

}
