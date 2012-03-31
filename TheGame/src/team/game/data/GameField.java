package team.game.data;

public class GameField {
	
	private int countX;
	private int countY;
	
	private Cell[][] cells;
	
	public GameField(int countX, int countY) {
		this.countX = countX;
		this.countY = countY;
		
		for (int i = 0; i < countX; ++i)
			for (int j = 0; j < countY; ++j) 
				cells[i][j] = new Cell();			
	}
	
	public Cell getCell(int i, int j) {
		return cells[i][j];
	}
}
