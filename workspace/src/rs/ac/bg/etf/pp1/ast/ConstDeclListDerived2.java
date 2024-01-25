// generated with ast extension for cup
// version 0.8
// 25/0/2024 19:14:58


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListDerived2 extends ConstDeclList {

    private ConstIdentifier ConstIdentifier;

    public ConstDeclListDerived2 (ConstIdentifier ConstIdentifier) {
        this.ConstIdentifier=ConstIdentifier;
        if(ConstIdentifier!=null) ConstIdentifier.setParent(this);
    }

    public ConstIdentifier getConstIdentifier() {
        return ConstIdentifier;
    }

    public void setConstIdentifier(ConstIdentifier ConstIdentifier) {
        this.ConstIdentifier=ConstIdentifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstIdentifier!=null) ConstIdentifier.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstIdentifier!=null) ConstIdentifier.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstIdentifier!=null) ConstIdentifier.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListDerived2(\n");

        if(ConstIdentifier!=null)
            buffer.append(ConstIdentifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListDerived2]");
        return buffer.toString();
    }
}
