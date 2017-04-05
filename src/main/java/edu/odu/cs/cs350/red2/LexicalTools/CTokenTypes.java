package edu.odu.cs.cs350.red2.LexicalTools;


/**
 * C++ Token Types
 * @author mpark
 *
 */
public enum CTokenTypes implements TokenTypes
{
	// Common Reserved Words
	AUTO ( "a" ),
	BOOLEAN ( "b" ),
	BREAK ( "c" ),
	CASE ( "d" ),
	CATCH ( "e" ),
	CHAR ( "f" ),
	CLASS ( "g" ),
	CONST ( "h" ),
	CONTINUE ( "i" ),
	DEFAULT ( "j" ),
	DELETE ( "k" ),
	DO ( "l" ),
	DOUBLE ( "m" ),
	DYNAMIC_CAST ( "n" ),
	ELSE ( "o" ),
	ENUM ( "p" ),
	EXPLICIT ( "q" ),
	EXTERN ( "r" ),
	FLOAT ( "s" ),
	FOR ( "t" ),
	FRIEND ( "u" ),
	IF ( "v" ),
	INLINE ( "w" ),
	INT ( "x" ),
	LONG ( "y" ),
	NAMESPACE ( "1" ),
	NEW ( "2" ),
	OPERATOR ( "4" ),
	PRIVATE ( "5" ),
	PROTECTED ( "6" ),
	PUBLIC ( "7" ),
	RETURN ( "8" ),
	SHORT ( "9" ),
	SIGNED ( "A" ),
	SIZEOF ( "B" ),
	STATIC ( "C" ),
	STATIC_CAST ( "D" ),
	STRUCT ( "E" ),
	SWITCH ( "F" ),
	TEMPLATE ( "G" ),
	THIS ( "H" ),
	THROW ( "I" ),
	TRY ( "J" ),
	TYPEDEF ( "K" ),
	TYPENAME ( "L" ),
	UNSIGNED ( "M" ),
	USING ( "N" ),
	VIRTUAL ( "O" ),
	VOID ( "P" ),
	WHILE ( "Q" ),
	BOOLEAN_LITERAL ( "R" ),
	NULL_LITERAL ( "S" ),
	
	// Uncommon Reserved Words
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

	// Operators
	EQ ( "T" ),
	NOTEQ ( "U" ),
	EQEQ ( "V" ),
	GT ( "W" ),
	GTEQ ( "X" ),
	LT ( "Y" ),
	LTEQ ( "`" ),
	NOT ( "~" ),
	DIV ( "!" ), 
	MULT ( "@" ),
	MINUS ( "#" ),
	MINUSMINUS ( "$"),
	PLUS ( "%" ),
	PLUSPLUS ( "^" ),
	OR ( "&" ),
	OROR ( "*" ),
	AND ( "-" ),
	ANDAND ( "_" ),
	MOD ( "+" ),
	
	// Uncommon Operators
	COMP ( "Z" ),
	QUESTION ( "Z" ),
	COLON ( "Z" ),
	XOR ( "Z" ),
	LSHIFT ( "Z" ),
	RSHIFT ( "Z" ),
	URSHIFT ( "Z" ),
	XOREQ ( "Z" ),
	MODEQ ( "Z" ),
	LSHIFTEQ ( "Z" ),
	RSHIFTEQ ( "Z" ),
	URSHIFTEQ ( "Z" ),
	OREQ ( "Z" ),
	PLUSEQ ( "Z" ),
	MINUSEQ ( "Z" ),
	MULTEQ ( "Z" ),
	DIVEQ ( "Z" ),
	ANDEQ ( "Z" ),
	
	MEMBERACCESS ( "memberaccess" ),
	
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
	INTEGER_LITERAL ( "'" ),
	FLOATING_POINT_LITERAL ( "/" ),
	STRING_LITERAL ( "\"" ),
	CHARACTER_LITERAL ( "3" ),
	
	// End of File
	EOF ( "0" );
	
	// String representation of the token
	private final String name;
	
	/**
	 * Constructor
	 * @param name String
	 */
	private CTokenTypes( String name )
	{
		this.name= name;
	}
	
	/**
	 * Return String representation of this token type
	 */
	@Override
	public String toString()
	{
		return name;
	}
}