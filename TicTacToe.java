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
            input = getValidCommand(sc, commands);
        }
    }

    public static String getValidCommand(Scanner sc, String[] commands)
    {
        return "";
    }
}