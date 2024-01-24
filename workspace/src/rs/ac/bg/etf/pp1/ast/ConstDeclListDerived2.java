// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:13:33


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListDerived2 extends ConstDeclList {

    private ConstEndIdentifier ConstEndIdentifier;

    public ConstDeclListDerived2 (ConstEndIdentifier ConstEndIdentifier) {
        this.ConstEndIdentifier=ConstEndIdentifier;
        if(ConstEndIdentifier!=null) ConstEndIdentifier.setParent(this);
    }

    public ConstEndIdentifier getConstEndIdentifier() {
        return ConstEndIdentifier;
    }

    public void setConstEndIdentifier(ConstEndIdentifier ConstEndIdentifier) {
        this.ConstEndIdentifier=ConstEndIdentifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstEndIdentifier!=null) ConstEndIdentifier.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstEndIdentifier!=null) ConstEndIdentifier.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstEndIdentifier!=null) ConstEndIdentifier.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListDerived2(\n");

        if(ConstEndIdentifier!=null)
            buffer.append(ConstEndIdentifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListDerived2]");
        return buffer.toString();
    }
}
