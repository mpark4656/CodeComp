/**
 * Testing jflex file
 * This is a very simple language. It has identifiers, integer literals, and a single keyword.
 * This is from http://forge350.cs.odu.edu:8090/zeil/jflexdemo/blob/master/src/main/jflex/demo.flex
 * Created by Steven Zeil
 *
 * @author mpark
 */

package edu.odu.cs.cs350.red2.LexicalTools;
@SuppressWarnings("unused")

%%

%public
%class GeneratedScanner

%line
%column

%type Token

%{
	StringBuilder string = new StringBuilder();
	
	private Token symbol( TokenTypes type ) {
		return new Token( type, yyline + 1, yycolumn + 1 );
	}
	
	private Token symbol( TokenTypes type , String value ) {
		return new Token( type , yyline + 1 , yycolumn + 1 , value );
	}
%}

/* Main Character Classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = [0-9][0-9]* | [0-9][_0-9]*[0-9]

Commentary = "//".*

%%

/* keywords */
"KEYWORD"			{ return symbol( TokenTypes.KEYWORD ); }

{IntegerLiteral}	{ return symbol(TokenTypes.INTEGER_LITERAL , yytext() ); }

{Identifier}		{ return symbol( TokenTypes.IDENTIFIER , yytext() ); }

{WhiteSpace}		{ /* Ignore */ }

{Commentary}		{ /* Ignore */ }

<<EOF>>				{ return symbol( TokenTypes.EOF ); }



