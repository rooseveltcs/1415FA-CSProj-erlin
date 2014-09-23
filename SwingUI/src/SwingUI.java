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

	  public static void main(String[] args) {
		  SwingUI app = new SwingUI();
	    app.setVisible(true);
	  }

	  private SwingUI() {
	    super("Product of numbers");
	    resultField.setEditable(false);
	    add(new JLabel("n1 times n2"), BorderLayout.NORTH);
	    add(numberField1, BorderLayout.CENTER);
	    add(numberField2, BorderLayout.WEST);
	    add(resultField, BorderLayout.PAGE_END);
	    JButton butt = new JButton("Product of n1 and n2");
	    butt.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        String numberStr1 = numberField1.getText();
	        String numberStr2 = numberField2.getText();
	        numberStr1 = numberStr1.trim();
	        numberStr2 = numberStr2.trim();
	        int n1 = Integer.parseInt(numberStr1);
	        int n2 = Integer.parseInt(numberStr2);
	        n1 *= n2;
	        resultField.setText("num1 * num2 = " + n1);
	      }
	    });
	    add(butt, BorderLayout.EAST);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	  }
	}