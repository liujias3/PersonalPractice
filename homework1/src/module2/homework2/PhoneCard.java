package module2.homework2;

public class PhoneCard {
    //1. private the member variable
    private CardType cardType;
    private String cardNumber;
    private String userName;
    private String password;
    private int restMoney;
    private int timeUsed;


    //set and get method
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType carType) {
        this.cardType = carType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(int restMoney) {
        this.restMoney = restMoney;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public int getInternetLimit() {
        return internetLimit;
    }

    public void setInternetLimit(int internetLimit) {
        this.internetLimit = internetLimit;
    }

    private int internetLimit;

    public PhoneCard(CardType cardType, String cardNumber, String userName, String password, int restMoney, int timeUsed, int internetLimit) {
        //set in the constructor
        setCardType(cardType);
        setCardNumber(cardNumber);
        setUserName(userName);
        setPassword(password);
        setRestMoney(restMoney);
        setTimeUsed(timeUsed);
        setTimeUsed(internetLimit);
    }

    public void show(){
        System.out.println("card Number: " + cardNumber + " userName: " + userName + " restMoney: " + restMoney);
    }

    public static void main(String[] args) {
        PhoneCard phoneCard = new PhoneCard(CardType.LARGECARD, "123", "lagou", "123456", 50, 120, 50);
        phoneCard.show();
    }
}
