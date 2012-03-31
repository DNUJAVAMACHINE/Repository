package team.game.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
		Tree(LocalPlayer pl, Point xy)
		{
			player		= pl;
			RootXY 		= new Point();
			RootXY 		= xy;
			Head 		= new Cell();
			Head 		= game.Field.getCell(RootXY.x,RootXY.y);
			Branches	= new ArrayList<Cell>();
			BranchesXY 	= new ArrayList<Point>();
			try{
				if(game.Field.getCell(RootXY.x-1,RootXY.y-1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x-1,RootXY.y-1));
					Point tmp = new Point();
					tmp.x= RootXY.x-1;
					tmp.y= RootXY.y-1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x,RootXY.y-1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x,RootXY.y-1));
					Point tmp = new Point();
					tmp.x= RootXY.x;
					tmp.y= RootXY.y-1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x+1,RootXY.y-1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x+11,RootXY.y-1));
					Point tmp = new Point();
					tmp.x= RootXY.x+1;
					tmp.y= RootXY.y-1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x-1,RootXY.y).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x-1,RootXY.y));
					Point tmp = new Point();
					tmp.x= RootXY.x-1;
					tmp.y= RootXY.y;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x+1,RootXY.y).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x+1,RootXY.y));
					Point tmp = new Point();
					tmp.x= RootXY.x+1;
					tmp.y= RootXY.y;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x-1,RootXY.y+1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x-1,RootXY.y+1));
					Point tmp = new Point();
					tmp.x= RootXY.x-1;
					tmp.y= RootXY.y+1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x,RootXY.y+1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x,RootXY.y+1));
					Point tmp = new Point();
					tmp.x= RootXY.x;
					tmp.y= RootXY.y+1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
			try{
				if(game.Field.getCell(RootXY.x+1,RootXY.y+1).getOwner()== player){
					Branches.add(game.Field.getCell(RootXY.x+1,RootXY.y+1));
					Point tmp = new Point();
					tmp.x= RootXY.x+1;
					tmp.y= RootXY.y+1;
					BranchesXY.add(tmp);
				}
			}
			catch (Exception e) {
			}
		}
		void searhLife(){
			//boolean isLife=false;
			for(int i=0; i< BranchesXY.size(); ++i)
			{
				if(Branches.get(i).getActor()==null){
					Head.setActor(Head.getOwner());
					Head.setOwner(player);
					//isLife =true;
					break;
				}
				else{
					Tree tmp=new Tree(player, BranchesXY.get(i));
					tmp.searhLife();
				}
					
			}
		}
	}
	public GameProcessor( Game game) {
		this.game = game;
	}
	public void ProcessStep(LocalPlayer player, Point xy){
		Tree TRcell= new Tree(player, xy);
		TRcell.searhLife();
	}
}
