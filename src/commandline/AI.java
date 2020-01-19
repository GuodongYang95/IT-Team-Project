package commandline;

import java.util.Map;



public class AI extends Player{

	public AI(String name) {
		super(name);
	}
	
	
	public String selectCategory(){
		Card handCard = this.getHand();
			return handCard.findBiggestCategory();
			
	}
	
}
