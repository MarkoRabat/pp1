// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:18:27


package rs.ac.bg.etf.pp1.ast;

public class SimpleDesignatorDerived1 extends SimpleDesignator {

    private String name;

    public SimpleDesignatorDerived1 (String name) {
        this.name=name;
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
        buffer.append("SimpleDesignatorDerived1(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleDesignatorDerived1]");
        return buffer.toString();
    }
}
