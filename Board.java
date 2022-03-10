import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board
{
    public int w;
    public int h;
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
						if (!claim(XCOPY, YCOPY, 'x')) System.out.println("Not claimable.");
                        else autoClaim();
					}
				});
                setAt(x, y, ' ');
            }
        }
    }

    public void setAt(int x, int y, char c)
    {
        data[y][x].setText(Character.toString(c));
    }
    public char getAt(int x, int y)
    {
        return data[y][x].getText().charAt(0);
    }

    public boolean claim(int x, int y, char c)
    {
        // claim it if possible
        if (x >= 0 && y >= 0 && x < w && y < h && getAt(x, y) == ' ')
        {
            setAt(x, y, c);
            return true;
        }
        return false;
    }

    public void autoClaim()
    {
        while (!claim(
            (int) (Math.random() * w),
            (int) (Math.random() * h),
            'o'
        ));
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
