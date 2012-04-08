package team.game.data;

import team.game.logic.GameProcessor;

/**
 * 
 * @author ������ & AWESOME & ����� (���� �����, ���� �����!)(�� ������ ������ :))
 *
 */
public class Game {
	public static final int LOCAL = 0;
	public static final int LAN   = 1;
	
	public  GameField        Field;
	public  GameProcessor 	 Processor;
	public  AbstractPlayer[] players;
	private int              indexCurrent;
	
	private static Game game = new Game();
	
	private Game() {
		players = new LocalPlayer[4];
		for (int i = 0; i < 4; ++i)
			players[i] = null;	
		//Field = new GameField(10, 10);
		Processor = new GameProcessor(this);
	}
	/**
	 * ������������� �������
	 * @param kindOfPlayer 0 - LocalPlayer, 1 - LanPlayer
	 * @param names ����� �������
	 */
	public void setPlayers(int kindOfPlayer, String... names) {
		for (int i = 0; i < 4; ++i)
			players[i] = null;
		
		for (int i = 0; i < names.length && i < 4; ++i)
			if (names[i] != null)
				if (kindOfPlayer == LOCAL)
					players[i] = new LocalPlayer(names[i], (i+1));
				else if (kindOfPlayer == LAN)
					players[i] = new LanPlayer(names[i], (i+1));
		}
	
	public static Game getInstance() {
		return game;
	}
	public int getIndexCurrent(){
		return indexCurrent;
	}
	
	/**
	 * �������� ���� ���������� ������
	 */
	public void nextPlayer() {
		if(indexCurrent < players.length - 1)
			++indexCurrent;
		else
			indexCurrent = 0;
	}
	/**
	 * ����� ��� ��������� ������ �� ������� ������ ��� ������������ ��������� ��� ��� �����...
	 * @return 
	 */
	public int getFirstPlayer()
	{
		int rez=-1;
		if (players!=null)
			for (int i=0;i<players.length;++i)
				if (rez==-1&&players[i]!=null)
					rez=i;
		return rez;		
	}
	/**
	 * �������� ������ ���� countX �� countY 
 	 * @param countX, ���������� �����
	 * @param countY, ���������� ��������
	 */
	public void setSize(int countX, int countY){
		Field = new GameField(countX, countY);
	}
	/**
	 * 
	 * @param index ������ ������
	 * @return Null ��� ������ ������ ���������... 
	 */
	public AbstractPlayer getPlayer(int index)
	{
		if (players!=null)
		{
			try
			{
				return players[index];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				//return null;  ������ �� �����...
			}
		}
		return null;
	}
}
