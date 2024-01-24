// generated with ast extension for cup
// version 0.8
// 24/0/2024 22:54:56


package rs.ac.bg.etf.pp1.ast;

public class SimpleDesignatorDerived2 extends SimpleDesignator {

    private String namesp;
    private String name;

    public SimpleDesignatorDerived2 (String namesp, String name) {
        this.namesp=namesp;
        this.name=name;
    }

    public String getNamesp() {
        return namesp;
    }

    public void setNamesp(String namesp) {
        this.namesp=namesp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
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
        buffer.append("SimpleDesignatorDerived2(\n");

        buffer.append(" "+tab+namesp);
        buffer.append("\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleDesignatorDerived2]");
        return buffer.toString();
    }
}
