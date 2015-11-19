
public class BoxTypeI extends Box{

	public BoxTypeI(double w, double l, double h) {
		super(w, l, h); 
		
		
	}
//Start of calculateCost
	@Override
	public double calculateCost(int cardGrade, int numOfColours,
			boolean rfBottom, boolean rfCorners, boolean slbTop) {
		double cost = 0;
		//work out cost of material based on Card grade 
		switch(cardGrade){
		
		case 1:			
			cost = 0.45 * getArea();			
			break;
		case 2: cost = 0.59 * getArea();
			break;			
		case 3: cost = 0.68 * getArea();
			break;
		}				
		
		if(slbTop == true){		
			//add the cost of sealable top keeping the cost of material for the top.			 			
			double addTop =  cost * 0.05;
			cost = (cost + addTop);				
			return cost;
		}
		else{						
			//box with no top and no extras 			
			return cost;
		}
	}
//End of calculateCost

}
