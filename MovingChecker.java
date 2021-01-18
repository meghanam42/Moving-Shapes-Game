/*  Meghana Moturu mmot335 938805776:
 *  ============================================================================================
 *  MovingChecker.java: This is the MovingChecker class, which is a subclass of MovingRectangle, 
	it creates randomly generated checkerboard patterns based on a randomly generated xNumBlock 
	and yNumBlock value.
 *  ============================================================================================
 */
import java.awt.*;
import java.util.Random;
public class MovingChecker extends MovingRectangle{
	protected int xNumBlock = 0;//create these two variables to determine number of blocks in when a checker pattern is created.
	protected int yNumBlock = 0;
	private Random randomNumbers = new Random();
	
	public MovingChecker(){
		super();//call to superclass constructor
		xNumBlock = 2+ randomNumbers.nextInt(5);// call a random number between 2 and 5 to find the value of the xNumBlock and yNumBlock i.e. how many blocks per row and column
		yNumBlock = 2 + randomNumbers.nextInt(5);
	}
	public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType);//call to superclass constructor
		xNumBlock = 2+ randomNumbers.nextInt(5);// call a random number between 2 and 5 to find the value of the xNumBlock and yNumBlock i.e. how many blocks per row and column
		yNumBlock = 2 + randomNumbers.nextInt(5);
	}
	public void draw(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		int checkerWidth = width/xNumBlock;//determine the width and height of the blocks/checker in the rectangle, to make sure it is evenly distributed and sized.
		int checkerHeight = height/yNumBlock;
		int x,y;
		boolean isFill = true;
		for(int row = 0; row < xNumBlock; row++){ //for loop for rows in MovingChecker
			for(int col = 0; col < yNumBlock; col++) { // for loop for columns in MovingChecker
				x = row * checkerWidth; // make the x value the row number * the checkerWidth, this is done to determine the topLeft.x value for the blocks in this MovingChecker pattern, acting as an increment for the leftX value inside the inner for loop and if statements.
				y = col * checkerHeight;// make the y value the column number * the checkerHeight this is done to determine the topLeft.x value for the blocks in this MovingChecker pattern, acting as an increment for the leftY value inside the inner for loop and if statements.
				if (isFill) { //if the boolean isFill is true, then the fill color is used in the block                    
					g2D.setPaint(fillColor);//set paint to the fill color.
					int leftX = topLeft.x + x; //increment the leftX value based on the topLeft.x value of the MovingRectangle and the x increment
					int leftY = topLeft.y + y; //increment the leftY value based on the topLeft.y value of the MovingRectangle and the y increment
					g2D.fillRect(leftX,leftY,checkerWidth,checkerHeight);//fill the rectangle/block with the fillColor using the leftX, leftY, checkerWidth and checkerHeight variables.
					isFill = false;// change boolean to false so that in the next iteration of the for loop, the border color is used.
					drawHandles(g);//draw the handles
				} else {
					g2D.setPaint(borderColor);//use border color instead.
					int leftX = topLeft.x + x;
					int leftY = topLeft.y + y;
					g2D.fillRect(leftX,leftY,checkerWidth,checkerHeight);
					isFill = true;
					drawHandles(g);
				}
		}
	}
}
}