package team.game.data;

import team.game.logic.GameProcessor;

/**
 * 
 * @author ¬итал€ & AWESOME (но больше ¬итал€ :))
 *
 */
public class Game {
	
	public  GameField 		Field;
	public  GameProcessor 	Processor;
	public  LocalPlayer[]	players;
	private LocalPlayer		current;
	private int 			indexCurrent;
	
	private static Game game = new Game();
	
	private Game() {
		players = new LocalPlayer[4];
		for (int i = 0; i < 4; ++i)
			players[i] = null;
		
		Field = new GameField(20, 20);
		Processor = new GameProcessor(this);
	}
	/**
	 * устанавливает игроков
	 * @param names имена игроков
	 */
	public void setPlayers(String... names) {
		for (int i = 0; i < names.length && i < 4; ++i)
			if (names[i] != null)
				players[i] = new LocalPlayer(names[i]);
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
		current = players[indexCurrent];	
	}
}
