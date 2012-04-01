package team.game.data;
/**
 * 
 * @author AWESOME
 *
 */
public abstract class AbstractPlayer {
	public String 	name;
	public int 		figureType;
	public abstract void action(int x, int y);
}
