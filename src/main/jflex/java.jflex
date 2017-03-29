/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2009  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* Java 1.2 language lexer specification */

/* Use together with unicode.flex for Unicode preprocesssing */
/* and java12.cup for a Java 1.2 parser                      */

/* Note that this lexer specification is not tuned for speed.
   It is in fact quite slow on integer and floating point literals, 
   because the input is read twice and the methods used to parse
   the numbers are not very fast. 
   For a production quality application (e.g. a Java compiler) 
   this could be optimized */


package edu.odu.cs.cs350.red2.LexicalTools;
import java_cup.runtime.*;

%%

%public
%class Scanner

%line
%column

%unicode
%type Token


%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenTypes type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

  private Token symbol(TokenTypes type, Object value) {
    return new Token(type, yyline+1, yycolumn+1, value);
  }

  /** 
   * assumes correct representation of a long value for 
   * specified radix in scanner buffer from <code>start</code> 
   * to <code>end</code> 
   */
  private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i),radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecIntegerLiteral} [lL]

HexIntegerLiteral = 0 [xX] 0* {HexDigit} {1,8}
HexLongLiteral    = 0 [xX] 0* {HexDigit} {1,16} [lL]
HexDigit          = [0-9a-fA-F]

OctIntegerLiteral = 0+ [1-3]? {OctDigit} {1,15}
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
OctDigit          = [0-7]
    
