import javax.swing.JFrame;

public class TestRandomShape
{
	public static void main( String[] args )
	{
		RandomShape panel = new RandomShape();
		
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.add( panel );
		window.setSize( 500 , 500 );
		window.setVisible( true );
	}
}