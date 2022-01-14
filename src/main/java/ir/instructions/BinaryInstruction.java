package ir.instructions;

import ir.Instruction;
import ir.Value;

public class BinaryInstruction extends Instruction {
    private BinaryOp op;
    private Value left;
    private Value right;

    public enum BinaryOp {
        MUL("mul"),
        DIV("sdiv"),
        MOD("mod"),
        PLUS("add"),
        MINUS("sub"),
        LT("icmp slt"),
        GT("icmp sgt"),
        LE("icmp sle"),
        GE("icmp sge"),
        EQ("icmp eq"),
        NEQ("icmp ne");

        String ir;

        BinaryOp(String ir) {
            this.ir = ir;
        }
    }

    public BinaryInstruction(Type type, BinaryOp op, Value left, Value right) {
        super(type);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public String toString() {
        return "\t" + getName() + " = " +
                op.ir + " " + left.getType() + " " +
                left.getName() +
                ", " +
                right.getName();
    }
}
