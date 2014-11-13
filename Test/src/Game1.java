
public class Game1 extends Game{
	static final long serialVersionUID = 1;
	
	public Game1(int players, int deckNum) {
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
}
