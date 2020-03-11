//Name: Dominic Feliton
//Date: 3/6/20
//Per: 2
//AP Comp Sci

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends AbstractPong
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;

  public Pong()
  {
	  ball = new Ball(Color.black);
	  
	  leftPaddle = new Paddle(10, 0, 10, 200, 6);
	  
	  rightPaddle = new Paddle(780, 0, 10, 200, 6);
  }

  public void render(Graphics window)
  {
    ball.moveAndDraw(window);
    leftPaddle.draw(window, Color.BLACK);
    rightPaddle.draw(window, Color.BLACK);

    if((ball.getX()<0 || ball.getX()>790))
    {
      ball.setXSpeed(0);
      
      ball.setYSpeed(0);
    }


    if((ball.getY()<0 || ball.getY()>570))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }
    
    
    if ((ball.getX() <= leftPaddle.getX()) &&
		((leftPaddle.getY() <= ball.getY()) && (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()) 
		))
    {
    	ball.setXSpeed(-ball.getXSpeed());
    }
    
    if ((ball.getX() >= rightPaddle.getX()) && //check if paddle is within bounds of x
    		((rightPaddle.getY() <= ball.getY()) && (ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()) 
    		))
        {
        	ball.setXSpeed(-ball.getXSpeed());
        }

    if(keyIsPressed('W') == true)
    {
      leftPaddle.moveUpAndDraw(window);
    }
    if(keyIsPressed('Z') == true)
    {
      leftPaddle.moveDownAndDraw(window);
    }
    
    if(keyIsPressed('I') == true)
    {
      rightPaddle.moveUpAndDraw(window);
    }
    if(keyIsPressed('M') == true)
    {
      rightPaddle.moveDownAndDraw(window);
    }
  }
}