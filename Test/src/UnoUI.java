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
		//work on wild cards color change

		if(deck.returnDraw() > 0){
			Card chosen = chooseDrawCard();
			if(chosen != null){
				if(chosen.returnCardNum() == 12 ){
					deck.addDraw(2);
				}
				if(chosen.returnCardNum() == 14){
					deck.addDraw(4);
				}
				deck.receiveCard(player.giveCard(chosen));
				Main.returnGame().addText("AI" + player.playerNum + " played " + chosen + "\n");
			}
			else{
				int temp = deck.returnDraw();
				for(int x=0; x<temp; x++){
					drawCard();
					deck.addDraw(-1);
				}
				Main.returnGame().addText("AI" + player.playerNum + " drew " + temp + " cards\n");
			}
			Main.returnGame().updateUIs();
		}
		else{
			Card chosen = chooseCard();
			if(chosen!=null){
				if(chosen.returnCardNum() == 12 ){
					deck.addDraw(2);
				}
				if(chosen.returnCardNum() == 14){
					deck.addDraw(4);
				}
				if(chosen.returnCardRep().equals("R")){
					Main.returnGame().setOrder(!Main.returnGame().returnOrder());
				}
				if(chosen.returnCardRep().equals("S")){
					deck.addSkip(1);
				}
				deck.receiveCard(player.giveCard(chosen));
				Main.returnGame().addText("AI" + player.playerNum + " played " + chosen + "\n");
			}
			else{
				drawCard();
				Main.returnGame().addText("AI" + player.playerNum +" drew a card\n");
			}
			Main.returnGame().updateUIs();
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
				changeColor(player.hand.get(x));
				return player.hand.get(x);
			}
		}
		return null;
	}
	
	public Card chooseDrawCard(){
		for(int x=0; x<player.hand.size(); x++){
			if((player.hand.get(x).returnCardNum() == 12 && deck.returnLastCard().returnCardColor().equals(player.hand.get(x).returnCardColor())) || deck.returnLastCard().returnCardNum() == (player.hand.get(x).returnCardNum()) || player.hand.get(x).returnCardNum() == 14){
				if(player.hand.get(x).returnCardColor().equals(Color.BLACK)){
					changeColor(player.hand.get(x));
					return player.hand.get(x);
				}
			}
		}
		return null;
	}
	
	public int[] countColorCards(){
		int[] colorCards = new int[4];
		for(int x=0; x<player.hand.size(); x++){
			if(player.hand.get(x).returnCardColor().equals(Color.GREEN)){
				colorCards[0]++;
			}
			if(player.hand.get(x).returnCardColor().equals(Color.YELLOW)){
				colorCards[1]++;
			}
			if(player.hand.get(x).returnCardColor().equals(Color.BLUE)){
				colorCards[2]++;
			}
			if(player.hand.get(x).returnCardColor().equals(Color.RED)){
				colorCards[3]++;
			}
		}
		return colorCards;
	}
	
	public Color chooseColor(int[] colorCards){
		int temp = 0;
		for(int x=1; x<4; x++){
			if(colorCards[temp] < colorCards[x]){
				temp = x;
			}
		}
		if(temp == 0){
			return Color.GREEN;
		}
		else if(temp == 1){
			return Color.YELLOW;
		}
		else if(temp == 2){
			return Color.BLUE;
		}
		else if(temp == 3){
			return Color.RED;
		}
		return null;
	}
	
	public void changeColor(Card card){
		Color tempColor = chooseColor(countColorCards());
		card.setCardColor(tempColor);
		if(tempColor.equals(Color.GREEN)){
			card.setColorRep("GREEN");
			card.setColorInt(1);
		}
		if(tempColor.equals(Color.YELLOW)){
			card.setColorRep("YELLOW");
			card.setColorInt(2);
		}
		if(tempColor.equals(Color.BLUE)){
			card.setColorRep("BLUE");
			card.setColorInt(3);
		}
		if(tempColor.equals(Color.RED)){
			card.setColorRep("RED");
			card.setColorInt(4);
		}
		
	}
}
