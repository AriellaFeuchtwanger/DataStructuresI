package ticTacToe;

public class Player {
	Character piece;
	Integer numberOfWins;
	
	public Player(Character piece){
		if(piece == 'X' || piece == 'O'){
			this.piece = piece;
		}
		else{
			throw new InvalidDataException();
		}
		
		numberOfWins = 0;
	}
	
	public Character getPiece(){
		return piece;
	}
	
	public void addWin(){
		numberOfWins++;
	}
	
	public Integer getNumberOfWins(){
		return numberOfWins;
	}
}
