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

	public void visit(ADesignAsign aDesignAsign) {
		if (aDesignAsign.getArrayDesignator().obj.getType().getElemType() == Tab.charType)
			Code.put(Code.bastore);
		else Code.put(Code.astore);
	}

	public void visit(ArrayAlloc arrayAlloc) {
		Code.put(Code.newarray);
		if (arrayAlloc.getSimpleDesignator().obj.getType().getElemType() == Tab.charType)
			Code.put(1);
		else Code.put(0);
		Code.store(arrayAlloc.getSimpleDesignator().obj);
	}
	
	public void visit(SDesignInc sDesignInc) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(sDesignInc.getSimpleDesignator().obj);
	}

	public void visit(SDesignDec sDesignDec) {
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(sDesignDec.getSimpleDesignator().obj);
	}
	
	public void visit(ADesignInc aDesignInc) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		if (aDesignInc.getArrayDesignator().obj
			.getType().getElemType() == Tab.charType)
			Code.put(Code.bastore);
		else Code.put(Code.astore);
	}

	public void visit(ADesignDec aDesignDec) {
		Code.put(Code.const_1);
		Code.put(Code.sub);
		if (aDesignDec.getArrayDesignator().obj
			.getType().getElemType() == Tab.charType)
			Code.put(Code.bastore);
		else Code.put(Code.astore);
	}
	
	public void visit(ReadSDesign readSDesign) {
		if (readSDesign.getSimpleDesignator().obj.getType() == Tab.charType)
			Code.put(Code.bread);
		else Code.put(Code.read);
		Code.store(readSDesign.getSimpleDesignator().obj);
	}

	public void visit(ReadADesign readADesign) {
		if (readADesign.getArrayDesignator()
			.obj.getType().getElemType() == Tab.charType) {
			Code.put(Code.bread);
			Code.put(Code.bastore);
		}
		else {
			Code.put(Code.read);
			Code.put(Code.astore);
		}
	}
	

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
	
	public void visit(NegExpr negExpr) { Code.put(Code.neg); }
	
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
		System.out.println("booleanConst:");
		System.out.println(booleanConst.getB1());
		con.setAdr((booleanConst.getB1().equals("true") ? 1 : 0));
		System.out.println(con.getAdr());
		Code.load(con);
	}
	
	public void visit(Ident ident) {
		if (ident.getParent().getClass() == SDesignAsign.class) return;
		if (ident.getParent().getClass() == ArrayAlloc.class) return;
		if (ident.getParent().getClass() == ReadSDesign.class) return;
		Code.load(ident.obj);
	}

	public void visit(NsIdent ident) {
		if (ident.getParent().getClass() == SDesignAsign.class) return;
		if (ident.getParent().getClass() == ArrayAlloc.class) return;
		if (ident.getParent().getClass() == ReadSDesign.class) return;
		Code.load(ident.obj);
	}
	
	public void visit(ArrIdent arrIdent) {
		Code.load(arrIdent.obj);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		if (arrIdent.getParent().getClass() == ADesignInc.class
			|| arrIdent.getParent().getClass() == ADesignDec.class)
			Code.put(Code.dup2);
		if (arrIdent.getParent().getClass() == ADesignAsign.class) return;
		if (arrIdent.getParent().getClass() == ReadADesign.class) return;
		if (arrIdent.obj.getType().getElemType() == Tab.charType)
			Code.put(Code.baload);
		else Code.put(Code.aload);
	}
	
	public void visit(NsArrIdent arrIdent) {
		Code.load(arrIdent.obj);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		if (arrIdent.getParent().getClass() == ADesignInc.class
			|| arrIdent.getParent().getClass() == ADesignDec.class)
			Code.put(Code.dup2);
		if (arrIdent.getParent().getClass() == ADesignAsign.class) return;
		if (arrIdent.obj.getType().getElemType() == Tab.charType)
			Code.put(Code.baload);
		else Code.put(Code.aload);
	}
}
