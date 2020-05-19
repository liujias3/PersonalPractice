package module1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoubleLuckyBall {

    public static void main(String[] args) {
        DoubleLuckyBall doubleLuckyBall = new DoubleLuckyBall();
        List<Integer> redBallList = new ArrayList<>();

        //generate the redBall List
        while(redBallList.size() < 6){
            int number = doubleLuckyBall.getRandom(6);
            //check for the duplicate
            if(!redBallList.contains(number)){
                redBallList.add(number);
            }
        }

        //generate blue ball
        int blueBall = doubleLuckyBall.getRandom(16);

        //print two ball seperate
        System.out.println("Red Ball List: " + redBallList.toString());
        System.out.println("Blue ball: " + blueBall);
    }

    public int getRandom(int range){
        //generate the random number for the input range
        Random random = new Random();

        //add one to slide the number from 1 to range
        int num = random.nextInt(range)+1;
        return num;
    }
}
