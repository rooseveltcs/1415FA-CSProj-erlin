import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Game extends JFrame{
	static final long serialVersionUID = 0;
	private Container contentPane;
	private int players;
	private Deck deck;
	private ArrayList<LimitedUI> uiList = new ArrayList<LimitedUI>(0);
	
	private JTextArea jtArea;
	private JTextField jtField;
	
	public Game(int players, int deckNum){
		this.players = players;
		this.deck = new Deck(deckNum);
		for(int x=1; x<=players; x++){
			uiList.add(new LimitedUI(new Player(x), deck));
		}
		Card firstCard = deck.giveCard();
		deck.receiveCard(firstCard);
		createGui();
		addText("First card: " + firstCard + "\n");
	}
	
	public void createGui(){
		this.setTitle("Game");
		this.setResizable(true);
		this.setVisible(true);
		
		jtField = new JTextField();
		jtField.setText("Players");
		jtField.setEditable(false);
		
		jtArea = new JTextArea();
		jtArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		GridBagLayout gridBag = new GridBagLayout();
		contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridx = 0;
		gridCons1.gridy = 0;
		gridCons1.weightx = 1.0;
		gridCons1.weighty = 1.0;
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.gridx = 0;
		gridCons2.gridy = 1;
		gridCons2.gridwidth = 31;
		gridCons2.gridwidth = GridBagConstraints.REMAINDER;
		gridCons2.fill = GridBagConstraints.HORIZONTAL;
		
		for(int x=0; x<players; x++){
			final int temp = x;
			JButton button = new JButton("Player" + (x+1));
			button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e){
	            	if(uiList.get(temp).isVisible()){
	            		uiList.get(temp).setVisible(false);
	            	}
	            	else{
	            		uiList.get(temp).pack();
	            		uiList.get(temp).setVisible(true);
	            		}
	            	}
			});
			GridBagConstraints b = new GridBagConstraints();
			b.gridx = x;
			b.gridy = 2;
			contentPane.add(button, b);
		}
		
		contentPane.add(scrollPane, gridCons1);
		contentPane.add(jtField, gridCons2);
	}
	
	public void addText(String str){
		jtArea.append(str);
		jtArea.setCaretPosition(jtArea.getDocument().getLength());
	}
	
	public Deck returnDeck(){
		return deck;
	}
	
	public ArrayList<LimitedUI> returnList(){
		return uiList;
	}
}
