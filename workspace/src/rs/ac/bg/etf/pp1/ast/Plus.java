// generated with ast extension for cup
// version 0.8
// 31/0/2024 19:59:23


package rs.ac.bg.etf.pp1.ast;

public class Plus extends Addop {

    private String P1;

    public Plus (String P1) {
        this.P1=P1;
    }

    public String getP1() {
        return P1;
    }

    public void setP1(String P1) {
        this.P1=P1;
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
        buffer.append("Plus(\n");

        buffer.append(" "+tab+P1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Plus]");
        return buffer.toString();
    }
}
