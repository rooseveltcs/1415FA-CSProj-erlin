import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

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
		
		update();
	}
	
	public void update(){
		
	}
}
