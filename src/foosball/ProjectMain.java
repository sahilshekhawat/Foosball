package foosball;

import javax.swing.JFrame;

public class ProjectMain {
	public static void main(String[] args){
		StartingScreen myField = new StartingScreen();
		myField.setDefaultCloseOperation
	         	(JFrame.EXIT_ON_CLOSE);
		myField.pack();
		myField.setVisible(true);
		
	}
}
