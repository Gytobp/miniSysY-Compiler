package ir;

public class FuncDefinition {
    public static final String DEF_FUNC = "define dso_local";

    public Function getFunc() {
        return func;
    }

    public void setFunc(Function func) {
        this.func = func;
    }

    private Function func;

    public FuncDefinition(Function func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return DEF_FUNC + " " + func.toString() + "\n";
    }
}
