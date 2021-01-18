/*  Meghana Moturu mmot335 938805776:
 *  ============================================================================================
 *  MovingGradient.java: This is the MovingGradient class, which is a subclass of MovingRectangle, it creates
	gradient patterns.
 *  ============================================================================================
 */

import java.awt.*;
public class MovingGradient extends MovingRectangle{//extends MovingRectangle as the gradient is contained within the shape of a rectangle
	public MovingGradient(){
		super();//call superclass constructor 
	}
	public MovingGradient(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType);//call superclass constructor 
	}
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;//create graphics2D object
		float [] distance = {0.0f, 0.5f};//these are the fraction values that specify the distribution of the colors along the gradient
		Color[] colors = {fillColor,borderColor};//fill and border color to be used in the gradient
		RadialGradientPaint gradientPat = new RadialGradientPaint(topLeft.x, topLeft.y,width/2, distance, colors, MultipleGradientPaint.CycleMethod.REFLECT);
		//new RadialGradientPaint gradient is created using the topLeft.x and topLeft.y values, the width/2 represents the radius of the circle that defines the extents of the gradient, however I have not used the exact radius
		//the distance and colors lists follow and then finally the cycle method is stated which in this case is reflect.
		g2d.setPaint(gradientPat);//set the paint colour to be that of the gradient pattern
		g2d.fillRect(topLeft.x, topLeft.y, width, height);//fill the rectangle with the gradient pattern
		drawHandles(g);
		//the resulting pattern is a black background with the fill colour basically forming a semi-circle ring, giving a pop of colour against the background, while giving a gradient effect.
	}
}
//contains method is not included as it is already in the MovingRectangle class and does not need to be overrided.