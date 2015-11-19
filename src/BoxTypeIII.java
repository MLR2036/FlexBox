
public class BoxTypeIII extends Box {

	public BoxTypeIII(double w, double l, double h) {
		super(w, l, h);
		
	}
//Start of calculateCost
	@Override
	public double calculateCost(int cardGrade, int numOfColours,
			boolean rfBottom, boolean rfCorners, boolean slbTop) {
		double cost = 0;
		//work out cost of material based on Card grade
		switch(cardGrade){
		case 2: cost = 0.59 * getArea();
			break;
		case 3: cost = 0.68 * getArea();
			break;
		case 4: cost = 0.92 * getArea();
			break;
		case 5: cost = 1.30 * getArea();
		}
		
		if(slbTop){
			double addTop = cost * 0.20;//get the cost of extras plus a top for this type of box
			cost =  (cost + addTop);//add extras plus top cost to cost 
			return cost;
		}
		else{			
			
			double extras = cost * 0.15;//get the cost of extras without a top for this type of box
			cost = (cost + extras);//add the cost of the extras to the cost
			return cost;
		}
	}
//End of calculateCost
}
