import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test2 extends JFrame implements ActionListener {
	static final long serialVersionUID = 0;
	JTextField textField;
	JTextField jtfInput;
	JButton button;
	static JTextArea jtAreaOutput;
	String newline = "\n";
	String text = "";
	boolean bframeTrue = false;
	ButtonsFrame frame = new ButtonsFrame();
	
	public Test2() {
		createGui();
	}
	public void createGui() {
		//things/varaibles...etc
		this.setTitle("Game");
		this.setResizable(true);
		textField = new JTextField(31);
		textField.setText("Input");
		textField.setEditable(false);
		jtfInput = new JTextField(31);
		jtfInput.addActionListener(this);
		button = new JButton("Button Input");
		jtAreaOutput = new JTextArea(10, 31);
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagLayout gridBag = new GridBagLayout();
		
		Container contentPane = getContentPane();
		
		
		contentPane.setLayout(gridBag);
		
		//sets grid to put stuff
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridx = 0;
		gridCons1.gridy = 2;
		gridCons1.gridwidth = 31;
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.gridx = 0;
		gridCons2.gridy = 0;
		gridCons2.weightx = 1.0;
		gridCons2.weighty = 1.0;
		gridCons2.gridwidth = 31;
		gridCons2.gridwidth = GridBagConstraints.REMAINDER;
		gridCons2.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridCons3 = new GridBagConstraints();
		gridCons3.gridx = 0;
		gridCons3.gridy = 1;
		gridCons3.gridwidth = 31;
		gridCons3.gridwidth = GridBagConstraints.REMAINDER;
		gridCons3.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints gridCons4 = new GridBagConstraints();
		gridCons4.gridx = 0;
		gridCons4.gridy = 3;
		gridCons4.gridwidth = 31;
		gridCons4.gridwidth = GridBagConstraints.REMAINDER;
		gridCons4.fill = GridBagConstraints.HORIZONTAL;
		
		//button
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	if(bframeTrue){
            		frame.setVisible(false);
            		bframeTrue = false;
            	}
            	else{
            		frame.pack();
        			frame.setVisible(true);
        			bframeTrue = true;
            		}
            	}
		});
		
		//put stuff on jframe
		contentPane.add(scrollPane, gridCons2);
		contentPane.add(textField, gridCons3);
		contentPane.add(jtfInput, gridCons1);
		contentPane.add(button, gridCons4);
	}
	
	public static void addText(String str){
		jtAreaOutput.append(str);
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument().getLength());
	}
	
	public void actionPerformed(ActionEvent evt) {
		text = jtfInput.getText();
	}
	
	
	
	public String returnText(){
		return text;
	}
	
	public void textClear(){
		text = "";
	}
	
/*	tesing to open frame
	public static void main(String[] args) {
		Test2 jtfTfDemo = new Test2();
		jtfTfDemo.pack();
		jtfTfDemo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jtfTfDemo.setVisible(true);
	}
*/	
}