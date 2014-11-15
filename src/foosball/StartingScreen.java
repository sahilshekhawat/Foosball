package foosball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartingScreen extends JFrame {
	
	private JLabel label;
	private ImageIcon footballField;
	private StartingOptions options;
	private JPanel panelMain;
	private BouncingBall ball;
	private JLayeredPane lPane = new JLayeredPane();
	public int screenWidth = 1085;
	public int screenHeight = 730;
	
	public StartingScreen(){
		super("FoosBall");
	
		setPreferredSize(new Dimension(screenWidth, screenHeight));
	    setLayout(new BorderLayout());
	    add(lPane, BorderLayout.CENTER);
		setBounds(0, 0, 1080, 1080);
		
		footballField = new ImageIcon("foosball.png");
		//BouncingBall ball = new BouncingBall(); //bouncing ball called
		label = new JLabel(footballField);
		panelMain = new JPanel();
        panelMain.setBackground(Color.BLACK);
        panelMain.add(label);
        panelMain.add(ball);
        panelMain.setBounds(0, 0, screenWidth, screenHeight);
        panelMain.setOpaque(true);
  
        options = new StartingOptions();
        
		lPane.add(panelMain, new Integer(0), 0);
	    lPane.add(options, new Integer(1), 0);
				
	    setResizable(false);
		pack();
	}
	
}

