package team.game.data;
/**
 * 
 * @author AWESOME
 *
 */
public class LocalPlayer extends AbstractPlayer {
	
	public LocalPlayer(String name, int figureType) {
		this.name 		= name;
		this.figureType	= figureType;
	}
	
	public void action(int x, int y) {
		
	}
	
	public String getTypeToString()	{
		switch (figureType) {
			case FigureType.BLUE_SQUARE:  return "������� �������";
			case FigureType.GREEN_CIRCLE: return "������ ����";
			case FigureType.RED_STRIPS:   return "������� ������";
			case FigureType.YELLOW_CROSS: return "����� �������";
			default:                      return "";
		}
	}

}
