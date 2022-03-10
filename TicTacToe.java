import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] commands = { "nw", "n", "ne", "w", "c", "e", "sw", "s", "se" };
        int[][3] board = {
        	{ 0, 0, 0 },
        	{ 0, 0, 0 },
        	{ 0, 0, 0 }
        }
        boolean playing = true;
        while (playing)
        {
            String input = getValidCommand("Where would you like to claim?", sc, commands);
            boolean row = 2;
            switch (input.charAt(0))
            {
            	case 'n': row = 0;
            	case 's':
            		// select north or south directly
            		if (input.length() == 1)
            		else if (input.charAt(1) == 'w') // select (north/south)west
            		else // select (north/south)east
            		break;
            	case 'e': break; // select east
            	case 'w': break; // select west
            	case 'c': break; // select center
            }
        }
    }

    public static String getValidCommand(String prompt, Scanner sc, String[] commands)
    {
        String input = null;
        boolean invalid = true;
        while (invalid)
        {
		System.out.println(prompt);
		input = sc.nextLine().toLowerCase();
        	for (String cmd : commands)
        	{
        		if (input.equals(cmd))
        		{
        			invalid = false;
        			break;
        		}
        	}
        }
        return input;
    }
}
