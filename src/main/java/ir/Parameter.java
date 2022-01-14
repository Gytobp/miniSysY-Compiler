package ir;

public class Parameter extends Value{
    public Parameter(Value.Type type, String name) {
        super(type);
        super.setName(name);
    }

    @Override
    public String toString() {
        return getType().string + " %" + getName();
    }
}
