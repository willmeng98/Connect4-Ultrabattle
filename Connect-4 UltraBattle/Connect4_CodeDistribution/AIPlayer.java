/** AIPlayer.java: 
  * The AI file for the Connect4 Game
  * Decides which moves the computer makes based on extremely complicated algorithms
  * 
  * @author William Meng(william_meng@loomis.org)
  * @contributor and inspirator Wayne Snyder (waysnyder@gmail.com)
  * @contributor and inspirator Ashley Hansberry (Ashley_Hansberry@loomis.org)
  * @version updated Spring 2015, 5/21/15
  */

import java.util.*;

public class AIPlayer implements Player
{
  private static int AI = 10;
  private static int PLAYER = 1;
  //Remember:
  //human = 1
  //ai = 10
  //human win = -100000
  //ai win = +100000
  
  /** move(int[][] B) should return the move that AI should take
      * if the specified player has won and false otherwise
      * @param B the current board that is being played on, should reflect the current situation containing integers
      * @return the integer of the next move the AI should take
      * Precondition: all the arrays in B should have the same length of B[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: B is not modified
      */
  public int move(int[][] B)
  {
    
    //originally only had 1 for loop however it does not work well since even though the 2 in a row is checked last, the program would block the 2 empty in a row without realizing that later on there is a 3 in a row for it to win
    
    //so now I split it into three separate for loops, first one to make obvious 3 in a row wins, next one to make obvious 3 in a row blocks then one to make 2 in a row with 2 empty blocks
    
//making obvious wins: finishing up 3 in a rows ========
     System.out.println("Start check 3 win");     
    for(int b = 0; b < B[0].length; b++)
    {
      for(int a = 0; a < B.length; a++)
      {
        
        if(((B[a][b] != 0)&&(a > 0))||(a==7))
        {
          if(!((a == 7)&&(B[a][b] == 0))) //not bottom row
          {
          a = a - 1;
          }

          if(a < B.length - 3) //checks downwards
          {
            if(((B[a+1][b] + B[a+2][b] + B[a+3][b]) == 30))
            {
              return b;
            }
            
          }
          if (b < B[0].length - 3)//checks hoizontal forwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b+1] + B[a][b+2] + B[a][b+3]));
            if((B[a][b+1] + B[a][b+2] + B[a][b+3]) == 30)
            {
              return b;
            }
            
            
          }
          if ((b > 0)&&(b < B[0].length - 2))//checks hoizontal two forwards one backwards
          {
            if((B[a][b-1] + B[a][b+1] + B[a][b+2]) == 30)
            {
              return b;
            }
            
            
          }
          if ((b > 1)&&(b < B[0].length - 1))//checks hoizontal one forwards two backwards
          {
            if((B[a][b-2] + B[a][b-1] + B[a][b+1]) == 30)
            {
              return b;
            }
            
            
          }
          if (b > 2)//checks hoizontal backwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b-1] + B[a][b-2] + B[a][b-3]) + "bak");
            if(((B[a][b-1] + B[a][b-2] + B[a][b-3]) == 30))
            {
              return b;
            }
            
            
          }
          if((a < B.length - 3)&&(b < B[0].length - 3)) //checks topleft to bottom right
          {
          if(((B[a+1][b+1] + B[a+2][b+2] + B[a+3][b+3]) == 30))
          {
            return b;
          }
          }
          if((a < B.length - 2)&&(b < B[0].length - 2)&&(a > 0)&&(b > 0)) //checks topleft to bottom right two bottom left to top right one
          {
          if(((B[a+1][b+1] + B[a+2][b+2] + B[a-1][b-1]) == 30))
          {
            return b;
          }
          }
          if((a < B.length - 1)&&(b < B[0].length - 1)&&(a > 1)&&(b > 1)) //checks topleft to bottom right one bottom left to top right two
          {
          if(((B[a+1][b+1] + B[a-2][b-2] + B[a-1][b-1]) == 30))
          {
            return b;
          }
          }
          
          if((a < B.length - 3)&&(b > 2)) //checks topright to bottom left
          {
          if(((B[a+1][b-1] + B[a+2][b-2] + B[a+3][b-3]) == 30))
          {
            return b;
          }
          }
          
          if((a < B.length - 2)&&(b > 1)&&(a > 0)&&(b < B[0].length - 1)) //checks topright to bottom left two and bottomleft to top right one
          {
          if(((B[a+1][b-1] + B[a+2][b-2] + B[a-1][b+1]) == 30))
          {
            return b;
          }
          }
          if((a < B.length - 1)&&(b > 0)&&(a > 1)&&(b < B[0].length - 2)) //checks topright to bottom left one and bottomleft to top right two
          {
          if(((B[a+1][b-1] + B[a-2][b+2] + B[a-1][b+1]) == 30))
          {
            return b;
          }
          }
          
          if((a > 2)&&(b < B[0].length - 3)) //checks bottomleft to top right
          {
          if(((B[a-1][b+1] + B[a-2][b+2] + B[a-3][b+3]) == 30))
          {
            return b;
          }
          }
          if((a > 2)&&(b > 2)) //checks bottomright to top left
          {
          if(((B[a-1][b-1] + B[a-2][b-2] + B[a-3][b-3]) == 30))
          {
            return b;
          }
          }
          a = 10000;
        }
      }
    }
    
    //making 3 in a row blocks
    System.out.println("Start check 3 block"); 
    for(int b = 0; b < B[0].length; b++)
    {
      for(int a = 0; a < B.length; a++)
      {
        
        if(((B[a][b] != 0)&&(a > 0))||(a==7))
        {
          if(!((a == 7)&&(B[a][b] == 0)))
          {
          a = a - 1;
          }
          //making obvious blocks: checks for 3 in a rows that is first priority to block
          if(a < B.length - 3) //checks downwards
          {
            if(((B[a+1][b] + B[a+2][b] + B[a+3][b]) == 3))
            {
              return b;
            }
            
          }
          if (b < B[0].length - 3)//checks hoizontal forwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b+1] + B[a][b+2] + B[a][b+3]));
            if(((B[a][b+1] + B[a][b+2] + B[a][b+3]) == 3))
            {
              return b;
            }
            
            
          }
                    if ((b > 0)&&(b < B[0].length - 2))//checks hoizontal two forwards one backwards
          {
            if((B[a][b-1] + B[a][b+1] + B[a][b+2]) == 3)
            {
              return b;
            }
            
            
          }
          if ((b > 1)&&(b < B[0].length - 1))//checks hoizontal one forwards two backwards
          {
            if((B[a][b-2] + B[a][b-1] + B[a][b+1]) == 3)
            {
              return b;
            }
            
            
          }
          if (b > 2)//checks hoizontal backwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b-1] + B[a][b-2] + B[a][b-3]) + "bak");
            if(((B[a][b-1] + B[a][b-2] + B[a][b-3]) == 3))
            {
              return b;
            }
            
            
          }
          if((a < B.length - 3)&&(b < B[0].length - 3)) //checks topleft to bottom right
          {
          if(((B[a+1][b+1] + B[a+2][b+2] + B[a+3][b+3]) == 3))
          {
            return b;
          }
          }
          if((a < B.length - 2)&&(b < B[0].length - 2)&&(a > 0)&&(b > 0)) //checks topleft to bottom right two bottom left to top right one
          {
          if(((B[a+1][b+1] + B[a+2][b+2] + B[a-1][b-1]) == 3))
          {
            return b;
          }
          }
          if((a < B.length - 1)&&(b < B[0].length - 1)&&(a > 1)&&(b > 1)) //checks topleft to bottom right one bottom left to top right two
          {
          if(((B[a+1][b+1] + B[a-2][b-2] + B[a-1][b-1]) == 3))
          {
            return b;
          }
          }
          
          if((a < B.length - 3)&&(b > 2)) //checks topright to bottom left
          {
          if(((B[a+1][b-1] + B[a+2][b-2] + B[a+3][b-3]) == 3))
          {
            return b;
          }
          }
          if((a < B.length - 2)&&(b > 1)&&(a > 0)&&(b < B[0].length - 1)) //checks topright to bottom left two and bottomleft to top right one
          {
          if(((B[a+1][b-1] + B[a+2][b-2] + B[a-1][b+1]) == 3))
          {
            return b;
          }
          }
          if((a < B.length - 1)&&(b > 0)&&(a > 1)&&(b < B[0].length - 2)) //checks topright to bottom left one and bottomleft to top right two
          {
          if(((B[a+1][b-1] + B[a-2][b+2] + B[a-1][b+1]) == 3))
          {
            return b;
          }
          }
          
          if((a > 2)&&(b < B[0].length - 3)) //checks bottomleft to top right
          {
          if(((B[a-1][b+1] + B[a-2][b+2] + B[a-3][b+3]) == 3))
          {
            return b;
          }
          }
          if((a > 2)&&(b > 2)) //checks bottomright to top left
          {
          if(((B[a-1][b-1] + B[a-2][b-2] + B[a-3][b-3]) == 3))
          {
            return b;
          }
          }
          a = 10000;
        }
      }
    }
     
    //making 2 in a line of 4 where the 2 other slots are empty
    System.out.println("Start check 2 block"); 
    for(int b = 0; b < B[0].length; b++)
    {
      for(int a = 0; a < B.length; a++)
      {
        
        if(((B[a][b] != 0)&&(a > 0))||(a==7))
        {
          if(!((a == 7)&&(B[a][b] == 0)))
          {
          a = a - 1;
          }
          
          
          //Making good blocks: Blocking 2 in a line of 4 where the other 2 spaces are empty
          
          //no need to do vertical. Do not need to block vertical until 3 in a row
          
          if (b < B[0].length - 2)//checks hoizontal forwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b+1] + B[a][b+2] + B[a][b+3]));
            if(((B[a][b+1] + B[a][b+2]) == 2))
            {
              System.out.println("Start check 2 block - horizontal forward"); 
              return b;
            }
            
            
          }
          if (b > 1)//checks hoizontal backwards
          {
            //System.out.println(a + " " + b + " " + (B[a][b-1] + B[a][b-2] + B[a][b-3]) + "bak");
            if(((B[a][b-1] + B[a][b-2]) == 2))
            {
              System.out.println("Start check 2 block - horizontal backwards"); 
              return b;
            }
            
            
          }
          if((a < B.length - 3)&&(b < B[0].length - 3)) //checks topleft to bottom right
          {
          if(((B[a+1][b+1] + B[a+2][b+2] + B[a+3][b+3]) == 2))
          {
            System.out.println("Start check 2 block - tl to br"); 
            return b;
          }
          }
          
          if((a < B.length - 3)&&(b > 2)) //checks topright to bottom left
          {
          if(((B[a+1][b-1] + B[a+2][b-2] + B[a+3][b-3]) == 2))
          {
            System.out.println("Start check 2 block - tr to bl"); 
            return b;
          }
          }
          if((a > 2)&&(b < B[0].length - 3)) //checks bottomleft to top right
          {
          if(((B[a-1][b+1] + B[a-2][b+2] + B[a-3][b+3]) == 2))
          {
            System.out.println("Start check 2 block - bl to tr"); 
            return b;
          }
          }
          if((a > 2)&&(b > 2)) //checks bottomright to top left
          {
          if(((B[a-1][b-1] + B[a-2][b-2] + B[a-3][b-3]) == 2))
          {
            System.out.println("Start check 2 block - br to tl"); 
            return b;
            
          }
          }
          
          a = 10000;
        }
        
        
      }
    }
    System.out.println("EXIT");
    //checks filled columns
    int[] filled = {0,0,0,0,0,0,0,0};
    for(int i = 1; i < B[0].length; i++)
    {
      if((B[0][i] == 1)&&(B[0][i] == 10))
      {
        filled[i] = 1;
      }
    }
    int placeofmove = 0;
