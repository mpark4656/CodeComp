package edu.odu.cs.cs350.red2.LexicalTools;


/**
 * <pre>
 * Enumeration of C++ Token Types
 * Each type will be represented with a single character.
 * This enum includes token types specific to C++ only.
 * This enum implements TokenTypes interface which provides
 * a method for generating the character as String
 * </pre>
 */
public enum CTokenTypes implements TokenTypes
{
	// Shared with Java
	BOOLEAN ( "1" ),
	BREAK ( "2" ),
	CASE ( "3" ),
	CATCH ( "4" ),
	CHAR ( "5" ),
	CLASS ( "6" ),
	CONTINUE ( "7" ),
	DO ( "8" ),
	DOUBLE ( "9" ),
	ELSE ( "a" ),
	ENUM ( "b" ),
	FLOAT ( "c" ),
	FOR ( "d" ),
	DEFAULT ( "e" ),
	INT ( "f" ),
	LONG ( "g" ),
	NEW ( "h" ),
	IF ( "i" ),
	PUBLIC ( "j" ),
	SHORT ( "k" ),
	SWITCH ( "l" ),
	PRIVATE ( "m" ),
	PROTECTED ( "n" ),
	RETURN ( "o" ),
	VOID ( "p" ),
	STATIC ( "q" ),
	WHILE ( "r" ),
	THIS ( "s" ),
	THROW ( "t" ),
	TRY ( "u" ),
	BOOLEAN_LITERAL ( "v" ),
	NULL_LITERAL ( "w" ),
	
	// Common C++ Reserved Words
	AUTO ( "x" ),
	CONST ( "y" ),
	DELETE ( "A" ),
	DYNAMIC_CAST ( "B" ),
	EXPLICIT ( "C" ),
	EXTERN ( "D" ),
	FRIEND ( "E" ),
	INLINE ( "F" ),
	NAMESPACE ( "G" ),
	OPERATOR ( "H" ),
	SIGNED ( "I" ),
	SIZEOF ( "J" ),
	STATIC_CAST ( "K" ),
	STRUCT ( "L" ),
	TEMPLATE ( "M" ),
	TYPEDEF ( "N" ),
	TYPENAME ( "O" ),
	UNSIGNED ( "P" ),
	USING ( "Q" ),
	VIRTUAL ( "R" ),
	
	// Uncommon C++ Reserved Words
	ALIGNAS ( "z" ),
	ALIGNOF ( "z" ),
	ASM ( "z" ),
	ATOMIC_CANCEL ( "z" ),
	ATOMIC_COMMIT ( "z" ),
	ATOMIC_NOEXCEPT ( "z" ),
	CHAR16T ( "z" ),
	CHAR32T ( "z" ),
	COMPL ( "z" ),
	CONCEPT ( "z" ),
	CONSTEXPR ( "z" ),
	CONSTCAST ( "z" ),
	DECLTYPE ( "z" ),
	EXPORT ( "z" ),
	GOTO ( "z" ),
	IMPORT ( "z" ),
	NOEXCEPT ( "z" ),
	MODULE ( "z" ),
	MUTABLE ( "z" ),
	REGISTER ( "z" ),
	REINTERPRET_CAST ( "z" ),
	REQUIRES ( "z" ),
	STATIC_ASSERT ( "z" ),
	SYNCHRONIZED ( "z" ),
	TYPEID ( "z" ),
	THREAD_LOCAL ( "z" ),
	UNION ( "z" ),
	VOLATILE ( "z" ),
	WCHART ( "z" ),

	// Common Operators
	EQ ( "~" ),
	NOTEQ ( "!" ),
	EQEQ ( "@" ),
	GT ( "#" ),
	GTEQ ( "$" ),
	LT ( "%" ),
	LTEQ ( "^" ),
	NOT ( "&" ),
	DIV ( "/" ), 
	MULT ( "*" ),
	MINUS ( "-" ),
	MINUSMINUS ( "`"),
	PLUS ( "+" ),
	PLUSPLUS ( ":" ),
	OR ( "|" ),
	PLUSEQ ( "S" ),
	MINUSEQ ( "T" ),
	MULTEQ ( "U" ),
	MOD ( "V" ),
	ANDAND ( "W" ),
	AND ( "X" ),
	OROR ( "Y" ),
	
	// Uncommon Operators
	COMP ( "Z" ),
	QUESTION ( "Z" ),
	COLON ( "Z" ),
	XOR ( "Z" ),
	LSHIFT ( "Z" ),
	RSHIFT ( "Z" ),
	URSHIFT ( "Z" ),
	XOREQ ( "Z" ),
	LSHIFTEQ ( "Z" ),
	RSHIFTEQ ( "Z" ),
	URSHIFTEQ ( "Z" ),
	MODEQ ( "Z" ),
	DIVEQ ( "V" ),
	ANDEQ ( "Z" ),
	OREQ ( "Z" ),
	MEMBERACCESS ( "Z" ),
	
	// Separators
	LPAREN ( "(" ),
	RPAREN ( ")" ),
	LBRACE ( "[" ),
	RBRACE ( "]" ),
	LBRACK ( "{" ),
	RBRACK ( "}" ),
	SEMICOLON ( ";" ),
	COMMA ( "," ),
	DOT ( "." ),
	
	// Identifier
	IDENTIFIER( "=" ),
	
	// Literals
	INTEGER_LITERAL ( "?" ),
	FLOATING_POINT_LITERAL ( "\\" ),
	STRING_LITERAL ( "\"" ),
	CHARACTER_LITERAL ( "'" ),
	
	// End of File
	EOF ( "0" );
	
	// String representation of the token
	private final String name;
	
	/**
	 * <pre>
	 * Constructor
	 * The name is the character that will represent this token.
	 * </pre>
	 * @param name <b>String</b>
	 */
	private CTokenTypes( String name )
	{
		this.name= name;
	}
	
	/**
	 * Return the name as String
	 * @return <b>String</b> - name
	 */
	@Override
	public String toString()
	{
		return name;
	}
}