// generated with ast extension for cup
// version 0.8
// 25/0/2024 19:14:58


package rs.ac.bg.etf.pp1.ast;

public class ConstIdentifierDerived2 extends ConstIdentifier {

    public ConstIdentifierDerived2 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstIdentifierDerived2(\n");

        buffer.append(tab);
        buffer.append(") [ConstIdentifierDerived2]");
        return buffer.toString();
    }
}
