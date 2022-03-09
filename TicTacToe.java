import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] commands = { "nw", "n", "ne", "w", "c", "e", "sw", "s", "se" };
        boolean playing = true;
        while (playing)
        {
            String input = getValidCommand("Where would you like to claim?", sc, commands);
            System.out.println("Ok, you claim " + input);
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
