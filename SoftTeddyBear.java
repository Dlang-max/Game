import java.awt.*;


public class SoftTeddyBear {
    
    private static final int SOFT_TEDDY_BEAR_WIDTH = 10; 
    private static final int SOFT_TEDDY_BEAR_HEIGHT = 10; 
    public static final int SOFT_TEDDY_BEAR_SPEED = 5; 


    public static final int SPACESHIP_SPEED = 5;

    private int x, y, xVelo, yVelo, angle, sX, sY; 
    private boolean first;

    private Rectangle softTeddyBearRect;


    public SoftTeddyBear( int x, int y, int xVelo, int yVelo, int angle, int sX, int sY){
        this.x = x;
        this.y = y; 
        this.xVelo = xVelo; 
        this.yVelo = yVelo; 
        this.angle = angle;
        this.sX = sX;
        this.sY = sY; 
        first = true; 

        
        softTeddyBearRect = new Rectangle(x, y, SOFT_TEDDY_BEAR_WIDTH, SOFT_TEDDY_BEAR_HEIGHT); 


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

    public void drawSoftTeddyBear( Graphics2D g, Spaceship s){
        
        softTeddyBearRect = new Rectangle(x + Spaceship.SPACESHIP_WIDTH / 2, y + Spaceship.SPACESHIP_HEIGHT / 2,  SOFT_TEDDY_BEAR_WIDTH, SOFT_TEDDY_BEAR_HEIGHT); 
        g.setColor(Color.WHITE);


        if( first )
            first = false;
            setDirection(g);

        g.fillOval(x + Spaceship.SPACESHIP_WIDTH / 2, y + Spaceship.SPACESHIP_HEIGHT / 2,  SOFT_TEDDY_BEAR_WIDTH, SOFT_TEDDY_BEAR_HEIGHT);
        g.draw( softTeddyBearRect );
        g.fill( softTeddyBearRect );

    }

    public void setDirection(Graphics2D g)
    {
        g.rotate(Math.toRadians(angle), sX + Spaceship.SPACESHIP_WIDTH / 2, sY + Spaceship.SPACESHIP_HEIGHT /2);
    }

    public void move()
    {

        // xVelo = (int)(Math.cos(Math.toRadians(-a)) * SOFT_TEDDY_BEAR_SPEED);
        // yVelo = (int)(Math.sin(Math.toRadians(-a)) * SOFT_TEDDY_BEAR_SPEED);

        this.x += xVelo;
        this.y += yVelo; 
    }

    public void stop()
    {
        xVelo = 0;
        yVelo = 0; 
    }


}
