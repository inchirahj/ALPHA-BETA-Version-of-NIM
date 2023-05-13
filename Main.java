import java.util.Scanner;

class Main 
{
  private static int numSticks;
  private static int maxSticks;
  
  public static void main(String[] args) 
  {
    System.out.println("Let's start playing!");
    System.out.println("Select the initial number of sticks in the pile:");
    Scanner sc1 = new Scanner(System.in);
    numSticks = sc1.nextInt();

    System.out.println("Select the maximum number of sticks that you can choose in a move:");
    Scanner sc2 = new Scanner(System.in);
    maxSticks = sc2.nextInt();
       
    System.out.println("Let's start playing!");
    
    nim(numSticks);
  }

  public static void nim(int sticks) 
  {

    
    System.out.println("The computer will start.");

    while (sticks >= 0)
      {

        if (sticks == 0) 
        {
          System.out.println("You win!");
          return;
        }
          
        int computerSticks = alphaBeta (sticks);
        sticks = sticks - computerSticks;
        System.out.println("The computer took " + computerSticks+ " sticks");
        System.out.println("There are " + sticks + " sticks left");        
      

        if (sticks == 0) 
        {
          System.out.println("The computer wins!");
          return;
        }
          
        System.out.println("Enter the number of sticks you want to take: ");
    
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        while (input <= 0 || input > maxSticks || input > sticks)
        {
          System.out.println("Invalid input. Enter a number between 1 and " + maxSticks);
          int newInput = in.nextInt();
          input = newInput;
        }

        if (input >= 1 && input <= 4 && input <= sticks)
        {
          int playerSticks = input;
          sticks = sticks - playerSticks;
          System.out.println("You took " + playerSticks + " sticks");
          System.out.println("There are " + sticks + " sticks left");
        }
          
      }   
    }
  

  static int alphaBeta(int sticks)
    {
      float v = Float.NEGATIVE_INFINITY;
      float alpha;
      float beta;
      int max = 0;
      alpha = Float.NEGATIVE_INFINITY;
      beta = Float.POSITIVE_INFINITY;
      
      for (int i = 1; i <= maxSticks ; i++)
      {
        v = Math.max(v, minValue(sticks - i, alpha, beta));
        if (v > alpha)
        {
          alpha = v;
          max = i;
        }
      }
      return max;
    }



  
  static int maxValue(int sticks, float alpha, float beta)
  {
    if (sticks <= 0)
    {
      return -1;
    }
    
    float v = Float.NEGATIVE_INFINITY;;
    for (int i = 1; i <= maxSticks ; i++)
    {
      v = Math.max(v, minValue(sticks - i, alpha, beta));
      if (v >= beta)
      {
        return (int) v;
      }
      alpha = Math.max(alpha, v);
    }
    return (int) v;
    
  }



  

   static int minValue (int sticks, float alpha, float beta)
  {

    if (sticks <= 0)
    {
      return 1;
    }
    
    float v = Float.POSITIVE_INFINITY;;
    for (int i = 1; i <= maxSticks ; i++)
    {
      v = Math.min(v, maxValue (sticks - i, alpha, beta));
      if (v <= alpha)
      {
        return (int) v;
      }
      beta = Math.min(beta, v);
    }
    return (int) v;
  }


  
}
