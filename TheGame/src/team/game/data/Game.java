package team.game.data;

import team.game.logic.GameProcessor;

/**
 * 
 * @author Виталя & AWESOME (но больше Виталя :))
 *
 */
public class Game {
	
	public  GameField 		Field;
	public  GameProcessor 	Processor;
	public  LocalPlayer[]	players;
	private int 			indexCurrent;
	
	private static Game game = new Game();
	
	private Game() {
		players = new LocalPlayer[4];
		for (int i = 0; i < 4; ++i)
			players[i] = null;	
		//Field = new GameField(10, 10);
		Processor = new GameProcessor(this);
	}
	/**
	 * устанавливает игроков
	 * @param names имена игроков
	 */
	public void setPlayers(String... names) {
		for (int i = 0; i < names.length && i < 4; ++i)
			if (names[i] != null)
				players[i] = new LocalPlayer(names[i], (i+1));
			else
				players[i] = null;
	}
	
	public static Game getInstance() {
		return game;
	}
	/**
	 * передача хода следуещему игроку
	 */
	public void nextPlayer() {
		if(indexCurrent < players.length - 1)
			++indexCurrent;
		else
			indexCurrent = 0;
	}
	/**
	 * задается размер поля countX на countY 
 	 * @param countX, количество строк
	 * @param countY, количество столбцов
	 */
	public void setSize(int countX, int countY){
		Field = new GameField(countX, countY);
	}
	/**
	 * 
	 * @param index индекс игрока
	 * @return Null при всяких плохих ситуациях... 
	 */
	public LocalPlayer getPlayer(int index)
	{
		if (players!=null)
		{
			try
			{
				return players[index];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				//return null;  походу не нужен...
			}
		}
		return null;
	}
}
