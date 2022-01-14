package ir;


import java.util.ArrayList;

/* a call or part of Definition
 */
public class Function extends User {
    private int nameCount = -1;

    public String genName() {
        nameCount++;
        return String.valueOf(nameCount);
    }

    private ArrayList<BasicBlock> basicBlocks;
    private ArrayList<Parameter> parameters;
    private Type returnType;

    public Function(Type returnType, String name, ArrayList<Parameter> parameters) {
        super(Type.FUNCTION);
        this.returnType = returnType;
        setName("@" + name);
        this.parameters = new ArrayList<>();
        this.parameters.addAll(parameters);
        this.basicBlocks = new ArrayList<>();
    }

    public Function(Type returnType, String name, ArrayList<Parameter> parameters, BasicBlock basicBlock) {
        super(Type.FUNCTION);
        this.returnType = returnType;
        setName("@" + name);
        this.parameters = new ArrayList<>();
        this.parameters.addAll(parameters);
        this.basicBlocks = new ArrayList<>();
        addBasicBlock(basicBlock);
    }

    public Function(Type returnType, String name, ArrayList<Parameter> parameters, ArrayList<BasicBlock> basicBlocks) {
        super(Type.FUNCTION);
        this.returnType = returnType;
        setName("@" + name);
        this.parameters = new ArrayList<>();
        this.parameters.addAll(parameters);
        this.basicBlocks = new ArrayList<>();
        setBasicBlocks(basicBlocks);
    }

    public void addBasicBlock(BasicBlock basicBlock) {
        this.basicBlocks.add(basicBlock);
    }

    public void setBasicBlocks(ArrayList<BasicBlock> basicBlocks) {
        this.basicBlocks = new ArrayList<>();
        this.basicBlocks.addAll(basicBlocks);
    }

    @Override
    public String toString() {
        var isCall = basicBlocks.size() == 0;
        var sb = new StringBuilder();
        sb.append(returnType.string).append(" ").append(getName()).append("(");
        for (int i = 0; i < parameters.size(); i++) {
            Parameter parameter = parameters.get(i);
            if (!isCall) {
                parameter.setName("%" + this.genName());
            }
            sb.append(parameter.toString());
            if (i != parameters.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        if (!isCall) { // 如果是函数声明（不含define等），要加上函数体（最后不含换行符）
            sb.append(" {\n");
            for (BasicBlock basicBlock : basicBlocks) {
                basicBlock.setName(this.genName());
                for (Instruction instruction :
                        basicBlock.instructions) {
                    instruction.setName("%" + this.genName());
                }
                sb.append(basicBlock.toString());
            }
            sb.append("}");
        }
        return sb.toString();
    }
}
