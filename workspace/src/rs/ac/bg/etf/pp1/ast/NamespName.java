// generated with ast extension for cup
// version 0.8
// 30/0/2024 22:40:29


package rs.ac.bg.etf.pp1.ast;

public class NamespName extends NamespaceName {

    private String i;

    public NamespName (String i) {
        this.i=i;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i=i;
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
        buffer.append("NamespName(\n");

        buffer.append(" "+tab+i);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespName]");
        return buffer.toString();
    }
}
