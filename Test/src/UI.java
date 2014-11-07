import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class UI extends JFrame{
	static final long serialVersionUID = 0;
	private Container contentPane;
	private Player player;
	private Deck deck;
	private Deck tempDeck;
	//private boolean endTurnButton;
	
	//creates UI of a player, with # of decks
	public UI(Player player, Deck deck){
		this.player = player;
		this.deck = deck;
		this.tempDeck = new Deck(deck.returnNumDeck());
		for(int x=0; x<7; x++){
			this.player.receiveCard(deck.giveCard());
		}
		//this.endTurnButton = endTurnButton;
		createGui();
	}
	
	//sets frame's info
	public void createGui() throws HeadlessException{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Player" + player.returnPlayerNum());
		this.setResizable(true);
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		update();
	}
	
	//updates frame
	//adds buttons...etc
	public void update(){
		player.sortHand();
		int gridHeight = 0;
		int remain = player.returnHand().size();
		contentPane.removeAll();
		for(int y=0; y<player.returnHand().size()/15 + 1; y++){
			if(remain<15){
				for(int x=0; x<remain; x++){
					//could probably be shortened and be more easier to read, but might take too much time
					//below code also the same
					final CardButton button = new CardButton(player.returnHand().get(15*y+x));
					final Card temp = button.returnCard();
					final int tempNum = x;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							deck.receiveCard(temp);
							tempDeck.receiveCard(temp);
							player.returnHand().remove(tempNum);
							Main.returnGame().addText("Player" + player.returnPlayerNum() + " played " + temp + ".\n");							System.out.println("hand: " + player.returnHand().size());
							System.out.println("played: " + temp.returnCardNum());
							System.out.println("remaining: " + deck.returnRandomized().size());
							System.out.println("playedDeck: " + deck.returnDeck().size());
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
					final CardButton button = new CardButton(player.returnHand().get(15*y+x));
					final Card temp = button.returnCard();
					final int tempNum = x;
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							deck.receiveCard(temp);
							tempDeck.receiveCard(temp);
							player.returnHand().remove(tempNum);
							Main.returnGame().addText("Player" + player.returnPlayerNum() + " played " + temp + ".\n");
							System.out.println("hand: " + player.returnHand().size());
							System.out.println("played: " + temp.returnCardNum());
							System.out.println("remaining: " + deck.returnRandomized().size());
							System.out.println("playedDeck: " + deck.returnDeck().size());
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
				player.receiveCard(deck.giveCard());
				Main.returnGame().addText("Player" + player.returnPlayerNum() + " drew a card.\n");
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
				if(tempDeck.returnDeck().size() != 0){
					Card tempCard = deck.returnPlayedCard();
					player.receiveCard(tempCard);
					tempDeck.returnDeck().remove(tempDeck.returnDeck().size()-1);
					Main.returnGame().addText("Player" + player.returnPlayerNum() + " took back " + tempCard + ".\n");
					contentPane.repaint();
					pack();
					update();
				}
            }});
		GridBagConstraints bU = new GridBagConstraints();
		bU.gridy = gridHeight + 1;
		bU.gridwidth = 3;
		contentPane.add(buttonU, bU);
		//sets EndTurn Button
		/*
		JButton buttonE = new JButton("EndTurn");
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				endTurn();
				contentPane.repaint();
				pack();
				update();
            }});
		GridBagConstraints bE = new GridBagConstraints();
		bE.gridy = gridHeight + 1;
		bE.gridwidth = 3;
		contentPane.add(buttonE, bE);
		buttonE.setEnabled(endTurnButton);
		*/
		
		pack();
		contentPane.paintAll(getGraphics());
	}
	
	/*
	public void endTurn(){
		
		System.exit(0);
	}
	*/
	
	//testing
	public static void main(String[] args) {
		Player player = new Player(1);
		Deck deck = new Deck(1);
		UI frame = new UI(player, deck);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
		frame.setVisible(true);
	}
	
	public Player returnPlayer(){
		return player;
	}
	
	public Deck returnDeck(){
		return deck;
	}
	
	public Deck returnTempDeck(){
		return tempDeck;
	}
}
