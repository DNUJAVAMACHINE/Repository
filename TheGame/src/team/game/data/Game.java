package team.game.data;

import team.game.logic.GameProcessor;

/**
 * 
 * @author ������ & AWESOME (�� ������ ������ :))
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
		Field = new GameField(10, 10);
		Processor = new GameProcessor(this);
	}
	/**
	 * ������������� �������
	 * @param names ����� �������
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
	 * �������� ���� ���������� ������
	 */
	public void nextPlayer() {
		if(indexCurrent < players.length - 1)
			++indexCurrent;
		else
			indexCurrent = 0;
		current = players[indexCurrent];	
	}
	/**
	 * �������� ������ ���� countX �� countY 
 	 * @param countX, ���������� �����
	 * @param countY, ���������� ��������
	 */
	public void setSize(int countX, int countY){
		Field = new GameField(countX, countY);
	}
}
