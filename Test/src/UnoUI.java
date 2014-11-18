import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class UnoUI extends UI{
	static final long serialVersionUID = 0;
	protected Container contentPane;
	
	public UnoUI(Player player, Deck deck){
		type = 2;
		this.player = player;
		this.deck = deck;
		for(int x=0; x<7; x++){
			this.player.receiveCard(deck.giveCard());
		
		}
		createGui();
	}
	
	public void createGui() throws HeadlessException{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("AI" + player.returnPlayerNum());
		this.setResizable(true);
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		setup();
	}
	
	public void setup(){
		JButton button = new JButton("Show Hand");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				update();
			}
		});
		contentPane.add(button);
		pack();
		contentPane.paintAll(getGraphics());
	}
	
	public void update(){
		player.sortHand();
		int gridHeight = 0;
		int remain = player.returnHand().size();
		contentPane.removeAll();
		for(int y=0; y<player.returnHand().size()/15 + 1; y++){
			if(remain<15){
				for(int x=0; x<remain; x++){
					setButton(y, x);
				}
			}
			else{
				for(int x=0; x<15; x++){
					setButton(y, x);
			}
			remain -= 15;
			gridHeight++;
			}
		}
		JButton buttonH = new JButton("Hide Hand");
		buttonH.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contentPane.removeAll();
				setup();
			}
		});
		contentPane.add(buttonH);
		pack();
		contentPane.repaint();
	}
	
	public void setButton(int y, int x) {
		final CardButton button = new CardButton(player.returnHand().get(15*y+x));
		final Card temp = button.returnCard();
		final int tempNum = x;
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = x;
		b.gridy = y;
		contentPane.add(button, b);
	}
	
	public void act(){
		Card chosen = chooseCard();
		if(chosen!=null){
			deck.receiveCard(player.giveCard(chosen));
			Main.returnGame().addText("AI" + player.playerNum + " played " + chosen + "\n");
		}
		else{
			drawCard();
			Main.returnGame().addText("AI" + player.playerNum +" drew a card\n");
		}
	}
	
	public void drawCard(){
		player.receiveCard(deck.giveCard());
	}
	
	public Card chooseCard(){
		for(int x=0; x<player.hand.size(); x++){
			if(deck.returnLastCard().returnCardColor().equals(player.hand.get(x).returnCardColor()) || deck.returnLastCard().returnCardNum() == (player.hand.get(x).returnCardNum()) || deck.returnLastCard().returnCardColor().equals(Color.BLACK)){
				return player.hand.get(x);
			}
		}
		for(int x=0; x<player.hand.size(); x++){
			if(player.hand.get(x).returnCardColor().equals(Color.BLACK)){
				return player.hand.get(x);
			}
		}
		return null;
	}
}
