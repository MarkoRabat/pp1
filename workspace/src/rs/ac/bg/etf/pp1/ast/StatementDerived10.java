// generated with ast extension for cup
// version 0.8
// 30/0/2024 13:52:38


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived10 extends Statement {

    private ArrayDesignator ArrayDesignator;

    public StatementDerived10 (ArrayDesignator ArrayDesignator) {
        this.ArrayDesignator=ArrayDesignator;
        if(ArrayDesignator!=null) ArrayDesignator.setParent(this);
    }

    public ArrayDesignator getArrayDesignator() {
        return ArrayDesignator;
    }

    public void setArrayDesignator(ArrayDesignator ArrayDesignator) {
        this.ArrayDesignator=ArrayDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayDesignator!=null) ArrayDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayDesignator!=null) ArrayDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayDesignator!=null) ArrayDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived10(\n");

        if(ArrayDesignator!=null)
            buffer.append(ArrayDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived10]");
        return buffer.toString();
    }
}
