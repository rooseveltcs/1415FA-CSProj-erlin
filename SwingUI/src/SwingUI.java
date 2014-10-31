import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingUI extends JFrame {
	  JTextField numberField1 = new JTextField(10);
	  JTextField numberField2 = new JTextField(10);
	  JTextField resultField = new JTextField(20);
	  
	  JButton butt1 = new JButton("Product of n1 and n2");
	  
	  public static void main(String[] args) {
		SwingUI app = new SwingUI();
	    app.setVisible(true);
	  }

	  private SwingUI() {
	    super("Calculator");
	    resultField.setEditable(false);
	    add(new JLabel("n1 times n2"), BorderLayout.NORTH);
	    add(numberField1, BorderLayout.CENTER);
	    add(numberField2, BorderLayout.WEST);
	    add(butt1, BorderLayout.EAST);
	    add(resultField, BorderLayout.AFTER_LAST_LINE);
	    butt1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        String numberStr1 = numberField1.getText();
	        String numberStr2 = numberField2.getText();
	        if(isInteger(numberStr1) && isInteger(numberStr2)){
	        	int n1 = Integer.parseInt(numberStr1);
	        	int n2 = Integer.parseInt(numberStr2);
	        	n1 *= n2;
	        	resultField.setText("num1 + num2 = " + n1);
	        }
	        else{
	        	resultField.setText("error");
	        }
	      }
	    });
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	  }
	  
	  public boolean isInteger( String input ) {
		    try {
		        Integer.parseInt( input );
		        return true;
		    }
		    catch( Exception e ) {
		        return false;
		    }
		}
	}