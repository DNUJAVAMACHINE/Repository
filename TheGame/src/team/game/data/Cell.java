package team.game.data;

public class Cell {
	
	private LocalPlayer owner;
	private LocalPlayer actor;
	
	public int model;   // = одно из трёх: CellState.EMPTY_CELL, KILLED_CELL, CROSSED_CELL
	
}
