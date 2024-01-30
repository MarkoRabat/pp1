// generated with ast extension for cup
// version 0.8
// 30/0/2024 13:52:38


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListDerived1 extends ConstDeclList {

    private ConstIdentifier ConstIdentifier;
    private ConstDeclList ConstDeclList;

    public ConstDeclListDerived1 (ConstIdentifier ConstIdentifier, ConstDeclList ConstDeclList) {
        this.ConstIdentifier=ConstIdentifier;
        if(ConstIdentifier!=null) ConstIdentifier.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ConstIdentifier getConstIdentifier() {
        return ConstIdentifier;
    }

    public void setConstIdentifier(ConstIdentifier ConstIdentifier) {
        this.ConstIdentifier=ConstIdentifier;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstIdentifier!=null) ConstIdentifier.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstIdentifier!=null) ConstIdentifier.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstIdentifier!=null) ConstIdentifier.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListDerived1(\n");

        if(ConstIdentifier!=null)
            buffer.append(ConstIdentifier.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListDerived1]");
        return buffer.toString();
    }
}
