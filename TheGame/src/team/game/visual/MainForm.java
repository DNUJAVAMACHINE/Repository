package team.game.visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
/**
 * ������� �����
 * ������ ������ ������ 575 �� �������������!
 * ��� ���������� �� ������� �����, �������� ������ ������� ��������.
 * @author ����
 *
 */
public class MainForm 
{
	private JFrame f=new JFrame("Virus War");
	private ImagePanel imagePnael=new ImagePanel();
	JMenuBar menuBar=new JMenuBar();
	JMenu gameMenu=new JMenu("����");
	JMenu helpMenu=new JMenu("������");
	JMenuItem createItem=new JMenuItem("�������");
	JMenuItem connectItem=new JMenuItem("������������");
	JMenuItem rulesItem=new JMenuItem("������� ����");
	JMenuItem aboutItem=new JMenuItem("� ���������");
	
	JPanel gameFieldPanel=new JPanel();//������ � ������� ����.
	JPanel emptyPanel=new JPanel();//////////////////�� ������!(�� �������)
	JPanel createPanel=new JPanel();//������ ��� �������� ����� ����
	JPanel connectPanel=new JPanel();//������ ��� ����������� � ����
	
	JSpinner countPlayer;//���������� ������� 1-4
	JSpinner sizeField;//������ ���� ���� 
	JTextField playerName;//
	JTabbedPane tabFromCreate=new JTabbedPane();//
	
	JButton buttonStartLocalGame=new JButton("�����");
	JButton buttonStartLanGame=new JButton("�����");
	JButton buttonCreateLanGame=new JButton("������� ����");
	JButton buttonSendMessageFromCreatePanel=new JButton("���������");
	JButton buttonConnect=new JButton("�����������");
	JButton buttonDisConnect=new JButton("����������");
	JButton buttonSendMessageFromConnectPanel=new JButton("���������");
	
	JTextField playerIP=new JTextField(16);//���� � ����������� ����
	JTextField serverIP=new JTextField(16);//���� ��� ����� ���� �������
	JTextField playerMessageFromCreatePanel=new JTextField(20);//���� ��������� ������
	JTextField playerMessageFromConnectPanel=new JTextField(20);//--||--
	
	JLabel stateFromConnectpanel=new JLabel();//��������� ������ ��� �����������
	
	JTextArea chatFromConnectPlayer=new JTextArea();
	JTextArea chatFromCreatePanel=new JTextArea();
	JTextArea chatFromConnectPanel=new JTextArea();
	
