// generated with ast extension for cup
// version 0.8
// 30/0/2024 21:51:32


package rs.ac.bg.etf.pp1.ast;

public class Mul extends Mulop {

    private String M1;

    public Mul (String M1) {
        this.M1=M1;
    }

    public String getM1() {
        return M1;
    }

    public void setM1(String M1) {
        this.M1=M1;
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
        buffer.append("Mul(\n");

        buffer.append(" "+tab+M1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Mul]");
        return buffer.toString();
    }
}
