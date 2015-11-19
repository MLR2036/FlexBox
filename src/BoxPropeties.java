import java.text.DecimalFormat;


public class BoxPropeties {	
	private double width;
	private double height;
	private double length;	
	private int cardGrade;
	private int colour;
	private boolean rfBottom;
	private boolean rfCorners;
	private boolean slbTop;	
	DecimalFormat dFormat = new DecimalFormat("#.##");//used to round cost to two DP
		public BoxPropeties(){				
		}
		
		public void setWidth(double width){
			this.width = width;
		}
		public double getWidth(){
			return width;
		}
		
		public void setHeight(double hight){
			this.height = hight;
		}
		public double getHeight(){
			return height;
			
		}
		
		public void setLength(double length){
			this.length = length;
		}
		public double getlength(){
			return length;
			
		}
		
		public void setCardGrade(int cardGrade){
			this.cardGrade = cardGrade;		
		}	
		public int getCardGrade(){
			return cardGrade;
		}
		
		public void setColour(int colour){
			this.colour = colour;
		}
		public int getColour(){
			return colour;
		}
		
		public void setRfBottom(boolean rfBottom){
			this.rfBottom = rfBottom;
		}
		public boolean getRfBottom(){
			return rfBottom;
		}
		
		public void setRfCorners(boolean rfCorners){
			this.rfCorners = rfCorners;
		}
		public boolean getRfCorners(){
			return rfCorners;
		}
		
		public void setSlbTop(boolean slbTop){
			this.slbTop = slbTop;
		}
		public boolean getSlbTop(){
			return slbTop;
		}
		
		public double boxCost() throws BoxException{
			BoxException invalid = new BoxException("That Box can not be supplied");
			BoxException dimensions = new BoxException("Can not take 0 or a negative number\n"
													+"                     as a dimension");
			double cost = 0;
		//checks for 0 or a negative number 
			if(width<=0 || length <=0 || height <=0)
			{
				throw dimensions;
			}
			else
			{
		//Checks the properties of the box then constructs a Box type that matches then calls its claculatecost method  
			if(cardGrade >=1 && cardGrade <= 3 && colour == 0 && rfBottom == false && rfCorners == false)
		    {
				BoxTypeI box = new BoxTypeI(width, length, height);
		         cost = box.calculateCost(cardGrade, colour, rfBottom, rfCorners, slbTop);
		         
		    	}
				else if(cardGrade >= 2 && cardGrade <= 4 && colour == 1 && rfBottom == false && rfCorners == false)
				{
					BoxTypeII box = new BoxTypeII(width, length, height);
					cost = box.calculateCost(cardGrade, colour, rfBottom, rfCorners, slbTop);
					
					}
					else if(cardGrade >=2 && cardGrade <= 5  && colour == 2 && rfBottom == false && rfCorners == false)
					{
						BoxTypeIII box = new BoxTypeIII(width, length, height);
						cost = box.calculateCost(cardGrade, colour, rfBottom, rfCorners, slbTop);
						
						}
						else if(cardGrade >= 2 && cardGrade <= 5 && colour == 2 && rfBottom == true && rfCorners == false)
						{
							BoxTypeIV box = new BoxTypeIV(width, length, height);
							cost = box.calculateCost(cardGrade, colour, rfBottom, rfCorners, slbTop);
							
							}
							else if(cardGrade >= 3 && cardGrade <= 5 && colour == 2 && rfBottom == true && rfCorners == true)
							{
								BoxTypeV box = new BoxTypeV(width, length, height);
								cost = box.calculateCost(cardGrade, colour, rfBottom, rfCorners, slbTop);
								
								}
								else 
								{
									// throw the error message to the class that called it if none of the boxtypes meet the condition of the if statement  
								  throw invalid;
								}
			return cost;
			}
			
		}
		
		//returns a string comprised of box properties and the cost for a box with these properties
		public String toString()
		{
			//boxcost throws a BoxException so a try catch is needed here  
			try {
				return "Box Propeties: Width: " + getWidth() + " Lenght: " + getlength() + " Height: " + getHeight() + "\nGrade: " + getCardGrade() +
						" Number of colours: " + getColour() + " Rienforced bottom: " + getRfBottom() + " Rienforced corners: " + getRfCorners() + "\nSealable Top " + getSlbTop()+
						"\ncost: £"+ dFormat.format(boxCost());
			} catch (BoxException e) {
				//return an exception message if the box could not be made
				return ""+ e;
				
			}
					
		}

}
