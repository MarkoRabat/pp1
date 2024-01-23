package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	int printCallCount = 0;
	int varDeclCount = 0;
	
	public void visit(VarDeclaration varDeclaration) {
		++varDeclCount;
	}
	
	public void visit(PrintStmt printStmt) {
		++printCallCount;
		log.info("Prepoznata naredba print!");
	}

}
