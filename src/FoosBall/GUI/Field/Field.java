package FoosBall.GUI.Field;

import FoosBall.GUI.Ball.BouncingBall;
import FoosBall.GUI.Menus.MainMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Field extends JFrame {

	private JLabel label;
    private JLabel label_title;
	private ImageIcon footballField;
    private ImageIcon title;
	private MainMenu options;
	private JPanel panelMain;
	private BouncingBall ball;
	private JLayeredPane lPane = new JLayeredPane();
	public int screenWidth = 1085;
	public int screenHeight = 700;
	
	public Field(){
		super("FoosBall");
        InitUi();
	}

    private void InitUi(){
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setLayout(new BorderLayout());
        add(lPane, BorderLayout.CENTER);
		setBounds(0, 0, 1080, 1080);
        try {
            footballField = new ImageIcon(this.getClass().getResource("../Images/main.jpg"));
        } catch(NullPointerException exception){
            System.out.println("Foosball.png doesnot exists!!");
        }
        label = new JLabel(footballField);

        try{
            title = new ImageIcon(this.getClass().getResource("../Images/title.png"));
        } catch (NullPointerException e){
            System.out.println("title.png does not exists");
        }

        //label_title = new JLabel(title);
        //label_title.setBounds(20,20,377,381);
        panelMain = new JPanel();
        panelMain.setBackground(Color.BLACK);
        panelMain.add(label);
        //panelMain.add(label_title);
        panelMain.setBounds(0, 0, screenWidth, screenHeight);
        panelMain.setOpaque(true);
        options = new MainMenu();
        options.setOpaque(true);
        lPane.add(panelMain, new Integer(0), 0);
        lPane.add(options, new Integer(1), 0);

        setResizable(false);
        pack();
    }
	
}

