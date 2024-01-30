// generated with ast extension for cup
// version 0.8
// 30/0/2024 23:15:29


package rs.ac.bg.etf.pp1.ast;

public class ProgNameDeclListDerived2 extends ProgNameDeclList {

    private ProgNameDeclList ProgNameDeclList;
    private VarDecl VarDecl;

    public ProgNameDeclListDerived2 (ProgNameDeclList ProgNameDeclList, VarDecl VarDecl) {
        this.ProgNameDeclList=ProgNameDeclList;
        if(ProgNameDeclList!=null) ProgNameDeclList.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public ProgNameDeclList getProgNameDeclList() {
        return ProgNameDeclList;
    }

    public void setProgNameDeclList(ProgNameDeclList ProgNameDeclList) {
        this.ProgNameDeclList=ProgNameDeclList;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgNameDeclListDerived2(\n");

        if(ProgNameDeclList!=null)
            buffer.append(ProgNameDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgNameDeclListDerived2]");
        return buffer.toString();
    }
}
