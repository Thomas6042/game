import java.util.Scanner;
/**
 * Write a description of class CaptainEncounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaptainEncounter
{
    public boolean run(Player hero, Inventory inv, Enemy cap)
    {
        Scanner scoobs = new Scanner(System.in);
        Battle fight = new Battle();
        int rando;

        boolean defending;
        boolean go;
        boolean itemUsed;
        String answer = "";
        while(cap.getHealth() > 0)
        {
            defending = false;
            go = false;
            while(!go)//use break method in non-invalid inputs
            {
                while(!go)
                {
                    System.out.print("\n");
                    fight.prompt(hero, cap);
                    System.out.print("Input: ");
                    answer = scoobs.next();
                    System.out.print("\f");
                    itemUsed = false;
                    if(answer.equals("1") || Search.check(answer, "attack"))
                    {
                        System.out.println("You attack the Captain of the Guard.");
                        cap.setHealth(cap.getHealth() - (int)(hero.getAttack()/2));
                        break;
                    }
                    else if(answer.equals("2") || Search.check(answer, "defend"))
                    {
                        System.out.println("You defend against the Captain of the Guard's attack");
                        defending = true;
                        break;
                    }
                    else if(answer.equals("3") || Search.check(answer, "item"))
                    {
                        System.out.print("\f");
                        while(!go)
                        {
                            System.out.println();
                            inv.getItems();
                            System.out.println("exit");
                            System.out.print("\nInput: ");
                            answer = scoobs.nextLine();
                            System.out.print("\f");
                            if(Search.check(answer, "throw") && Search.check(answer, "stone") && inv.getItem(1).getHave())
                            {
                                System.out.println("\fYou throw the stone at your opponent");
                                inv.setItem(1, false);
                                cap.setHealth(cap.getHealth() - 1);
                                itemUsed = true;
                                break;
                            }
                            else if(Search.check(answer, "cell key"))
                                System.out.println("You can not use the cell key in this battle");
                            else if(Search.check(answer, "exit"))
                                break;
                            else
                                System.out.println("Input invalid");
                        }
                        if(itemUsed)
                            break;
                    }
                    else if(answer.equals("4") || Search.check(answer, "inv"))
                    {
                        if(inv.getInvBattle())
                            break;
                    }
                    else if(answer.equals("5") || Search.check(answer, "observe"))
                    {
                        System.out.println("The soldier standing in front of you is skilled in all kinds of combat. His beautiful crafted armor can make all but the greatest of weapons seem weak.");
                        break;
                    }
                    else if(answer.equals("6") || Search.check(answer, "run"))
                    {
                        System.out.println("You turn to run, but your adversary uses the opening to attack, keeping you in the fight.");
                        break;
                    }
                    else
                    {
                        System.out.println("Input invalid\n");
                    }
                }
                rando = (int)(Math.random() * 5);
                //captian attacks
                if(cap.getHealth() > 0)
                {
                    if(rando == 0)
                        System.out.println("\nThe captain masterfully swings his sword, stricking you in the arm.");
                    else if(rando == 1)
                    {
                        System.out.println("\nYou are struck by quick thrust to your shoulder.");
                    }
                    else if(rando == 2)
                    {
                        System.out.println("\nTaking an opening, the captain swings for your torso.");
                    }
                    else if(rando == 3)
                    {
                        System.out.println("\nThe captain disrupts your footing and stricks your head with his pommel.");
                    }
                    else if(rando == 4)
                    {
                        System.out.println("\nAn overhead swing comes right for you, but you move in time for it to do only minor damage.");
                    }

                    if(defending)
                    {
                        hero.setHealth(hero.getHealth() - (int)(cap.getAttack()/2));
                        System.out.println("You take " + (int)(cap.getAttack()/2) + " damage");
                    }
                    else
                    {
                        hero.setHealth(hero.getHealth() - cap.getAttack());
                        System.out.println("You take " + cap.getAttack() + " damage");
                    }
                }
                if(hero.getHealth() <= 0)
                    return false;
            }
        }

        return true;
    }
}
