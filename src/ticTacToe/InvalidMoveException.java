package ticTacToe;

public class InvalidMoveException extends RuntimeException{
	public InvalidMoveException(){
		super("Invalid Move");
	}
}
