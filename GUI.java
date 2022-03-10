import javax.swing.JFrame;

public class GUI extends JFrame {
	public GUI(Board board) {
		super("TicTacToe");
		this.setTitle("TicTacToe");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 500, 525);
		for (int y = 0; y < board.h; y++)
			for (int x = 0; x < board.w; x++)
				this.add(board.data[y][x]);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}