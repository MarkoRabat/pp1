package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.ac.bg.etf.pp1.ast.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc = 0;
	public int getMainPc() { return mainPc; }
	
	public void visit(IIdentDecl iIdentDecl) {
		Code.store(iIdentDecl.obj);
	}
	
	public void visit(NInit nInit) {
		Obj con = Tab.insert(Obj.Con, "$", nInit.obj.getType());
		con.setLevel(0); con.setAdr(nInit.getN1()); Code.load(con);
	}

	public void visit(CInit cInit) {
		Obj con = Tab.insert(Obj.Con, "$", cInit.obj.getType());
		con.setLevel(0);
		con.setAdr(cInit.getC1().charAt(1));
		Code.load(con);
	}

	public void visit(BInit bInit) {
		Obj con = Tab.insert(Obj.Con, "$", bInit.obj.getType());
		con.setLevel(0);
		con.setAdr((bInit.getB1().equals("true") ? 1 : 0));
		Code.load(con);
	}
	
	public void visit(MethodDeclaration methodDeclaration) {
		Code.put(Code.exit); Code.put(Code.return_); }
	
	public void visit(MethName methName) {
		methName.obj.setAdr(Code.pc);
		SyntaxNode methodDecl = methName.getParent();
		VarCounter countLocals = new VarCounter();
		methodDecl.traverseTopDown(countLocals);
		Code.put(Code.enter); Code.put(0);
		Code.put(countLocals.getCount());
	}
	
	public void visit(SDesignAsign sDesignAsign) {
		Code.store(sDesignAsign.getSimpleDesignator().obj); }
	
	public void visit(PrintStmt pritnStmt) {
		Struct exprType = pritnStmt.getExpr().struct;
		if (exprType == Tab.charType) {
			Code.loadConst(1); Code.put(Code.bprint); return; }
		Code.loadConst(5); Code.put(Code.print);
	}
	
	public void visit(PrintOnWith printOnWith) {
		Code.loadConst(printOnWith.getN2());
		Struct exprType = printOnWith.getExpr().struct;
		if (exprType == Tab.charType)
			 Code.put(Code.bprint);
		else Code.put(Code.print);
	}
	
	public void visit(Return ret) {
		Code.put(Code.exit); Code.put(Code.return_); }
	
	public void visit(AddExpr addExpr) {
		switch(addExpr.getAddop().obj.getName()) {
		case "+": Code.put(Code.add); break;
		case "-": Code.put(Code.sub); break;
		default: break;
		}
	}
	
	public void visit(MulTerm mulTerm) {
		switch(mulTerm.getMulop().obj.getName()) {
		case "*": Code.put(Code.mul); break;
		case "/": Code.put(Code.div); break;
		case "%": Code.put(Code.rem); break;
		default: break;
		}
	}
	
	public void visit(NumberConst numberConst) {
		Obj con = Tab.insert(Obj.Con, "$", numberConst.struct);
		con.setLevel(0); con.setAdr(numberConst.getN1()); Code.load(con);
	}

	public void visit(CharacterConst characterConst) {
		Obj con = Tab.insert(Obj.Con, "$", characterConst.struct);
		con.setLevel(0);
		con.setAdr(characterConst.getC1().charAt(1));
		Code.load(con);
	}

	public void visit(BooleanConst booleanConst) {
		Obj con = Tab.insert(Obj.Con, "$", booleanConst.struct);
		con.setLevel(0);
		con.setAdr((booleanConst.getB1().equals("true") ? 1 : 0));
		Code.load(con);
	}
	
	public void visit(Ident ident) {
		if (ident.getParent().getClass() == SDesignAsign.class) return;
		Code.load(ident.obj);
	}

	public void visit(NsIdent nsIdent) {
		if (nsIdent.getParent().getClass() == SDesignAsign.class) return;
		Code.load(nsIdent.obj);
	}
}
