
/**
 * Write a description of class RatEncounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class RatEncounter
{
    private int counter = 0;

    public boolean run(Player hero, Inventory inv)
    {
        Scanner scoobs = new Scanner(System.in);
        Enemy rat = new Enemy("Rat", "An overgrown rat", 1000, 10);
        Battle fight = new Battle();

        String answer = "";
        boolean haveSword = false;
        boolean defending = false;
        boolean fistAttack = false;
        boolean go = false;

        System.out.println("\fFeeling cold stone against your skin, you open your eyes and find yourself laying on a dimly lit dungeon floor. You start to slowly get up, but as soon as you move you hear"
            + "\nsomething far behind you. You dart up and see the outline of a huge, grotesque rat heading right for you from the other end of the room. You have to act fast.");
        while(rat.getHealth() > 0)
        {

            go = false;
            while(!go)
            {
                System.out.print("\n");
                fight.prompt(hero, rat);
                System.out.print("Input: ");
                answer = scoobs.next();
                System.out.print("\f"); 

                go = true;
                if(answer.equals("1") || Search.check(answer, "attack"))
                {
                    if(hero.getEquippedWeapon().equals("fist"))
                    {
                        if(counter <2)
                            System.out.println("You hold up our fists to fight off the beast but it is still too far away to reach.\n");
                        else
                        {
                            System.out.println("You get in one good blow with your fist.\n");
                            fistAttack = true;
                            rat.setHealth(rat.getHealth() - hero.getAttack());
                        }
                    }
                    else if(hero.getEquippedWeapon().equals("broken sword"))
                    {
                        System.out.println("You plunge what remains of the blade into the flesh of the rat and it gives out a haunting scream. You push on the hilt as hard as you can and pin the rat to the"
                            + "\ndungeon floor. Its bloody jaws and deadly claws snap and swipe at you in a useless attempt to escape its demise. You watch as the rat's struggle weakens and then"
                            + "\nsubsides. Withdrawing your blade from the beast, you step away from the lifeless body and take in your surroundings.\nThe room is an old cell. There is a door to the east.\n");
                        rat.setHealth(rat.getHealth() - hero.getAttack());
                        return true;
                    }
                }
                else if(answer.equals("2") || Search.check(answer, "defend"))
                {
                    System.out.println("You hold up your naked arms in a desperate attempt to block the rat's lethal attack.\n");
                    if(counter == 2)
                        defending = true;
                }
                else if(answer.equals("3") || Search.check(answer, "item"))
                {
                    System.out.println("You have no items.\n");
                }
                else if(answer.equals("4") || Search.check(answer, "inv"))
                {
                    go = inv.getInvBattle();
                    if(go == false)
                    {
                        counter--;
                    }
                }
                else if(answer.equals("5") || Search.check(answer, "observe"))
                {
                    System.out.print("The starving rat obviously sees you as its next meal.");
                    if(!haveSword)
                    {
                        System.out.print(" Looking to the left, though, you see a broken sword. You pick up the broken sword.");
                        inv.setWeapon(1, true);
                        haveSword = true;
                    }
                    System.out.println("\n");
                }
                else if(answer.equals("6") || Search.check(answer, "run"))
                {
                    System.out.println("You turn around to run from the rat but find that your back is literally aganist a wall.\n");
                }
                else if(answer.equals("skip"))
                {
                    return true;
                }
                else
                {
                    System.out.println("Input invalid\n");
                    go = false;
                    counter--;
                }
                

                counter++;
                if(counter == 1)
                {
                    System.out.println("Now half halfway across the room, the starving rat is close enough to where you can see its blood-soaked fur glisen crimson.");
                }
                else if(counter == 2)
                {
                    System.out.println("The rat begins to hiss and screech as it prepares to attack. It is almost upon you.");
                }
                else if(counter == 3)
                {
                    if(rat.getHealth() > 0)
                    {
                        if(fistAttack)
                            System.out.println("Your punch barely phases the rat. Its teeth bite into your unprotected neck and you die instantly.");
                        else if(defending)    
                            System.out.println("Your defense does no good against the rat who tears through your unprotected flesh.");
                        else
                            System.out.println("It's too late. The rat reaches you tears you apart.");

                        return false;
                    }
                    else
                    {
                        rat.setAlive(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
