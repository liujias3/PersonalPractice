package module1;

import java.util.Arrays;

public class Expansion {

    private int size;
    private int usage;
    private Object[] elementData;

    public Expansion(){
        //default size 10
        this.size = 10;
        this.usage = 0;
        this.elementData = new Object[10];
    }


    public Expansion(int initialCapacity) {
        //constructor
        if (initialCapacity > 0) {
            this.size = initialCapacity;
            this.usage = 0;
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    public boolean add(Object o){
        //before add check the size
        doubleCheck();
        this.elementData[usage++] = o;
        return true;
    }

    public void doubleCheck(){
        //double check the capacity if it reach the 80 percent of the current capacity, increase the size
        if((this.usage +1) >= (Math.floor(this.size * 0.8))){
            int newLength = (int)Math.ceil(this.size * 1.5);
            this.elementData = Arrays.copyOf(this.elementData, newLength);
            this.size = newLength;
        }
    }

    public static void main(String[] args) {
        //Set the initial Capacity
        Expansion expansion = new Expansion(10);

        //keep adding the number until reach the expansion capacity
        for(int i = 0; i < 15; i++){
            expansion.add(1);
            System.out.println("Current Usage  " + expansion.usage + "  Current Size: " + expansion.size);
        }

    }
}
