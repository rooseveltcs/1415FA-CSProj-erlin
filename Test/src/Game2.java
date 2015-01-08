import java.awt.Color;
import java.util.ArrayList;




public class Game2 extends Game{
	static final long serialVersionUID = 0;
	protected int humans;
	protected int turnPos;
	protected int playingPlayers;
	protected boolean firstCard = true;
	
	public Game2(int players, int humans, int deckNum){
		this.humans = humans;
		playingPlayers = players;
		this.players = players;
		this.deck = new Deck(deckNum);
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
					if(deck.returnSkip() != 0){
						skipPlayed(turnPos);
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
						checkUno(turnPos);
						checkWin(turnPos);
					}
					//force ends when only one player left
					if(playingPlayers <= 1){
						uiList.get(turnPos).player.hand.clear();
						checkWin(turnPos);
					}
				}
					if(turnPos>=players-1){
						turnPos=-1;
					}
				firstCard = false;	
			}
		}
	
	//checks if a player has no cards
	public void checkWin(int x){
		if(uiList.get(x).player.hand.size() == 0 && uiList.get(x).returnPlace() == 0){
			place++;
			//added >>>>>'s and <<<<<'s for better visibility
			Main.returnGame().addText(">>>>>" + uiList.get(x).getTitle() + " finished " + place + "<<<<<\n");
			uiList.get(x).setPlace(place);
			uiList.get(x).setTitle(uiList.get(x).getTitle()+"(" + place + ")");
			uiList.get(x).setEnabled(false);
			playingPlayers--;
		}
	}
	
	//check if player has only 1 card left
	public void checkUno(int x){
		if(uiList.get(x).player.hand.size() == 1){
			Main.returnGame().addText(">>>" + uiList.get(x).getTitle() + " has one card left<<<\n");
		}
	}
	
	public void normalCardPlayed(int x) {
		if(uiList.get(x).returnType() == 1){
			uiList.get(x).setTurn(true);
			while(uiList.get(x).returnTurn()){
			}
		}
		else{
			//makes AI to wait a while before playing
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
			deck.addSkip(-1);
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
