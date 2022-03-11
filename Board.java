import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Board
{
    public int w;
    public int h;
    final static char USERSYM = 'X', AUTOSYM = 'O', BLANKSYM = ' ';
    public JButton data[][];
    final static String WINMSG = "You won!", LOSEMSG = "You lost!", TIEMSG = "You tied!";

    
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
						setAt(XCOPY, YCOPY, USERSYM);
                        //check for win
                        String win = winChecker();
                        // player won, OR bot has nowhere to go (tie), OR bot won
                        if (win != TIEMSG || !autoClaim() || (win = winChecker()) != TIEMSG)
                        {
                            JOptionPane.showMessageDialog(data[YCOPY][XCOPY], win);
                            // disable all
                            for (int y = 0; y < h; y++)
                                for (int x = 0; x < w; x++)
                                    data[y][x].setEnabled(false);
                        }
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

    public String winChecker()
    {
        //Checking Columns
        for (int x = 0; x < w; x++)
        {
            int sum = getAt(x, 0) + getAt(x, 1) + getAt(x, 2);
            switch (sum)
            {
            case USERSYM*3:
                return WINMSG;
            case AUTOSYM*3:
                return LOSEMSG;
            }
        }
        //Checking Rows
        for (int y = 0; y < h; y++)
        {
            int sum = getAt(0, y) + getAt(1, y) + getAt(2, y);
            switch (sum)
            {
            case USERSYM*3:
                return WINMSG;
            case AUTOSYM*3:
                return LOSEMSG;
            }
        }
        //Checking Diagonals
        switch (getAt(0, 0) + getAt(1, 1) + getAt(2, 2))
        {
            case USERSYM*3:
                return WINMSG;
            case AUTOSYM*3:
                return LOSEMSG;
        }

        switch ((((((((((((getAt(2, 0) + getAt(1, 1) + getAt(0, 2)))))))))))))
        {
            case USERSYM*3:
                return WINMSG;
            case AUTOSYM*3:
                return LOSEMSG;
        }
        return TIEMSG;
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
