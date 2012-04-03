package team.game.visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import team.game.data.FigureType;
import team.game.data.Game;
import team.game.data.GameField;
import team.game.data.LocalPlayer;
/**
 * Прорисовка графич компонент
 * Отловка ходов игрока 
 * В архитектуре ГеймВйу
 * @author Юрий и самую малость AWESOME :)
 *
 */
public class ImagePanel extends JPanel
{
	//int CellWidth;//delete
	//int CellHeight;//delete
	GameField gameField;
	
	Game gaga;//Временная шняга....
	
	private Image green;
	private Image blue;
	private Image yellow;
	private Image blueKillsGreen;
	private Image greenKillsBlue;
	private Image blueKillsYellow;
	private Image red;
	private Image blueKillsRed;
	private Image greenKillsYellow;
	private Image redKillsBlue;
	private Image greenKillsRed;
	private Image yellowKillsBlue;
	private Image redKillsGreen;
	private Image redKillsYellow;
	private Image yellowKillsGreen;
	private Image yellowKillsRed;

	/**
	 * загрузка картинок в конструкторе
	 * @param refFormCells ссылка на масив Cell-сов
	 * @param ga - временная шняга.....
	 */
	ImagePanel(GameField _gameField,Game ga)
	{
		gameField = _gameField;
		this.gaga=ga;
		try 
		{
			green=ImageIO.read(new File("resources\\Green.jpg"));
			blue=ImageIO.read(new File("resources\\Blue.jpg"));
			yellow=ImageIO.read(new File("resources\\Yellow.jpg"));
			blueKillsGreen=ImageIO.read(new File("resources\\BlueKillsGreen.jpg"));
			greenKillsBlue=ImageIO.read(new File("resources\\GreenKillsBlue.jpg"));
			blueKillsYellow=ImageIO.read(new File("resources\\BlueKillsYellow.jpg"));
			red=ImageIO.read(new File("resources\\Red.jpg"));
			blueKillsRed=ImageIO.read(new File("resources\\BlueKillsRed.jpg"));
			greenKillsYellow=ImageIO.read(new File("resources\\GreenKillsYellow.jpg"));
			redKillsBlue=ImageIO.read(new File("resources\\RedKillsBlue.jpg"));
			greenKillsRed=ImageIO.read(new File("resources\\GreenKillsRed.jpg"));
			yellowKillsBlue=ImageIO.read(new File("resources\\YellowKillsBlue.jpg"));
			redKillsGreen=ImageIO.read(new File("resources\\RedKillsGreen.jpg"));
			redKillsYellow=ImageIO.read(new File("resources\\RedKillsYellow.jpg"));
			yellowKillsGreen=ImageIO.read(new File("resources\\YellowKillsGreen.jpg"));
			yellowKillsRed=ImageIO.read(new File("resources\\YellowKillsRed.jpg"));
		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
			System.out.println("Эпик фэйл пикчер нот фаунд :)");
		}
		//Добавление клика...
		this.addMouseListener(
				new MouseAdapter() 
				{
					@Override
					public void mousePressed(MouseEvent e) 
					{
						//super.mousePressed(e); хз итп....
						int cellWidth=getWidth()/gameField.countX;
						int cellHeight=getHeight()/gameField.countY;
						int i=e.getY()/cellHeight;
						int j=e.getX()/cellWidth;
						LocalPlayer o=gameField.getCell(i, j).getOwner();
						LocalPlayer a=gameField.getCell(i, j).getActor();
						Random random=new Random();
						if (e.getModifiers()==InputEvent.BUTTON1_MASK)
						{
							if (o==null)
								gameField.getCell(i, j).setOwner(gaga.getPlayer(0));
							else
							{
								if (o.equals(gaga.players[0]))
									gameField.getCell(i, j).setOwner(gaga.getPlayer(1));
								if (o.equals(gaga.players[1]))
									gameField.getCell(i, j).setOwner(gaga.getPlayer(2));
								if (o.equals(gaga.players[2]))
									gameField.getCell(i, j).setOwner(gaga.getPlayer(3));
								if (o.equals(gaga.players[3]))
									gameField.getCell(i, j).setOwner(null);
							}
						}
						else
						//if (e.getModifiers()==InputEvent.BUTTON3_MASK)
							if (a==null)
								gameField.getCell(i, j).setActor(gaga.getPlayer(0));
							else
							{
								if (a.equals(gaga.players[0]))
									gameField.getCell(i, j).setActor(gaga.getPlayer(1));
								if (a.equals(gaga.players[1]))
									gameField.getCell(i, j).setActor(gaga.getPlayer(2));
								if (a.equals(gaga.players[2]))
									gameField.getCell(i, j).setActor(gaga.getPlayer(3));
								if (a.equals(gaga.players[3]))
									gameField.getCell(i, j).setActor(null);
							}	
						repaint();
					}
				}
				);
	}
	/**
	 * Прорисовка Игрового поля
	 */
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		int i,j;
		int countWidth=gameField.countX;
		int countHeight=gameField.countY;
		int cellWidth=getWidth()/countWidth;
		int cellHeight=getHeight()/countHeight;
		
		g.setColor(Color.black);
		for (i=0;i<countHeight+1;++i)
			g.drawLine(0,i*cellHeight,cellWidth*countWidth,i*cellHeight);	
		for (i=0;i<countWidth+1;++i)
			g.drawLine(i*cellWidth,0,i*cellWidth,countHeight*cellHeight);
		
		Image image=null;
		for (i=0;i<gameField.countY;++i)
			for (j=0;j<gameField.countX;++j)//if-ы не пределовать!
			{
				LocalPlayer owner=gameField.getCell(i, j).getOwner();
				LocalPlayer actor=gameField.getCell(i, j).getActor();
				if (owner!=null)
				{
					if (actor==null)
					{
						switch (owner.figureType) 
						{
							case FigureType.BLUE_SQUARE:
								image=blue;							
								break;
							case FigureType.GREEN_STRIPS:
								image=green;
								break;
							case FigureType.RED_CROSS:
								image=red;
								break;
							case FigureType.YELLOW_CIRCLE:
								image=yellow;
								break;
						}
					}
					else//actor!=null
					{
						switch (owner.figureType)
						{
						case FigureType.BLUE_SQUARE:
							switch (actor.figureType)
							{
							case FigureType.GREEN_STRIPS:
								image=blueKillsGreen;
								break;
							case FigureType.RED_CROSS:
								image=blueKillsRed;
								break;
							case FigureType.YELLOW_CIRCLE:
								image=blueKillsYellow;
								break;
							}
							break;
						case FigureType.GREEN_STRIPS:
							switch (actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=greenKillsBlue;
								break;
							case FigureType.RED_CROSS:
								image=greenKillsRed;
								break;
							case FigureType.YELLOW_CIRCLE:
								image=greenKillsYellow;
								break;
							}
							break;
						case FigureType.RED_CROSS:
							switch (actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=redKillsBlue;
								break;
							case FigureType.GREEN_STRIPS:
								image=redKillsGreen;
								break;
							case FigureType.YELLOW_CIRCLE:
								image=redKillsYellow;
								break;
							}
							break;
						case FigureType.YELLOW_CIRCLE:
							switch(actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=yellowKillsBlue;
								break;
							case FigureType.GREEN_STRIPS:
								image=yellowKillsGreen;
								break;
							case FigureType.RED_CROSS:
								image=yellowKillsRed;
								break;
							}
						}
					}
					//brush image;
					g.drawImage(image,j*cellWidth,i*cellHeight,cellWidth,cellHeight,null);
				}
			}
	}
}
