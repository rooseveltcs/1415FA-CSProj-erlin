
public class LimitedUI extends UI{
	static final long serialVersionUID = 1;
	private Player player;
	private Deck deck;
	
	public LimitedUI(Player player, Deck deck){
		super(player, deck);
		this.player = super.returnPlayer();
		this.player = super.returnPlayer();
	}
	
	public void createGui(){
		
	}
	
	public static void main(String[] args){
		LimitedUI a = new LimitedUI(new Player(1), new Deck(1));
		System.out.println(a.returnPlayer().returnPlayerNum());
	}
}
