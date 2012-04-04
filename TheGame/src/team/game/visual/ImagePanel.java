package team.game.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import team.game.data.FigureType;
import team.game.data.Game;
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
	//GameField gameField;
	
	Game game;
	
	private int countSteps=0;
	
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
	private int ch=1;
	JLabel positionGame;
	boolean endGame;
	boolean inStart=true;//для написания имени первого игрока в самом начале игры
	boolean showNextPlaerInDrawinfPanel=false;//кидается в тру и при прорисовке произойдет вывод имени след игрока 8)

	/**
	 * загрузка картинок в конструкторе
	 * @param refFormCells ссылка на масив Cell-сов
	 * @param ga - временная шняга.....
	 */
	ImagePanel(Game _game, final JLabel positionGame )
	{
		//gameField = _gameField;
		//this.gaga=ga;
		this.positionGame=positionGame;
		this.game=_game;
		//this.gameField=_game.Field;
		this.setBackground(new Color(35,35,35));
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
					//Событие отжатия мыши
					//После отжатия миши создаст новый поток для прорисовек сообщения о смене игрока.
					//зачем новый просто прорисовка сообщения сотанавливает выполнение потока на пвру секунд
					//и клацну при этом на поле переменная showNextPlaerInDrawinfPanel кинется в фолс
					//и надпись исчезнет.
					public void mouseReleased(MouseEvent e) {
						
						if (showNextPlaerInDrawinfPanel&&endGame)
						{
							//обявление нового потока
							Thread tread=new Thread(new Runnable() 
							{
								public void run() 
								{
									if (showNextPlaerInDrawinfPanel&&endGame)
									{
										if (game.getPlayer(game.getIndexCurrent())!=null)
											showStepNexPlayer(game.getPlayer(game.getIndexCurrent()).name);
										showNextPlaerInDrawinfPanel=false;
										repaint();
									}
								}
							});
							tread.start();//запуск нового потока.
						}
					};
					@Override
					public void mousePressed(MouseEvent e) 
					{
						showNextPlaerInDrawinfPanel=false;
						//super.mousePressed(e); хз итп....
						int cellWidth=getWidth()/game.Field.countX;
						int cellHeight=getHeight()/game.Field.countY;
						int i=e.getY()/cellHeight;
						int j=e.getX()/cellWidth;
						
						Point pt = new Point();
						pt.x=i; pt.y=j;
						try {
							if(game.Processor.GameEnd())
							{
								if(game.Processor.existenceMove(game.getPlayer( game.getIndexCurrent())))
								{	
									endGame=true;
									//positionGame.setText("ход " + game.getPlayer( game.getIndexCurrent()).name+" - "+game.getPlayer( game.getIndexCurrent()).getTypeToString());
									if(game.Processor.ProcessStep(game.getPlayer( game.getIndexCurrent()), pt))
										ch++;
									if(ch>3){
										ch=1;
										game.nextPlayer();
										showNextPlaerInDrawinfPanel=true;
									}
								}
								else
								{
									ch=1;
									game.nextPlayer();
									showNextPlaerInDrawinfPanel=true;
								}
							}

							else {
								endGame=false;
								int[] win = new int[4]; 
								win=game.Processor.Winner();
								positionGame.setText("Конец игры!..");
								for(int l=0; l< 4 ; ++l){
									if(game.getPlayer(l)!=null){
										positionGame.setText(positionGame.getText()+ " "+game.getPlayer(l).getTypeToString()+":"+win[l]);
									}
								}
							}
						} catch (Throwable ex) {
							ex.printStackTrace();
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
		//так надо! просто больше негде... та ваще здесь супер...  не трогать...
		if (inStart)
		{
			inStart=false;
			if (game.getPlayer( game.getIndexCurrent())!=null)
				this.positionGame.setText("ход " + game.getPlayer( game.getIndexCurrent()).name+" - "+game.getPlayer( game.getIndexCurrent()).getTypeToString()+" | Осталось ходов :"+(4-ch));
		}
		else
			if (game.getPlayer( game.getIndexCurrent())!=null && endGame)
				this.positionGame.setText("ход " + game.getPlayer( game.getIndexCurrent()).name+" - "+game.getPlayer( game.getIndexCurrent()).getTypeToString()+" | Осталось ходов :"+(4-ch));
		
		super.paint(g);
		int i,j;
		int countWidth=game.Field.countX;
		int countHeight=game.Field.countY;
		int cellWidth=getWidth()/countWidth;
		int cellHeight=getHeight()/countHeight;
		
		g.setColor(Color.DARK_GRAY);
		for (i=0;i<countHeight+1;++i)
			g.drawLine(0,i*cellHeight,cellWidth*countWidth,i*cellHeight);	
		for (i=0;i<countWidth+1;++i)
			g.drawLine(i*cellWidth,0,i*cellWidth,countHeight*cellHeight);
		
		for (i=0;i<game.Field.countY;++i)
			for (j=0;j<game.Field.countX;++j)//if-ы не пределовать!
			{
				Image image=null;
				LocalPlayer owner=game.Field.getCell(i, j).getOwner();
				LocalPlayer actor=game.Field.getCell(i, j).getActor();
				if (owner!=null)
				{
					if (actor==null)
					{
						switch (owner.figureType) 
						{
							case FigureType.BLUE_SQUARE:
								image=blue;							
								break;
							case FigureType.GREEN_CIRCLE:
								image=green;
								break;
							case FigureType.RED_STRIPS:
								image=red;
								break;
							case FigureType.YELLOW_CROSS:
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
							case FigureType.GREEN_CIRCLE:
								image=blueKillsGreen;
								break;
							case FigureType.RED_STRIPS:
								image=blueKillsRed;
								break;
							case FigureType.YELLOW_CROSS:
								image=blueKillsYellow;
								break;
							}
							break;
						case FigureType.GREEN_CIRCLE:
							switch (actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=greenKillsBlue;
								break;
							case FigureType.RED_STRIPS:
								image=greenKillsRed;
								break;
							case FigureType.YELLOW_CROSS:
								image=greenKillsYellow;
								break;
							}
							break;
						case FigureType.RED_STRIPS:
							switch (actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=redKillsBlue;
								break;
							case FigureType.GREEN_CIRCLE:
								image=redKillsGreen;
								break;
							case FigureType.YELLOW_CROSS:
								image=redKillsYellow;
								break;
							}
							break;
						case FigureType.YELLOW_CROSS:
							switch(actor.figureType)
							{
							case FigureType.BLUE_SQUARE:
								image=yellowKillsBlue;
								break;
							case FigureType.GREEN_CIRCLE:
								image=yellowKillsGreen;
								break;
							case FigureType.RED_STRIPS:
								image=yellowKillsRed;
								break;
							}
						}
					}
					//brush image;
					g.drawImage(image,j*cellWidth+1,i*cellHeight+1,cellWidth-1,cellHeight-1,null);
				}
			}
		//Создание нового потока для прорисовки след игрока при смене игроков...
		
		
	}
	/**
	 * Временная задержка и отображ имени след игрока при смене игроков...
	 * Автор Волченко Юрий Константинович 8)
	 * @param playerName
	 */
	private void showStepNexPlayer(String playerName)
	{
		Graphics graphics=getGraphics();
		int centerX=this.getWidth()/2;
		int centerY=this.getHeight()/2;
		graphics.setColor(Color.LIGHT_GRAY);
		Font f=new Font("Monospaced", Font.ITALIC, 65);//размер шрифта не менять.
		graphics.setFont(f);
		graphics.drawString(playerName, centerX-(playerName.length()*20), centerY-10);
		try {
			Thread.currentThread().sleep(3000);//3 sec.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Исключение при задержке потока в задержке и отображ имени след игрока при смене игроков");
		}
	}
}
