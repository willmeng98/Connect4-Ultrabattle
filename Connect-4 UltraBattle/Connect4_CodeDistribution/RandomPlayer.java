import java.util.*;

public class RandomPlayer implements Player
{
  
  
  public RandomPlayer()
  {
    
    
  }
  
  public int move(int[][] B)
  {
    boolean found = false;
    int themove = 0;
    while(found == false)
    {
    Random rn = new Random();
    int answer = rn.nextInt(B.length);
    if(B[answer][0] == 0)
    {
      themove = answer;
      found = true;
    }
    }
    
    return themove;
  }
  

  
  
  
  
  
  
  
  
  
  
}