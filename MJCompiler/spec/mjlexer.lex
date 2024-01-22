
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%


%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn, value);
	}

%}


%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}


%%

" " {}
"\b" {}
"\t" {}
"\r\n" {}
"\f" {}

"true"|"false" { return new_symbol(sym.BOOLEAN, yytext()); }
"namespace" { return new_symbol(sym.NAMESPACE, yytext()); }
"program" { return new_symbol(sym.PROG, yytext()); }
"return" { return new_symbol(sym.RETURN, yytext()); }
"print" { return new_symbol(sym.PRINT, yytext()); }
"const" { return new_symbol(sym.CONST, yytext()); }
"read" { return new_symbol(sym.READ, yytext()); }
"new" { return new_symbol(sym.NEW, yytext()); }

"++" { return new_symbol(sym.PLUSPLUS, yytext()); }
"--" { return new_symbol(sym.MINUSMINUS, yytext()); }
"*" { return new_symbol(sym.MUL, yytext()); }
"/" { return new_symbol(sym.DIV, yytext()); }
"+" { return new_symbol(sym.PLUS, yytext()); }
"-" { return new_symbol(sym.MINUS, yytext()); }
"%" { return new_symbol(sym.PERCENT, yytext()); }
"=" { return new_symbol(sym.EQUAL, yytext()); }

"(" { return new_symbol(sym.LPAREN, yytext()); }
"[" { return new_symbol(sym.LBRACKET, yytext()); }
"{" { return new_symbol(sym.LBRACE, yytext()); }
")" { return new_symbol(sym.RPAREN, yytext()); }
"]" { return new_symbol(sym.RBRACKET, yytext()); }
"}" { return new_symbol(sym.RBRACE, yytext()); }

"\'"[a-z|A-Z|0-9|_]"\'" { return new_symbol(sym.CHARACTER, yytext()); }
"::" { return new_symbol(sym.COLONCOLON, yytext()); }
"\." { return new_symbol(sym.DOT, yytext()); }
"'" { return new_symbol(sym.QUOTATION, yytext()); }
"\"" { return new_symbol(sym.DOUBLEQUOTES, yytext()); }
";" { return new_symbol(sym.SEMI, yytext()); }
"," { return new_symbol(sym.COMMA, yytext()); }
":" { return new_symbol(sym.COLON, yytext()); }

"//" { yybegin(COMMENT); }
<COMMENT> . { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+ { return new_symbol(sym.NUMBER, Integer.parseInt(yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* { return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska (" + yytext() + ") u liniji " + (yyline + 1)); }







