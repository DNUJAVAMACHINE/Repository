package team.game.data;
/**
 * 
 * @author AWESOME
 *
 */
public abstract class AbstractPlayer {
	public String 	name;
	public int 		figureTipe;
	public abstract void action(int x, int y);
}
