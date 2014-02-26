package guess;

/**
 * Created by xiaolongchang on 2/26/14.
 */
public class Game {
    private String givenNum;
    private int cs=0;
    private IComparetor comparetor=null;
    public Game(String givenNum, IComparetor comparetor, int cs) {
        this.givenNum = givenNum;
        this.cs=cs;
        this.comparetor=comparetor;
    }

    public String guess(String s,int cs) {
        String result = comparetor.compare(this.givenNum,s);
        if (result.equalsIgnoreCase("x4y0")){
            return "You win";
        }else if(cs<this.cs){
            return result;
        }
        return "You lose";
    }
}
