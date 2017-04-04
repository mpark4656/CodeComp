import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 * This class implements JFrame for the temperature conversion program.
 * @author mpark
 */
public class ConversionJFrame extends JFrame
{
	private final JTextField outputField;
	private final JRadioButton fToCRadio;
	private final JRadioButton cToFRadio;
	private final ButtonGroup radioButtons;
	private final JTextField fToCInputField;
	private final JLabel fToCLabel;
	private final JTextField cToFInputField;
	private final JLabel cToFLabel;
	private final JButton fToCConvertButton;
	private final JButton cToFConvertButton;

	/**
	 * 	Default Constructor that initializes all the components
	 * 	 and register handlers.
	 */
	public ConversionJFrame()
	{
		// Initialize JFrame and set the Layout.
		super( "Temperature Conversion" );
		setLayout( new FlowLayout( 1 , 10 , 10 ) );

		// Create and Add the Output Text Field.
		outputField = new JTextField( 25 );
		outputField.setEditable( false );
		outputField.setToolTipText( "Displays result" );
		add( outputField );

		// Create and Add Fahrenheit to celsius Radio button.
		fToCRadio = new JRadioButton( "Fahrenheit to Celsius" , true );
		fToCRadio.setToolTipText("Select this for Fahrenheit to Celsius Conversion");
		add( fToCRadio );

		// Create and Add Celsius to Fahrenheit Radio Button.
		cToFRadio = new JRadioButton( "Celsius to Fahrenheit" , false );
		cToFRadio.setToolTipText("Select this for Celsius to Fahrenheit Conversion");
		add( cToFRadio );

		// Create Radio Button Group and Add the two Radio buttons.
		radioButtons = new ButtonGroup();
		radioButtons.add( fToCRadio );
		radioButtons.add( cToFRadio );


		// Create input field for Fahrenheit to Celsius conversion.
		fToCInputField = new JTextField( 15 );
		fToCInputField.setToolTipText( "Enter the temperature in Fahrenheit" );
		add( fToCInputField );

		// Create a unit label for Fahrenheit.
		fToCLabel = new JLabel("\u00b0F");
		add( fToCLabel );

		// Create Convert Button for Fahrenheit to Celsius.
		fToCConvertButton = new JButton( "Convert to Celsius" );
		add( fToCConvertButton );


		// Create input field for Celsius to Fahrenheit conversion.
		cToFInputField = new JTextField( 15 );
		cToFInputField.setToolTipText( "Enter the temperature in Celsius" );
		add( cToFInputField );
		cToFInputField.setVisible( false );

		// Create a unit label for Celsius.
		cToFLabel = new JLabel( "\u00b0C" );
		add( cToFLabel );
		cToFLabel.setVisible( false );

		// Create Convert Buttons for Celsius to Fahrenheit.
		cToFConvertButton = new JButton( "Convert to Fahrenheit" );
		add( cToFConvertButton );
		cToFConvertButton.setVisible( false );


		// Register Radio Button Handler.
		fToCRadio.addItemListener( new RadioButtonHandler() );
		cToFRadio.addItemListener( new RadioButtonHandler() );

		// Register Text Field Handler.
		fToCInputField.addActionListener( new fToCTextFieldHandler() );
		cToFInputField.addActionListener( new cToFTextFieldHandler() );

		// Register Focus Listener for Input Text Fields
		fToCInputField.addFocusListener( new FocusListener() {
			@Override public void focusLost( final FocusEvent fe ) {}
			@Override public void focusGained( final FocusEvent fe ) {
				fToCInputField.selectAll();
			}
		});
		
		cToFInputField.addFocusListener( new FocusListener() {
			@Override public void focusLost( FocusEvent fe ) {}
			@Override public void focusGained( FocusEvent fe ) {
				cToFInputField.selectAll();
			}
		});
		
		// Register JButton Handler.
		fToCConvertButton.addActionListener( new fToCButtonHandler() );
		cToFConvertButton.addActionListener( new cToFButtonHandler() );
	}

