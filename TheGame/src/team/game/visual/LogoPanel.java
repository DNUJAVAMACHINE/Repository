package team.game.visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LogoPanel extends JPanel
{
	private Image image;
	public LogoPanel() 
	{
		//this.setBackground(Color.black);
		try 
		{
			image=ImageIO.read(new File("resources\\logo2.jpg"));
		} 
		catch (IOException e) 
		{
			System.out.println("Logo not load");
		}
	}
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawImage(image,getWidth()/2-500/2,getHeight()/2-500/2,null);
	}
}
