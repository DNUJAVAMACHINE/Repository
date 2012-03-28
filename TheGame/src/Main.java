import javax.swing.SwingUtilities;

import VisualComponents.MainForm;



public class Main 
{
	public static void main(String arg[])
	{
		SwingUtilities.invokeLater(
				new Runnable() 
				{
					public void run() 
					{
						new MainForm();
					}
				}
				);
	}
}
