// generated with ast extension for cup
// version 0.8
// 30/0/2024 23:15:29


package rs.ac.bg.etf.pp1.ast;

public class ADesignDec extends Statement {

    private ArrayDesignator ArrayDesignator;

    public ADesignDec (ArrayDesignator ArrayDesignator) {
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
        buffer.append("ADesignDec(\n");

        if(ArrayDesignator!=null)
            buffer.append(ArrayDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ADesignDec]");
        return buffer.toString();
    }
}
