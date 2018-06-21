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
        {
            return player + " is the winner";
        } else if (isDraw())
        {
            return "The result is draw";
        }
        return "No winner";
    }

    private boolean isWinner()
    {
        int playerTotal = player * 3;
        char diagonal1 = '\0';
        char diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++)
        {
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
            if (board[0][i] + board[1][i] + board[2][i] == playerTotal)
            {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] == playerTotal)
            {
                return true;
            }
        }

        if (diagonal1 == playerTotal || diagonal2 == playerTotal)
        {
            return true;
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

    private boolean isDraw()
    {
        for (int x = 0; x < SIZE; x++)
        {
            for (int y = 0; y <SIZE; y++)
            {
                if (board[x][y] == '\0')
                {
                    return false;
                }
            }
        }
        return true;
    }
}
