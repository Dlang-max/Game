import java.awt.*;
import javax.swing.*;


public class Spaceship {
    
    public static final int SPACESHIP_WIDTH = 50; 
    public static final int SPACESHIP_HEIGHT = 50; 


    public static final int SPACESHIP_SPEED = 5;

    private int x, y, xVelo, yVelo, angle; 

    private Rectangle spaceshipRect;


    public Spaceship( int x, int y, int xVelo, int yVelo, int angle ){
        this.x = x;
        this.y = y; 
        this.xVelo = xVelo; 
        this.yVelo = yVelo; 
        this.angle = angle;
        
        spaceshipRect = new Rectangle(x, y, SPACESHIP_WIDTH, SPACESHIP_HEIGHT); 


    }

    public void setX( int x ){
        this.x = x; 
    }
    public void setY( int y ){
        this.y = y; 
    }
    public void setXVelo( int xVelo ){
        this.xVelo = xVelo; 
    }
    public void setYVelo( int yVelo ){
        this.yVelo = yVelo; 
    }

    public void setAngle( int angle ){
        this.angle = angle; 
    }

    public void stopXVelo(){
        this.xVelo = 0; 
    }
    public void stopYVelo(){
        this.yVelo = 0; 
    }

    public int getX(){
        return this.x; 
    }
    public int getY(){
        return this.y; 
    }
    public int getXVelo(){
        return this.xVelo; 
    }
    public int getYVelo(){
       return this.yVelo; 
    }
    public int getAngle(){
        return this.angle; 
     }

    public void drawSpaceship( Graphics2D g, boolean right, boolean left ){
        if( right )
        {
            angle -= 5;
        }
        else if( left )
        {
            angle += 5;
        }
        spaceshipRect = new Rectangle(x, y, SPACESHIP_WIDTH, SPACESHIP_HEIGHT); 

        g.setColor(Color.WHITE);

        g.rotate(Math.toRadians(angle), x + SPACESHIP_WIDTH / 2, y + SPACESHIP_HEIGHT / 2);
        g.draw(spaceshipRect);
        g.fill(spaceshipRect);

        g.rotate(-Math.toRadians(angle), x + SPACESHIP_WIDTH / 2, y + SPACESHIP_HEIGHT / 2);


    }

    public void move()
    {
        this.x += xVelo;
        this.y += yVelo; 
    }

    public void stop()
    {
        xVelo = 0;
        yVelo = 0; 
    }


}
