
public class Game2 {
	private int total;
	private int num = 5;
	private int player = 2;
	
	public Game2(){
	}
	
	public void gameStart(){
		System.out.println("Initial stick amount:(10-100)");
		String str = Main.console.next();
		numError(str, 10, 100);
		while(total>0 && Main.repeat==true){
			if(player==2){
				System.out.println("Player1: How many do you choose?(1-5)");
				System.out.println("Remaining:" + total);
				String str1 = Main.console.next();
				inputError(str1,1,5);
				player--;
			}
			else{
				//resume
				player++;
			}
		}
		if(Main.repeat==true){
		System.out.println("Player" + player + " loses");
		}
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				numError(Main.console.next(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			System.out.println("error: input not an int");
			numError(Main.console.next(),min,max);
		}
		else{
			Main.repeat = false;
		}
	}
	
	public void inputError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total -= num;
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				inputError(Main.console.next(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			System.out.println("error: input not an int");
			inputError(Main.console.next(),min,max);
			
		}
		else{
			Main.repeat = false;
		}
	}
}
