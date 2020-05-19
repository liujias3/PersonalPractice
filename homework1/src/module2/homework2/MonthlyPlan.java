package module2.homework2;

public class MonthlyPlan extends Plan implements MonthlyService{
    private int timeUsed;
    private int messageCnt;

    public MonthlyPlan(int timeUsed, int messageCnt, int moneyCost) {
        super(moneyCost);
        setTimeUsed(timeUsed);
        setMessageCnt(messageCnt);
    }

    //override show method from module2.homework2.Plan
    @Override
    public void show(){
        System.out.println("timeUsed: " + timeUsed + " messageCnt: " + messageCnt + " moneyCost: " + getMoneyCost());
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public int getMessageCnt() {
        return messageCnt;
    }

    public void setMessageCnt(int messageCnt) {
        this.messageCnt = messageCnt;
    }

    //override call method from module2.homework2.MonthlyService
    @Override
    public void call(int callTime, PhoneCard phoneCard) {
        System.out.println("We can use call service, this phoneCard user "+ phoneCard.getUserName() + " use call Time " + callTime + " minutes");
    }

    public static void main(String[] args) {
        MonthlyPlan monthlyPlan = new MonthlyPlan(300, 50, 100);
        PhoneCard phoneCard = new PhoneCard(CardType.LARGECARD, "123", "lagou", "123456", 50, 120, 50);
        monthlyPlan.show();
        monthlyPlan.call(300, phoneCard);
    }
}
