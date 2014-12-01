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
	protected Container contentPane;
	protected int players;
	protected Deck deck;
	protected ArrayList<UI> uiList = new ArrayList<UI>(0);
	
	protected JTextArea jtArea;
	protected JTextField jtField;
	
	public Game(){
		
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
			JButton button;
			if(uiList.get(x).getClass().equals(UnoUI.class)){
				button = new JButton("AI" + uiList.get(x).player.playerNum);
			}
			else{
				button = new JButton("Player" + uiList.get(x).player.playerNum);
			}
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
	
	public void gameStart(){
		
	}
	
	//Not really needed, but can be added
	//public void deleteLastLine(){
	//	jtArea
	//}
	
	public Deck returnDeck(){
		return deck;
	}
	
	public ArrayList<UI> returnList(){
		return uiList;
	}
}
