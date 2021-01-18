/*  Meghana Moturu mmot335 938805776:
 *  ============================================================================================
 *  MovingOval.java: This is the MovingOval class, which is a subclass of MovingShape, it creates
	Ovals based on specifications defined by the user.
 *  ============================================================================================
 */
import java.awt.*;
public class MovingOval extends MovingShape{
	
	public MovingOval(){
		super();//call to superclass constructor
	}
	public MovingOval(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType);//call to superclass constructor
	}
	public void draw(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(fillColor);//set paint so that it uses the fill color
		g2D.fillOval(topLeft.x, topLeft.y,width,height);// fill the rectangle with the fill color using the topLeft.x, topLeft.y, width and height values.
		g2D.setPaint(borderColor);//set the border color
		g2D.drawOval(topLeft.x, topLeft.y,width,height);//draw the oval with the border color and the dimensions that are the same as above, drawing the oval means only an outline is created, thus giving a border effect.
		drawHandles(g);
	}
	public boolean contains(Point p){
		 Point EndPt = new Point(topLeft.x + width, topLeft.y + height);//this determines where the end point is
		 double dx = (2 * p.x - topLeft.x - EndPt.x) / (double) width;
		 double dy = (2 * p.y - topLeft.y - EndPt.y) / (double) height;
		 return dx * dx + dy * dy < 1.0; 
		 //the above is a commonly used mathematical equation used to test if a particular point is within an oval.
	}
}
