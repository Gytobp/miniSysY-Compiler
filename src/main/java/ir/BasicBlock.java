package ir;

import org.stringtemplate.v4.compiler.Bytecode;

import java.util.ArrayList;

public class BasicBlock extends User{
    private ArrayList<Instruction> instructions;

    public BasicBlock(Type type) {
        super(type);
    }

    public BasicBlock(Type type, String name) {
        super(type);
        setName(name);
    }

    public BasicBlock(Type type, ArrayList<Instruction> instructions) {
        super(type);
        this.instructions = new ArrayList<>();
        setInstructions(instructions);
    }

    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = new ArrayList<>();
        this.instructions.addAll(instructions);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (Instruction instruction : instructions) {
            sb.append(instruction.toString());
        }
        return sb.toString();
    }
}
