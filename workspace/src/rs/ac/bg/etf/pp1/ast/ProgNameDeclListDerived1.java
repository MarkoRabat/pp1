// generated with ast extension for cup
// version 0.8
// 26/0/2024 15:3:36


package rs.ac.bg.etf.pp1.ast;

public class ProgNameDeclListDerived1 extends ProgNameDeclList {

    private ProgNameDeclList ProgNameDeclList;
    private NamespaceDecl NamespaceDecl;

    public ProgNameDeclListDerived1 (ProgNameDeclList ProgNameDeclList, NamespaceDecl NamespaceDecl) {
        this.ProgNameDeclList=ProgNameDeclList;
        if(ProgNameDeclList!=null) ProgNameDeclList.setParent(this);
        this.NamespaceDecl=NamespaceDecl;
        if(NamespaceDecl!=null) NamespaceDecl.setParent(this);
    }

    public ProgNameDeclList getProgNameDeclList() {
        return ProgNameDeclList;
    }

    public void setProgNameDeclList(ProgNameDeclList ProgNameDeclList) {
        this.ProgNameDeclList=ProgNameDeclList;
    }

    public NamespaceDecl getNamespaceDecl() {
        return NamespaceDecl;
    }

    public void setNamespaceDecl(NamespaceDecl NamespaceDecl) {
        this.NamespaceDecl=NamespaceDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.accept(visitor);
        if(NamespaceDecl!=null) NamespaceDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseTopDown(visitor);
        if(NamespaceDecl!=null) NamespaceDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseBottomUp(visitor);
        if(NamespaceDecl!=null) NamespaceDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgNameDeclListDerived1(\n");

        if(ProgNameDeclList!=null)
            buffer.append(ProgNameDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NamespaceDecl!=null)
            buffer.append(NamespaceDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgNameDeclListDerived1]");
        return buffer.toString();
    }
}
