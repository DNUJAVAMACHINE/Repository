package team.game.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import team.game.data.AbstractPlayer;
import team.game.data.Cell;
import team.game.data.Game;

/**
 * 
 * @author ������
 *
 */
public class GameProcessor {
	private Game game;
	private class Tree{
		AbstractPlayer player;
		Point          RootXY;
		List<Cell>     Branches ;
		List<Point>    BranchesXY;
		int            countX, countY;
		List<Point>    MemoryBranches;
		Tree(AbstractPlayer pl, Point xy, List<Point> Memory)
		{
			player			= pl;
			RootXY 			= new Point();
			RootXY 			= xy;
			Branches		= new ArrayList<Cell>();
			BranchesXY 		= new ArrayList<Point>();
			MemoryBranches	= Memory;
			//----------------------------------------------------------
			countX=game.Field.getCountX();
			countY=game.Field.getCountY();
			for(int i = RootXY.x-1; i<= RootXY.x+1; ++i ){
				for(int j = RootXY.y-1; j<=RootXY.y+1; ++j ){
					Point tmpPoint = new Point();
					tmpPoint.x=i;
					tmpPoint.y=j;
					if((i>=0 && i< countX && j>=0 && j< countY && 
							(i!=RootXY.x || j!= RootXY.y))&&
							(game.Field.getCell(i,j).getOwner()== player)
							&&(! MemoryBranches.contains(tmpPoint))){
						Branches.add(game.Field.getCell(i,j));
						Point tmp 	= new Point();
						tmp.x		= i;
						tmp.y		= j;
						BranchesXY.add(tmp);
					}
				}
			}
			//----------------------------------------------------------
		}			
		boolean searhLife(){
			boolean res = false;
			if(BranchesXY.size()>0)
				for(int i=0; i< BranchesXY.size(); ++i)
				{
					MemoryBranches.add(RootXY);
					if(Branches.get(i).getActor()==null){
						res = true;
						break;
					}
					else{
						Tree tmp=new Tree(player, BranchesXY.get(i), MemoryBranches);
						res= tmp.searhLife();
						if(res)
							break;
					}
					
				}
			return res;
		}
	}
	public GameProcessor( Game game) {this.game = game;}
	public boolean ProcessStep(AbstractPlayer player, Point xy){
		if(game.Field.getCell(xy.x, xy.y).getOwner()==player)
			return false;
		Tree TRcell= new Tree(player, xy, new ArrayList<Point>());
		if(TRcell.searhLife()&& game.Field.getCell(xy.x, xy.y).getActor()==null 
				&& game.Field.getCell(xy.x, xy.y).getOwner() != player &&(player != game.Field.getCell(xy.x, xy.y).getOwner())){
			game.Field.getCell(xy.x, xy.y).setActor(game.Field.getCell(xy.x, xy.y).getOwner());
			game.Field.getCell(xy.x, xy.y).setOwner(player);
			return true;
		//&&(player == game.Field.getCell(xy.x, xy.y).getOwner())
		}
		else
			return false;
	}
	/**
	 * ������� ���� �� � pl ��������� ���
	 * @param pl, ���������� �����
	 * @return true, ���� ���� ���
	 */
	public boolean existenceMove(AbstractPlayer pl){ 
		boolean res = false;
		for(int i=0; i< game.Field.getCountX(); ++i)
			for(int j=0; j< game.Field.getCountY(); ++j)
				if((game.Field.getCell(i, j).getOwner()== null)
						||(game.Field.getCell(i, j).getOwner()!= pl 
						&& game.Field.getCell(i, j).getActor()==null)){
					Point tmp	= new Point();
					tmp.x		= i;
					tmp.y		= j;
					Tree tree = new Tree(pl,tmp , new  ArrayList<Point>());
					if(tree.searhLife()){
						res = true;
						break;
					}
				}
		return res;
	}
	/**
	 * ������� ���� �� ������ ���� ���� � ������ ������
	 * @return true, ���� ���� ���
	 */
	public boolean GameEnd(){
		boolean res = false;
		for(int i=0; i< game.players.length; ++i){
			res=existenceMove(game.players[i]);
			if(res) return res;
		}		
		return res;
	}
	/**
	 * ����������, ���������� ���. ����� + ������� ������
	 * ������� �� 4-� �������, �� ����� ���� ������ �������� 3-�� ����,
	 * �� ����� �������� ������� 3-�� ��������
	 * @return
	 */
	public int[] Winner(){
		int[] res = new int[4];
			for(int i=0; i< game.Field.getCountX(); ++i){
				for(int j=0; j< game.Field.getCountY();++j){
					switch (game.Field.getCell(i, j).getOwner().figureType) {
					case 1:
						res[0]++;
						break;
					case 2:
						res[1]++;
						break;
					case 3:
						res[2]++;
						break;
					case 4:
						res[3]++;
						break;
					default:
						break;
					}
				}
			}
		return res;
	}
}
