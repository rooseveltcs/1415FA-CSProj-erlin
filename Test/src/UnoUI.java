import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class UnoUI extends JFrame{
	static final long serialVersionUID = 0;
	private Container contentPane;
	private UnoAI AI;
	private Deck deck;
	
	public UnoUI(UnoAI AI){
		this.AI = AI;
		this.deck = AI.returnDeck();
		for(int x=0; x<7; x++){
			this.AI.receiveCard(deck.giveCard());
		
		}
		createGui();
	}
	
	public void createGui() throws HeadlessException{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("AI" + AI.returnPlayerNum());
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
		AI.sortHand();
		int gridHeight = 0;
		int remain = AI.returnHand().size();
		contentPane.removeAll();
		for(int y=0; y<AI.returnHand().size()/15 + 1; y++){
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
		final CardButton button = new CardButton(AI.returnHand().get(15*y+x));
		final Card temp = button.returnCard();
		final int tempNum = x;
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = x;
		b.gridy = y;
		contentPane.add(button, b);
	}
}
