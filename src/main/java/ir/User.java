package ir;

import java.util.ArrayList;

public class User extends Value{
    private ArrayList<Usage> usages;

    public User(Type type) {
        super(type);
    }

    public ArrayList<Usage> getUsages() {
        return usages;
    }

    public void setUsages(ArrayList<Usage> usages) {
        this.usages = usages;
    }
}
