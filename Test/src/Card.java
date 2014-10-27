import java.awt.Color;


public class Card {
	private int cardNum;
	private String cardRep;
	private Color cardColor;
	private String colorRep;
	
	//sets a cards properties
	public Card(int num, Color color){
		cardNum = num;
		cardColor = color;
		if(cardNum>9){
			if(cardNum==10){
				cardRep = "R";
			}
			if(cardNum==11){
				cardRep = "S";
			}
			if(cardNum==12){
				cardRep = "+2";
			}
			if(cardNum==13){
				cardRep = "W";
			}
			if(cardNum==14){
				cardRep = "+4";
			}
		}
		else{
			cardRep = Integer.toString(cardNum);
		}
		if(cardColor.equals(Color.GREEN)){
			colorRep = "GREEN";
		}
		if(cardColor.equals(Color.YELLOW)){
			colorRep = "YELLOW";
		}
		if(cardColor.equals(Color.BLUE)){
			colorRep = "BLUE";
		}
		if(cardColor.equals(Color.RED)){
			colorRep = "RED";
		}
		if(cardColor.equals(Color.BLACK)){
			colorRep = "BLACK";
		}
	}
	
	public int returnCardNum() {
		return cardNum;
	}

	//should not be used
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String returnCardRep() {
		return cardRep;
	}

	//should not be used
	public void setCardRep(String cardRep) {
		this.cardRep = cardRep;
	}

	public Color returnCardColor() {
		return cardColor;
	}

	//should not be used
	public void setCardColor(Color cardColor) {
		this.cardColor = cardColor;
	}

	public String returnColorRep() {
		return colorRep;
	}

	//should not be used
	public void setColorRep(String colorRep) {
		this.colorRep = colorRep;
	}

	//for testing card properties
	public String toString(){
		return cardRep + "-" + colorRep;
	}
}
