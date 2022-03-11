import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board
{
    public int w;
    public int h;
    final static char USERSYM = 'X', AUTOSYM = 'O', BLANKSYM = ' ';
    public JButton data[][];
    
    public Board(int w, int h)
    {
        data = new JButton[h][w];
        this.w = w;
        this.h = h;
        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
            {
                final int YCOPY = y;
                final int XCOPY = x;
                data[y][x] = new JButton();
				data[y][x].setBounds(50+x*150, 50+y*150, 100, 100);
				data[y][x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!claim(XCOPY, YCOPY, USERSYM)) System.out.println("Not claimable.");
                        else autoClaim();
					}
				});
                setAt(x, y, BLANKSYM);
            }
        }
    }

    public void setAt(int x, int y, char c)
    {
        data[y][x].setText(Character.toString(c));
        if (c != BLANKSYM) data[y][x].setEnabled(false);
    }
    public char getAt(int x, int y)
    {
        return data[y][x].getText().charAt(0);
    }

    public boolean claim(int x, int y, char c)
    {
        // claim it if possible
        if (x >= 0 && y >= 0 && x < w && y < h && getAt(x, y) == BLANKSYM)
        {
            setAt(x, y, c);
            return true;
        }
        return false;
    }

    // returns false when nothing was claimable; otherwise false
    public boolean autoClaim()
    {
        // get list of available choices
        int available[] = new int[h * w];
        // after this loop, i will be the number of available options
        // within the loop, i keeps track of what index in available should be written to
        int i = 0;
        for (int j = 0; j < w * h; j++)
            if (getAt(j % w, j / w) == BLANKSYM)
                available[i++] = j;
        if (i == 0) return false; // none available
        // choose random one
        i = available[(int) (Math.random() * i)];
        setAt(i % w, i / w, AUTOSYM);
        return true;
    }


    public String toString()
    {
        String output = "";
        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
                output += getAt(x, y);
            if (y != h - 1) output += '\n';
        }
        return output;
    }
}
