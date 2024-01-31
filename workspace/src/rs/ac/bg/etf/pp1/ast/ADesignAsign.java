// generated with ast extension for cup
// version 0.8
// 31/0/2024 18:24:13


package rs.ac.bg.etf.pp1.ast;

public class ADesignAsign extends Statement {

    private ArrayDesignator ArrayDesignator;
    private Expr Expr;

    public ADesignAsign (ArrayDesignator ArrayDesignator, Expr Expr) {
        this.ArrayDesignator=ArrayDesignator;
        if(ArrayDesignator!=null) ArrayDesignator.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ArrayDesignator getArrayDesignator() {
        return ArrayDesignator;
    }

    public void setArrayDesignator(ArrayDesignator ArrayDesignator) {
        this.ArrayDesignator=ArrayDesignator;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayDesignator!=null) ArrayDesignator.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayDesignator!=null) ArrayDesignator.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayDesignator!=null) ArrayDesignator.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ADesignAsign(\n");

        if(ArrayDesignator!=null)
            buffer.append(ArrayDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ADesignAsign]");
        return buffer.toString();
    }
}