	/**
	 * This class implements Event Handler for F to C Button
	 * 	It obtains the value entered as String in the text field and converts
	 *  the Fahrenheit temperature to Celsius temperature. Then, it changes the
	 *  texts of the output text field to reflect the result.
	 * @author mpark
	 */
	private class fToCButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent event )
		{
			String str = fToCInputField.getText();

			try {
				double f = Double.parseDouble( str );
				double result = (double)5 / 9 * ( f - 32 );
				outputField.setText( String.format("%.2f \u00b0C" , result) );
			}
			catch ( NumberFormatException e ) {
				JOptionPane.showMessageDialog( ConversionJFrame.this , "Invalid Input!" ,
						   "Error" , JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	/**
	 * This class implements Event Handler for C to F Button
	 * 	It obtains the value entered as String in the text field and converts the
	 *  Celsius temperature to Fahrenheit temperature. Then, it changes the texts
	 * 	of the output text field to reflect the result.
	 * @author mpark
	 */
	private class cToFButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent event )
		{
			String str = cToFInputField.getText();

			try {
				double c = Double.parseDouble( str );
				double result = (double)9 / 5 * c + 32;
				outputField.setText( String.format("%.2f \u00b0F" , result) );
			}
			catch( NumberFormatException e ) {
				JOptionPane.showMessageDialog( ConversionJFrame.this , "Invalid Input!" ,
											   "Error" , JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	/**
	 * This class implements Event Handler for F to C Text Field
	 * 	It obtains the value entered as String and converts the Fahrenheit
	 * 	temperature to Celsius temperature. Then, it changes the texts
	 * 	of the output text field to reflect the result.
	 * @author mpark
	 */
	private class fToCTextFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent event )
		{
			String str = "";
			str = event.getActionCommand();

			try {
				double f = Double.parseDouble( str );
				double result = (double)5 / 9 * ( f - 32 );
				outputField.setText( String.format("%.2f \u00b0C" , result) );
			}
			catch ( NumberFormatException e ) {
				JOptionPane.showMessageDialog( ConversionJFrame.this , "Invalid Input!" ,
						   "Error" , JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	/**
	 * This class implements Event Handler for C to F Text Field
	 * 	It obtains the value entered as String and converts the Celsius
	 * 	temperature to Fahrenheit temperature. Then, it changes the texts
	 * 	of the output text field to reflect the result.
	 * @author mpark
	 */
	private class cToFTextFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent event )
		{
			String str = "";
			str = event.getActionCommand();

			try {
				double c = Double.parseDouble( str );
				double result = (double)9 / 5 * c + 32;
				outputField.setText( String.format("%.2f \u00b0F" , result) );
			}
			catch( NumberFormatException e ) {
				JOptionPane.showMessageDialog( ConversionJFrame.this , "Invalid Input!" ,
											   "Error" , JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	/**
	 * This class implements RadioButtonHandler
	 * 	It works by hiding some buttons and text fields while
	 * 	making other buttons and text fields visible
	 * For example, if the user selected C to F conversion, it hides
	 * 	any buttons and fields that are used for F to C conversion
	 * This allows user to switch between C to F and F to C.
	 * @author mpark
	 */
	private class RadioButtonHandler implements ItemListener
	{
		@Override
		public void itemStateChanged( ItemEvent event )
		{
			// User selected F to C conversion.
			if( event.getItem() == fToCRadio )
			{
				// Clear the output field.
				outputField.setText( "" );

				// Hide the input field, label, and button of C to F.
				cToFInputField.setVisible( false );;
				cToFLabel.setVisible( false );;
				cToFConvertButton.setVisible( false );

				// Make F to C button, label and text field visible
				fToCInputField.setVisible( true );
				fToCLabel.setVisible( true );
				fToCConvertButton.setVisible( true );
			}
			// User selected C to F conversion.
			else
			{
				// Clear the output field.
				outputField.setText( "" );

				// Hide the input field, label, and button of F to C.
				fToCInputField.setVisible( false );
				fToCLabel.setVisible( false );
				fToCConvertButton.setVisible( false );

				// Make C to F button, label, and text field visible.
				cToFInputField.setVisible( true );
				cToFLabel.setVisible( true );
				cToFConvertButton.setVisible( true );
			}
		}
	}
}