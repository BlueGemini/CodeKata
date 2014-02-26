package guess;

import junit.framework.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by xiaolongchang on 2/26/14.
 */
public class GameTest {

    @Test
    public void should_return_you_win(){
        //Given
        String givenNum = "1234";
        int cs=6;
        IComparetor comparetor=mock(IComparetor.class);
        //When
        when(comparetor.compare(givenNum,"1234")).thenReturn("x4y0");
        String output = new Game(givenNum,comparetor, cs).guess("1234",1);

        //Then
        Assert.assertEquals(output,"You win");
    }

    @Test
    public void should_return_you_lose(){
        //Given
        String givenNum = "1234";
        int cs=6;
        IComparetor comparetor=mock(IComparetor.class);

        Game game = new Game(givenNum, comparetor, cs);


        //When
        when(comparetor.compare(givenNum,"3241")).thenReturn("x1y3");
        String output = game.guess("3241",6);

        //Then
        Assert.assertEquals(output,"You lose");
    }

    @Test
    public void should_return_feedback_when_guess_wrong(){
        //Given
        String givenNum = "1234";
        int cs =6;
        IComparetor comparetor=mock(IComparetor.class);
        Game game = new Game(givenNum,comparetor, cs);

        //When

        when(comparetor.compare(givenNum,"3241")).thenReturn("x1y3");
        String output = game.guess("3241",1);

        //Then
        Assert.assertEquals(output,"x1y3");
    }

    @Test
    public void should_return_compare_when_guess_wrong(){
        //Given
        String givenNum = "1234";
        int cs =6;
        IComparetor comparetor = mock(IComparetor.class);
        Game game = new Game(givenNum, comparetor, cs);

        //When
        when(comparetor.compare(givenNum,"3241")).thenReturn("x1y3");
        String output = game.guess("3241",1);

        //Then
        Assert.assertEquals(output,"x1y3");
        verify(comparetor,times(1)).compare(givenNum,"3241");
    }

}
