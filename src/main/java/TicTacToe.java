public class TicTacToe
{

    private char player = '\0';
    private final static int SIZE = 3;
    private Character[][] board =
            {
                    {'\0', '\0', '\0'},
                    {'\0', '\0', '\0'},
                    {'\0', '\0', '\0'}
            };

    public String play(int x, int y) {
        checkXAxis(x);
        checkYAxis(y);
        player = nextPlayer();
        setBox(x, y, player);

        if(isWinner())
            return player + " is the winner";
        return "No winner";


    }

    private boolean isWinner()
    {
        for (int index = 0; index < SIZE; index++)
        {
            if (board[0][index] == player && board[1][index] == player && board[2][index] == player)
            {
                return true;
            }
        }
        return false;
    }

    private void checkXAxis(int x)
    {
        if (x < 1 || x > 3 )
        {
            throw new RuntimeException("X is outside the board");
        }
    }

    private void checkYAxis(int y)
    {
        if (y < 1 || y > 3 )
        {
            throw new RuntimeException("Y is outside the board");
        }
    }

    private void setBox(int x, int y, char player)
    {
        if (board[x - 1][y - 1] != '\0')
        {
            throw new RuntimeException("Box is already occupied");
        }
        else {
            board[x - 1][y - 1] = player;
        }
    }

    public char nextPlayer()
    {
        if (player == 'X')
            return 'O';
        else
            return 'X';
    }
}
