

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
			uiList.add(temp, new UnoUI(new Player(x+1), deck));
		}
		Card firstCard = deck.giveCard();
		deck.receiveCard(firstCard);
		createGui();
		addText("First card: " + firstCard + "\n");
	}
	
	public void gameStart(){
		for(int x=0; x<players; x++){
			if(deck.returnLastCard().returnCardRep().equals("S")){
				if(uiList.get(x).returnType() == 1){
					Main.returnGame().addText("Player" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
				}
				else{
					Main.returnGame().addText("AI" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
				}	
				x++;
			}
			else{
				if(uiList.get(x).returnType() == 1){
					uiList.get(x).setTurn(true);
					while(uiList.get(x).returnTurn()){
					}
				}
				else{
					uiList.get(x).act();
				}	
			}
			if(x==players-1){
				x=-1;
			}
		}
	}
}
