package team.game.main;

import javax.swing.SwingUtilities;

import team.game.visual.MainForm;

public class Main {
	public static void main(String arg[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override		
			public void run() {
				new MainForm();
			}
		});
	}
}
