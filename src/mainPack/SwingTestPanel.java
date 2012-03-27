package mainPack;
//yura commit
/*Vetal
 * 
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingTestPanel extends JPanel implements MouseListener, FocusListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyMessageBox    msgBox    = new MyMessageBox();

    public SwingTestPanel(){
        initialize();
        addMouseListener(this);
        addFocusListener(this);
    }

    private void initialize(){
        this.setBackground(Color.GREEN);
        this.setLayout(null);
        this.setSize(new Dimension(446, 265));
        this.add(msgBox);
    }

    @Override
    public void focusGained(FocusEvent fe){
        System.out.println("Focus gained in JPanel");
    }

    @Override
    public void focusLost(FocusEvent fe){
        System.out.println("Focus lost in JPanel");
    }

    @Override
    public void mousePressed(MouseEvent me){
        requestFocus();
        System.out.println("Mouse Pressed in JPanel");
    }

    @Override
    public void mouseReleased(MouseEvent me){}

    @Override
    public void mouseClicked(MouseEvent me){}

    @Override
    public void mouseEntered(MouseEvent me){}

    @Override
    public void mouseExited(MouseEvent me){}

    static class MyMessageBox extends JComponent implements FocusListener, MouseListener {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyMessageBox(){
            initialize();
            addMouseListener(this);
            addFocusListener(this);
            System.out.println("Done");
        }

        private void initialize(){
            this.setName("msgBox");
            this.setEnabled(true);
            this.setSize(100, 100);
            this.setLocation(new Point(150, 100));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        @Override
        public void mousePressed(MouseEvent me){
            requestFocus();
            System.out.println("Mouse pressed on box");
        }

        @Override
        public void mouseReleased(MouseEvent me){}

        @Override
        public void mouseClicked(MouseEvent me){}

        @Override
        public void mouseEntered(MouseEvent me){}

        @Override
        public void mouseExited(MouseEvent me){}

        @Override
        public void focusGained(FocusEvent fe){
            System.out.println("Focus gained by box");
        }

        @Override
        public void focusLost(FocusEvent fe){
            System.out.println("Focus lost by box");
        }
    }
    public static void main(String args[]){
        JFrame window = new JFrame();
        SwingTestPanel content = new SwingTestPanel();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 75);
        window.setSize(400, 400);
        window.setVisible(true);
    }
}