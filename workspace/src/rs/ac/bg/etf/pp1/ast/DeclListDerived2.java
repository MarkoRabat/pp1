// generated with ast extension for cup
// version 0.8
// 25/0/2024 19:14:58


package rs.ac.bg.etf.pp1.ast;

public class DeclListDerived2 extends DeclList {

    private Identifier Identifier;

    public DeclListDerived2 (Identifier Identifier) {
        this.Identifier=Identifier;
        if(Identifier!=null) Identifier.setParent(this);
    }

    public Identifier getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Identifier Identifier) {
        this.Identifier=Identifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Identifier!=null) Identifier.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Identifier!=null) Identifier.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Identifier!=null) Identifier.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListDerived2(\n");

        if(Identifier!=null)
            buffer.append(Identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListDerived2]");
        return buffer.toString();
    }
}
