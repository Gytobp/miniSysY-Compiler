package ir;

import java.util.ArrayList;

public class Value {
    public enum Type {
        FUNCTION(""),
        VOID("void"),
        INTEGER1("i1"),
        INTEGER32("i32"),
        LABEL("label"),
        POINTER(""), // TODO * ??
        ARRAY(""); // TODO unknown ??

        public final String string;

        private Type(String string) {
            this.string = string;
        }
        
        public static Type getTypeFromString(String string) {
            for (Type t :
                    Type.values()) {
                if (t.string.equals(string)) {
                    return t;
                }
            }
            return null;
        }

    }

    private Type type;
    private String name;

    private ArrayList<Usage> usages;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Usage> getUsages() {
        return usages;
    }

    public void setUsages(ArrayList<Usage> usages) {
        this.usages = usages;
    }

    public Value(Type type) {
        this.type = type;
        this.usages = new ArrayList<>();
    }
}
