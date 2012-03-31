package team.game.visual;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * ������� �����
 * ������ ������ ������ 575 �� �������������!
 * @author ����
 *
 */
public class MainForm 
{
	private JFrame f=new JFrame("");
	private ImagePanel imagePnael=new ImagePanel();
	JMenuBar menuBar=new JMenuBar();
	JMenu gameMenu=new JMenu("����");
	JMenu helpMenu=new JMenu("������");
	JMenuItem createItem=new JMenuItem("�������");
	JMenuItem connectItem=new JMenuItem("������������");
	JMenuItem rulesItem=new JMenuItem("������� ����");
	JMenuItem aboutItem=new JMenuItem("� ���������");
	
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
