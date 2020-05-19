package module2.homework2;

public class UserCostInfo {
    private int totalTime;
    private int totalDataUsage;
    private int monthlyCost;

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalDataUsage() {
        return totalDataUsage;
    }

    public void setTotalDataUsage(int totalDataUsage) {
        this.totalDataUsage = totalDataUsage;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public UserCostInfo(int totalTime, int totalDataUsage, int monthlyCost) {
        setTotalTime(totalTime);
        setMonthlyCost(monthlyCost);
        setTotalDataUsage(totalDataUsage);
    }
}
