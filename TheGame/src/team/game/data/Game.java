package team.game.data;

import team.game.logic.GameProcessor;

/**
 * 
 * @author Виталя & AWESOME (но больше Виталя :))
 *
 */
public class Game {
	public GameField 		Field;
	public GameProcessor 	Processor;
	public LocalPlayer[]	players;
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
	
	public static Game getInstance() {
		return game;
	}
	/**
	 * передача хода следуещему игроку
	 */
	public void nextPlayer(){
		if(indexCurrent<players.length-1)
			indexCurrent ++;
		else
			indexCurrent = 0;
		current = players[indexCurrent];	
	}
}