	Dimension sizeButton=new Dimension(110,30);
	
	
	public MainForm()
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 575);
		f.setMinimumSize(new Dimension(500,300));
		Dimension scrinSize=Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(scrinSize.width/2-f.getWidth()/2, scrinSize.height/2-f.getHeight()/2);
		
		gameMenu.add(createItem);
		gameMenu.addSeparator();
		gameMenu.add(connectItem);
		helpMenu.add(rulesItem);
		helpMenu.add(aboutItem);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		f.setJMenuBar(menuBar);
		
		AddActions();
		
		SetComponentsFromCreatePanel();
		SetComponentsFromConnectPanel();
		//f.add(createPanel);
		
		f.setVisible(true);		
	}
	/**
	 * ��������� ����������� ��� �����������
	 */
	private void AddActions()
	{
		createItem.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						setPanelFromFrame(createPanel);
					}
				}
				);
		connectItem.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						setPanelFromFrame(connectPanel);
					}
				}
				);
	}
	/**
	 * ������� �� �������� ���������.
	 * @param panel ���� �� createPanel,emptyPanel,connectPanel,gameFieldPanel
	 */
	private void setPanelFromFrame(JPanel panel)
	{
		f.remove(createPanel);
		f.remove(emptyPanel);
		f.remove(connectPanel);
		f.remove(gameFieldPanel);
		f.add(panel);
		f.getContentPane().validate();//�� ����� �� ��� ��������
		f.getContentPane().repaint();//--||--
	}
	/**
	 * ��������� ����������� � ������ �������� ����
	 */
	private void SetComponentsFromCreatePanel()
	{
		/////////////////////////////////////////////////////////////////////////////////////////LocalGame
		createPanel.setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(0,50));
		topPanel.setLayout(new FlowLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel countPlayerPanel=new JPanel();
		SpinnerNumberModel model=new SpinnerNumberModel();
		model.setMinimum(1);
		model.setMaximum(4);
		model.setValue(4);
		countPlayer=new JSpinner(model);
		countPlayerPanel.add(new JLabel("���������� �������:"));
		countPlayerPanel.add(countPlayer);
		
		topPanel.add(countPlayerPanel);
		
		JPanel sizeFieldPanel=new JPanel();
		sizeFieldPanel.setLayout(new FlowLayout());
		model=new SpinnerNumberModel();
		model.setMinimum(10);
		model.setMaximum(50);
		model.setValue(10);
		sizeField=new JSpinner(model);
		sizeFieldPanel.add(new JLabel("������ ����:"));
		sizeFieldPanel.add(sizeField);
		
		topPanel.add(sizeFieldPanel);
		
		JPanel playerNamePanel=new JPanel();
		playerName=new JTextField(7);
		playerNamePanel.add(new JLabel("������� ���:"));
		playerNamePanel.add(playerName);
		
		topPanel.add(playerNamePanel);
		
		createPanel.add("North",topPanel);
		
		JPanel panelFromLoacalGame=new JPanel();
		buttonStartLocalGame.setPreferredSize(sizeButton);
		panelFromLoacalGame.add(buttonStartLocalGame);
		JLabel label=new JLabel("<html>������� �����, ��� ������ ��������� ���� <br> � ��������� �����������.");
		label.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelFromLoacalGame.add(label);
		
		tabFromCreate.addTab("���� � ����� ����������", panelFromLoacalGame);
		
		/////////////////////////////////////////////////////////////////////////////////////////LanGame
		JPanel panelFromLanGame=new JPanel();
		panelFromLanGame.setLayout(new BorderLayout());
		
		JPanel panelLanTop=new JPanel();
		panelLanTop.setLayout(new BorderLayout());
		panelLanTop.setPreferredSize(new Dimension(0,150));
		
		JPanel left=new JPanel();
		left.setPreferredSize(new Dimension(120,0));
		
		label=new JLabel("��� IP �����:");
		label.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		left.add(label);
		buttonCreateLanGame.setPreferredSize(sizeButton);
		buttonStartLanGame.setPreferredSize(sizeButton);
		left.add(buttonCreateLanGame);
		left.add(buttonStartLanGame);
			
		panelLanTop.add("West",left);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setPreferredSize(new Dimension(200,50));
		panel.add(playerIP);
		panel.add(new JLabel("� ��� ������������:"));
		JPanel right=new JPanel();
		right.setLayout(new BorderLayout());
		right.add("North",panel);
		chatFromConnectPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
		right.add("Center",chatFromConnectPlayer);
		
		panelLanTop.add("Center",right);
		
		JPanel panelChat=new JPanel();
		panelChat.setLayout(new BorderLayout());
		panelChat.add("North",new JLabel("���:"));
		chatFromCreatePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		panelChat.add("Center",chatFromCreatePanel);
		
		JPanel panelButtom=new JPanel();
		panelButtom.setLayout(new BorderLayout());
		playerMessageFromCreatePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		panelButtom.add(playerMessageFromCreatePanel);
		panelButtom.add("East",buttonSendMessageFromCreatePanel);
		
		panelFromLanGame.add("North",panelLanTop);
		panelFromLanGame.add("Center",panelChat);
		panelFromLanGame.add("South",panelButtom);
		tabFromCreate.addTab("���� �� ����",panelFromLanGame);
		
		createPanel.add(tabFromCreate);
	}
	/**
	 * ��������� ����������� � ������ ����������� � ����
	 */
	private void SetComponentsFromConnectPanel()
	{
		JPanel topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(0,120));
		topPanel.setLayout(new BorderLayout());
		JPanel leftTopPanel=new JPanel();
		leftTopPanel.setPreferredSize(new Dimension(150,0));
		leftTopPanel.add(new JLabel("������� ���:"));
		leftTopPanel.add(new JLabel("IP ����� �������:"));
		buttonConnect.setPreferredSize(sizeButton);
		leftTopPanel.add(buttonConnect);
		buttonDisConnect.setPreferredSize(sizeButton);
		leftTopPanel.add(buttonDisConnect);
		
		JPanel centerTopPanel=new JPanel();
		centerTopPanel.setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(0,70));
		panel.setLayout(new GridLayout(3,1));
		panel.add(playerName);
		panel.add(serverIP);
		panel.add(stateFromConnectpanel);
		
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		p.add("North",panel);
		
		topPanel.add("West",leftTopPanel);
		topPanel.add("Center",p);
		
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add("North",new JLabel("���:"));
		centerPanel.add("Center",chatFromConnectPanel);
		
		JPanel bottomPanel=new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		playerMessageFromConnectPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.add("Center",playerMessageFromConnectPanel);
		bottomPanel.add("East",buttonSendMessageFromConnectPanel);
		
		connectPanel.setLayout(new BorderLayout());
		connectPanel.add("North",topPanel);
		chatFromConnectPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		connectPanel.add("Center",centerPanel);
		connectPanel.add("South",bottomPanel);
		
		
	}
	
	//private void SetComponentsFrom �� ����...
	
	
	
	
	
}
