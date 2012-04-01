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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import team.game.data.Game;

/**
 * ������� �����
 * ������ ������ ������ 575 �� �������������!
 * ��� ���������� �� ������� �����, �������� ������ ������� ��������.
 * @author ���� � ����� AWESOME :)
 *
 */
public class MainForm 
{
	private JFrame f=new JFrame("Virus War");
	private ImagePanel imagePnael=new ImagePanel();
	private JMenuBar menuBar=new JMenuBar();
	private JMenu gameMenu=new JMenu("����");
	private JMenu helpMenu=new JMenu("������");
	private JMenuItem createItem=new JMenuItem("�������");
	private JMenuItem connectItem=new JMenuItem("������������");
	private JMenuItem rulesItem=new JMenuItem("������� ����");
	private JMenuItem aboutItem=new JMenuItem("� ���������");
	
	private JPanel gameFieldPanel=new JPanel();//������ � ������� ����.
	private LogoPanel emptyPanel=new LogoPanel();//////////////////�� ������!(�� �������)
	private JPanel createPanel=new JPanel();//������ ��� �������� ����� ����
	private JPanel connectPanel=new JPanel();//������ ��� ����������� � ����
	
	private JSpinner countPlayer;//���������� ������� 2-4
	private JSpinner sizeField;//������ ���� ���� 
	private JTextField playerName;//
	private JTabbedPane tabFromCreate=new JTabbedPane();//
	
	private JButton buttonStartLocalGame=new JButton("�����");
	private JButton buttonStartLanGame=new JButton("�����");
	private JButton buttonCreateLanGame=new JButton("������� ����");
	private JButton buttonConnect=new JButton("�����������");
	private JButton buttonDisConnect=new JButton("����������");
	private JButton buttonSendMessageFromConnectPanel=new JButton("���������");
	private JButton buttomSendMessageFromFieldPanel=new JButton("���������");
	private JButton buttonSendMessageFromCreatePanel=new JButton("���������");
	
	private JTextField playerIP=new JTextField(16);//���� � ����������� ����
	private JTextField serverIP=new JTextField(16);//���� ��� ����� ���� �������
	private JTextField playerMessageFromCreatePanel=new JTextField(20);//���� ��������� ������
	private JTextField playerMessageFromConnectPanel=new JTextField(20);//--||--
	private JTextField playerMessageFromFieldPanel=new JTextField(20);//--||--
	private JTextField player1NameFromLocalgame=new JTextField(10);//����� ������� � ��������� ����...
	private JTextField player2NameFromLocalgame=new JTextField(10);
	private JTextField player3NameFromLocalgame=new JTextField(10);
	private JTextField player4NameFromLocalgame=new JTextField(10);
	
	private JLabel stateFromConnectpanel=new JLabel();//��������� ������ ��� �����������//////////////////�������� ���������!
	private JLabel stateFromFieldPanel=new JLabel("Starting...");//��������� ������ (����� ����� ����� �1...)
	
	private JTextArea chatFromConnectPlayer=new JTextArea();
	private JTextArea chatFromCreatePanel=new JTextArea();
	private JTextArea chatFromConnectPanel=new JTextArea();
	private JTextArea chatFromFieldPanel=new JTextArea();
	
	private Dimension sizeButton=new Dimension(110,30);
	
	
	private ImageIcon volumeImageDisable=new ImageIcon("resources\\volumeDisable2.jpg");
	private ImageIcon volumeImageEanble=new ImageIcon("resources\\volumeEnable2.jpg");
	private JButton buttonVolume=new JButton(volumeImageDisable);
	private JSlider volume=new JSlider(JSlider.HORIZONTAL,0,99,0);//��������� �����.... 
	private boolean volumeEnable=false;//��� ���� ����, ����... 
	
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
		SetComponentsFromFieldPanel();
		
		//������� ������ ����� � ���� ����.
		chatFromConnectPanel.setEditable(false);
		chatFromConnectPlayer.setEditable(false);
		chatFromCreatePanel.setEditable(false);
		chatFromFieldPanel.setEditable(false);
		
		setPanelFromFrame(emptyPanel);
		
