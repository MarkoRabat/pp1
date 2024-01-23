
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;


%%

%{
	// pravi token na osnovu tipa
	// ukljucuje informacije o poziciji tokena iz izvornog mj koda
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// pravi token i na osnovu tipa i na osnovu njegove vrednosti
	// ukljucuje informacije o poziciji tokena iz izvornog mj koda
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
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

" "    {}
"\b"   {}
"\t"   {}
"\r\n" {}
"\f"   {}

"program"   { return new_symbol(sym.PROG, yytext());        }
"namespace" { return new_symbol(sym.NAMESPACE, yytext());   }
"print"     { return new_symbol(sym.PRINT, yytext());       }
"read"      { return new_symbol(sym.READ, yytext());        }
"return"    { return new_symbol(sym.RETURN, yytext()); 	    }
"const"     { return new_symbol(sym.CONST, yytext());        }
"void"      { return new_symbol(sym.VOID, yytext());        }
"new"       { return new_symbol(sym.NEW, yytext());         }
"++" 	    { return new_symbol(sym.DOUBLEPLUS, yytext());  }
"--" 	    { return new_symbol(sym.DOUBLEMINUS, yytext()); }
"*" 	    { return new_symbol(sym.MUL, yytext());         }
"/" 	    { return new_symbol(sym.DIV, yytext());         }
"%" 	    { return new_symbol(sym.PERCENT, yytext());     }
"+" 	    { return new_symbol(sym.PLUS, yytext());        }
"-" 	    { return new_symbol(sym.MINUS, yytext());        }
"=" 	    { return new_symbol(sym.EQUAL, yytext());       }
";" 	    { return new_symbol(sym.SEMI, yytext());        }
"," 	    { return new_symbol(sym.COMMA, yytext());       }
"(" 	    { return new_symbol(sym.LPAREN, yytext());      }
")" 	    { return new_symbol(sym.RPAREN, yytext());      }
"[" 	    { return new_symbol(sym.LBRACKET, yytext());    }
"]" 	    { return new_symbol(sym.RBRACKET, yytext());    }
"{" 	    { return new_symbol(sym.LBRACE, yytext());      }
"}" 	    { return new_symbol(sym.RBRACE, yytext());      }
"::" 	    { return new_symbol(sym.DOUBLECOLON, yytext()); }

"//" 	    	 { yybegin(COMMENT);                 }
<COMMENT> . 	 { yybegin(COMMENT); 				 }
<COMMENT> "\r\n" { yybegin(YYINITIAL);				 }

[0-9]+ 				    { return new_symbol(sym.NUMBER, Integer.parseInt(yytext())); }
"true"|"false" 		    { return new_symbol(sym.BOOLEAN, yytext());              	 }
"\'"[a-zA-Z0-9_]"\'"	{ return new_symbol(sym.CHARACTER, yytext());                }
[a-zA-Z][a-zA-Z0-9_]*   { return new_symbol(sym.IDENT, yytext());         		     }

. { System.err.println("Leksicka greska (" + yytext() + ") u liniji " + (yyline + 1)); }
























