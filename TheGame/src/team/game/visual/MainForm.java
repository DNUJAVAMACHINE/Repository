package team.game.visual;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * Главная форма
 * Размер высоты больше 575 не устанавливать!
 * @author Юрий
 *
 */
public class MainForm 
{
	private JFrame f=new JFrame("");
	private ImagePanel imagePnael=new ImagePanel();
	JMenuBar menuBar=new JMenuBar();
	JMenu gameMenu=new JMenu("Игра");
	JMenu helpMenu=new JMenu("Помощь");
	JMenuItem createItem=new JMenuItem("Создать");
	JMenuItem connectItem=new JMenuItem("Подключиться");
	JMenuItem rulesItem=new JMenuItem("Правила игры");
	JMenuItem aboutItem=new JMenuItem("О программе");
	
	public MainForm()
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 575);
		Dimension scrinSize=Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(scrinSize.width/2-f.getWidth()/2, scrinSize.height/2-f.getHeight()/2);
		
		AddComponentFromFrame();
		
		f.setVisible(true);		
	}
	private void AddComponentFromFrame()
	{
		
		gameMenu.add(createItem);
		gameMenu.addSeparator();
		gameMenu.add(connectItem);
		helpMenu.add(rulesItem);
		helpMenu.add(aboutItem);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		f.setJMenuBar(menuBar);
		f.add(imagePnael);
	}
}
