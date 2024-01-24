// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:18:27


package rs.ac.bg.etf.pp1.ast;

public class IdentifierDerived3 extends Identifier {

    private String I1;
    private Initializator Initializator;

    public IdentifierDerived3 (String I1, Initializator Initializator) {
        this.I1=I1;
        this.Initializator=Initializator;
        if(Initializator!=null) Initializator.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Initializator!=null) Initializator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Initializator!=null) Initializator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Initializator!=null) Initializator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentifierDerived3(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Initializator!=null)
            buffer.append(Initializator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentifierDerived3]");
        return buffer.toString();
    }
}
