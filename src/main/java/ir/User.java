package ir;

import java.util.ArrayList;

public class User extends Value{
    private ArrayList<Usage> operands;

    public User(Type type) {
        super(type);
    }

    public ArrayList<Usage> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Usage> operands) {
        this.operands = operands;
    }
}
