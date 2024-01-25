// generated with ast extension for cup
// version 0.8
// 25/0/2024 19:14:58


package rs.ac.bg.etf.pp1.ast;

public class ProgramDerived1 extends Program {

    private String I1;
    private ProgNameDeclList ProgNameDeclList;
    private MethodDeclList MethodDeclList;

    public ProgramDerived1 (String I1, ProgNameDeclList ProgNameDeclList, MethodDeclList MethodDeclList) {
        this.I1=I1;
        this.ProgNameDeclList=ProgNameDeclList;
        if(ProgNameDeclList!=null) ProgNameDeclList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ProgNameDeclList getProgNameDeclList() {
        return ProgNameDeclList;
    }

    public void setProgNameDeclList(ProgNameDeclList ProgNameDeclList) {
        this.ProgNameDeclList=ProgNameDeclList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgNameDeclList!=null) ProgNameDeclList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ProgNameDeclList!=null)
            buffer.append(ProgNameDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDerived1]");
        return buffer.toString();
    }
}
