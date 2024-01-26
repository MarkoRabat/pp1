package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	Logger log = Logger.getLogger(getClass());
	
	int printCallCount = 0;
	int varDeclCount = 0;
	private Obj currentMethod = null;
	private Struct currDeclListType = null;
	
	public void setCurrDeclLType(Struct type) { currDeclListType = type; }
	public Struct getCurrDeclLType() { return currDeclListType; }
	public void setCurrentMethod(Obj currMethod) { currentMethod = currMethod; }
	public void setCurrentMethodToNull() { currentMethod = null; }
	public Obj getCurrentMethod() { return currentMethod; }
	public boolean currentMethodIsNull() { return currentMethod == null; }
	public boolean isNoObj(Obj obj) { return obj == Tab.noObj; }
	public boolean isNotTypeObj(Obj obj) { return obj.getKind() != Obj.Type; }
	
	public void visit(Prog prog) {
		Tab.chainLocalSymbols(prog.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(DeclListType declListType) {
		setCurrDeclLType(declListType.getType().struct); }

	public void visit(ConstDeclListType constDeclListType) {
		setCurrDeclLType(constDeclListType.getType().struct); }
	
	public void visit(TypeAccess type) {
		Obj typeNode = Tab.find(type.getTypeName());
		type.struct = Tab.noType; 
		if (isNoObj(typeNode) || isNotTypeObj(typeNode)) {
			report_undefined_type(type.getTypeName(), type); return; }
		type.struct = typeNode.getType();
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
		if (!currentMethodIsNull()) {
			Tab.chainLocalSymbols(getCurrentMethod()); Tab.closeScope(); }
		setCurrentMethodToNull();
	}
	
	public void visit(MethName methName) {
		methName.obj = Tab.insert(Obj.Meth, methName.getI1(), Tab.nullType);
		if (isNoObj(methName.obj)) {
			report_name_isAlready_defined(methName.getI1(), methName); return; }
		setCurrentMethod(methName.obj);
		Tab.openScope();
	}

	public void visit(PrintStmt printStmt) {
		++printCallCount;
		log.info("Prepoznata naredba print!");
	}
	
	public void visit(Ident ident) {
		Obj designator = Tab.find(ident.getName());
		if (isNoObj(designator))
			report_name_isNot_defined(ident.getName(), ident);
		ident.obj = designator;
	}
	
	public void report_name_isNot_defined(String name, SyntaxNode obj) {
		report_error("ime " + name + " nije definisano", obj); }
	public void report_name_isAlready_defined(String name, SyntaxNode obj) {
		report_error("ime " + name + " je vec definisano", obj); }
	public void report_undefined_type(String name, SyntaxNode obj) {
		report_error("nepostojeci tip " + name, obj); }
	public StringBuilder build_msg(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append("\n\tna liniji ").append(line);
		return msg;
	}
	
	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = build_msg(message, info);
		msg.insert(0, "Greska: ");
		log.error(msg.toString());
	}
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = build_msg(message, info);
		log.info(msg.toString());
	}

}
