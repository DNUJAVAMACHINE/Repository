package team.game.data;
/**
 * 
 * @author AWESOME
 *
 */
public abstract class AbstractPlayer {
	public String name;
	public int    figureType;
	
	public String getTypeToString()	{
		switch (figureType) {
			case FigureType.BLUE_SQUARE:  return "синий квадрат";
			case FigureType.GREEN_CIRCLE: return "зелёный круг";
			case FigureType.RED_STRIPS:   return "красные полосы";
			case FigureType.YELLOW_CROSS: return "жёлтый крестик";
			default:                      return "";
		}
	}
}