//    for(int i = 1; i < B[0].length; i++)
//    {
//      
//      if(B[0][i] == 0)
//      {
//        placeofmove = i;
//      }
//      i = 10000;
//    }
    int bestmove = minMax(B, 0);
    for(int i = placeofmove; i < B[0].length; i++)
    {
      while(filled[i] == 1)
      {
        i++;
      }
      putPlace(B,i,10);
      

      if((B[0][i] == 0))
      {
        int newone = minMax(B,0);
        if(newone > bestmove)
        {
        bestmove = newone;
        placeofmove = i;
        System.out.println(i + "  " + newone);
        }
      }
      removePlace(B,i);
    }
    
   // System.out.println(placeofmove);
    
    for(int a = 0; a < B.length; a++)
    {
      for(int b = 0; b < B[0].length; b++)
      {
        System.out.print(B[a][b] + " ");
        
      }
      System.out.println();
    }
    
    return placeofmove;
  }
  
  
  /** minMax(int[][] B, int depth) should look through future moves to return a value that represents the possible move for the AI at this moment
      * @param B the current board that is being played on, should reflect the current situation containing integers
      * @param depth - the depth of moves that this method should look into the future to evalute the number
      * @return the integer that best represnts the future outcome of this board
      * Precondition: all the arrays in B should have the same length of B[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: B is not modified
      */
  private static int minMax(int[][] B, int depth) { 
        if( isLeaf(B) || depth == 5)
        {
          //System.out.println("IN");
            return eval(B);  
        }
        else if( depth % 2 == 0 ) {
          //System.out.println("IN");  // even levels are max, ai player           
            int max = -100000; 
            for(int move = 0; move < B[0].length; ++move) { 
                if(B[0][move] == 0) {   // move is available
                    
                    putPlace(B,move,10);       // make the move  -player move
                    
                    int val = minMax( B, depth + 1 );  
                    
                    if(val > max) { 
                        max = val; 
                    }
                    
                    //System.out.println(depth + "  " + move);
                    removePlace(B,move);       // undo the move and try next move  -putit back to 0;
                }
            }
            
            return max; 
        } else {                          // is a min node, human player
            int min = 100000; 
            for(int move = 0; move < B[0].length; ++move) { 
                if(B[0][move] == 0) {   // move is available
                    
                    putPlace(B,move,1);       // make the move  
                    
                    int val = minMax( B, depth + 1 );
                    
                    if(val < min) {
                        min = val;
                    }
                    //System.out.println(depth + "  " + move);
                    removePlace(B,move);       // undo the move and try next move    
                }
            }
            return min; 
        }
    }
  
  /** isLeaf(int[][] B) should return whether or not the evaluated board is a dead end and should end the minMax method
      * @param B the current board that is being played on, should reflect the current situation containing integers
      * @return boolean, true if this is a leaf to the minMax tree and the minMax should end or false this is not a leaf and the minMax should keep running
      * Precondition: all the arrays in B should have the same length of B[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: B is not modified
      */
  
  private static  boolean isLeaf(int[][] B) 
  {
    //System.out.println("IN");
        if(eval(B) == 100000  || eval(B) == -100000) //if win return true
            return true; 
        return false;
    }
  
  //Special behind the scenes bouns: failures from previous versions
  //returns the evaluated number of a certain move
