package team.game.data;
/**
 * 
 * @author AWESOME и кто-то ещё :)
 *
 */
public class GameField {
	
	private int countX;
	private int countY;
	
	private Cell[][] cells;
	
	public GameField(int countX, int countY) {
		this.countX = countX;
		this.countY = countY;	
		
		cells = new Cell[countX][countY];
		for (int i = 0; i < countX; ++i)
			for (int j = 0; j < countY; ++j) 
				cells[i][j] = new Cell();			
	}
	
	public Cell getCell(int i, int j) 	{return cells[i][j];}
	public int getCountX()				{return countX;}
	public int getCountY()				{return countY;}
}
