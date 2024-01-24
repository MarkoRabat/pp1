// generated with ast extension for cup
// version 0.8
// 24/0/2024 22:54:56


package rs.ac.bg.etf.pp1.ast;

public class DeclListDerived2 extends DeclList {

    private EndIdentifier EndIdentifier;

    public DeclListDerived2 (EndIdentifier EndIdentifier) {
        this.EndIdentifier=EndIdentifier;
        if(EndIdentifier!=null) EndIdentifier.setParent(this);
    }

    public EndIdentifier getEndIdentifier() {
        return EndIdentifier;
    }

    public void setEndIdentifier(EndIdentifier EndIdentifier) {
        this.EndIdentifier=EndIdentifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EndIdentifier!=null) EndIdentifier.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EndIdentifier!=null) EndIdentifier.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EndIdentifier!=null) EndIdentifier.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListDerived2(\n");

        if(EndIdentifier!=null)
            buffer.append(EndIdentifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListDerived2]");
        return buffer.toString();
    }
}
