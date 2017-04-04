import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class DrawBullsEye extends JPanel
{
	private static final SecureRandom randomNumber = new SecureRandom();
	private static final long serialVersionUID = 1L;

	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		
		int xIncrement = getWidth() / 6;
		int yIncrement = getHeight() / 6;
		
		
		// Generate a random color
		Color randomColor1 = new Color(randomNumber.nextInt(256) , randomNumber.nextInt(256) , randomNumber.nextInt(256));
		Color randomColor2 = new Color(randomNumber.nextInt(256) , randomNumber.nextInt(256) , randomNumber.nextInt(256));
		
		for( int i = 5 ; i > 0 ; i-- ) {
			// Set Color
			if( i % 2 == 0 ) {
				g.setColor( randomColor1 );
			}
			else {
				g.setColor( randomColor2 );
			}

			// Parameter Variables
			int x = xCenter - ( (xIncrement / 2) * i );
			int y = yCenter - ( (yIncrement / 2) * i );
			int width = xIncrement * ( i );
			int height = yIncrement * ( i );
			
			// Draw the circle
			g.fillOval( x , y , width , height );
		}
	}
}