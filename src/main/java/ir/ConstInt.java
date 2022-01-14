package ir;

public class ConstInt extends User{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ConstInt(Type type, int value) {
        super(type);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
