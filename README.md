# FlexBox
This is my Second Year university java project.
It is a custom calculator to determin the cost of cardboad boxes based on size and diffrent types. 

The application which was to be designed needed to allow properties of a cardboard box to be entered, 
the program would then print out a quote for the box and also allow for multiple boxes to be ordered at one time. 
There were 5 different boxes each with a different price range so I saw the need to 
create an Abstract class which would have a constructor containing only the attributes that could be shared between
all sub classes these where the width, length and height. I coded a class “BoxProperties” to take in all the 
properties of the class whose Accessors and Mutators are fired by event handlers on the GUI “form” which is an 
object of my GUI class “OrderForm” which extends JFrame.

I have assumed that the system is an interface for customers to use to order boxes so therefore as they are not 
allowed to know the Box Type the system will not print off the Box Type with the order quote. 
The system dose notify the user when a box cannot be supplied,
as well as not allowing String or empty text fields to be passed as values to the dimensions.  

I have extended the Exception class to make my own exceptions called “BoxException” this means when the exception 
is shown on screen it will be titled BoxException: which will then be folloed by the message passed to it. 
This makes it more user friendly.

Also the GUI will stop the user from trying to create a box the has no reinforced bottom but reinforced corners by 
greying out the yes checkbox for reinforced corners if the no checkbox for  reinforced bottom is selected.

The limitation of my program is that it cannot store customer personal details for future reference.
