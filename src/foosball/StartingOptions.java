package foosball;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartingOptions extends JPanel {
	private JButton play;
	private JButton instructions;
	private JButton quit;
	

	public StartingOptions(){
		play = new JButton("PLAY");
		makeButtonOpaque(play);
		add(play);
		
		instructions = new JButton("INSTRUCTIONS");
		makeButtonOpaque(instructions);
		add(instructions);
		
		quit = new JButton("QUIT");
		makeButtonOpaque(quit);
		add(quit);
		
		setBounds(17, 320, 1050, 40);
		setVisible(true);
		setOpaque(true);
		
		ButtonHandlerClass buttonHandler = new ButtonHandlerClass();
		play.addActionListener(buttonHandler);
		instructions.addActionListener(buttonHandler);
		quit.addActionListener(buttonHandler);
		
	}
	
	public void makeButtonOpaque(JButton button){
		button.setOpaque(false);
		button.setContentAreaFilled(false);
	}
	
	private class ButtonHandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
		}
		
		public String getInstructions(){
			return "Mahaan Shrotriya";
		}
	}
}

