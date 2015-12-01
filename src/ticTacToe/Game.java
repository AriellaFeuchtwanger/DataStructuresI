package ticTacToe;

public class Game {
	char board[][];
	boolean win;

	public Game() {
		board = new char[3][3];
	}

	public void addMove(char piece, int row, int column) {
		// Check that the row and column are valid - decremented in main.
		if (row > 2 || row < 0) {
			throw new InvalidMoveException();
		}
		if (column > 2 || column < 0) {
			throw new InvalidMoveException();
		}
		// Check that the spot isn't full
		if (board[row][column] == 'X' || board[row][column] == 'O') {
			throw new InvalidMoveException();
		} else {
			board[row][column] = piece;
		}
	}

	public boolean getStatus(Character piece) {
		win = checkRow(piece);
		if (win) {
			return win;
		} else {
			win = checkColumn(piece);
		}
		if (win) {
			return win;
		} else {
			win = checkDiagonal(piece);
		}

		return win;
	}

	public char[][] getBoard() {
		return board;
	}

	public boolean isFull() {
		boolean full = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'X' || board[i][j] == 'O') {
					full = true;
				}
			}
		}
		return full;
	}

	private boolean checkRow(Character piece) {
		boolean win = true;
		for (int i = 0; i < 3; i++) {
			while (win) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == piece) {
						win = true;
					} else {
						win = false;
					}
				}
				if (win) {
					break;
				}
			}
		}

		return win;
	}

	private boolean checkColumn(Character piece) {
		boolean win = true;
		for (int i = 0; i < 3; i++) {
			while (win) {
				for (int j = 0; j < 3; j++) {
					if (board[j][i] == piece) {
						win = true;
					} else {
						win = false;
					}
				}
				if (win) {
					break;
				}
			}
		}

		return win;
	}

	private boolean checkDiagonal(Character piece) {
		boolean win = true;
		for (int i = 0; i < 3; i++) {
			if (win) {
				if (board[i][i] == piece) {
					win = true;
				} else {
					win = false;
				}
			}
		}

		// Check other diagonal
		if (!win) {
			if (board[0][2] == piece && board[1][1] == piece
					&& board[2][0] == piece) {
				win = true;
			}
		}

		return win;
	}
}
