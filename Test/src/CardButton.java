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
		super.setPreferredSize(new Dimension(30, 40));
		this.card = card;
	}
	
	public Card returnCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
