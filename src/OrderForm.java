import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;


public class OrderForm extends JFrame {
 private BoxException invalid = new BoxException("invalid input"); 
 private BoxPropeties boxProps = new BoxPropeties();
 private DecimalFormat dFormat = new DecimalFormat("#.##");//will be used to round the outputs of costs to two dp
 private double totalCost = 0;
 private int index; 
 private OrderList orderList;
 private JPanel propertySelectors;
 private JPanel orderControlers;
 private JPanel dimensionsP;
 private JPanel gradeP;
 private JPanel colourP;
 private JPanel bottomP;
 private JPanel cornersP;
 private JPanel slbTopP;
 private JPanel addPlace;
 private JPanel listOrders;	
 private JComboBox<String> cardGrade;
 private String Grades[] = {"Grade","1", "2", "3", "4", "5"};
 private ButtonGroup colours;
 private JRadioButton colours0;
 private JRadioButton colours1;
 private JRadioButton colours2;
 private ButtonGroup rFBottom;
 private JCheckBox rFBottomYes;
 private JCheckBox rFBottomNo;
 private ButtonGroup rFCorners;
 private JCheckBox rFCornersYes;
 private JCheckBox rFCornersNo;
 private ButtonGroup top;
 private JCheckBox slbTopYes;
 private JCheckBox slbTopNo;
 private JButton addOrder;
 private JButton placeOrder;
 private JTextField width;
 private JTextField length;
 private JTextField height;
 private JTextField tCost;
 private JTextArea orders;
 private JScrollPane scrollOrders;
 private JLabel widthL = new JLabel("Width m");
 private JLabel lengthL = new JLabel("Length m");
 private JLabel heightL = new JLabel("Height m");
 private JLabel cGrade = new JLabel("Select Card Grade");
 private JLabel colour = new JLabel("Select Number of Colours");
 private JLabel bottom = new JLabel("Would You Like a Reinforced Bottom?");
 private JLabel corners = new JLabel("Would You Like Reinforced Corners?");
 private JLabel sealbTop = new JLabel("Would You Like a sealable Top?");
 private JLabel yourOrder = new JLabel("Your Order");
 private JLabel tCostL = new JLabel("Total Cost: £");
	
 public OrderForm(){
		super("FlexBox Order");		
		setLayout(new GridLayout());
		propertySelectors = new JPanel();		
		orderControlers = new JPanel();
		dimensionsP = new JPanel();
		gradeP = new JPanel();
		colourP = new JPanel();
		bottomP = new JPanel();
		cornersP = new JPanel();
		slbTopP = new JPanel();
		addPlace = new JPanel();
		listOrders = new JPanel(new BorderLayout());
		orderControlers.setLayout(new BorderLayout());
		width = new JTextField(5);
		length = new JTextField(5);
		height = new JTextField(5);
		tCost = new JTextField("0",5);
		tCost.setEditable(false);
		cardGrade = new JComboBox<String>(Grades);
		colours = new ButtonGroup();
		rFBottom = new ButtonGroup();
		rFCorners = new ButtonGroup();
		top = new ButtonGroup();
		colours0 = new JRadioButton("0");
		colours1 = new JRadioButton("1");
		colours2 = new JRadioButton("2");
		colours.add(colours0);
		colours.add(colours1);
		colours.add(colours2);
		rFBottomYes = new JCheckBox("Yes");
		rFBottomNo = new JCheckBox("No");
		rFCornersYes = new JCheckBox("Yes");
		rFCornersNo = new JCheckBox("No");
		slbTopYes = new JCheckBox("Yes");
		slbTopNo = new JCheckBox("No");
		rFBottom.add(rFBottomYes);
		rFBottom.add(rFBottomNo);
		rFCorners.add(rFCornersYes);
		rFCorners.add(rFCornersNo);
		top.add(slbTopYes);
		top.add(slbTopNo);
		addOrder = new JButton("Add to Orders");
		placeOrder = new JButton("Place Order");
		orders = new JTextArea();
		orders.setEditable(false);		
		scrollOrders = new JScrollPane(orders);
		orderList = new OrderList();
		
		
		SetNumOfColours setColours = new SetNumOfColours(); 
		ReinforcedBottom reinforcedBottom = new ReinforcedBottom();
		ReinforcedCorners reinforcedCorners = new ReinforcedCorners();
		SlbTop slbTop = new SlbTop();
//Add event handlers for property selectors		
		cardGrade.addActionListener(new SetCardGrade());
		colours0.addActionListener(setColours);
		colours1.addActionListener(setColours);
		colours2.addActionListener(setColours);
		rFBottomYes.addActionListener(reinforcedBottom);
		rFBottomNo.addActionListener(reinforcedBottom);
		rFCornersYes.addActionListener(reinforcedCorners);
		rFCornersNo.addActionListener(reinforcedCorners);
		slbTopYes.addActionListener(slbTop);
		slbTopNo.addActionListener(slbTop);
		colours0.setActionCommand("0");
		colours1.setActionCommand("1");
		colours2.setActionCommand("2");
		
//Panel containing text fields to set dimensions  
		dimensionsP.add(widthL);
		dimensionsP.add(width);
		dimensionsP.add(lengthL);
		dimensionsP.add(length);
		dimensionsP.add(heightL);		
		dimensionsP.add(height);
		
//Panel containing label and combo box to change card grade      
		gradeP.add(cGrade);
		gradeP.add(cardGrade);

//Panel containing label and Radio buttons to select number of colours   
		colourP.add(colour);
		colourP.add(colours0);
		colourP.add(colours1);
		colourP.add(colours2);
		
//Panel containing label and check boxes to set reinforced bottom  		
		bottomP.add(bottom);
		bottomP.add(rFBottomYes);
		bottomP.add(rFBottomNo);

//Panel containing label and check boxes to set reinforced corners		
		cornersP.add(corners);
		cornersP.add(rFCornersYes);
		cornersP.add(rFCornersNo);

//Panel containing label and check boxes to set sealable top
		slbTopP.add(sealbTop);
		slbTopP.add(slbTopYes);
		slbTopP.add(slbTopNo);

//Panel containing all panels which contain property setting controls 
		propertySelectors.add(dimensionsP);
		propertySelectors.add(gradeP);
		propertySelectors.add(colourP);
		propertySelectors.add(bottomP);
		propertySelectors.add(cornersP);
		propertySelectors.add(slbTopP);
		
		
	
//add event handlers for order controls 	
		addOrder.addActionListener(new CalculateCost());
		placeOrder.addActionListener(new FinalOrder());

//Panel containing the total cost label and text field as well as the order control buttons 		
		addPlace.add(tCostL);
		addPlace.add(tCost);
		addPlace.add(addOrder);
		addPlace.add(placeOrder);
		
//Panel containing a label and a text area to display the orders
		listOrders.add(yourOrder, BorderLayout.NORTH);
		listOrders.add(scrollOrders, BorderLayout.CENTER);
		
//Panel containing all panels containing to do with adding, placing and showing orders  					
		orderControlers.add(listOrders, BorderLayout.CENTER);
		orderControlers.add(addPlace, BorderLayout.SOUTH);
		
//Add the two panels containing everything to OrderForm 		
		add(propertySelectors, BorderLayout.EAST);
		add(orderControlers, BorderLayout.WEST);
		
		setSize(1150,400);
		setVisible(true);
		
		 this.setDefaultCloseOperation(OrderForm.EXIT_ON_CLOSE);//closes the form properly
		
		
	}
	
	
	
