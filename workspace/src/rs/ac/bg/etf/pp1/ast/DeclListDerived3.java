// generated with ast extension for cup
// version 0.8
// 24/0/2024 22:48:55


package rs.ac.bg.etf.pp1.ast;

public class DeclListDerived3 extends DeclList {

    private String I1;
    private Initializator Initializator;
    private DeclList DeclList;

    public DeclListDerived3 (String I1, Initializator Initializator, DeclList DeclList) {
        this.I1=I1;
        this.Initializator=Initializator;
        if(Initializator!=null) Initializator.setParent(this);
        this.DeclList=DeclList;
        if(DeclList!=null) DeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Initializator getInitializator() {
        return Initializator;
    }

    public void setInitializator(Initializator Initializator) {
        this.Initializator=Initializator;
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
        if(Initializator!=null) Initializator.accept(visitor);
        if(DeclList!=null) DeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Initializator!=null) Initializator.traverseTopDown(visitor);
        if(DeclList!=null) DeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Initializator!=null) Initializator.traverseBottomUp(visitor);
        if(DeclList!=null) DeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListDerived3(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Initializator!=null)
            buffer.append(Initializator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclList!=null)
            buffer.append(DeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListDerived3]");
        return buffer.toString();
    }
}
