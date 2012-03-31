package team.game.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import team.game.data.Cell;
import team.game.data.Game;
import team.game.data.LocalPlayer;

/**
 * 
 * @author Виталя
 *
 */
public class GameProcessor {
	private Game game;
	private class Tree{
		LocalPlayer player;
		Point 		RootXY;
		Cell 		Head;
		List<Cell> 	Branches ;
		List<Point> BranchesXY;
		int countX, countY;
		Tree(LocalPlayer pl, Point xy)
		{
			player		= pl;
			RootXY 		= new Point();
			RootXY 		= xy;
			Head 		= new Cell();
			Head 		= game.Field.getCell(RootXY.x,RootXY.y);
			Branches	= new ArrayList<Cell>();
			BranchesXY 	= new ArrayList<Point>();
			//----------------------------------------------------------
			countX=game.Field.getCountX();
			countY=game.Field.getCountY();
			for(int i = RootXY.x-1; i<= RootXY.x+1; ++i ){
				for(int j = RootXY.y-1; j<=RootXY.y+1; ++j ){
					if((i>=0 && i< countX && j>=0 && j< countY && 
							(i!=RootXY.x || j!= RootXY.y))&&
							(game.Field.getCell(i,j).getOwner()== player)){
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
			for(int i=0; i< BranchesXY.size(); ++i)
			{
				if(Branches.get(i).getActor()==null){
					res = true;
					break;
				}
				else{
					Tree tmp=new Tree(player, BranchesXY.get(i));
					tmp.searhLife();
				}					
			}
			return res;
		}
	}
	public GameProcessor( Game game) {
		this.game = game;
	}
	public void ProcessStep(LocalPlayer player, Point xy){
		Tree TRcell= new Tree(player, xy);
		if(TRcell.searhLife()){
			game.Field.getCell(xy.x, xy.y).setActor(game.Field.getCell(xy.x, xy.y).getOwner());
			game.Field.getCell(xy.x, xy.y).setOwner(player);
		}
	}
	
}
