// generated with ast extension for cup
// version 0.8
// 30/0/2024 21:51:32


package rs.ac.bg.etf.pp1.ast;

public class NsIdent extends SimpleDesignator {

    private String namesp;
    private String name;

    public NsIdent (String namesp, String name) {
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
        buffer.append("NsIdent(\n");

        buffer.append(" "+tab+namesp);
        buffer.append("\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NsIdent]");
        return buffer.toString();
    }
}
