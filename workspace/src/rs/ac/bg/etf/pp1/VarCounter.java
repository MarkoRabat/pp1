package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.AIdentDecl;
import rs.ac.bg.etf.pp1.ast.IIdentDecl;
import rs.ac.bg.etf.pp1.ast.SIdentDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class VarCounter extends VisitorAdaptor {
	protected int count = 0;
	public int getCount() { return count; }
	public void visit(SIdentDecl sIdentDecl) { ++count; }
	public void visit(AIdentDecl aIdentDecl) { ++count; }
	public void visit(IIdentDecl iIdentDecl) { ++count; }
}
