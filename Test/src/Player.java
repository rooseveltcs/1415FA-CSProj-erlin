import java.awt.Container;
import java.awt.Dimension;
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
		
		draw(7);
		update();
		
		
		
		//JButton button
	}

	public void update(){
		int gridHeight = 0;
		int remain = hand.size();
		contentPane.removeAll();
		for(int y=0; y<hand.size()/15 + 1; y++){
			if(remain<15){
				for(int x=0; x<remain; x++){
					final CardButton button = new CardButton(hand.get(15*y+x));
					final Card temp = button.returnCard();
					final int tempNum = x;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							Deck.receiveCard(temp);
							hand.remove(tempNum);
							System.out.println(hand.size());
							System.out.println(temp.returnCardNum());
							pack();
							contentPane.repaint();
		            		update();
						}});
					GridBagConstraints b = new GridBagConstraints();
					b.gridx = x;
					b.gridy = y;
					contentPane.add(button, b);
				}
			}
			else{
				for(int x=0; x<15; x++){
					final CardButton button = new CardButton(hand.get(15*y+x));
					final Card temp = button.returnCard();
					final int tempNum = x;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							Deck.receiveCard(temp);
							hand.remove(tempNum);
							System.out.println(hand.size());
							System.out.println(temp.returnCardNum());
							pack();
							contentPane.repaint();
								update();
						}});
					GridBagConstraints b = new GridBagConstraints();
					b.gridx = x;
					b.gridy = y;
					contentPane.add(button, b);
			}
			remain -= 15;
			gridHeight++;
			}
		}
		//sets Draw Button
		JButton buttonD = new JButton("Draw");
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				draw(1);
				contentPane.repaint();
				pack();
				update();
            }});
		GridBagConstraints bD = new GridBagConstraints();
		bD.gridy = gridHeight + 1;
		bD.gridwidth = 3;
		contentPane.add(buttonD, bD);
		//sets Undo Button
		JButton buttonU = new JButton("Undo");
		buttonU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(Deck.returndeck().size() != 0){
					hand.add(Deck.returndeck().get(Deck.returndeck().size()-1));
					Deck.returndeck().remove(Deck.returndeck().size()-1);
					contentPane.repaint();
					pack();
					update();
				}
            }});
		GridBagConstraints bU = new GridBagConstraints();
		bU.gridy = gridHeight + 1;
		bU.gridwidth = 3;
		contentPane.add(buttonU, bU);
		
		pack();
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
		
		
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
}
