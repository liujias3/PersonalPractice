package module2.homework2;

public class InternetPlan extends Plan implements InternetService{
    private int dataUsage;


    public InternetPlan(int dataUsage, int moneyCost) {
        // super for the father class module2.homework2.Plan
        super(moneyCost);
        setDataUsage(dataUsage);
    }

    //override show method from module2.homework2.Plan
    @Override
    public void show(){
        System.out.println("dataUsage: " + dataUsage + " moneyCost: " + getMoneyCost());
    }

    public int getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(int dataUsage) {
        this.dataUsage = dataUsage;
    }

    //override chat method from module2.homework2.InternetService
    @Override
    public void chat(int dataUsage, PhoneCard phoneCard) {
        System.out.println("By internet we can chat, this phoneCard user " + phoneCard.getUserName() + " use " + dataUsage + "G");
    }

    public static void main(String[] args) {
        InternetPlan internetPlan = new InternetPlan(300, 100);
        PhoneCard phoneCard = new PhoneCard(CardType.LARGECARD, "123", "lagou", "123456", 50, 120, 50);
        internetPlan.show();
        internetPlan.chat(300, phoneCard);
    }
}
