package module1;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static void main(String[] args) {

        List<Integer> perfectNumList = new ArrayList<>();

        //loop the number from 1 to 1000
        for(int i = 1 ; i < 1000 ; i++){
            int sum = 0;
            //increase the speed for check until the sqrt(i)
            for(int j = 1; j < Math.sqrt(i); j++)
            {
                if(i % j ==0) {
                    //add the two value multiply equal to i
                    sum += j;
                    sum +=  i / j;
                }

            }
            //because 1 * i = i so there will be an extra i in the sum
            sum -= i;
            if(sum==i) {
                perfectNumList.add(i);
            }
        }
        System.out.print("Perfect num under 1000: ");
        for(int i : perfectNumList){
            System.out.print(i + " ");
        }
    }
}
