/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2009  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 * Modified by mpark                                                       *
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

%%

%public
%class JavaScanner

%line
%column

%unicode
%type Token


%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(JTokenTypes type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

  private Token symbol(JTokenTypes type, Object value) {
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

Annotation = "@" {InputCharacter}* {LineTerminator}?

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
  "abstract"                     { return symbol(JTokenTypes.ABSTRACT); }
  "boolean"                      { return symbol(JTokenTypes.BOOLEAN); }
  "break"                        { return symbol(JTokenTypes.BREAK); }
  "byte"                         { return symbol(JTokenTypes.BYTE); }
  "case"                         { return symbol(JTokenTypes.CASE); }
  "catch"                        { return symbol(JTokenTypes.CATCH); }
  "char"                         { return symbol(JTokenTypes.CHAR); }
  "class"                        { return symbol(JTokenTypes.CLASS); }
  "const"                        { return symbol(JTokenTypes.CONST); }
  "continue"                     { return symbol(JTokenTypes.CONTINUE); }
  "do"                           { return symbol(JTokenTypes.DO); }
  "double"                       { return symbol(JTokenTypes.DOUBLE); }
  "else"                         { return symbol(JTokenTypes.ELSE); }
  "enum"						 { return symbol(JTokenTypes.ENUM); }
  "extends"                      { return symbol(JTokenTypes.EXTENDS); }
  "final"                        { return symbol(JTokenTypes.FINAL); }
  "finally"                      { return symbol(JTokenTypes.FINALLY); }
  "float"                        { return symbol(JTokenTypes.FLOAT); }
  "for"                          { return symbol(JTokenTypes.FOR); }
  "default"                      { return symbol(JTokenTypes.DEFAULT); }
  "implements"                   { return symbol(JTokenTypes.IMPLEMENTS); }
  "import"                       { return symbol(JTokenTypes.IMPORT); }
  "instanceof"                   { return symbol(JTokenTypes.INSTANCEOF); }
  "int"                          { return symbol(JTokenTypes.INT); }
  "interface"                    { return symbol(JTokenTypes.INTERFACE); }
  "long"                         { return symbol(JTokenTypes.LONG); }
  "native"                       { return symbol(JTokenTypes.NATIVE); }
  "new"                          { return symbol(JTokenTypes.NEW); }
  "goto"                         { return symbol(JTokenTypes.GOTO); }
  "if"                           { return symbol(JTokenTypes.IF); }
  "public"                       { return symbol(JTokenTypes.PUBLIC); }
  "short"                        { return symbol(JTokenTypes.SHORT); }
  "super"                        { return symbol(JTokenTypes.SUPER); }
  "switch"                       { return symbol(JTokenTypes.SWITCH); }
  "synchronized"                 { return symbol(JTokenTypes.SYNCHRONIZED); }
  "package"                      { return symbol(JTokenTypes.PACKAGE); }
  "private"                      { return symbol(JTokenTypes.PRIVATE); }
  "protected"                    { return symbol(JTokenTypes.PROTECTED); }
  "transient"                    { return symbol(JTokenTypes.TRANSIENT); }
  "return"                       { return symbol(JTokenTypes.RETURN); }
  "void"                         { return symbol(JTokenTypes.VOID); }
  "static"                       { return symbol(JTokenTypes.STATIC); }
  "while"                        { return symbol(JTokenTypes.WHILE); }
  "this"                         { return symbol(JTokenTypes.THIS); }
  "throw"                        { return symbol(JTokenTypes.THROW); }
  "throws"                       { return symbol(JTokenTypes.THROWS); }
  "try"                          { return symbol(JTokenTypes.TRY); }
  "volatile"                     { return symbol(JTokenTypes.VOLATILE); }
  "strictfp"                     { return symbol(JTokenTypes.STRICTFP); }
  
  /* boolean literals */
  "true"                         { return symbol(JTokenTypes.BOOLEAN_LITERAL, true); }
  "false"                        { return symbol(JTokenTypes.BOOLEAN_LITERAL, false); }
  
  /* null literal */
  "null"                         { return symbol(JTokenTypes.NULL_LITERAL); }
  
  
  /* separators */
  "("                            { return symbol(JTokenTypes.LPAREN); }
  ")"                            { return symbol(JTokenTypes.RPAREN); }
  "{"                            { return symbol(JTokenTypes.LBRACE); }
  "}"                            { return symbol(JTokenTypes.RBRACE); }
  "["                            { return symbol(JTokenTypes.LBRACK); }
  "]"                            { return symbol(JTokenTypes.RBRACK); }
  ";"                            { return symbol(JTokenTypes.SEMICOLON); }
  ","                            { return symbol(JTokenTypes.COMMA); }
  "."                            { return symbol(JTokenTypes.DOT); }
  
  /* operators */
  "="                            { return symbol(JTokenTypes.EQ); }
  ">"                            { return symbol(JTokenTypes.GT); }
  "<"                            { return symbol(JTokenTypes.LT); }
  "!"                            { return symbol(JTokenTypes.NOT); }
  "~"                            { return symbol(JTokenTypes.COMP); }
  "?"                            { return symbol(JTokenTypes.QUESTION); }
  ":"                            { return symbol(JTokenTypes.COLON); }
  "=="                           { return symbol(JTokenTypes.EQEQ); }
  "<="                           { return symbol(JTokenTypes.LTEQ); }
  ">="                           { return symbol(JTokenTypes.GTEQ); }
  "!="                           { return symbol(JTokenTypes.NOTEQ); }
  "&&"                           { return symbol(JTokenTypes.ANDAND); }
  "||"                           { return symbol(JTokenTypes.OROR); }
  "++"                           { return symbol(JTokenTypes.PLUSPLUS); }
  "--"                           { return symbol(JTokenTypes.MINUSMINUS); }
  "+"                            { return symbol(JTokenTypes.PLUS); }
  "-"                            { return symbol(JTokenTypes.MINUS); }
  "*"                            { return symbol(JTokenTypes.MULT); }
  "/"                            { return symbol(JTokenTypes.DIV); }
  "&"                            { return symbol(JTokenTypes.AND); }
  "|"                            { return symbol(JTokenTypes.OR); }
  "^"                            { return symbol(JTokenTypes.XOR); }
  "%"                            { return symbol(JTokenTypes.MOD); }
  "<<"                           { return symbol(JTokenTypes.LSHIFT); }
  ">>"                           { return symbol(JTokenTypes.RSHIFT); }
  ">>>"                          { return symbol(JTokenTypes.URSHIFT); }
  "+="                           { return symbol(JTokenTypes.PLUSEQ); }
  "-="                           { return symbol(JTokenTypes.MINUSEQ); }
  "*="                           { return symbol(JTokenTypes.MULTEQ); }
  "/="                           { return symbol(JTokenTypes.DIVEQ); }
  "&="                           { return symbol(JTokenTypes.ANDEQ); }
  "|="                           { return symbol(JTokenTypes.OREQ); }
  "^="                           { return symbol(JTokenTypes.XOREQ); }
  "%="                           { return symbol(JTokenTypes.MODEQ); }
  "<<="                          { return symbol(JTokenTypes.LSHIFTEQ); }
  ">>="                          { return symbol(JTokenTypes.RSHIFTEQ); }
  ">>>="                         { return symbol(JTokenTypes.URSHIFTEQ); }
  
  /* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }

  /* numeric literals */

  /* This is matched together with the minus, because the number is too big to 
     be represented by a positive integer. */
  "-2147483648"                  { return symbol(JTokenTypes.INTEGER_LITERAL, new Integer(Integer.MIN_VALUE)); }
  
  {DecIntegerLiteral}            { return symbol(JTokenTypes.INTEGER_LITERAL, new Integer(yytext())); }
  {DecLongLiteral}               { return symbol(JTokenTypes.INTEGER_LITERAL, new Long(yytext().substring(0,yylength()-1))); }
  
  {HexIntegerLiteral}            { return symbol(JTokenTypes.INTEGER_LITERAL, new Integer((int) parseLong(2, yylength(), 16))); }
  {HexLongLiteral}               { return symbol(JTokenTypes.INTEGER_LITERAL, new Long(parseLong(2, yylength()-1, 16))); }
 
  {OctIntegerLiteral}            { return symbol(JTokenTypes.INTEGER_LITERAL, new Integer((int) parseLong(0, yylength(), 8))); }  
  {OctLongLiteral}               { return symbol(JTokenTypes.INTEGER_LITERAL, new Long(parseLong(0, yylength()-1, 8))); }
  
  {FloatLiteral}                 { return symbol(JTokenTypes.FLOATING_POINT_LITERAL, new Float(yytext().substring(0,yylength()-1))); }
  {DoubleLiteral}                { return symbol(JTokenTypes.FLOATING_POINT_LITERAL, new Double(yytext())); }
  {DoubleLiteral}[dD]            { return symbol(JTokenTypes.FLOATING_POINT_LITERAL, new Double(yytext().substring(0,yylength()-1))); }
  
  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */ 
  {Identifier}                   { return symbol(JTokenTypes.IDENTIFIER, yytext()); } 
  
  {Annotation}					 { /* ignore */ } 
}

<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(JTokenTypes.STRING_LITERAL, string.toString()); }
  
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
  \\.                            { /* throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); */ }
  {LineTerminator}               { /* throw new RuntimeException("Unterminated string at end of line"); */ }
}

<CHARLITERAL> {
  {SingleCharacter}\'            { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, yytext().charAt(0)); }
  
  /* escape sequences */
  "\\b"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\b');}
  "\\t"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\t');}
  "\\n"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\n');}
  "\\f"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\f');}
  "\\r"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\r');}
  "\\\""\'                       { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\"');}
  "\\'"\'                        { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\'');}
  "\\\\"\'                       { yybegin(YYINITIAL); return symbol(JTokenTypes.CHARACTER_LITERAL, '\\'); }
  \\[0-3]?{OctDigit}?{OctDigit}\' { yybegin(YYINITIAL); 
			                              int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                            return symbol(JTokenTypes.CHARACTER_LITERAL, (char)val); }
  
  /* error cases */
  \\.                            { /* throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); */ }
  {LineTerminator}               { /* throw new RuntimeException("Unterminated character literal at end of line"); */ }
}

/* error fallback */
.|\n                             { /* throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); */ }

<<EOF>>                          { return symbol(JTokenTypes.EOF); }
