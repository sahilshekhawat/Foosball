package FoosBall.Menus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	private JButton play;
	private JButton instructions;
	private JButton quit;
	

	public MainMenu(){


		play = new JButton();
		makeButtonOpaque(play);
		add(play);
        try {
            Image imgp = ImageIO.read(getClass().getResource("../Images/play.png"));
            Image newimgp = imgp.getScaledInstance( 60, 40,  java.awt.Image.SCALE_SMOOTH ) ;
            play.setIcon(new ImageIcon(newimgp));
        } catch(IOException e){
            System.out.println("play images does not exists");
        }
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });
		
		instructions = new JButton();
		makeButtonOpaque(instructions);
		add(instructions);
        try {
            Image img = ImageIO.read(getClass().getResource("../Images/instructions.png"));
            Image newimg = img.getScaledInstance( 100, 40,  java.awt.Image.SCALE_SMOOTH ) ;
            instructions.setIcon(new ImageIcon(newimg));
        } catch(IOException e){
            System.out.println("INstructions images does not exists");
        }
        instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, String.format("%s", getInstructions()));
            }
        });


		quit = new JButton();
		makeButtonOpaque(quit);
		add(quit);
        try {
            Image imgq = ImageIO.read(getClass().getResource("../Images/quit.jpg"));
            Image newimgq = imgq.getScaledInstance( 60, 40,  java.awt.Image.SCALE_SMOOTH ) ;
            quit.setIcon(new ImageIcon(newimgq));
        } catch(IOException e){
            System.out.println("quit images does not exists");
        }
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
		
		setBounds(17, 320, 1150, 60);
		setVisible(true);
		setOpaque(true);
		
/*		ButtonHandlerClass buttonHandler = new ButtonHandlerClass();
		play.addActionListener(buttonHandler);
		instructions.addActionListener(buttonHandler);
		quit.addActionListener(buttonHandler);*/
		
	}
	
	public void makeButtonOpaque(JButton button){
		button.setOpaque(false);
		button.setContentAreaFilled(false);
	}

    public String getInstructions(){
        return "Mahaan Shrotriya";
    }
	
/*	private class ButtonHandlerClass implements ActionListener {
*//*		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String actionCommand = ((JButton) e.getSource()).getActionCommand();
			if(actionCommand == "QUIT"){
				System.exit(0);
			}
			if(actionCommand == "INSTRUCTIONS"){
				JOptionPane.showMessageDialog(null, String.format("%s", getInstructions()));
			}
			if(actionCommand == "PLAY"){
				setVisible(false);

			}
		}*//*
		
		public String getInstructions(){
			return "Mahaan Shrotriya";
		}
	}*/
}

