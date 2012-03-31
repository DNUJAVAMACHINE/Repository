package team.game.visual;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Прорисовка графич компонент
 * Отловка ходов игрока 
 * В архитектуре ГеймВйу
 * @author Юрий
 *
 */
public class ImagePanel extends JPanel
{
	class myCell
	{
		int a;
	}
	int CellWidth;//delete
	int CellHeight;//delete
 
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
	 * загрузка картинок
	 */
	ImagePanel()
	{
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
	}
	/**
	 * Прорисовка Игрового поля
	 */
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		int x=0,y=0;
		//g.drawImage(green,x,y,null);
		//x+=50;		
	}
}
