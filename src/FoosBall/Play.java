package FoosBall;

import FoosBall.GUI.Field.Field;

import javax.swing.JFrame;

public class Play {
	public static void main(String[] args){
		Field myField = new Field();
		
		myField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myField.pack();
		myField.setVisible(true);
	}
}
