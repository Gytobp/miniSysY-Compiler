import ir.Definition;
import ir.Function;

import java.util.ArrayList;

// 由于是单文件、单次编译，把样例中的Module、EmitLLVM、IRBuilder这三个单例类结合为一类
public class IRBuilder {
    private static final IRBuilder instance = new IRBuilder();

    public static IRBuilder getInstance() {
        return instance;
    }

    public ArrayList<Definition> functionDefinitions = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Definition funcDef :
                functionDefinitions) {
            sb.append(funcDef);
        }
        return sb.toString();
    }

}
