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
    private int horDir;
    private int verDir; 
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
        
        int random = (int)(Math.random() * 12) + 1 ;
        
        if (random>8){ 
            this.horDir= Ball.RIGHT;
            this.verDir= Ball.DOWN; 
        }else if (random>4){
            this.verDir= Ball.UP;
            this.horDir= Ball.LEFT; 
        }else{
            this.verDir= Ball.DOWN;
            this.horDir= Ball.LEFT;   
        }
    }
    
    /*getter method for length
     *@return the length 
    */
    public double getLength (){
        return this.length;
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
     
    /* getter method for y
     * @return the y value
     */ 
     public double getY (){
    	 return this.y;
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
     
    /* setter method for x
    *@param x - int value of x
    */
     public void setX (int x) {
       this.x = x;
     }

     
    /* setter method for y
    *@param y - int value of y
    */
     public  void setY (int y) {
       this.y = y  ;
     }
     
    /*change method for the x and y cords
    *@param changeInX - change in x 
    *@param changeInY - change in y
    */
    public void change(int changeInX, int changeInY){
            this.x += changeInX;
            this.y += changeInY;
        }
    
    /* update method for the change in direction of ball
    *@param xMaximum - change in x 
    *@param yMaximum - change in y
    *@param change - change in direction
    */
    public void update(int xMaximum, int change, int yMaximum){
    	
            if (x + width >= xMaximum){
                this.horDir = Ball.LEFT;
            } else if (x <= 0){
                this.horDir = Ball.RIGHT;
            }

            if (y + width >= yMaximum){
                this.verDir = Ball.UP;
            } else if (y <= 50){
                this.verDir = Ball.DOWN;
            }

            if(this.horDir == Ball.LEFT){
                this.x -= change;
            } else {
                this.x += change;
            }

            if(this.verDir == Ball.UP){
                this.y -= change;
            } else {
                this.y += change;
            }
        }
    
    /* paddlehit method for the hits against the paddle
    */
    public void paddleHit(){
        if (horDir==Ball.RIGHT){
            horDir=Ball.LEFT;
        }else{
            horDir=Ball.RIGHT;
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



