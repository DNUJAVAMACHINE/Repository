package team.game.data;

public abstract class AbstractPlayer {
	public String name;
	public Game game;
	public abstract void action(int x, int y);
}
