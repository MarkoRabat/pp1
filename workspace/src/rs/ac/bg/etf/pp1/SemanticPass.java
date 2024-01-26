package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	
	private int printCallCount = 0;
	private int varDeclCount = 0;
	private Obj currentMethod = null;
	private Struct currDeclListType = null;
	private SemanticPassLogger spl = new SemanticPassLogger();
	
	public SemanticPass() {}
	
	public void setPrintCallCount(int newPrintCallCount) { printCallCount = newPrintCallCount; }
	public int getPrintCallCount() { return printCallCount; } 
	public void incPrintCallCount() { ++printCallCount; }
	public void setVarDeclCount(int newVarDeclCount) { varDeclCount = newVarDeclCount; }
	public int getVarDeclCount() { return varDeclCount; } 
	public void incVarDeclCount() { ++varDeclCount; }

	public void setCurrDeclLType(Struct type) { currDeclListType = type; }
	public Struct getCurrDeclLType() { return currDeclListType; }
	public void setCurrentMethod(Obj currMethod) { currentMethod = currMethod; }
	public void setCurrentMethodToNull() { currentMethod = null; }
	public Obj getCurrentMethod() { return currentMethod; }
	public boolean currentMethodIsNull() { return currentMethod == null; }
	public boolean isNoObj(Obj obj) { return obj == Tab.noObj; }
	public boolean isNotTypeObj(Obj obj) { return obj.getKind() != Obj.Type; }
	
	public void visit(Prog prog) {
		String programName = prog.getProgName().obj.getName();
		Obj program = Tab.find(programName);
		if (isNoObj(program)) {
			spl.report_name_isNot_defined(programName, prog); return; }
		Tab.chainLocalSymbols(prog.getProgName().obj); Tab.closeScope();
	}
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		if (isNoObj(progName.obj)) {
			spl.report_name_isAlready_defined(progName.getProgName(), progName); return; }
		Tab.openScope();
	}

	public void visit(DeclListType declListType) {
		setCurrDeclLType(declListType.getType().struct); }

	public void visit(ConstDeclListType constDeclListType) {
		setCurrDeclLType(constDeclListType.getType().struct); }
	
	public void visit(TypeAccess type) {
		Obj typeNode = Tab.find(type.getTypeName()); type.struct = Tab.noType; 
		if (isNoObj(typeNode) || isNotTypeObj(typeNode)) {
			spl.report_undefined_type(type.getTypeName(), type); return; }
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
			spl.report_name_isAlready_defined(methName.getI1(), methName); return; }
		setCurrentMethod(methName.obj); Tab.openScope();
	}

	public void visit(PrintStmt printStmt) {
		incPrintCallCount();
		spl.info_print();
	}
	
	public void visit(Ident ident) {
		Obj designator = Tab.find(ident.getName());
		if (isNoObj(designator))
			spl.report_name_isNot_defined(ident.getName(), ident);
		ident.obj = designator;
	}

}
