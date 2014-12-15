


public class Game2 extends Game{
	static final long serialVersionUID = 0;
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
			if(uiList.get(x).player.hand.size() != 0){
				if(deck.returnLastCard().returnCardRep().equals("S") && deck.returnLastCard().returnUsed() == false){
					skipPlayed(x);
				}
				else{
					normalCardPlayed(x);
				}
				
			}
			else{
				uiList.get(x).setEnabled(false);
				Main.returnGame().addText("ended");
			}
			if(x>=players-1){
				x=-1;
			}
		}
	}

	public void normalCardPlayed(int x) {
		if(uiList.get(x).returnType() == 1){
			uiList.get(x).setTurn(true);
			while(uiList.get(x).returnTurn()){
			}
		}
		else{
			try{
			Thread.sleep(500 + (int)(Math.random()*2000));
			}
			catch(InterruptedException e){
				System.out.println("exception");
			}
			uiList.get(x).act();
		}
	}
	
	public void skipPlayed(int x){
		if(uiList.get(x).returnType() == 1){
			Main.returnGame().addText("Player" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
		}
		else{
			Main.returnGame().addText("AI" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
		}
		deck.returnLastCard().setUsed(true);
	}
	
	public void reversePlayed(int x){
		
	}
	
}
