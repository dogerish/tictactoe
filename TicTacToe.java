import javax.swing.SwingUtilities;

public class TicTacToe
{
    public static Board board = new Board(3, 3);
    public static void main(String[] args)
    {
		// Swing calls must be run by the event dispatching thread.
		SwingUtilities.invokeLater(() -> new GUI(board));
    }
}
