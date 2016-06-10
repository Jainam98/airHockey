/* ICS4U1 - Computer Science
 * Game: Air Hockey
 * June 9, 2016
 */

package airHockey;

import java.awt.Color;
import java.awt.Graphics;

    /* Paddle class, used to initilize variables
    */
public class Paddle {

    private int x;
    private int y;
    private int width;
    private int length;
    private int top = 50; 
    private int bottom = 400; 

    public Paddle () {
    
    }

    /* Paddle method for x,y,length and width measurements
    * @param x - x cord for paddle
    * @param y - y cord for paddle
    * @param length - length of paddle
    * @param width - width of paddle
    */
    public Paddle(int x,int y,int length, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    /* getter method for length
    * @return the length value
    */
    public double getLength (){
        return this.length;
    }   
    /* setter method for length
    *@param setLength - int value of length
    */
    public void setLength ( int length ) {
        this.length = length;
    }
    /* getter method for width
    * @return the width value
    */
    public double getWidth () {
        return this.width ;
    }
    /* setter method for width
    *@param setWidth - int value of width
    */
    public void setWidth (int width) {
        this.width = width ;
    }
    /* getter method for x
    * @return the x value
    */
    public double getX () {
        return this.x;
    }
    /* setter method for x
    *@param setX - int value of x
    */
    public void setX (int x) {
        this.x = x;
    }
    /* getter method for y
    * @return the y value
    */
    public double getY (){
        return this.y;
    }
    /* setter method for y
    *@param setY - int value of y
    */    
    public  void setY (int y) {
        this.y = y  ;
    }
    /* update method for ball`s cords
    *@param ballx - x cord of ball
    *@param bally - y cord of ball
    */  
    public void  update(double ballx, double bally) {
        if (ballx > 400 ){
            if (this.y>bally){
                if (bally-2>50){
                    this.y = this.y-10; 
                }
            }
            if (this.y+this.length-30<bally){
                if ( bally+this.length+2<400 ) {
                    this.y = this.y+10;
                }
            }
        }
    }
    /* update method for ball`s change in y cords
    *@param yChange - used to change the direction of y cords
    */ 
    public void change ( int yChange){
        if ( ((yChange < 0) && (yChange+getY()>= top))  ) {
            this.y += yChange;
        }
        if ((yChange >0)&&((yChange+this.length+getY())<=380)){
            this.y += yChange;
        }
    }  
    /* Paint method, used to colour the paddles
    *@param g - graphics variable used to set and fill colour of paddle
    */ 
    public void paint (Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, length);
    }
}


