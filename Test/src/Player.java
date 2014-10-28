import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Player extends JFrame{
	static final long serialVersionUID = 0;
	private ArrayList<Card> hand;
	private int playerNum;
	public static Deck deck;
	private static Player frame;
	private Container contentPane;
	
	
	public Player(int playerNum){
		this.playerNum = playerNum;
		hand = new ArrayList<Card>(0);
		createGui();
	}
	
	public void createGui(){
		this.setTitle("Player" + playerNum);
		this.setResizable(true);
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		/*
		CardButton button1 = new CardButton(new Card(1, Color.GREEN));
		JButton button2 = new JButton(new Card(1, Color.BLUE).returnCardRep());
		button2.setBackground(new Card(1, Color.BLUE).returnCardColor());
		
		GridBagConstraints b1 = new GridBagConstraints();
		b1.gridx = 0;
		b1.gridy = 0;
		GridBagConstraints b2 = new GridBagConstraints();
		b2.gridx = 1;
		b2.gridy = 0;
		
		contentPane.add(button1, b1);
		contentPane.add(button2, b2);
		*/
		
	}

	public void update(){
		contentPane.removeAll();
		for(int x=0; x<hand.size(); x++){
			final CardButton button = new CardButton(hand.get(x));
			final Card temp = button.returnCard();
			final int tempNum = x;
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
	            	Deck.receiveCard(temp);
	            	hand.remove(tempNum);
	            	System.out.println(hand.size());
	            	System.out.println(temp.returnCardNum());
	            	contentPane.repaint();
	            	update();
	            }});
			GridBagConstraints b = new GridBagConstraints();
			b.gridx = x;
			b.gridy = 0;
			contentPane.add(button, b);
		}
		contentPane.paintAll(getGraphics());
	}
	
	public void draw(int num){
		for(int x=0; x<num; x++){
			Card temp = Deck.giveCard();
			hand.add(temp);
		}
	}
	
	public static void main(String[] args) {
		deck = new Deck(1);
		frame = new Player(1);
		frame.draw(7);
		frame.update();
		
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}
