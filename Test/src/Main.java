import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
	static Game game;
	
	public static void main(String[] args){
		startGame();
	}
	
	public static void startGame(){
		game = new Game2(4, 1, 1);
		game.pack();
		game.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		game.setVisible(true);
		
		//game.returnDeck().displayDeck();
		//game.returnDeck().displayRandomized();
		
		game.gameStart();
	}

	public static Game returnGame(){
		return game;
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