package VisualComponents;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * Главная форма
 * Размер высоты больше 575 не устанавливать!
 * @author Юрий
 *
 */
public class MainForm 
{
	private JFrame f=new JFrame("");
	
	public MainForm()
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 575);
		Dimension scrinSize=Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(scrinSize.width/2-f.getWidth()/2, scrinSize.height/2-f.getHeight()/2);
		
		
		f.setVisible(true);		
	}
}
