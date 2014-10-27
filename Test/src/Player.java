import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Player extends JFrame{
	static final long serialVersionUID = 0;
	private ArrayList<Card> hand;
	private int playerNum;
	
	public Player(int playerNum){
		this.playerNum = playerNum;
		createGui();
	}
	
	public void createGui(){
		this.setTitle("Player" + playerNum);
		this.setResizable(true);
		
		CardButton button1 = new CardButton(new Card(1, Color.GREEN));
		JButton button2 = new JButton(new Card(1, Color.BLUE).returnCardRep());
		button2.setBackground(new Card(1, Color.BLUE).returnCardColor());
		
		GridBagLayout gridBag = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		GridBagConstraints b1 = new GridBagConstraints();
		b1.gridx = 0;
		b1.gridy = 0;
		GridBagConstraints b2 = new GridBagConstraints();
		b2.gridx = 1;
		b2.gridy = 0;
		
		contentPane.add(button1, b1);
		contentPane.add(button2, b2);
		
		this.repaint();
	}

	public static void main(String[] args) {
		Player frame = new Player(1);
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}
