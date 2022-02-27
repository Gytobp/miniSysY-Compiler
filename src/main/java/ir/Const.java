package ir;

public class Const extends Value{
    public String ident;
    public int value;

    public Const(String ident, int value) {
        super(Type.INTEGER32);
        this.ident = ident;
        this.value = value;
    }

}
