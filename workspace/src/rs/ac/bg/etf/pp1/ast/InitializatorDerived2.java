// generated with ast extension for cup
// version 0.8
// 25/0/2024 19:14:58


package rs.ac.bg.etf.pp1.ast;

public class InitializatorDerived2 extends Initializator {

    public InitializatorDerived2 () {
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
        buffer.append("InitializatorDerived2(\n");

        buffer.append(tab);
        buffer.append(") [InitializatorDerived2]");
        return buffer.toString();
    }
}
