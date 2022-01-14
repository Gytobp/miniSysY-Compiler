package ir.instructions;

import ir.ConstInt;
import ir.Instruction;
import ir.Value;

public class TerminatorInstruction extends Instruction {
    public TerminatorInstruction(Type type, Command cmd, ConstInt arg) {
        super(type);
        this.cmd = cmd;
        this.arg = arg;
    }

    public Command getCmd() {
        return cmd;
    }

    public void setCmd(Command cmd) {
        this.cmd = cmd;
    }

    public enum Command {
        BR("br"), RET("ret"), CALL("call");

        Command(String ir) {
            this.ir = ir;
        }

        public String ir;
    }

    private Command cmd;

    public ConstInt getArg() {
        return arg;
    }

    public void setArg(ConstInt arg) {
        this.arg = arg;
    }

    /*
     * br - label
     * ret - void or int or ??
     * call - function
     */
    private ConstInt arg;

    @Override
    public String toString() {
        return cmd.ir + " " + arg.getType().string + " " + arg + ";\n";
    }
}
