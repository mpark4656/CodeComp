import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class RandomShape extends JPanel
{
	private static final SecureRandom randomNumber = new SecureRandom ();
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		
		for( int i = 0 ; i < 10 ; i++ ) {
			// Obtain a random color
			Color randomColor = new Color( randomNumber.nextInt(256) , randomNumber.nextInt(256) , randomNumber.nextInt(256) );
			
			// Set random color
			g.setColor( randomColor );
			
			// Random Starting Coordinates
			int x = randomNumber.nextInt( getWidth() );
			int y = randomNumber.nextInt( getHeight() );
			
			// Random Length and Height
			int width = randomNumber.nextInt( getWidth() / 2 + 1 );
			int height = randomNumber.nextInt( getHeight() / 2 + 1 );
			
			if( randomNumber.nextInt(2) == 0 ) {
				g.fillOval( x , y , width , height);
			}
			else {
				g.fillRect( x , y , width , height);
			}
		}	
	}
}