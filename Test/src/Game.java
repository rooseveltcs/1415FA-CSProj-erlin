import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Game extends JFrame{
	static final long serialVersionUID = 0;
	private Container contentPane;
	private Deck deck;
	private ArrayList<UI> uiList = new ArrayList<UI>(0);
	
	public Game(int players, int deckNum){
		this.deck = new Deck(deckNum);
		for(int x=1; x<=players; x++){
			uiList.add(new UI(new Player(x), deck));
			pull(uiList.get(x-1).push());
		}
		createGui();
	}
	
	public void createGui(){
		this.setTitle("Game");
		this.setResizable(true);
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
	}
	
	//pushes deck
	public Deck push(){
		return deck;
	}
	
	//pulls deck
	public void pull(Deck deck){
		this.deck = deck;
	}
	
	public Deck returnDeck(){
		return deck;
	}
	
	public ArrayList<UI> returnList(){
		return uiList;
	}
}
