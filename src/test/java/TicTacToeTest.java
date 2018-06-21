import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest
{

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before()
    {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testXAxis()
    {
        exception.expect(RuntimeException.class);

        ticTacToe.play(5, 1);
    }

    @Test
    public void testYAxis()
    {
        exception.expect(RuntimeException.class);

        ticTacToe.play(1, 5);
    }

    @Test
    public void testUnoccupied()
    {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void testNextPlayer()
    {
        Assert.assertEquals(ticTacToe.nextPlayer(), 'X');
        ticTacToe.play(2, 2);
        Assert.assertEquals(ticTacToe.nextPlayer(), 'O');
    }

    @Test
    public void whenPlayThenNoWinner()
    {
        String actual = ticTacToe.play(1, 1);
        Assert.assertEquals("No winner", actual);
    }

    @Test
    public void horizontalLineWinner()
    {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 1); //X
        ticTacToe.play(2, 2); //O
        String actual = ticTacToe.play(3, 1); //X
        Assert.assertEquals("X is the winner", actual);
    }



}