package View.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/*
 * Defines the transformation if the targeted JTextField 
 * does not meet our expectations
 */
public class FieldChecker implements FocusListener{
	
	JTextField FieldtoCheck = null;
	String Pattern = "";
	
	public FieldChecker(JTextField FieldtoCheck,String Pattern){
		this.FieldtoCheck = FieldtoCheck;
		this.Pattern = Pattern;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		FieldtoCheck.setBackground(null);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(!(FieldtoCheck.getText().matches(Pattern))){
			FieldtoCheck.setBackground(Color.red);
		}
	}
}
