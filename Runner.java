import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.Timer;

/**
 * Runner class for our game
 */
public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener
{
    private static final int MAX_WIDTH = ( int )Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int MAX_HEIGHT = ( int )Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final Rectangle SCREEN_DIMENSIONS =  new Rectangle( 0, 0, MAX_WIDTH, MAX_HEIGHT );


    private ArrayList<SoftTeddyBear> bears = new ArrayList<SoftTeddyBear>();
    private Spaceship spaceship;
    private boolean right, left;


    private Timer clock;
    /**
     * Constructor for our game
     */
    public Runner()
    {
        clock = new Timer( 17, this ); 
        clock.start(); 

        spaceship = new Spaceship( 0, 0, 0, 0, 0); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }

    @Override
    public void keyPressed( KeyEvent e ) 
    {

        if( e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
           System.exit(1);   
        }
        if( e.getKeyCode() == KeyEvent.VK_W )
        {
            spaceship.setYVelo(-Spaceship.SPACESHIP_SPEED);   
        }
        if( e.getKeyCode() == KeyEvent.VK_A )
        {
            spaceship.setXVelo(-Spaceship.SPACESHIP_SPEED);   
        }
        if( e.getKeyCode() == KeyEvent.VK_S )
        {
            spaceship.setYVelo(Spaceship.SPACESHIP_SPEED);   
        }
        if( e.getKeyCode() == KeyEvent.VK_D )
        {
            spaceship.setXVelo(Spaceship.SPACESHIP_SPEED);   
        }
        if( e.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            right = true; 
        }
        if( e.getKeyCode() == KeyEvent.VK_LEFT )
        {
            left = true; 
        }
        if( e.getKeyCode() == KeyEvent.VK_SPACE )
        {
            bears.add( new SoftTeddyBear(spaceship.getX(), spaceship.getY(),
                (int)(SoftTeddyBear.SOFT_TEDDY_BEAR_SPEED * Math.cos( Math.toRadians(spaceship.getAngle()))),
                (int)(SoftTeddyBear.SOFT_TEDDY_BEAR_SPEED * Math.sin( Math.toRadians(spaceship.getAngle()))),
                spaceship.getAngle(), spaceship.getX(), spaceship.getY())); 

                System.out.println("angle:" + spaceship.getAngle());
                



        }
        
    }

    @Override
    public void keyReleased( KeyEvent e ) 
    {
        if( e.getKeyCode() == KeyEvent.VK_W )
        {
            spaceship.stopYVelo();
        }
        if( e.getKeyCode() == KeyEvent.VK_A )
        {
            spaceship.stopXVelo();
        }
        if( e.getKeyCode() == KeyEvent.VK_S )
        {
            spaceship.stopYVelo();
        }
        if( e.getKeyCode() == KeyEvent.VK_D )
        {
            spaceship.stopXVelo();
        }
        if( e.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            right = false; 
        }
        if( e.getKeyCode() == KeyEvent.VK_LEFT )
        {
            left = false; 
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if( e.getSource() == clock )
        {
            repaint();
        }
   }

    public void paintComponent( Graphics g )
    { 
        Graphics2D g2d = (Graphics2D)g;

        setBackground( new Color( 0, 0, 0 ) );
        super.paintComponent( g ); 

        spaceship.move();
        spaceship.drawSpaceship(g2d, right, left);

        for( SoftTeddyBear bear: bears )
        {
            //bear.move(spaceship.getAngle());
            bear.move();
            bear.drawSoftTeddyBear(g2d, spaceship);

            System.out.println("xVelo:" + spaceship.getXVelo());
            System.out.println("yVelo:" + spaceship.getYVelo());
        }

    }

    /**
     * This method is run for our game to begin.
     * 
     * @param arg 
     */
    public static void main(String[] args) 
    {
        JFrame window = new JFrame( "Pac-Man" ); 
        Runner game = new Runner();    

        window.setBounds( SCREEN_DIMENSIONS );
        window.add( game ); 

        window.setVisible( true );  
        window.addKeyListener( game );
        
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    }    
}