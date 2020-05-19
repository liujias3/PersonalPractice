package module3;

import java.util.HashMap;
import java.util.Map;

public class StringDigitCount {
    public void count(String str){
        //判断边缘条件
        if(str.length() == 0){
            System.out.println("是一个空字符串");
            return;
        }
        //创建map
        Map<String, Integer> result  = new HashMap<>();
        //将String 分成char array
        String[] stringArray = str.split(",");
        //把每个string 加入到map中去
        for(String s : stringArray) {
            int currValue = result.getOrDefault(s, 0);
            result.put(s,++currValue);
        }

        //打印结果
        for (String key : result.keySet()){
            System.out.println(key + " 出现了 " + result.get(key) + " 次");
        }
    }

    public static void main(String[] args) {
        //测试用例
        StringDigitCount stringDigitCount = new StringDigitCount();
        stringDigitCount.count("123,456,789,123,456");
    }
}
