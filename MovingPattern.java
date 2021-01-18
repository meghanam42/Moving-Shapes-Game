/*  Meghana Moturu mmot335 938805776:
 *  ============================================================================================
 *  MovingPattern.java This is the MovingPattern class, which is a subclass of MovingRectangle, it creates
	a rectangle within a rectangle pattern.
 *  ============================================================================================
 */
import java.awt.*;
public class MovingPattern extends MovingRectangle{//MovingPattern extends the MovingRectangle class as the pattern is rectangles within rectangles
	
	public MovingPattern(){
		super();//superclass constructor call
	}
	
	public MovingPattern(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType);//superclass constructor call
	}
	
	public void draw(Graphics g){
		Graphics2D g2D = (Graphics2D) g;//create Graphics2D object
		int currentX = topLeft.x;//set variable currentX to that of the topLeft.x value, this currentX being a temp value as such to use in the for loop
		int currentWidth = width;//this will be the width of the rectangles generated in each loop
		int currentY = topLeft.y;//set variable currentY to that of the topLeft.y value, this currentY being a temp value as such to use in the for loop
		int currentHeight = height;//height of the rectangles generated in each loop
		int step = 6;//increment and decrement value
		for (int i = 0; i <=8; i++){//for loop, will continue to create rectangles while i is less than or equal to 8
			g2D.setPaint(borderColor);//set the colour to the border color
			g2D.drawRect(currentX, currentY,currentWidth,currentHeight);//draw the outline of the rectangle with the current x,y,width and height variables
			currentX += step;//increment x value
			currentWidth -= step; //decrement the width
			currentHeight -= step;//decrement the height
			//decrementing these two variables will mean that each time a rectangle is drawn, it is smaller than the one before it.
			drawHandles(g);//draw handles so that it can be seen when the shape is selected
		}
	}
}		

//contains method is not included as it is already in the MovingRectangle class and does not need to be overrided.