package INTERPRETE_PILA.GRAMATICA;
import ESTRUCTURAS.*;
import java.util.LinkedList;
import java_cup.runtime.*;

%%
%{
   
%}

%class LexicoDasm
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

eti = ["$"]{Id}

Comentario1 = "//" [^\r\n]* [^\r\n]

%%

/*ARITMETICOS*/
{Comentario1}   {/* ignorar */}

<YYINITIAL> "-" {return new Symbol(sym.SIG_MENOS, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "add" {return new Symbol(sym.ADD, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "diff" {return new Symbol(sym.DIFF, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "mult" {return new Symbol(sym.MULT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "div" {return new Symbol(sym.DIV, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "pot" {return new Symbol(sym.POT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "mod" {return new Symbol(sym.MOD, new token(yycolumn, yyline, yytext()));}


/*RELACIONALES*/
<YYINITIAL> "$$_outstr" {return new Symbol(sym.OUT_STR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_noIgual" {return new Symbol(sym.NOIGUAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_igualIgual" {return new Symbol(sym.IGUALIGUAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "$$_menor" {return new Symbol(sym.MENOR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_menorIgual" {return new Symbol(sym.MENORIGUAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_mayor" {return new Symbol(sym.MAYOR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_mayorIgual" {return new Symbol(sym.MAYORIGUAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_getStr" {return new Symbol(sym.GETSTR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_getInt" {return new Symbol(sym.GETINT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$$_concat" {return new Symbol(sym.CONCAT, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> "eqz" {return new Symbol(sym.EQZ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "lt" {return new Symbol(sym.LT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "lte" {return new Symbol(sym.LTE, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "gt" {return new Symbol(sym.GT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "gte" {return new Symbol(sym.GTE, new token(yycolumn, yyline, yytext()));}


/*LOGICOS*/

<YYINITIAL> "or"            {return new Symbol(sym.OR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "and"           {return new Symbol(sym.AND, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "not"           {return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));}

/*OTROS*/
<YYINITIAL> "function"      {return new Symbol(sym.FUNCTION, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "end"      {return new Symbol(sym.END, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "set_local"     {return new Symbol(sym.SET_LOCAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "set_global"    {return new Symbol(sym.SET_GLOBAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "get_local"     {return new Symbol(sym.GET_LOCAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "get_global"    {return new Symbol(sym.GET_GLOBAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "br_if"         {return new Symbol(sym.BR_IF, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "br"            {return new Symbol(sym.BR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "print"         {return new Symbol(sym.PRINT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "%c"            {return new Symbol(sym.F_CHAR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "%d"            {return new Symbol(sym.D_CHAR, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "$calc"         {return new Symbol(sym.C4LC, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "$ret"          {return new Symbol(sym.R3T, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "call"          {return new Symbol(sym.CALL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {eti}         {return new Symbol(sym.ETIQUETA, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> {Numero}        {return new Symbol(sym.NUMERO, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Decimal}       {return new Symbol(sym.DECIMAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Id}            {return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));}



{LineTerminator} {/* ignorar */}
{WhiteSpace} {/* ignorar */}
. {System.err.println(yyline+","+yycolumn+"=["+yytext()+"],"+yychar); }


