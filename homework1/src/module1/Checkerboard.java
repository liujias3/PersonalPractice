package module1;

public class Checkerboard {
    private static  char[] coordinate = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        System.out.print("  ");

        //print the first line
        for(char c: coordinate){
            System.out.print("  " + c);
        }
        System.out.println();

        //use two for loops to going through the whole board
        for(char c: coordinate){
            //print the first col
            System.out.print(" "+c);
            for (char c2: coordinate){
                System.out.print("  +");
            }
            System.out.println();
        }
    }
}
