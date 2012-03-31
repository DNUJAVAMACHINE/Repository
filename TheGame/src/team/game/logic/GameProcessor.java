package team.game.logic;

import java.awt.Point;

import team.game.data.Cell;
import team.game.data.Game;

/**
 * 
 * @author Виталя
 *
 */
public class GameProcessor {
	Game game;
	private class Tree{
		Point RootXY;
		Cell Head;
		Cell[] Branches ;
		Point[] BranchesXY;
		Tree(Point xy)
		{
			RootXY = new Point();
			RootXY = xy;
			Head = new Cell();
			Head = game.Field.getCell(RootXY.x,RootXY.y);
		}
	}
}
