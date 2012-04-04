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
			 res= "Голубой квадрат";
			break;
		case 2:
			 res= "Зеленный круг";
			break;
		case 3:
			 res= "Красные полосы ";
			break;
		case 4:
			 res= "Жолтый крестик ";
			break;
		default:
			break;
		}
		return res;
	}

}
