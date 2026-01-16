import java.util.LinkedList;
import java.util.Scanner;

public class LRUCatch {

    private int cap;
    private static LinkedList<Integer> link;

    public LRUCatch(int cap) {
        this.cap = cap;
        this.link=new LinkedList<>();
    }

    private void put(int value){

        link.remove((Integer) value);

        if(link.size()== cap){
            link.removeFirst();
        }

        link.addLast(value);
        System.out.println("Cache : " + link);
    }

    private int get (int index){

        int newvalue=link.get(index);
        link.remove((Integer) newvalue);
      //  link.removeFirst();
        link.addLast(newvalue);

        return newvalue;
    }

   /* private static void display(){
        System.out.println("final list"+this.link);
    }*/
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of link");
        int n= sc.nextInt();
        LRUCatch cache=new LRUCatch(n);


       /* for(int i=0;i<n;i++){
         //cache[i]=sc.nextInt();
            int value=sc.nextInt();
            cache.put(value);
        }*/
      //  display();
       cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.put(5);
        cache.put(6);

        cache.get(1);
        System.out.println("finall Cache : " + link);
    }


}
