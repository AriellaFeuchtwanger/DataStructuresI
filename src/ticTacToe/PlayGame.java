package ticTacToe;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		System.out.println("Let's play TicTacToe!");
		System.out.println("Please decide who will be Player X! You will go first!");
		Scanner keyboard = new Scanner(System.in);
		Player x = new Player('X');
		Player o = new Player('O');
		boolean playAgain = true;
		boolean win = false;
		Character lastPlayer = ' ';
		int row = 0;
		int column = 0;
		char board[][];
		
		while(playAgain){
			System.out.println("-------------");
			System.out.println("|   |   |   |");
			System.out.println("-------------");
			System.out.println("|   |   |   |");
			System.out.println("-------------");
			System.out.println("|   |   |   |");
			System.out.println("-------------");
			
			Game g = new Game();
			win = false;
			while(!win){
				if(lastPlayer == 'X'){
					System.out.println("Player O's turn:");
					System.out.println("Enter the row.");
					row = keyboard.nextInt();
					System.out.println("Enter the column.");
					column = keyboard.nextInt();
					
					try{
					g.addMove(o.getPiece(), (row - 1), (column - 1)); //adjust values
					}
					catch(InvalidMoveException e){
						System.out.println("That move was illegal.");
						
					}
					win = g.getStatus(o.getPiece());
					if(win){
						System.out.println("You won!");
						o.addWin();
					}
					lastPlayer = o.getPiece();
				}
				else{
					System.out.println("Player X's turn:");
					System.out.println("Enter the row.");
					row = keyboard.nextInt();
					System.out.println("Enter the column.");
					column = keyboard.nextInt();
					try{
					g.addMove(x.getPiece(), (row - 1), (column - 1));
					}
					catch(InvalidMoveException e1){
						System.out.println("That move was illegal.");
					}
					win = g.getStatus(x.getPiece());
					
					if(win){
						System.out.println("You won!");
						x.addWin();
					}
					lastPlayer = x.getPiece();
				}
				board = g.getBoard();
				
				System.out.println("-------------");
				System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
				System.out.println("-------------");
			}
			playAgain = chooseToPlay();
		}
		System.out.println("Final Score:");
		System.out.println("Player X: " + x.getNumberOfWins());
		System.out.println("Player O: " + o.getNumberOfWins());
	}
	
	public static boolean chooseToPlay(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to play again? Enter yes or no.");
		String choice = keyboard.next();
		
		if(choice.charAt(0) == 'Y' || choice.charAt(0) == 'y'){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean checkWin(Game g, Character piece){
		if(g.getStatus(piece)){
			return true;
		}
		else{
			return false;
		}
	}

}
