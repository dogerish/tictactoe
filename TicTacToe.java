import java.util.Scanner;
import javax.swing.SwingUtilities;

public class TicTacToe
{
    public static Board board = new Board(3, 3);
    public static void main(String[] args)
    {
		// Swing calls must be run by the event dispatching thread.
		SwingUtilities.invokeLater(() -> new GUI());
        Scanner sc = new Scanner(System.in);
        boolean playing = true;
        while (playing)
        {
            do System.out.println("what");
            while (!claim(sc.nextInt(), sc.nextInt(), 'x'));
            autoClaim();
            System.out.println(board);
        }
    }

    public static boolean claim(int x, int y, char player)
    {
        // claim it if possible
        if (x >= 0 && y >= 0 && x < board.w && y < board.h && board.data[y][x] == ' ')
        {
            board.setAt(x, y, player);
            return true;
        }
        return false;
    }

    public static void autoClaim()
    {
        while (!claim(
            (int) (Math.random() * board.w),
            (int) (Math.random() * board.h),
            'o'
        ));
    }
}
