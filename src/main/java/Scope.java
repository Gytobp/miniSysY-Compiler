import ir.Value;

import java.util.ArrayList;
import java.util.HashMap;


// 只记录变量和常量，不包括函数
public class Scope {
    private static final ArrayList<HashMap<String, Value>> SymbolTables = new ArrayList<>();

    private Scope() {
    }

    public static boolean checkIdent(String ident) {
        var table = top();
        return table.get(ident) == null;
    }

    public static void push(HashMap<String, Value> table) {
        SymbolTables.add(table);
    }

    public static HashMap<String, Value> top() {
        return SymbolTables.get(SymbolTables.size()-1);
    }

    public static void pop() {
        SymbolTables.remove(top());
    }


}
