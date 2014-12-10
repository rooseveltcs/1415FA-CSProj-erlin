import java.awt.Color;


public class Card implements Comparable<Card>{
	private int cardNum;
	private String cardRep;
	private Color cardColor;
	private String colorRep;
	private int colorInt;
	private boolean used;
	//private CardFrame cardFrame;
	
	//sets a cards properties
	public Card(int num, Color color){
		used = false;
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
			colorInt= 1;
		}
		if(cardColor.equals(Color.YELLOW)){
			colorRep = "YELLOW";
			colorInt= 2;
		}
		if(cardColor.equals(Color.BLUE)){
			colorRep = "BLUE";
			colorInt= 3;
		}
		if(cardColor.equals(Color.RED)){
			colorRep = "RED";
			colorInt= 4;
		}
		if(cardColor.equals(Color.BLACK)){
			colorRep = "BLACK";
			colorInt= 5;
			//cardFrame = new CardFrame(this);
		}
	}
	
	public int compareTo(Card comparedCard){
		if(this.colorInt - comparedCard.returnColorInt() != 0){
			return this.colorInt - comparedCard.colorInt;
		}
		else{
			return this.cardNum - comparedCard.cardNum;
		}
	}
	
	public boolean returnUsed(){
		return used;
	}
	
	public void setUsed(boolean b){
		used = b;
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

	public int returnColorInt() {
		return colorInt;
	}
	
	//should not be used
	public void setColorInt(int colorInt) {
		this.colorInt = colorInt;
	}
	
	//for testing card properties
	public String toString(){
		return cardRep + "-" + colorRep;
	}
	
	//public CardFrame returnCardFrame(){
	//	return cardFrame;
	//}
}
