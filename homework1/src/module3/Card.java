package module3;

import java.util.Arrays;
import java.util.List;

public class Card {
    //封装卡牌
    private String color;
    private String number;
    //卡牌数字（已从大到小排序 颜色也排序了）
    public static final List<String> cardNum = Arrays.asList("大王","小王","2","A","K","Q","J","10","9","8","7","6","5","4","3");
    public static final List<String> colorsOption = Arrays.asList("黑","红","梅","方");

    @Override
    public String toString() {
        if(this.getNumber().equals("大王") || this.getNumber().equals("小王")){
            return "(" + this.getNumber() + ")";
        }
        return "(" + color + "," + number + ")";
    }

    public Card(String color, String number) {
        setColor(color);
        setNumber(number);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
