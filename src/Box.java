import java.text.DecimalFormat;


public abstract class Box {
	
	//used to set the dimensions for the boxes 
	private double width;
    private double length;
    private double height;
   
    public Box (double w, double l, double h)
    {
        width = w;
        length = l;
        height = h;
    }
	
    public double getWidth(){
        return width;
    }
    
    public double getLength(){
        return length;
    }
    
    public double getHeight(){
        
        return height;
    } 
  //used to calculate surface area of top side 
    public double top(){    	 
    	return getLength() * getWidth();
    }
    
  //returns the surface for all 6 sides
    public double getArea(){
  		double lengthSides = (getLength() * getHeight()) * 2;
  		double widthSides = (getWidth() * getHeight()) * 2;
  		double topBottom = (getLength() * getWidth());
  		double area = lengthSides + widthSides + topBottom;   		 
  		return area;  		  
  	  }
    
        //Signature for taking arguments used to calculate cost based on the properties of box
  public abstract double calculateCost(int cardGrade, int numOfColours, boolean rfBottom, boolean rfCorners, boolean slbTop);
  
}
