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
	public String getTypeToString()
	{
		String res="";
		switch (figureType) {
		case 1:
			 res= "������� �������";
			break;
		case 2:
			 res= "�������� ����";
			break;
		case 3:
			 res= "������� ������ ";
			break;
		case 4:
			 res= "������ ������� ";
			break;
		default:
			break;
		}
		return res;
	}

}
