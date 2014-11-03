
public class Main {
	
	public static void main(String[] args){
		startGame();
	}
	
	public static void startGame(){
		
		Deck deck = new Deck(1);
		Player player1 = new Player(1);
		for(int x=0; x<7; x++){
			player1.receiveCard(deck.giveCard());
		}
		player1.displayHand();
		player1.sortHand();
		player1.displayHand();
		
		/*
		Deck deck = new Deck(1);
		Player player1 = new Player(1);
		player1.init();
		//for(int x=0; x<107; x++){
		//	deck.giveCard();
		//}
		System.out.println(deck.returnRandomized().isEmpty());
		deck.displayCards();
		deck.displayRandomized();
		*/
	}
}

/*
 * 108 cards
 * 4-colors
 * (1-9) x2 each color
 * (0) x1 each color
 * (reverse, +2, skip) x2 each color
 * (wild, wild+4) x4
 * 
 * 7 cards to each player
 * moves possible:
 * 	play card, matching symbol/color
 * 	play wild/wild+4(only if no other same color cards)
 * 	draw card from deck if no playable cards, can play if drawn card playable
 * 
 * Rules:
 * 	skip:		skips next person, or first person
 *	draw2:		next player +2, or first person
 *	reverse:	switches order of play
 *	wild:		player chooses color, or first person
 *	wildDraw4:	declare color and next person +4, re-shuffle and put new card
 */	