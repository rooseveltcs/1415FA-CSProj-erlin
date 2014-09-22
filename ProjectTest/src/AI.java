import java.util.ArrayList;


public class AI {
	private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(0);
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
		int chosen = list.get(remain).get((int)(Math.random()*num));
		return chosen;
	}
	
	
	
	public int returnTotal(){
		return this.total;
	}
	
	public int returnNum(){
		return this.num;
	}
}
