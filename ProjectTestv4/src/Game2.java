/**
 * 	author Eric Lin
 * 	Completed
 * 		Player vs AI
 */

//sets a new AI
public class Game2 extends Game{
	public void playerTwoMove(){
		player = 2;
		int tempNum = bot1.chooseNum(total);
		
		bot1.updateTemp(total, tempNum);
		Test2.addText("Remaining:" + total + "\n");
		Test2.addText("AI chooses " + tempNum + " sticks\n\n");
		total = total - tempNum;
	}
	
	public void playerLoss(){
		if(player==1){
			Test2.addText("Player" + player + " loses\n\n");
			bot1.improve();
		}
		else{
			Test2.addText("AI loses\n\n");
		}
		bot1.editTemp();
	}
}