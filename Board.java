public class Board
{
    public int w;
    public int h;
    public char data[][];
    
    public Board(int w, int h)
    {
        data = new char[h][w];
        this.w = w;
        this.h = h;
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                setAt(x, y, ' ');
    }

    public void setAt(int x, int y, char c)
    {
        data[y][x] = c;
    }
    public char getAt(int x, int y)
    {
        return data[y][x];
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
