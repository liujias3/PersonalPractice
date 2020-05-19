package module2.homework2;

public abstract class Plan {

    private int moneyCost;

    //abstract method
    public abstract void show();

    public int getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(int moneyCost) {
        this.moneyCost = moneyCost;
    }

    public Plan() {
    }

    public Plan(int moneyCost) {
        setMoneyCost(moneyCost);
    }
}
