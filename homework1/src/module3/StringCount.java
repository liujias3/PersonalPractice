package module3;

public class StringCount {

    //封装
    private int upperLetter;
    private int lowerLetter;
    private int digit;
    private int otherChar;

    public StringCount(String str){
        //计算大写，小写，数字，和其他
        countUpperLetter(str);
        countLowerLetter(str);
        countDigitLetter(str);
        countOther(str);
    }

    public int getUpperLetter() {
        return upperLetter;
    }

    public void setUpperLetter(int upperLetter) {
        this.upperLetter = upperLetter;
    }

    public int getLowerLetter() {
        return lowerLetter;
    }

    public void setLowerLetter(int lowerLetter) {
        this.lowerLetter = lowerLetter;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getOtherChar() {
        return otherChar;
    }

    public void setOtherChar(int otherChar) {
        this.otherChar = otherChar;
    }

    // 统计大写字符
    public void countUpperLetter(String str){
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c))
                upperLetter++;
        }
    }

    // 统计小写字符
    public void countLowerLetter(String str){
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c))
                lowerLetter++;
        }
    }

    // 统计数字字符
    public void countDigitLetter(String str){
        for(char c : str.toCharArray()){
            if(Character.isDigit(c))
                digit++;
        }
    }

    // 统计其他字符
    public void countOther(String str){
        //长度减去大小写和数字 算作其他
        otherChar = str.length() - upperLetter - lowerLetter - digit;
    }

    @Override
    public String toString() {
        //重写toString 方法
        return "统计字符串{" +
                "大写字符个数 = " + upperLetter +
                ", 小写字符个数 = " + lowerLetter +
                ", 数字 = " + digit +
                ", 其他 = " + otherChar +
                '}';
    }

    public static void main(String[] args) {
        //测试用例
        StringCount sc = new StringCount("ABCD123!@#$%ab");
        System.out.println(sc);
    }
}
