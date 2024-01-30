// generated with ast extension for cup
// version 0.8
// 30/0/2024 22:40:29


package rs.ac.bg.etf.pp1.ast;

public class DeclListDerived1 extends DeclList {

    private Identifier Identifier;
    private DeclList DeclList;

    public DeclListDerived1 (Identifier Identifier, DeclList DeclList) {
        this.Identifier=Identifier;
        if(Identifier!=null) Identifier.setParent(this);
        this.DeclList=DeclList;
        if(DeclList!=null) DeclList.setParent(this);
    }

    public Identifier getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Identifier Identifier) {
        this.Identifier=Identifier;
    }

    public DeclList getDeclList() {
        return DeclList;
    }

    public void setDeclList(DeclList DeclList) {
        this.DeclList=DeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Identifier!=null) Identifier.accept(visitor);
        if(DeclList!=null) DeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Identifier!=null) Identifier.traverseTopDown(visitor);
        if(DeclList!=null) DeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Identifier!=null) Identifier.traverseBottomUp(visitor);
        if(DeclList!=null) DeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListDerived1(\n");

        if(Identifier!=null)
            buffer.append(Identifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclList!=null)
            buffer.append(DeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListDerived1]");
        return buffer.toString();
    }
}
