/**
 * 	author Eric Lin
 * 	Completed
 * 		Player vs trained AI
 */

//sets a trained AI
public class Game3 extends Game2{
	private final int TIMES = 100000;
	
	public void trainAI(AI bot1, AI bot2){
		Test2.addText("AI in training...\n");
		for(int x=0; x<TIMES; x++){
			while(total>0){
				if(player==2){
					player=1;
					int tempNum = bot1.chooseNum(total);
					bot1.updateTemp(total, tempNum);
					total = total - tempNum;
				}
				else{
					player=2;
					int tempNum = bot2.chooseNum(total);
					bot2.updateTemp(total, tempNum);
					total = total - tempNum;
				}
			}
			if(player==1){
					bot2.improve();
			}
			else{
				bot1.improve();
			}
			bot1.editTemp();
			bot2.editTemp();
			player = 2;
			total = initial;
		}
	}
}