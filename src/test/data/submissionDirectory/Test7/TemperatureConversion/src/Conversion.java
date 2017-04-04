import javax.swing.JFrame;

/**
 * Test Driver for the Temperature Conversion Program.
 * @author mpark
 */
public class Conversion
{
	public static void main( String[] args )
	{
		ConversionJFrame appFrame = new ConversionJFrame();
		appFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		appFrame.setSize( 300 , 250 );
		appFrame.setResizable( false );
		appFrame.setVisible( true );
	}
}