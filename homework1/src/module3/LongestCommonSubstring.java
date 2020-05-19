package module3;

public class LongestCommonSubstring {

    public String countLongestCommonSubstring(String first, String second){
        if (first.length() == 0 || second.length() == 0){
            return "没有相同的字符串";
        }

        //确保第一个是长的字符
        if(second.length() > first.length())
            countLongestCommonSubstring(second, first);

        int start = 0;
        int end = -1;
        for(int i = 0 ; i < second.length();i++){
            //外层遍历每个char字符
            for(int j = second.length() ; j > i ;j--){
                //内层从前向后依次递减
                String tmp = second.substring(i,j);
                if(first.contains(tmp) && (j-i > end - start)){
                    //如果包含该substring 同时长度超过已有值 更新起点终点
                    start = i;
                    end = j;
                }
            }
        }
        //确认如果没有公共字符串时
        if(end == -1)
            return "没有相同的字符串";
        else
            return "最大相同子串是" + second.substring(start, end);
    }

    public static void main(String[] args) {
        //测试用例
        LongestCommonSubstring longestCommonSubstring =  new LongestCommonSubstring();
        String result = longestCommonSubstring.countLongestCommonSubstring("asdafghjka", "aaasdfg");
        System.out.println(result);

        String result1 = longestCommonSubstring.countLongestCommonSubstring("fg", "asdafghjka");
        System.out.println(result1);

        String result2 = longestCommonSubstring.countLongestCommonSubstring("asdafghjka", "pp");
        System.out.println(result2);

    }
}
