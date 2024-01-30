// generated with ast extension for cup
// version 0.8
// 30/0/2024 21:51:32


package rs.ac.bg.etf.pp1.ast;

public class Div extends Mulop {

    private String D1;

    public Div (String D1) {
        this.D1=D1;
    }

    public String getD1() {
        return D1;
    }

    public void setD1(String D1) {
        this.D1=D1;
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
        buffer.append("Div(\n");

        buffer.append(" "+tab+D1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Div]");
        return buffer.toString();
    }
}
