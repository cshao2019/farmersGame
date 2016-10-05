import java.util.Scanner;

/**
*@author Christine Shao
*To get all three things to the other side. Rules are that if you leave 
*
*/
public class FarmersGame

{
	//global scope
	public static boolean cabb;
	public static boolean sheep;
	public static boolean wolf;
	public static boolean human;

	
	public static void main(String[] args)
	{
		welcome();
		displaysGameStatus();
		while (gameEnds() == 0)
		{
			var();
			displaysGameStatus();
		
		if(gameEnds() == 1)
			System.out.println("You lose. Wolf ate the sheep");
		if(gameEnds() == 2)
			System.out.println("You lose. Sheep ate the cabbage");
		if(gameEnds() == 3)
			System.out.println("You Win!");
		}

	
	}
	/**
	*
	*
	*
	*/
	
	public static void welcome()
	{
		System.out.println("\n");
		System.out.println("Farmer's Game: The object of the game is to get the human, sheep, wolf and cabbage ");
		System.out.println("to the other side of the bank using a boat. The rules are if you leave the sheep and wolf ");
		System.out.println("together, the wolf will eat the sheep and you will lose. The same is true if you leave that ");
		System.out.println("sheep with the cabbage. The boat can only be operated by the human and can only bring one ");
		System.out.println("passenger at a time.");
	}
	
	/**
	*
	*
	*
	*/
	public static void displaysGameStatus()
	{
		String bank0 = " ";
		String bank1 = " ";
		
		if(!cabb)
			bank0 += "C  ";
		else
			bank1 += "C  ";

		if(!sheep)
			bank0 += "S  ";
		else
			bank1 += "S  ";

		if(!wolf)
			bank0 += "W  ";
		else
			bank1 += "W  ";
					
		if(!human)
			bank0 += "H  ";
		else
			bank1 += "H  ";	
			
		System.out.println(bank0);
		System.out.println("-----------------");
		System.out.println("\n \n \n");
		System.out.println("-----------------");
		System.out.println(bank1);
				
	}
	
	public static void var()
	{
		Scanner kb = new Scanner(System.in); // initializing scanner 
		System.out.print("What do you want to move? (H - human, S - sheep, W - wolf, C - cabbage): ");
		String user_Choice = kb.nextLine();
		//System.out.println(user_Choice);

		if(user_Choice.equals("H"))
			human = !human;
		else if( user_Choice.equals("C") && cabb == human )
		{
			cabb = !cabb;
			human = !human;

		}
		else if(user_Choice.equals("S") && sheep == human )
		{
			sheep = !sheep;
			human = !human;

		}
		else if(user_Choice.equals("W") && wolf == human )
		{
			wolf = !wolf;
			human = !human;

		}
		else
			System.out.println("Please make sure human is on the same side as the "
								+ " character you want to move");
			
		
	}	
	
	/**
	*This method compares the variables each time to determine if the game continues or not
	*@return true Stop the game. Or false Continue the game
	*
	*/
	public static int gameEnds()
		{
		if (wolf == sheep && human != wolf && cabb != wolf) //lose because wolf eats sheep
			return 1;
		else if (cabb == sheep && human != sheep && sheep != wolf) //lose because sheep eats cabbage
			return 2;
		else if (wolf && sheep && cabb) // win because all on one side
			return 3;
		else 
			return 0;
		    
		        
		        
		}
		    
		
		






}


// If sheep and wolf and cabbage = 0 or 1 --> safe
// If sheep and wolf both = 0 or 1 --> lose
// If sheep and cabbage both = 0 or 1 --> lose
// If sheep and wolf and human = 0 or 1 --> safe
// If sheep and cabbage and human = 0 or 1 --> safe
// If wolf and cabbage both = 0 or 1 --> safe
// If wolf and cabbage and human = 0 or 1 --> safe 
//