	class SetCardGrade implements ActionListener{          
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				
			    boxProps.setCardGrade(Integer.parseInt((String) (cardGrade.getSelectedItem())));//The combo box return value is an object Which needs to be cast 
			    	//to a sting before being parsed as a number
				
			
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, invalid, "Input Error", JOptionPane.WARNING_MESSAGE);
				
				
			}
			
		}
		
	}
	
	class SetNumOfColours implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("0"))
			{
				boxProps.setColour(0);
				
			}
			else if (e.getActionCommand().equals("1"))
			{
				boxProps.setColour(1);
				
			}
			else  
			{
				boxProps.setColour(2);
				
			}
		}
			
		
	}
	
	class ReinforcedBottom implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Yes"))
			{
				boxProps.setRfBottom(true);
				rFCornersYes.setEnabled(true);// if the customer wants a reinforced bottom they can select to have reinforced corners
			    
			
			}
			else if(e.getActionCommand().equals("No"))
			{
				boxProps.setRfBottom(false);				
				rFCornersYes.setEnabled(false);//if the customer dose not want a reinforced bottom they can not have reinforced corners				                              
				rFCornersNo.setSelected(true);//Select no for reinforced corners  
				boxProps.setRfCorners(false);//if reinforced corners has been selected as yes previously during a single order process it is set to false 
			 
			}
			
		}
		
	}
	
	
class ReinforcedCorners implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Yes"))
			{
				boxProps.setRfCorners(true);
				
			}
			else if(e.getActionCommand().equals("No"))
			{
				boxProps.setRfCorners(false);
				
			}
			
		}
		
	}

class SlbTop implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Yes"))
		{
			boxProps.setSlbTop(true);
			
		}
		else if(e.getActionCommand().equals("No"))
		{
			boxProps.setSlbTop(false);
			
		}
		
	}
	
}

class CalculateCost implements ActionListener{	
	@Override
	public void actionPerformed(ActionEvent e) {
		//boxcost throws a BoxException so a try catch is needed here 
	if(width.getText().equals("")|| length.getText().equals("") || height.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Please enter all box dimensions", "Input Error", JOptionPane.WARNING_MESSAGE);
		}
	else{
		try {
		//The width, length and height are set   
			boxProps.setWidth(Double.parseDouble(width.getText()));
			boxProps.setLength(Double.parseDouble(length.getText()));
			boxProps.setHeight(Double.parseDouble(height.getText()));
		//boxprops is then added to an OrderList object   
			orderList.add(boxProps);
			
		//The current position in the ArrayList is determined by the value of index			
		//The BoxProperties object p gets assigned the current orderList position which is equal to index 		
			BoxPropeties p = orderList.get(index);
			totalCost = totalCost + p.boxCost();
		//Display current order
			orders.insert(p.toString()+"\n\n",0);
			tCost.setText(dFormat.format(totalCost));
			index +=1;
		} 
		catch (BoxException e1)
		{	
		//message to show if box can not be supplied 
			JOptionPane.showMessageDialog(null, e1, "Input Error", JOptionPane.WARNING_MESSAGE);
			
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Cannot take letters for dimension", "Input Error", JOptionPane.WARNING_MESSAGE);
		}
	   }
		
	}
	
}

class FinalOrder implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	//message to display after 
		JOptionPane.showMessageDialog(null,"You have ordered " + orderList.size() + " boxes. The total cost is: £" + dFormat.format(totalCost));
	//Clear all orders from previous ordering session
		orderList.clear();
		orders.setText("");
		tCost.setText("");
		index = 0;
		totalCost = 0;
		
	}
	
}

	
}
