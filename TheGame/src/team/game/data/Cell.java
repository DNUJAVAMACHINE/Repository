package team.game.data;

public class Cell {
	
	private AbstractPlayer owner;
	private AbstractPlayer actor;
	public Cell(){
		owner=null;
		actor=null;
	}
	public AbstractPlayer getOwner(){return owner;}
	public AbstractPlayer getActor(){return actor;}
	public void setOwner(AbstractPlayer player){owner = player;}
	public void setActor(AbstractPlayer player){actor = player;}
}
