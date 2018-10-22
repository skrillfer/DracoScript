
package ANALIZADORES.LenguajeDracoScript;
import ESTRUCTURAS.*;
import java.util.LinkedList;
import java_cup.runtime.*;

%%
%{
   
%}

%class Analizador_LexSR
%public
%full
%unicode
%line
%column
%char
%ignorecase
%cup

LineTerminator = \r|\n|\r\n|\n\r|\t
WhiteSpace = {LineTerminator} | [ \t\f]|\t
Numero = [:digit:][[:digit:]]* 
Decimal = ([:digit:][[:digit:]]*)? ([.][:digit:][[:digit:]]*)?

Id = [:jletter:]["�"|"�"|"�"|"�"|"�"|[:jletterdigit:]|"_"|]*


Cadena = [\"] [^\"]* [\"]

CaracterL = [\'] [^\']* [\']


Nulo   = "nulo" | "\'\\u0000\'"

Comentario1 = "$*" ["*"]* [^*] ~"*$" | "$*" ["*"]* "*$"
Comentario2 = "$$" [^\r\n]* [^\r\n]


%%

/*ARITMETICOS*/
<YYINITIAL> "+" {return new Symbol(sym.MAS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "-" {return new Symbol(sym.MENOS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "*" {return new Symbol(sym.POR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "/" {return new Symbol(sym.DIV, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "^" {return new Symbol(sym.POT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "%" {return new Symbol(sym.MOD, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "++" {return new Symbol(sym.INC, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "--" {return new Symbol(sym.DEC, new token(yycolumn, yyline, yytext()));}

/*RELACIONALES*/
<YYINITIAL> "==" {return new Symbol(sym.IG_IG, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<" {return new Symbol(sym.MENQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<=" {return new Symbol(sym.MENIQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ">" {return new Symbol(sym.MAYQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ">=" {return new Symbol(sym.MAYIQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<>" {return new Symbol(sym.DIF, new token(yycolumn, yyline, yytext()));}

/*LOGICOS*/

<YYINITIAL> "||" {return new Symbol(sym.OR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "&&" {return new Symbol(sym.AND, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "!" {return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> "(" {return new Symbol(sym.APAR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ")" {return new Symbol(sym.CPAR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "{" {return new Symbol(sym.ALLA, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "}" {return new Symbol(sym.CLLA, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "[" {return new Symbol(sym.ACORCH, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "]" {return new Symbol(sym.CCORCH, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "=" {return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ";" {return new Symbol(sym.PYC, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ":" {return new Symbol(sym.DSPTS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "." {return new Symbol(sym.PTO, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "," {return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> "var" {return new Symbol(sym.VAR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "if" {return new Symbol(sym.IF, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "elif" {return new Symbol(sym.ELIF, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "not" {return new Symbol(sym.NO_T, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "smash" {return new Symbol(sym.SMASH, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "while" {return new Symbol(sym.WHILE, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "for" {return new Symbol(sym.FOR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "print" {return new Symbol(sym.PRINT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "runmultdasm" {return new Symbol(sym.RUNMULTDASM, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "point" {return new Symbol(sym.POINT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "quadrate" {return new Symbol(sym.QUADRATE, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "oval" {return new Symbol(sym.OVAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "string" {return new Symbol(sym.STRING, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "line" {return new Symbol(sym.LINE, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> "true" {return new Symbol(sym.TRUE, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "false" {return new Symbol(sym.FALSE, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> {Nulo} {return new Symbol(sym.NULO, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Numero} {return new Symbol(sym.NUM_LITERAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> {Decimal} {return new Symbol(sym.DECIMAL_LITERAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> {Id} {return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> {CaracterL} {return new Symbol(sym.CHAR_LITERAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> {Cadena} {return new Symbol(sym.STRING_LITERAL, new token(yycolumn, yyline, yytext()));}



{LineTerminator} {/* ignorar */}
{WhiteSpace} {/* ignorar */}
. {System.err.println(yyline+","+yycolumn+"=["+yytext()+"],"+yychar); }


