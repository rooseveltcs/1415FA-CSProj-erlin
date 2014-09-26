import java.util.ArrayList;


public class AI {
	private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(0);
	private ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>(0);
	private int total;
	private int num;
	
	public AI(int total, int num){
		for(int x=1; x<=total; x++){
			ArrayList<Integer> nums = new ArrayList<Integer>(0);
			for(int y=1; y<=num; y++){
				nums.add(y);
			}
			this.list.add(nums);
		}
		this.total = total;
		this.num = num;
	}
	
	public int chooseNum(int remain){
		int chosen = list.get(remain-1).get((int)(Math.random()*list.get(remain-1).size()));
		return chosen;
	}
	
	public void printArray(){
		System.out.println(list);
	}
	
	public void updateTemp(int remain, int tempNum){
		
	}
	
	public void improve(){
		
	}
}
