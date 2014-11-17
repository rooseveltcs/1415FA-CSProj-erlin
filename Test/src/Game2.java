

public class Game2 extends Game{
	protected int humans;

	public Game2(int players, int humans, int deckNum){
		this.humans = humans;
		this.players = players;
		this.deck = new Deck(deckNum);
		deck.displayDeck();
		for(int x=1; x<=humans; x++){
			uiList.add(new LimitedUI(new Player(x), deck));
		}
		for(int x=0; x<(players-humans); x++){
			int temp = (int)(Math.random()*(uiList.size()));
			uiList.add(temp, new UnoUI(new UnoAI(temp+1, deck)));
		}
		Card firstCard = deck.giveCard();
		deck.receiveCard(firstCard);
		createGui();
		addText("First card: " + firstCard + "\n");
		gameStart();
	}
	
	public void gameStart(){
		//for(int x=0; x<1; x++){
		//	if(uiList.get(x).returnType() == 1){
				
		//	}
		//	else{
					//work on this
				uiList.get(0).returnAI().act();
		//	}
		//}
	}
}