//   private static int minMax(int[][] B, int place) 
//   {
//     
//     //goes down 4 steps
//     int[][] newboard1 = B;
//     putPlace(newboard1,place,AI);
//     
//     int[] line1 = new int[B[0].length];
     
//     for(int i = 0; i < B.length; i++)
//     {
//       int[][] newboard2 = newboard1;
//       int[] line2 = new int[newboard1[0].length];
//       putPlace(newboard2, i, PLAYER); //player future move
//       //find lowest and that is where player would go
//       for(int a = 0; a < newboard2[0].length; a++)
//       {
//         int[][] newboard3 = newboard2;
//         int[] line3 = new int[newboard2[0].length];
//         putPlace(newboard3, a, AI);  //ai's move after that
//         
//         //evaluate each move and find highest because that is where ai would go
//         for(int b = 0; b < newboard3[0].length; b++)
//         {
//           int[][] newboard4 = newboard3;
//           int[] line4 = new int[newboard3[0].length];
//           putPlace(newboard4, b, PLAYER);  //player's move after that
//           for(int c = 0; c < newboard4[0].length; c++)
//           {
//             int[][] newboard5 = newboard4;
//             putPlace(newboard5, c, AI); //AI just moved
//             line4[i] = eval(newboard5); 
//           }
//             //evaluate each move and find the lowest because that is the one that the player would go.
//             //*****YOU ONLY EVALUATE THE LAST MOVE!!! NOT EVERY MOVE!!
//         }
//         
//       }
//       
//     }
     
     
//     return 0;
//   }
   
  /** eval(int[][] B) should evaluate the board only based on the current situation
      * should return a value that correctly represents the current situation
      * @param B the current board that is being played on, should reflect the current situation containing integers
      * @return the integer value that represents the evaluation of the board with bigger fvoring the AI and lower favoring the player
      * Precondition: all the arrays in B should have the same length of B[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: B is not modified
      */
  private static  int eval(int[][] B) {
        
    
    
    //go through each 4 by 4 and just store a minmax number.
    //do not need arraylist!!!
    //ArrayList<Integer[][]> listofboards = new ArrayList<Integer[][]>();
    
    //System.out.println("IN EVAL");
    int count = 0;
    for(int a = 0; a < B.length; a++)
    {
      for(int b = 0; b < B[0].length; b++)
      {
        //Some notes to self/ left behind from earlier editions:
        //System.out.println("Eval: " + a + "  " + b + "   " + count); 
        //System.out.println("1");
        /*if == 40 then ai win (+1000)
         * else if == 4 then human win
         * else if == 0 then return 0
         * else if > 10 and %10 != 0 then return 0 //means there is both in this line
         * else if >= 10 return x/10
         * else return x%10
         */
        
        if(a < B.length - 3) //add downwards
        {
         // System.out.println("2");
          int total = B[a][b] + B[a+1][b] + B[a+2][b] + B[a+3][b];
          if(total == 4)
          {
            return -100000;
          }
          else if(total == 40)
          {
            return 100000;
          }
          else if( total >= 10 && total % 10 == 0) //only AI in this line
          {
            count = count + (int)Math.pow(10,total/10);
          }
          else if(total < 10 && total > 0) //only player in this line
          {
            count = count - (int)Math.pow(10,total%10);
          }
          
          
        }
        if (b < B[0].length - 3)// add horizontal
        {
          //System.out.println("3");
          int total = B[a][b] + B[a][b+1] + B[a][b+2] + B[a][b+3];
          if(total == 4)
          {
            return -100000;
          }
          else if(total == 40)
          {
            return 100000;
          }
          else if( total >= 10 && total % 10 == 0) //only AI in this line
          {
            count = count + (int)Math.pow(10,total/10);
          }
          else if(total < 10 && total > 0) //only player in this line
          {
            count = count - (int)Math.pow(10,total%10);
          }
          
        }
          
          
        if((a < B.length - 3)&&(b < B[0].length - 3)) //add topleft to bottom right
        {
          //System.out.println("4");
          int total = B[a][b] + B[a+1][b+1] + B[a+2][b+2] + B[a+3][b+3];
          if(total == 4)
          {
            return -100000;
          }
          else if(total == 40)
          {
            return 100000;
          }
          else if( total >= 10 && total % 10 == 0) //only AI in this line
          {
            count = count + (int)Math.pow(10,total/10);
          }
          else if(total < 10 && total > 0) //only player in this line
          {
            count = count - (int)Math.pow(10,total%10);
          }
        }
          
        if((a < B.length - 3)&&(b > 2)) //add topright to bottom left
        {
          //System.out.println("5");
          int total = B[a][b] + B[a+1][b-1] + B[a+2][b-2] + B[a+3][b-3];
          //System.out.println("6");
          if(total == 4)
          {
            return -100000;
          }
          else if(total == 40)
          {
            return 100000;
          }
          else if( total >= 10 && total % 10 == 0) //only AI in this line
          {
            count = count + (int)Math.pow(10,total/10);
          }
          else if(total < 10 && total > 0) //only player in this line
          {
            count = count - (int)Math.pow(10,total%10);
          }
          
        }
        
        
        //System.out.println("Count: " + count);
      }
      
      //System.out.println("End COUNT");
      
      
    }
        
    
    return count;
    }
  
  /** putPlace(int[][] a, int place, int what) make a move on the current game board
      * @param a - the current board that is being played on, should reflect the current situation containing integers
      * @param place - the index value of the place on the array where the move is made
      * @param what - the value of the player that is making this move, should be either 1 for human or 10 for AI
      * Precondition: all the arrays in a should have the same length of a[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: only makes one move on the board, replacing a blank space (0) with a move of either 1 for human player of 10 for AI
      */
  
  private static void putPlace(int[][] a,int place, int what)
  {
    for(int i = a.length - 1; i >= 0; i--)
    {
      if(a[i][place] == 0)
      {
        a[i][place] = what;
        i = -1;
      }
      
    }
    
  }
  /** removePlace(int[][] a, int place) should remove a move that was placed earlier.
      * removes the top-most move of a certain index of the board
      * @param a the current board that is being played on, should reflect the current situation containing integers
      * @param place - the index value of the place on the array where the removal is made
      * Precondition: all the arrays in B should have the same length of B[0] with 1 representing the player, 10 representing the AI and 0 representing an empty space
      * Postcondition: B is modified once, taking away one of the moves, either a 1 or 10, that is the top-most move of a certain column and is replaced with 0
      */
  private static void removePlace(int[][] a,int place)
  {
    for(int i = 0; i < a.length; i++)
    {
      if(a[i][place] != 0)
      {
        a[i][place] = 0;
        i = a.length + 2;
      }
      
      //System.out.println(i);
      
    }
    
  }
  
  
  
}