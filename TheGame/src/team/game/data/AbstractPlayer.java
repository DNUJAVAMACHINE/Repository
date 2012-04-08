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
			case FigureType.BLUE_SQUARE:  return "����� �������";
			case FigureType.GREEN_CIRCLE: return "������ ����";
			case FigureType.RED_STRIPS:   return "������� ������";
			case FigureType.YELLOW_CROSS: return "����� �������";
			default:                      return "";
		}
	}
}
