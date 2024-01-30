// generated with ast extension for cup
// version 0.8
// 30/0/2024 13:52:38


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived5 extends Statement {

    private SimpleDesignator SimpleDesignator;

    public StatementDerived5 (SimpleDesignator SimpleDesignator) {
        this.SimpleDesignator=SimpleDesignator;
        if(SimpleDesignator!=null) SimpleDesignator.setParent(this);
    }

    public SimpleDesignator getSimpleDesignator() {
        return SimpleDesignator;
    }

    public void setSimpleDesignator(SimpleDesignator SimpleDesignator) {
        this.SimpleDesignator=SimpleDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SimpleDesignator!=null) SimpleDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SimpleDesignator!=null) SimpleDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SimpleDesignator!=null) SimpleDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived5(\n");

        if(SimpleDesignator!=null)
            buffer.append(SimpleDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived5]");
        return buffer.toString();
    }
}
