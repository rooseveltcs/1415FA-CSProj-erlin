import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class CardButton extends JButton{
	private Card card;
	
	public CardButton(Card card){
		super(card.returnCardRep());
		//super.setBackground(card.returnCardColor());
		super.setBorder(new LineBorder(card.returnCardColor()));
		super.setPreferredSize(new Dimension(100, 30));
		this.card = card;
	}
	
    public void actionPerformed(ActionEvent e){
    	
    }
}