/* floating point literals */        
FloatLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* keywords */
  "abstract"                     { return symbol(TokenTypes.ABSTRACT); }
  "boolean"                      { return symbol(TokenTypes.BOOLEAN); }
  "break"                        { return symbol(TokenTypes.BREAK); }
  "byte"                         { return symbol(TokenTypes.BYTE); }
  "case"                         { return symbol(TokenTypes.CASE); }
  "catch"                        { return symbol(TokenTypes.CATCH); }
  "char"                         { return symbol(TokenTypes.CHAR); }
  "class"                        { return symbol(TokenTypes.CLASS); }
  "const"                        { return symbol(TokenTypes.CONST); }
  "continue"                     { return symbol(TokenTypes.CONTINUE); }
  "do"                           { return symbol(TokenTypes.DO); }
  "double"                       { return symbol(TokenTypes.DOUBLE); }
  "else"                         { return symbol(TokenTypes.ELSE); }
  "extends"                      { return symbol(TokenTypes.EXTENDS); }
  "final"                        { return symbol(TokenTypes.FINAL); }
  "finally"                      { return symbol(TokenTypes.FINALLY); }
  "float"                        { return symbol(TokenTypes.FLOAT); }
  "for"                          { return symbol(TokenTypes.FOR); }
  "default"                      { return symbol(TokenTypes.DEFAULT); }
  "implements"                   { return symbol(TokenTypes.IMPLEMENTS); }
  "import"                       { return symbol(TokenTypes.IMPORT); }
  "instanceof"                   { return symbol(TokenTypes.INSTANCEOF); }
  "int"                          { return symbol(TokenTypes.INT); }
  "interface"                    { return symbol(TokenTypes.INTERFACE); }
  "long"                         { return symbol(TokenTypes.LONG); }
  "native"                       { return symbol(TokenTypes.NATIVE); }
  "new"                          { return symbol(TokenTypes.NEW); }
  "goto"                         { return symbol(TokenTypes.GOTO); }
  "if"                           { return symbol(TokenTypes.IF); }
  "public"                       { return symbol(TokenTypes.PUBLIC); }
  "short"                        { return symbol(TokenTypes.SHORT); }
  "super"                        { return symbol(TokenTypes.SUPER); }
  "switch"                       { return symbol(TokenTypes.SWITCH); }
  "synchronized"                 { return symbol(TokenTypes.SYNCHRONIZED); }
  "package"                      { return symbol(TokenTypes.PACKAGE); }
  "private"                      { return symbol(TokenTypes.PRIVATE); }
  "protected"                    { return symbol(TokenTypes.PROTECTED); }
  "transient"                    { return symbol(TokenTypes.TRANSIENT); }
  "return"                       { return symbol(TokenTypes.RETURN); }
  "void"                         { return symbol(TokenTypes.VOID); }
  "static"                       { return symbol(TokenTypes.STATIC); }
  "while"                        { return symbol(TokenTypes.WHILE); }
  "this"                         { return symbol(TokenTypes.THIS); }
  "throw"                        { return symbol(TokenTypes.THROW); }
  "throws"                       { return symbol(TokenTypes.THROWS); }
  "try"                          { return symbol(TokenTypes.TRY); }
  "volatile"                     { return symbol(TokenTypes.VOLATILE); }
  "strictfp"                     { return symbol(TokenTypes.STRICTFP); }
  
  /* boolean literals */
  "true"                         { return symbol(TokenTypes.BOOLEAN_LITERAL, true); }
  "false"                        { return symbol(TokenTypes.BOOLEAN_LITERAL, false); }
  
  /* null literal */
  "null"                         { return symbol(TokenTypes.NULL_LITERAL); }
  
  
  /* separators */
  "("                            { return symbol(TokenTypes.LPAREN); }
  ")"                            { return symbol(TokenTypes.RPAREN); }
  "{"                            { return symbol(TokenTypes.LBRACE); }
  "}"                            { return symbol(TokenTypes.RBRACE); }
  "["                            { return symbol(TokenTypes.LBRACK); }
  "]"                            { return symbol(TokenTypes.RBRACK); }
  ";"                            { return symbol(TokenTypes.SEMICOLON); }
  ","                            { return symbol(TokenTypes.COMMA); }
  "."                            { return symbol(TokenTypes.DOT); }
  
  /* operators */
  "="                            { return symbol(TokenTypes.EQ); }
  ">"                            { return symbol(TokenTypes.GT); }
  "<"                            { return symbol(TokenTypes.LT); }
  "!"                            { return symbol(TokenTypes.NOT); }
  "~"                            { return symbol(TokenTypes.COMP); }
  "?"                            { return symbol(TokenTypes.QUESTION); }
  ":"                            { return symbol(TokenTypes.COLON); }
  "=="                           { return symbol(TokenTypes.EQEQ); }
  "<="                           { return symbol(TokenTypes.LTEQ); }
  ">="                           { return symbol(TokenTypes.GTEQ); }
  "!="                           { return symbol(TokenTypes.NOTEQ); }
  "&&"                           { return symbol(TokenTypes.ANDAND); }
  "||"                           { return symbol(TokenTypes.OROR); }
  "++"                           { return symbol(TokenTypes.PLUSPLUS); }
  "--"                           { return symbol(TokenTypes.MINUSMINUS); }
  "+"                            { return symbol(TokenTypes.PLUS); }
  "-"                            { return symbol(TokenTypes.MINUS); }
  "*"                            { return symbol(TokenTypes.MULT); }
  "/"                            { return symbol(TokenTypes.DIV); }
  "&"                            { return symbol(TokenTypes.AND); }
  "|"                            { return symbol(TokenTypes.OR); }
  "^"                            { return symbol(TokenTypes.XOR); }
  "%"                            { return symbol(TokenTypes.MOD); }
  "<<"                           { return symbol(TokenTypes.LSHIFT); }
  ">>"                           { return symbol(TokenTypes.RSHIFT); }
  ">>>"                          { return symbol(TokenTypes.URSHIFT); }
  "+="                           { return symbol(TokenTypes.PLUSEQ); }
  "-="                           { return symbol(TokenTypes.MINUSEQ); }
  "*="                           { return symbol(TokenTypes.MULTEQ); }
  "/="                           { return symbol(TokenTypes.DIVEQ); }
  "&="                           { return symbol(TokenTypes.ANDEQ); }
  "|="                           { return symbol(TokenTypes.OREQ); }
  "^="                           { return symbol(TokenTypes.XOREQ); }
  "%="                           { return symbol(TokenTypes.MODEQ); }
  "<<="                          { return symbol(TokenTypes.LSHIFTEQ); }
  ">>="                          { return symbol(TokenTypes.RSHIFTEQ); }
  ">>>="                         { return symbol(TokenTypes.URSHIFTEQ); }
  
  /* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }

  /* numeric literals */

  /* This is matched together with the minus, because the number is too big to 
     be represented by a positive integer. */
  "-2147483648"                  { return symbol(TokenTypes.INTEGER_LITERAL, new Integer(Integer.MIN_VALUE)); }
  
  {DecIntegerLiteral}            { return symbol(TokenTypes.INTEGER_LITERAL, new Integer(yytext())); }
  {DecLongLiteral}               { return symbol(TokenTypes.INTEGER_LITERAL, new Long(yytext().substring(0,yylength()-1))); }
  
  {HexIntegerLiteral}            { return symbol(TokenTypes.INTEGER_LITERAL, new Integer((int) parseLong(2, yylength(), 16))); }
  {HexLongLiteral}               { return symbol(TokenTypes.INTEGER_LITERAL, new Long(parseLong(2, yylength()-1, 16))); }
 
  {OctIntegerLiteral}            { return symbol(TokenTypes.INTEGER_LITERAL, new Integer((int) parseLong(0, yylength(), 8))); }  
  {OctLongLiteral}               { return symbol(TokenTypes.INTEGER_LITERAL, new Long(parseLong(0, yylength()-1, 8))); }
  
  {FloatLiteral}                 { return symbol(TokenTypes.FLOATING_POINT_LITERAL, new Float(yytext().substring(0,yylength()-1))); }
  {DoubleLiteral}                { return symbol(TokenTypes.FLOATING_POINT_LITERAL, new Double(yytext())); }
  {DoubleLiteral}[dD]            { return symbol(TokenTypes.FLOATING_POINT_LITERAL, new Double(yytext().substring(0,yylength()-1))); }
  
  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */ 
  {Identifier}                   { return symbol(TokenTypes.IDENTIFIER, yytext()); }  
}

<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(TokenTypes.STRING_LITERAL, string.toString()); }
  
  {StringCharacter}+             { string.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\[0-3]?{OctDigit}?{OctDigit}  { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   string.append( val ); }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<CHARLITERAL> {
  {SingleCharacter}\'            { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, yytext().charAt(0)); }
  
  /* escape sequences */
  "\\b"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\b');}
  "\\t"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\t');}
  "\\n"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\n');}
  "\\f"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\f');}
  "\\r"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\r');}
  "\\\""\'                       { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\"');}
  "\\'"\'                        { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\'');}
  "\\\\"\'                       { yybegin(YYINITIAL); return symbol(TokenTypes.CHARACTER_LITERAL, '\\'); }
  \\[0-3]?{OctDigit}?{OctDigit}\' { yybegin(YYINITIAL); 
			                              int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                            return symbol(TokenTypes.CHARACTER_LITERAL, (char)val); }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated character literal at end of line"); }
}

/* error fallback */
.|\n                             { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(TokenTypes.EOF); }