package edu.odu.cs.cs350.red2.LexicalTools;

/**
 * Enumeration for Token Types, 
 * Mainly Divided into 5 Parts 
 * 1. Reserved Words
 * 2. Operators
 * 3. Separators
 * 4. Identifier
 * 5. Literals
 * This will combine both C++ and Java Token Types
 * 
 * @author mpark
 *
 */
public enum TokenTypes
{
	// Reserved Words
	ABSTRACT ("abstract"),
	ALIGNAS ( "alignas" ),
	ALIGNOF ( "alignof" ),
	ASM ( "asm" ),
	ATOMIC_CANCEL ( "atomic_cancel" ),
	ATOMIC_COMMIT ( "atomic_commit" ),
	ATOMIC_NOEXCEPT ( "atomic_noexcept" ),
	AUTO ( "auto" ),
	BOOLEAN ( "boolean" ),
	BREAK ( "break" ),
	BYTE ( "byte" ),
	CASE ( "case" ),
	CATCH ( "catch" ),
	CHAR ( "char" ),
	CHAR16T ( "char16_t" ),
	CHAR32T ( "char32_t" ),
	CLASS ( "class" ),
	COMPL ( "compl" ),
	CONCEPT ( "concept" ),
	CONST ( "const" ),
	CONSTEXPR ( "constexpr" ),
	CONSTCAST ( "const_cast" ),
	CONTINUE ( "continue" ),
	DECLTYPE ( "decltype" ),
	DEFAULT ( "default" ),
	DELETE ( "delete" ),
	DO ( "do" ),
	DOUBLE ( "double" ),
	DYNAMIC_CAST ( "dynamic_cast" ),
	ELSE ( "else" ),
	ENUM ( "enum" ),
	EXPLICIT ( "explicit" ),
	EXPORT ( "export" ),
	EXTERN ( "extern" ),
	EXTENDS ( "extends" ),
	FINAL ( "final" ),
	FINALLY ( "finally" ),
	FLOAT ( "float" ),
	FOR ( "for" ),
	FRIEND ( "friend" ),
	GOTO ( "goto" ),
	IF ( "if" ),
	IMPLEMENTS ( "implements" ),
	IMPORT ( "import" ),
	INLINE ( "inline" ),
	INSTANCEOF ( "instanceof" ),
	INT ( "int" ),
	INTERFACE ( "interface" ),
	LONG ( "long" ),
	MODULE ( "module" ),
	MUTABLE ( "mutable" ),
	NAMESPACE ( "namespace" ),
	NATIVE ( "native" ),
	NEW ( "new" ),
	NOEXCEPT ( "noexcept" ),
	OPERATOR ( "operator" ),
	PUBLIC ( "public" ),
	REGISTER ( "register" ),
	REINTERPRET_CAST ( "reinterpret_cast" ),
	REQUIRES ( "requires" ),
	SHORT ( "short" ),
	SIGNED ( "signed" ),
	SIZEOF ( "sizeof" ),
	STATIC_ASSERT ( "static_assert" ),
	STATIC_CAST ( "static_cast" ),
	STRUCT ( "struct" ),
	SUPER ( "super" ),
	SWITCH ( "switch" ),
	SYNCHRONIZED ( "synchronized" ),
	PACKAGE ( "package" ),
	PRIVATE ( "private" ),
	PROTECTED ( "protected" ),
	TRANSIENT ( "transient" ),
	RETURN ( "return" ),
	VOID ( "void" ),
	STATIC ( "static" ),
	STRICTFP ( "strictfp" ),
	TEMPLATE ( "template" ),
	THIS ( "this" ),
	THREAD_LOCAL ( "thread_local" ),
	THROW ( "throw" ),
	THROWS ( "throws" ),
	TRY ( "try" ),
	TYPEDEF ( "typedef" ),
	TYPEID ( "typeid" ),
	TYPENAME ( "typename" ),
	UNION ( "union" ),
	UNSIGNED ( "unsigned" ),
	USING ( "using" ),
	VIRTUAL ( "virtual" ),
	VOLATILE ( "volatile" ),
	WCHART ( "wchar_t" ),
	WHILE ( "while" ),
	BOOLEAN_LITERAL ( "boolean_literal" ),
	NULL_LITERAL ( "null_literal" ),
	
	// Operators
	EQ ( "eq" ),
	NOTEQ ( "noteq" ),
	EQEQ ( "eqeq" ),
	GT ( "gt" ),
	GTEQ ( "gteq" ),
	LT ( "lt" ),
	LTEQ ( "lteq" ),
	NOT ( "not" ),
	COMP ( "comp" ),
	QUESTION ( "question" ),
	COLON ( "colon" ),
	DIV ( "div" ), 
	MULT ( "mult" ),
	MINUS ( "minus" ),
	MINUSMINUS ( "minusminus"),
	PLUS ( "plus" ),
	PLUSPLUS ( "plusplus" ),
	OR ( "or" ),
	OROR ( "oror" ),
	XOR ( "xor" ),
	AND ( "and" ),
	ANDAND ( "andand" ),
	MOD ( "mod" ),
	LSHIFT ( "lshift" ),
	RSHIFT ( "rshift" ),
	URSHIFT ( "urshift" ),
	PLUSEQ ( "pluseq" ),
	MINUSEQ ( "minuseq" ),
	MULTEQ ( "multeq" ),
	DIVEQ ( "diveq" ),
	ANDEQ ( "andeq" ),
	OREQ ( "oreq" ),
	XOREQ ( "xoreq" ),
	MODEQ ( "modeq" ),
	LSHIFTEQ ( "lshifteq" ),
	RSHIFTEQ ( "rshifteq" ),
	URSHIFTEQ ( "urshifteq" ),
	MEMBERACCESS ( "memberaccess" ),
	
	// Separators
	LPAREN ( "lparen" ),
	RPAREN ( "rparen" ),
	LBRACE ( "lbrace" ),
	RBRACE ( "rbrace" ),
	LBRACK ( "lbrack" ),
	RBRACK ( "rbrack" ),
	SEMICOLON ( "semicolon" ),
	COMMA ( "comma" ),
	DOT ( "dot" ),
	
	// Identifier
	IDENTIFIER( "identifier" ),
	
	// Literals
	INTEGER_LITERAL ( "integer_literal" ),
	FLOATING_POINT_LITERAL ( "floating_point_literal" ),
	STRING_LITERAL ( "string_literal" ),
	CHARACTER_LITERAL ( "character_literal" ),
	
	// End of File
	EOF ( "eof" );
	
	// String representation of the token
	private final String name;
	
	/**
	 * Constructor
	 * @param name String
	 */
	private TokenTypes( String name )
	{
		this.name = name;
	}
	
	/**
	 * Override toString() method
	 * @return String Returns the type of token in String
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
}
