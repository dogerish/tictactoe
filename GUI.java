import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	private final JButton[][] buttonArray =
	{
		{new JButton(), new JButton(), new JButton()},
		{new JButton(), new JButton(), new JButton()},
		{new JButton(), new JButton(), new JButton()}
	};

	public GUI() {
		super("TicTacToe");
		this.setTitle("TicTacToe");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 500, 525);
		for (int x = 0; x <3; x++)
			{
				for (int y = 0; y < 3; y++)
				this.add(makeButton(x, y, buttonArray));
			}
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JButton makeButton(int x, int y, JButton[][] buttonArray) {
				buttonArray[x][y].setText("Click me!");
				buttonArray[x][y].setBounds(50+x*150, 50+y*150, 100, 100);
				buttonArray[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonArray[x][y].setText("X");
					}
				});
				return buttonArray[x][y];
	}
}