package mainPack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldFrameClass extends JFrame
{

	private static final long serialVersionUID = 1L;

	public HelloWorldFrameClass()
	{
			JLabel jlbHelloWorld = new JLabel("Hello World");
			add(jlbHelloWorld);
			this.setSize(100, 100);
			setVisible(true);
	}
}