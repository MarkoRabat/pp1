package rs.ac.bg.etf.pp1;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.SemanticPassLogger;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {
	private int printCallCount = 0;
	private int varDeclCount = 0;
	private int conDeclCount = 0;
	private Obj currentMethod = null;
	private Struct currDeclListType = null;
	private SemanticPassLogger spl = new SemanticPassLogger();
	private Struct boolType, intArray, charArray, boolArray;
	public SemanticPass() {
		boolType = new Struct(Struct.Bool);
		Tab.insert(Obj.Type, "bool", boolType);
		intArray = new Struct(Struct.Array);
		intArray.setElementType(Tab.intType);
		charArray = new Struct(Struct.Array);
		charArray.setElementType(Tab.charType);
		boolArray = new Struct(Struct.Array);
		boolArray.setElementType(boolType);
	}
	
	public void setPrintCallCount(int newPrintCallCount) { printCallCount = newPrintCallCount; }
	public int getPrintCallCount() { return printCallCount; } 
	public void incPrintCallCount() { ++printCallCount; }
	public void setVarDeclCount(int newVarDeclCount) { varDeclCount = newVarDeclCount; }
	public int getVarDeclCount() { return varDeclCount; } 
	public void incVarDeclCount() { ++varDeclCount; }
	public void setConDeclCount(int newConDeclCount) { conDeclCount = newConDeclCount; }
	public int getConDeclCount() { return conDeclCount; } 
	public void incConDeclCount() { ++conDeclCount; }
	public void setCurrDeclLType(Struct type) { currDeclListType = type; }
	public Struct getCurrDeclLType() { return currDeclListType; }
	public void setCurrentMethod(Obj currMethod) { currentMethod = currMethod; }
	public void setCurrentMethodToNull() { currentMethod = null; }
	public Obj getCurrentMethod() { return currentMethod; }
	public Struct getArrayTypeOf(Struct primitiveType) {
		switch(primitiveType.getKind()) {
		case Struct.Int: return intArray;
		case Struct.Char: return charArray;
		case Struct.Bool: return boolArray;
		}
		return Tab.noType;
	}
	
	public String getTypeName(Struct type) {
		switch(type.getKind()) {
		case Struct.Int: return "int";
		case Struct.Char: return "char";
		case Struct.Bool: return "bool";
		case Struct.Array:
			switch(type.getElemType().getKind()) {
			case Struct.Int: return "int array";
			case Struct.Char: return "char array";
			case Struct.Bool: return "bool array";
			}
		}
		return "nepostojeci_tip";
	}
	
	public boolean isCurrentMethodNull() { return currentMethod == null; }
	public boolean isNoObj(Obj obj) { return obj == Tab.noObj; }
	public boolean isNotTypeObj(Obj obj) { return obj.getKind() != Obj.Type; }
	public boolean isInTab(String name) { return !isNoObj(Tab.find(name)); }
	public boolean isIntType(Struct... types) { 
		boolean rezult = true;
		for (Struct type : types)
			rezult = rezult && (type == Tab.intType);
		return rezult;
	}
	
	public Obj insertIntoTab(int kind, String name, Struct type) throws NameAlreadyBoundException {
		if (!isNoObj(Tab.find(name))) throw new NameAlreadyBoundException(name);
		switch(kind) {
		case Obj.Var: incVarDeclCount(); break;
		case Obj.Con: incConDeclCount(); break; }
		return Tab.insert(kind, name, type);
	}
	public Obj findInTab(String name) throws NameNotFoundException {
		Obj obj = Tab.find(name);
		if (isNoObj(obj)) throw new NameNotFoundException(name);
		return obj;
	}

	public void visit(Prog prog) {
		try {
			Obj programObj = findInTab(prog.getProgName().obj.getName());
			Tab.chainLocalSymbols(programObj); Tab.closeScope();
		}
		catch (NameNotFoundException e) {}
	}

	public void visit(ProgName progName) {
		try {
			progName.obj =
				insertIntoTab(Obj.Prog, progName.getProgName(), Tab.noType);
			Tab.openScope();
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), progName);
			progName.obj = Tab.noObj;
		}
	}

	public void visit(SIdentDecl newVar) {
		try {
			newVar.obj = insertIntoTab(Obj.Var, newVar.getI1(), getCurrDeclLType());
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), newVar);
			newVar.obj = Tab.noObj;
		}
	}
	
	public void visit(AIdentDecl newVar) {
		try {
			Struct arrayType = getArrayTypeOf(getCurrDeclLType());
			newVar.obj = insertIntoTab(Obj.Var, newVar.getI1(), arrayType);
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), newVar);
			newVar.obj = Tab.noObj;
		}
	}
	
	public void visit(IIdentDecl newVar) {
		try {
			newVar.obj = insertIntoTab(Obj.Var, newVar.getI1(), getCurrDeclLType());
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), newVar);
			newVar.obj = Tab.noObj;
		}
	}
	
	public void visit(CIdentDecl newConst) {
		try {
			newConst.obj = insertIntoTab(Obj.Con, newConst.getI1(), getCurrDeclLType());
			newConst.obj.setAdr(newConst.getInitializator().obj.getAdr());
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), newConst);
			newConst.obj = Tab.noObj;
		}
		catch (Exception e) {}
	}
	
	public void visit(NInit nInit) {
		try {
			if (getCurrDeclLType() != Tab.intType)
				throw new IllegalArgumentException("int");
			int number = nInit.getN1();
			nInit.obj = new Obj(Obj.Con, "numberInitializator", Tab.intType, number, 0);
		}
		catch(IllegalArgumentException e) {
			String varType = getTypeName(getCurrDeclLType());
			spl.report_incompatible_types_inInit(varType, e.getMessage(), nInit);
		}
	}

	public void visit(CInit cInit) {
		try {
			if (getCurrDeclLType() != Tab.charType)
				throw new IllegalArgumentException("char");
			char character = cInit.getC1().charAt(1);
			cInit.obj = new Obj(Obj.Con, "characterInitializator", Tab.charType, character, 0);
		}
		catch(IllegalArgumentException e) {
			String varType = getTypeName(getCurrDeclLType());
			spl.report_incompatible_types_inInit(varType, e.getMessage(), cInit);
		}
	}

	public void visit(BInit bInit) {
		try {
			if (getCurrDeclLType() != boolType)
				throw new IllegalArgumentException("bool");
			int bool = bInit.getB1().equals("true") ? 1 : 0;
			bInit.obj = new Obj(Obj.Con, "booleanInitializator", boolType, bool, 0);
		}
		catch(IllegalArgumentException e) {
			String varType = getTypeName(getCurrDeclLType());
			spl.report_incompatible_types_inInit(varType, e.getMessage(), bInit);
		}
	}

	public void visit(TypeAccess type) {
		try {
			Obj typeNode = findInTab(type.getTypeName());
			if (isNotTypeObj(typeNode))
				throw new NameAlreadyBoundException(typeNode.getName());
			type.struct = typeNode.getType();
		}
		catch (NameNotFoundException | NameAlreadyBoundException e) {
			spl.report_undefined_type(e.getMessage(), type);
			type.struct = Tab.noType; 
		}
		finally { setCurrDeclLType(type.struct); }
	}

	public void visit(MethodDeclaration methodDeclaration) {
		if (!isCurrentMethodNull()) {
			Tab.chainLocalSymbols(getCurrentMethod()); Tab.closeScope(); }
		setCurrentMethodToNull();
	}

	public void visit(MethName methName) {
		try {
			methName.obj = insertIntoTab(Obj.Meth, methName.getI1(), Tab.nullType);
			setCurrentMethod(methName.obj); Tab.openScope();
		}
		catch (NameAlreadyBoundException e) {
			spl.report_name_isAlready_defined(e.getMessage(), methName);
			methName.obj = Tab.noObj;
		}
	}

	public void visit(PrintStmt printStmt) {
		incPrintCallCount(); spl.info_print(); }

	public void visit(AddExpr addExpr) {
		try {
			Struct leftOpType = addExpr.getExpr().struct;
			Struct rightOpType = addExpr.getTerm().struct;
			if (!isIntType(leftOpType, rightOpType))
				throw new IllegalArgumentException(
					addExpr.getAddop().obj.getName());
			addExpr.struct = leftOpType;
		}
		catch (IllegalArgumentException e) {
			spl.report_nonInt_operands(e.getMessage(), addExpr);
			addExpr.struct = Tab.noType;
		}
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct; }
	
	public void visit(MulTerm mulTerm) {
		try {
			Struct leftOpType = mulTerm.getTerm().struct;
			Struct rightOpType = mulTerm.getFactor().struct;
			if (!isIntType(leftOpType, rightOpType))
				throw new IllegalArgumentException(
					mulTerm.getMulop().obj.getName());
			mulTerm.struct = leftOpType;
		}
		catch (IllegalArgumentException e) {
			spl.report_nonInt_operands(e.getMessage(), mulTerm);
			mulTerm.struct = Tab.noType;
		}
	}

	public void visit(FactorTerm factorTerm) {
		factorTerm.struct = factorTerm.getFactor().struct; }
	
	public void visit(NumberConst numberConst) {
		numberConst.struct = Tab.intType; }

	public void visit(CharacterConst characterConst) {
		characterConst.struct = Tab.charType; }

	public void visit(BooleanConst booleanConst) {
		booleanConst.struct = boolType; }
	
	public void visit(SFactorDesignator sFactorDesignator) {
		sFactorDesignator.struct
			= sFactorDesignator.getSimpleDesignator().obj.getType(); }
	
	public void visit(AFactorDesignator aFactorDesignator) {
		aFactorDesignator.struct
			= aFactorDesignator.getArrayDesignator().obj.getType().getElemType();
	}

	public void visit(Ident ident) {
		try { ident.obj = findInTab(ident.getName()); }
		catch (NameNotFoundException e) {
			spl.report_name_isNot_defined(e.getMessage(), ident);
			ident.obj = Tab.noObj;
		}
	}

	public void visit(ArrIdent arrIdent) {
		try {
			arrIdent.obj = findInTab(arrIdent.getName());
			if (arrIdent.obj.getType().getKind() != Struct.Array)
				throw new IllegalArgumentException(arrIdent.obj.getName());
			if (arrIdent.getExpr().struct != Tab.intType)
				 throw new IllegalArgumentException(
				     getTypeName(arrIdent.getExpr().struct));
		}
		catch (NameNotFoundException e) {
			spl.report_name_isNot_defined(e.getMessage(), arrIdent);
			arrIdent.obj = Tab.noObj;
		}
		catch (IllegalArgumentException e) {
			if (getTypeName(arrIdent.getExpr().struct).equals(e.getMessage()))
				spl.report_index_nonInt_type(e.getMessage(), arrIdent);
			else spl.report_indexing_nonArray(e.getMessage(), arrIdent);
			arrIdent.obj = Tab.noObj;
		}
	}
	
	public void visit(Mul mul) {
		mul.obj = new Obj(Obj.NO_VALUE, mul.getM1(), Tab.noType); }

	public void visit(Div div) {
		div.obj = new Obj(Obj.NO_VALUE, div.getD1(), Tab.noType); }

	public void visit(Per per) {
		per.obj = new Obj(Obj.NO_VALUE, per.getP1(), Tab.noType); }
	
	public void visit(Plus plus) {
		plus.obj = new Obj(Obj.NO_VALUE, plus.getP1(), Tab.noType); }

	public void visit(Minus minus) {
		minus.obj = new Obj(Obj.NO_VALUE, minus.getM1(), Tab.noType); }

}
