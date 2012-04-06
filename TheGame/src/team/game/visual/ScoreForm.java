package team.game.visual;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreForm 
{
	private static boolean isFormScoreShow=false;
	
	private JFrame f=new JFrame("—чет");
	private JButton buttonOk=new JButton("Ok...");
	private JPanel centerPanel=new JPanel();
	private JPanel bottomPanel=new JPanel(); 
	
	private ScoreForm(String dataFromScore[])
	{
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//f.setUndecorated(true);
		f.setSize(300,300);
		Dimension scrinSize=Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(scrinSize.width/2-f.getWidth()/2,scrinSize.height/2-f.getHeight()/2);
		f.getRootPane().setDefaultButton(buttonOk);
		buttonOk.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						f.setVisible(false);
						isFormScoreShow=false;
					}
				}
				);
		bottomPanel.setPreferredSize(new Dimension(0,40));
		buttonOk.setPreferredSize(new Dimension(110,30));
		bottomPanel.add(buttonOk);
		
		sortData(dataFromScore);
		centerPanel.setLayout(new GridLayout(dataFromScore.length,1));
		for (int i=0;i<dataFromScore.length;++i)
		{
			JPanel panelFromLabel=new JPanel();
			panelFromLabel.add(new JLabel(dataFromScore[i]));
			centerPanel.add(panelFromLabel);
		}
		
		f.add("South",bottomPanel);
		f.add(centerPanel);
		f.setVisible(true);
	}
	private void sortData(String data[])
	{
		int values[]=new int[data.length];
		int i,j;
		for (i=0;i<data.length;++i)
			values[i]=Integer.parseInt(data[i].substring(data[i].lastIndexOf(' ')+1));
		for (i=0;i<values.length;++i)
			for (j=0;j<values.length;++j)
				if (values[i]>values[j])
				{
					int buf=values[i];
					values[i]=values[j];
					values[j]=buf;
					String bufs=data[i];
					data[i]=data[j];
					data[j]=bufs;
				}
	}
	public static void showScore(String dataFromScore[])
	{
		if (!isFormScoreShow)
		{
			new ScoreForm(dataFromScore);
			isFormScoreShow=true;
		}
	}
}
