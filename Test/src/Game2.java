
public class Game2 extends Game{
	protected int AIs;

	public Game2(int players, int AIs, int deckNum){
		this.AIs = AIs;
		this.players = players;
		this.deck = new Deck(deckNum);
		deck.displayDeck();
		for(int x=1; x<=players; x++){
			uiList.add(new LimitedUI(new Player(x), deck));
		}
		Card firstCard = deck.giveCard();
		deck.receiveCard(firstCard);
		createGui();
		addText("First card: " + firstCard + "\n");
	}
	
	
}
