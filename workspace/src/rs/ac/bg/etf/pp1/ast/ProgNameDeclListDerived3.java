// generated with ast extension for cup
// version 0.8
// 30/0/2024 16:30:9


package rs.ac.bg.etf.pp1.ast;

public class ProgNameDeclListDerived3 extends ProgNameDeclList {

    public ProgNameDeclListDerived3 () {
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
        buffer.append("ProgNameDeclListDerived3(\n");

        buffer.append(tab);
        buffer.append(") [ProgNameDeclListDerived3]");
        return buffer.toString();
    }
}
