package team.game.data;

public class Cell {
	
	private LocalPlayer owner;
	private LocalPlayer actor;
	public Cell(){
		owner=null;
		actor=null;
	}
	public LocalPlayer getOwner(){return owner;}
	public LocalPlayer getActor(){return actor;}
	public void setOwner(LocalPlayer player){owner = player;}
	public void setActor(LocalPlayer player){actor = player;}
}
