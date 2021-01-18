/*  Meghana Moturu mmot335 938805776:
 *  ============================================================================================
 *  MovingRectangle.java: This is the MovingRectangle class, which is a subclass of MovingShape, it creates
	rectangles based on specifications defined by the user.
 *  ============================================================================================
 */
import java.awt.*;
public class MovingRectangle extends MovingShape{
	public MovingRectangle(){
		super();//call superclass MovingShape
	}
	public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType);//superclass call
	}
	public void draw(Graphics g){
		Graphics2D g2D = (Graphics2D) g;//create graphics2D object
		g2D.setPaint(fillColor);//set the paint colour to be that of the fill color
		g2D.fillRect(topLeft.x, topLeft.y, width, height);//fill the rectangle with the fill color using the dimensions of the rectangle.
		g2D.setPaint(borderColor);//set the border color
		g2D.drawRect(topLeft.x, topLeft.y, width, height);//draw the outline of the rectangle using drawRect which in turn gives a border effect.
		drawHandles(g);//draw the handles so that they show up when the shape is selected.
	}
	public boolean contains(Point p){
		 return (this.getX() < p.getX() && this.getY() < p.getY() &&//check if the point is in the particular rectangle. If the current x value is less than the point p value in the method and the current y value is less than the point y value 
                this.getX() + this.width > p.getX()  &&// and if the current x value plus the width is greater than the x value of p and the current y value plus the height is greater than the y value of p, then the point is in the rectangle
                this.getY() + this.height > p.getY());
    }
}