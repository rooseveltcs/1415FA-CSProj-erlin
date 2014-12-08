import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;


public class CardFrame extends JFrame{
	static final long serialVersionUID = 0;
	private Container contentPane;
	private Card card;
	private ArrayList<Card> cards = new ArrayList<Card>(0);
	private Card green = new Card(-1, Color.GREEN);
	private Card yellow = new Card(-1, Color.YELLOW);
	private Card blue = new Card(-1, Color.BLUE);
	private Card red = new Card(-1, Color.RED);
	private boolean open = true;
	
	public CardFrame(Card temp){
		setColors();
		this.card = temp;
		createGui();
	}
	
	public void createGui(){
		this.setTitle("Color");
		this.setResizable(true);
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		update();
		pack();
		contentPane.paintAll(getGraphics());
	}
	
	public void update(){
		for(int x=0; x<4; x++){
			final String rep = cards.get(x).returnColorRep();
			final Color color = cards.get(x).returnCardColor();
			final int temp = cards.get(x).returnColorInt();
			CardButton button = new CardButton(cards.get(x));
			button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				card.setCardColor(color);
				card.setColorRep(rep);
				card.setColorInt(temp);
				close();
			}});
			GridBagConstraints b = new GridBagConstraints();
			contentPane.add(button, b);
			pack();
		}
	}
	
	public void setColors(){
		green.setCardRep("G");
		yellow.setCardRep("Y");
		blue.setCardRep("B");
		red.setCardRep("R");
		cards.add(green);
		cards.add(yellow);
		cards.add(blue);
		cards.add(red);
	}
	
	public Card returnCard(){
		return card;
	}
	
	public boolean returnOpen(){
		return open;
	}
	
	public void close(){
		setVisible(false);
	}
}
