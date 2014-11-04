import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ButtonsFrame  extends JFrame{
	static final long serialVersionUID = 0;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonY, buttonN, buttonE, buttonC;
	
	public ButtonsFrame() {
		createGui();
	}
	public void createGui() throws HeadlessException{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//things/varaibles...etc
		this.setTitle("Buttons");
		this.setResizable(false);
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button0 = new JButton("0");
		buttonY = new JButton("Y");
		buttonN = new JButton("N");
		buttonE = new JButton("Enter");
		buttonC = new JButton("Clear");
		GridBagLayout gridBag = new GridBagLayout();
		
		Container contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		//sets grid to put stuff
		GridBagConstraints b1 = new GridBagConstraints();
		b1.gridx = 0;
		b1.gridy = 0;
		GridBagConstraints b2 = new GridBagConstraints();
		b2.gridx = 1;
		b2.gridy = 0;
		GridBagConstraints b3 = new GridBagConstraints();
		b3.gridx = 2;
		b3.gridy = 0;
		GridBagConstraints b4 = new GridBagConstraints();
		b4.gridx = 0;
		b4.gridy = 1;
		GridBagConstraints b5 = new GridBagConstraints();
		b5.gridx = 1;
		b5.gridy = 1;
		GridBagConstraints b6 = new GridBagConstraints();
		b6.gridx = 2;
		b6.gridy = 1;
		GridBagConstraints b7 = new GridBagConstraints();
		b7.gridx = 0;
		b7.gridy = 2;
		GridBagConstraints b8 = new GridBagConstraints();
		b8.gridx = 1;
		b8.gridy = 2;
		GridBagConstraints b9 = new GridBagConstraints();
		b9.gridx = 2;
		b9.gridy = 2;
		GridBagConstraints b0 = new GridBagConstraints();
		b0.gridx = 1;
		b0.gridy = 3;
		GridBagConstraints bY = new GridBagConstraints();
		bY.gridx = 0;
		bY.gridy = 3;
		GridBagConstraints bN = new GridBagConstraints();
		bN.gridx = 2;
		bN.gridy = 3;
		GridBagConstraints bE = new GridBagConstraints();
		bE.gridy = 5;
		bE.gridwidth = GridBagConstraints.REMAINDER;
		bE.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints bC = new GridBagConstraints();
		bC.gridy = 4;
		bC.gridwidth = GridBagConstraints.REMAINDER;
		bC.fill = GridBagConstraints.HORIZONTAL;
		
		//addListeners for buttons
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "1");
            }});
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "2");
            }});
		button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "3");
            }});
		button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "4");
            }});
		button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "5");
            }});
		button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "6");
            }});
		button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "7");
            }});
		button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "8");
            }});
		button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "9");
            }});
		button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "0");
            }});
		buttonY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "1");
            	Main.window.text = Main.window.jtfInput.getText();
            }});
		buttonN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText(Main.window.jtfInput.getText() + "0");
            	Main.window.text = Main.window.jtfInput.getText();
            }});
		buttonE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.text = Main.window.jtfInput.getText();
            }});
		buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Main.window.jtfInput.setText("");
            }});
		
		//put stuff on jframe
		contentPane.add(button1, b1);
		contentPane.add(button2, b2);
		contentPane.add(button3, b3);
		contentPane.add(button4, b4);
		contentPane.add(button5, b5);
		contentPane.add(button6, b6);
		contentPane.add(button7, b7);
		contentPane.add(button8, b8);
		contentPane.add(button9, b9);
		contentPane.add(button0, b0);
		contentPane.add(buttonY, bY);
		contentPane.add(buttonN, bN);
		contentPane.add(buttonE, bE);
		contentPane.add(buttonC, bC);
	}
	
	//testing to open frame
	public static void main(String[] args) {
		ButtonsFrame frame = new ButtonsFrame();
		frame.pack();
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}
