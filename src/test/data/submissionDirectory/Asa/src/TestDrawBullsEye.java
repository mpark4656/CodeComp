import javax.swing.JFrame;


public class TestDrawBullsEye
{
	public static void main( String[] args )
	{
		DrawBullsEye panel = new DrawBullsEye();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.add( panel );
		application.setSize( 500 , 500 );
		application.setVisible( true );
	}
}