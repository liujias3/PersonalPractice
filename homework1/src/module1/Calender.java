package module1;

import java.io.*;
import java.util.Scanner;

public class Calender {

    public static void main(String[] args) {
        //获取输入
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the Year Info: ");
        int year  = sc.nextInt();
        System.out.println("Please input the Month Info: ");
        int month  = sc.nextInt();
        System.out.println("Please input the Day Info: ");
        int day  = sc.nextInt();

        //判断输入条件
        if(year < 0 || month < 0 || day < 0){
            System.out.println("Wrong input");
            System.exit(0);
        }

        boolean flag = false;
        int result = 0;

        //闰年判断条件 1.能被4整除同时不能被100整除 2. 能被400整除
        if((year % 4 == 0) && (year % 100 !=0) || (year % 400 ==0)){
            if(month > 2){
                flag = true;
            }
        }

        switch (month){
            case 1: result = 0 ;break;
            case 2: result = 31 ;break;
            case 3: result = 59;break;
            case 4: result = 90 ;break;
            case 5: result = 120 ;break;
            case 6: result = 151 ;break;
            case 7: result = 181 ;break;
            case 8: result = 212 ;break;
            case 9: result = 243 ;break;
            case 10: result = 273 ;break;
            case 11: result = 304 ;break;
            case 12: result = 334 ;break;
        }
        //添加闰年 2月29号 那一天
        result = flag? result + day + 1 : result + day;

        System.out.println("This day is the " + result + "th day for "+ year + " year");

    }


}
