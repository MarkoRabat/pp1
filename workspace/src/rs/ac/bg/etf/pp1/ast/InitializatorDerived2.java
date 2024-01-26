// generated with ast extension for cup
// version 0.8
// 26/0/2024 17:15:9


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
