package airHockey;

/* ICS4U1 - Computer Science
 * Game: Air Hockey
 * June 9, 2016
 */

import java.awt.Graphics;
import java.awt.Color;

    /** The ball class, used to initialize variables 
    */
public class Ball {

    private int width;
    private int length;
    private int x;
    private int y;
    private int horizontalDirection;
    private int verticalDirection; 
    private static final int RIGHT = 1;
    private static final int LEFT = 0;
    private static final int DOWN = 0;
    private static final int UP = 1;

    public Ball () {

    }
    
    /** The ball method, used to determine how the ball will move
    * @param x - x value of the ball
    * @param y - y value of the ball
    * @param length - length of the ball
    * @param width - width of the ball
    * @return none
    */
    public Ball(int x,int y,int length, int width) {
    	
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        
        int selector = (int)(Math.random() * 12) + 1 ;
        
        if (selector>8){ 
            this.horizontalDirection= Ball.RIGHT;
            this.verticalDirection= Ball.DOWN; 
        }else if (selector>4){
            this.verticalDirection= Ball.UP;
            this.horizontalDirection= Ball.LEFT; 
        }else{
            this.verticalDirection= Ball.DOWN;
            this.horizontalDirection= Ball.LEFT;   
        }
    }
    
    /*getter method for length
     *@return the length 
    */
    public double getLength (){
        return this.length;
    }
    
    /*setter method for length
    *@param length - int value of length
    */
    public void setLength ( int length ) {
        this.length = length;
    }
    
    /* setter method for width
    *@param width - int value of width
    */
    public void setWidth (int width) {
        this.width = width ;
    }
    
    /* getter method for width
    * @return the width
    */
    public double getWidth () {
        return this.width ;
    }
    
    /* getter method for x
    * @return the x value
    */
     public double getX () {
         return this.x;
    }
     
    /* setter method for x
    *@param x - int value of x
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
    *@param y - int value of y
    */
     public  void setY (int y) {
       this.y = y  ;
     }
     
    /*change method for the x and y cords
    *@param xChange - change in x 
    *@param yChange - change in y
    */
    public void change(int xChange, int yChange){
            this.x += xChange;
            this.y += yChange;
        }
    
    /* update method for the change in direction of ball
    *@param xMax - change in x 
    *@param yMax - change in y
    *@param change - change in direction
    */
    public void update(int xMax, int change, int yMax){
            if (x + width >= xMax){
                this.horizontalDirection = Ball.LEFT;
            } else if (x <= 0){
                this.horizontalDirection = Ball.RIGHT;
            }

            if (y + width >= yMax){
                this.verticalDirection = Ball.UP;
            } else if (y <= 50){
                this.verticalDirection = Ball.DOWN;
            }

            if(this.horizontalDirection == Ball.LEFT){
                this.x -= change;
            } else {
                this.x += change;
            }

            if(this.verticalDirection == Ball.UP){
                this.y -= change;
            } else {
                this.y += change;
            }
        }
    
    /* paddlehit method for the hits against the paddle
    */
    public void paddleHit(){
        if (horizontalDirection==Ball.RIGHT){
            horizontalDirection=Ball.LEFT;
        }else{
            horizontalDirection=Ball.RIGHT;
        }
    }

    /* paint method to add colors
    *@param g - graphics variable used to set and fill color of ball
    */
    public void paint (Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, length);
    }
}



