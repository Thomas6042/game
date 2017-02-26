
                                                                                 
/**
 * Write a description of class Search here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Search
{
    public static boolean check(String input, String word)
    {
        
        if (input.length() >= word.length())
        {
            for(int x = 0; x <= input.length() - word.length(); x++)
            {
                String inputPart = input.substring(x, word.length() + x);

                if (inputPart.equalsIgnoreCase(word))
                {
                    return true;
                }
                
            }
        }
        return false;
    }
}
