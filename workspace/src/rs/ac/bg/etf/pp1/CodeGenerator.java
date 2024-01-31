package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.ac.bg.etf.pp1.ast.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	public int getMainPc() { return mainPc; }
	
	public void visit(MethodDeclaration methodDeclaration) {
		Code.put(Code.exit); Code.put(Code.return_); }
	
	public void visit(MethName methName) {
		mainPc = Code.pc; methName.obj.setAdr(Code.pc);
		SyntaxNode methodDecl = methName.getParent();
		VarCounter countLocals = new VarCounter();
		methodDecl.traverseTopDown(countLocals);
		Code.put(Code.enter); Code.put(0);
		Code.put(countLocals.getCount());
	}
	
	public void visit(PrintStmt pritnStmt) {
		Struct exprType = pritnStmt.getExpr().struct;
		if (exprType == Tab.charType) {
			Code.loadConst(1); Code.put(Code.bprint); return; }
		Code.loadConst(5); Code.put(Code.print);
	}
	
	public void visit(NumberConst numberConst) {
		Obj con = Tab.insert(Obj.Con, "$", numberConst.struct);
		con.setLevel(0); con.setAdr(numberConst.getN1()); Code.load(con);
	}

}
