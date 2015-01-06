import java.awt.Color;
import java.util.ArrayList;




public class Game2 extends Game{
	static final long serialVersionUID = 0;
	protected int humans;
	protected int turnPos;
	protected boolean firstCard = true;
	
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
			for(turnPos=0; turnPos<players; turnPos++){
				if(uiList.get(turnPos).returnPlace() == 0){
//					if(deck.returnLastCard().returnCardRep().equals("S") && deck.returnLastCard().returnUsed() == false){
//						skipPlayed(turnPos);
//					}
					if(deck.returnSkip() != 0){
						skipPlayed(turnPos);
						deck.addSkip(-1);
					}
					else if(deck.returnLastCard().returnCardRep().equals("R") && deck.returnLastCard().returnUsed() == false){
						if(firstCard){
							reversePlayed(turnPos+2);
						}
						else{
							reversePlayed(turnPos);
						}
					}
					else{
						normalCardPlayed(turnPos);
						checkWin(turnPos);
					}
				}
					if(turnPos>=players-1){
						turnPos=-1;
					}
				firstCard = false;	
			}
		}
	
	//maybe: check player if one card left
	
	
	//checks if a player has no cards
	public void checkWin(int x){
		if(uiList.get(x).player.hand.size() == 0 && uiList.get(x).returnPlace() == 0){
			place++;
			//added >>>>>'s and <<<<<'s for better visibility
			Main.returnGame().addText(">>>>>" + uiList.get(x).getTitle() + " finished " + place + "<<<<<\n");
			uiList.get(x).setPlace(place);
			uiList.get(x).setTitle(uiList.get(x).getTitle()+"(" + place + ")");
			uiList.get(x).setEnabled(false);
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
		for(int a=0; a<deck.returnSkip(); a++){
//			while(uiList.get(x).returnPlace() != 0){
//				x++;
//				if(x>=players-1){
//					x=-1;
//				}
			}
			if(uiList.get(x).returnType() == 1){
				Main.returnGame().addText("Player" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
			}
			else{
				Main.returnGame().addText("AI" + uiList.get(x).returnPlayer().playerNum + " skipped\n");
			}
			deck.returnLastCard().setUsed(true);
//			deck.addSkip(-1);
//			x++;
//		}
	}
	
	public void reversePlayed(int x){
		if(x-1<0){
			x = uiList.size()-1;
		}
		else{
			x = x-1;
		}
		UI tempUI = uiList.get(x);
		ArrayList<UI> tempList = new ArrayList<UI>(0);
		for(int k=(uiList.size()-1); k>=0; k--){
			tempList.add(uiList.get(k));
		}
		uiList.clear();
		uiList = tempList;
		int tempPos = uiList.indexOf(tempUI);
		turnPos = tempPos;
		deck.returnLastCard().setUsed(true);
	}
	
}
