/*
 * Written by Donte Littlejohn
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static final int NUM_OF_ROUNDS = 3;
	public static final String COMPUTER_WIN_MSG = "The Computer Wins!\nPlay again? \"Yes\" or \"No\""; 
	public static final String PLAYER_WIN_MSG = "The Player Wins!\nPlay again? \"Yes\" or \"No\"";
	public static final String TIE_GAME_MSG = "The game ended in a tie!\nPlay again? \"Yes\" or \"No\"";

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		int pScore = 0;
		int cScore = 0;
		
		String[] rps = {"Rock", "Paper", "Scissors"};
		
		System.out.println("Welcome to Rock Paper Scissors!  Best 2 out of 3!");
		
		for(int i = 0; i < NUM_OF_ROUNDS; i++)
		{
			System.out.println("Enter \"Rock\", \"Paper\", or \"Scissors\"");
			int iComputerChoice = r.nextInt(3);
			int iPlayerChoice = 0;
			String playerChoice = keyboard.nextLine();
			String keepPlayingMsg;
			String keepPlayingChoice;
			
			//Check if player's selection is a valid selection. If not, the computer is awarded a point. If so, determine the integer value of the player's pick.
			if(!(playerChoice.equalsIgnoreCase("rock") || playerChoice.equalsIgnoreCase("paper") || playerChoice.equalsIgnoreCase("scissors")))
			{
				cScore++;
				System.out.println("Sorry, that's not a valid option. The computer has been awarded a point.\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
				if(cScore == 2)
				{
					System.out.println(COMPUTER_WIN_MSG);
					keepPlayingChoice = keyboard.nextLine();
					
					if(keepPlayingChoice.equalsIgnoreCase("yes"))
					{
						pScore = 0;
						cScore = 0;
						i = -1;
						continue;
					}
					else if(keepPlayingChoice.equalsIgnoreCase("no"))
					{
						System.out.println("Thank you for playing!\nGoodbye!");	
						System.exit(0);
					}
				}
				else 
				{
					continue;
				}
			}
			//If player's choice is a valid selection, convert selection to an integer index value
			else if(playerChoice.equalsIgnoreCase("rock"))
			{
				iPlayerChoice = 0;
			}
			else if(playerChoice.equalsIgnoreCase("paper"))
			{
				iPlayerChoice = 1;
			}
			else if(playerChoice.equalsIgnoreCase("scissors"))
			{
				iPlayerChoice = 2;
			}
			
			
			//Check if round ended in a tie.
			if(iPlayerChoice == iComputerChoice)
			{
				System.out.println(rps[iPlayerChoice] + " v " + rps[iComputerChoice] + "! Tie! No one wins!\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
			}
			//Check to see if player won. (Rock vs Paper && Paper vs Scissors)
			else if(iPlayerChoice > iComputerChoice && iPlayerChoice - 2 != iComputerChoice)
			{
				pScore++;
				System.out.println(rps[iPlayerChoice] + " v " + rps[iComputerChoice] + "! Player Wins!\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
				if(pScore == 2) 
				{
					System.out.println(PLAYER_WIN_MSG);
					keepPlayingChoice = keyboard.nextLine();
					
					if(keepPlayingChoice.equalsIgnoreCase("yes"))
					{
						pScore = 0;
						cScore = 0;
						i = -1;
						continue;
					}
					else if(keepPlayingChoice.equalsIgnoreCase("no"))
					{
						System.out.println("Thank you for playing!\nGoodbye!");	
						System.exit(0);
					}
				}
			}
			//Check to see if player won. (Rock vs Scissors)
			else if(iComputerChoice > iPlayerChoice && iComputerChoice - 2 == iPlayerChoice)
			{
				pScore++;
				System.out.println(rps[iPlayerChoice] + " v " + rps[iComputerChoice] + "! Player Wins!\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
				if(pScore == 2) 
				{
					System.out.println(PLAYER_WIN_MSG);
					keepPlayingChoice = keyboard.nextLine();
					
					if(keepPlayingChoice.equalsIgnoreCase("yes"))
					{
						pScore = 0;
						cScore = 0;
						i = -1;
						continue;
					}
					else if(keepPlayingChoice.equalsIgnoreCase("no"))
					{
						System.out.println("Thank you for playing!\nGoodbye!");	
						System.exit(0);
					}
				}
			}
			//Check to see if computer won. (Rock vs Paper && Paper vs Scissors)
			else if(iComputerChoice > iPlayerChoice && iComputerChoice - 2 != iPlayerChoice)
			{
				cScore++;
				System.out.println(rps[iPlayerChoice] + " v " + rps[iComputerChoice] + "! Computer Wins!\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
				if(cScore == 2) 
				{
					System.out.println(COMPUTER_WIN_MSG);
					keepPlayingChoice = keyboard.nextLine();
					
					if(keepPlayingChoice.equalsIgnoreCase("yes"))
					{
						pScore = 0;
						cScore = 0;
						i = -1;
						continue;
					}
					else if(keepPlayingChoice.equalsIgnoreCase("no"))
					{
						System.out.println("Thank you for playing!\nGoodbye!");	
						System.exit(0);
					}
				}
			}
			//Check to see if player won. (Rock vs Scissors)
			else if(iPlayerChoice > iComputerChoice && iPlayerChoice - 2 == iComputerChoice)
			{
				cScore++;
				System.out.println(rps[iPlayerChoice] + " v " + rps[iComputerChoice] + "! Computer Wins!\nPlayer has won " + pScore + " times and the computer has won " + cScore + " times");
				if(cScore == 2) 
				{
					System.out.println(COMPUTER_WIN_MSG);
					keepPlayingChoice = keyboard.nextLine();
					
					if(keepPlayingChoice.equalsIgnoreCase("yes"))
					{
						pScore = 0;
						cScore = 0;
						i = -1;
						continue;
					}
					else if(keepPlayingChoice.equalsIgnoreCase("no"))
					{
						System.out.println("Thank you for playing!\nGoodbye!");	
						System.exit(0);
					}
				}
			}
			
			//If there are no more rounds left to play, present winner (or tie) and ask if user wants to keep playing.
			if(i == NUM_OF_ROUNDS - 1)
			{
				if(pScore > cScore) {
					keepPlayingMsg = PLAYER_WIN_MSG;
				}
				else if(cScore > pScore)
				{
					keepPlayingMsg = COMPUTER_WIN_MSG;
				}
				else
				{
					keepPlayingMsg = TIE_GAME_MSG;
				}
				
				System.out.println(keepPlayingMsg);
				keepPlayingChoice = keyboard.nextLine();
				
				if(keepPlayingChoice.equalsIgnoreCase("yes"))
				{
					pScore = 0;
					cScore = 0;
					i = -1;
					continue;
				}
				else if(keepPlayingChoice.equalsIgnoreCase("no"))
				{
					System.out.println("Thank you for playing!\nGoodbye!");	
					System.exit(0);
				}
			}
		}
		
		keyboard.close();
	}
}