		f.setVisible(true);		
	}
	/**
	 * ��������� ����������� ��� �����������
	 * @author ����
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
		buttonVolume.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						if (volumeEnable)
							volumeEnable=false;
						else
							volumeEnable=true;
						if (volumeEnable)
							buttonVolume.setIcon(volumeImageEanble);
						else
							buttonVolume.setIcon(volumeImageDisable);
					}
				}
				);
		buttonStartLocalGame.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						setPanelFromFrame(gameFieldPanel);
						
						String player1 = player1NameFromLocalgame.getText() != null && 
								         player1NameFromLocalgame.getText() != "" ? 
								         player1NameFromLocalgame.getText() : null;
						String player2 = player2NameFromLocalgame.getText() != null && 
								         player2NameFromLocalgame.getText() != "" ? 
								         player2NameFromLocalgame.getText() : null;
						String player3 = player3NameFromLocalgame.getText() != null && 
								         player3NameFromLocalgame.getText() != "" ? 
								         player3NameFromLocalgame.getText() : null;
						String player4 = player4NameFromLocalgame.getText() != null && 
								         player4NameFromLocalgame.getText() != "" ? 
								         player4NameFromLocalgame.getText() : null;
								         
						Game game = Game.getInstance();
						game.setPlayers(player1, player2, player3, player4);
					}
				});
	}
	/**
	 * ������� �� �������� ���������.
	 * @param panel ���� �� createPanel,emptyPanel,connectPanel,gameFieldPanel
	 *
	 * @author ����
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
		model.setMinimum(2);
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
		//playerNamePanel.add(new JLabel("������� ���:"));///////////////////������ ���� ����� ������...
		//playerNamePanel.add(playerName);
		
		topPanel.add(playerNamePanel);
		
		createPanel.add("North",topPanel);
		
		JPanel panelFromPlayer=new JPanel(new GridLayout(4, 2));
		panelFromPlayer.setPreferredSize(new Dimension(300, 200));
		
		panelFromPlayer.add(new JLabel("����� �1:"));
		panelFromPlayer.add(player1NameFromLocalgame);
		panelFromPlayer.add(new JLabel("����� �2:"));
		panelFromPlayer.add(player2NameFromLocalgame);
		panelFromPlayer.add(new JLabel("����� �3:"));
		panelFromPlayer.add(player3NameFromLocalgame);
		panelFromPlayer.add(new JLabel("����� �4:"));		
		panelFromPlayer.add(player4NameFromLocalgame);
		
		JPanel panelFromLoacalGame=new JPanel();
		panelFromLoacalGame.setLayout(new BorderLayout());
		
		JPanel startButtonAndLabel = new JPanel();
		buttonStartLocalGame.setPreferredSize(sizeButton);
		startButtonAndLabel.add(buttonStartLocalGame);
		startButtonAndLabel.add(new JLabel());
		startButtonAndLabel.add(new JLabel("<html>������� �����, ��� ������ ��������� ���� <br> � ��������� �����������."));
		
		panelFromLoacalGame.add(panelFromPlayer, BorderLayout.CENTER);
		panelFromLoacalGame.add(startButtonAndLabel, BorderLayout.SOUTH);
		
		/*
		panelFromLoacalGame.add(panelFrom1);
		panelFromLoacalGame.add(panelFrom2);
		panelFromLoacalGame.add(panelFrom3);
		panelFromLoacalGame.add(panelFrom4);
		*/
		
		//panelFromLoacalGame.add(buttonStartLocalGame);
		
		tabFromCreate.addTab("���� � ����� ����������", panelFromLoacalGame);
		
		/////////////////////////////////////////////////////////////////////////////////////////LanGame
		JPanel panelFromLanGame=new JPanel();
		panelFromLanGame.setLayout(new BorderLayout());
		
		JPanel panelLanTop=new JPanel();
		panelLanTop.setLayout(new BorderLayout());
		panelLanTop.setPreferredSize(new Dimension(0,150));
		
		JPanel left=new JPanel();
		left.setPreferredSize(new Dimension(120,0));
		
		JLabel label=new JLabel("��� IP �����:");
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
	 * @author ����
	 * 
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

	private void SetComponentsFromFieldPanel()
	{
		JPanel bottomPanel=new JPanel();
		//JPanel centerPanel=new JPanel();
		JPanel topPanel=new JPanel();
		
		bottomPanel.setLayout(new BorderLayout());
		playerMessageFromFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.add("Center",playerMessageFromFieldPanel);
		bottomPanel.add("East",buttomSendMessageFromFieldPanel);
		chatFromFieldPanel.setPreferredSize(new Dimension(0,90));
		chatFromFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.add("North",chatFromFieldPanel);
		
		topPanel.setLayout(new BorderLayout());
		topPanel.add("West",stateFromFieldPanel);
		//topPanel.add("East",null);//////////////////////////////////////�������������.
		buttonVolume.setBorder(null);
		
		JPanel volumePanel=new JPanel();
		volumePanel.setLayout(new BorderLayout());
		
		volumePanel.add("West",buttonVolume);
		volumePanel.add("Center",volume);
		topPanel.add("East",volumePanel);
		///////////////////////////////////////////////////////////////////////////////
		gameFieldPanel.setLayout(new BorderLayout());
		gameFieldPanel.add("North",topPanel);
		gameFieldPanel.add("Center",imagePnael);
		gameFieldPanel.add("South",bottomPanel);
	}
	
	
	
	
	
	
	
	
}
