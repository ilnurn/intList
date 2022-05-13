import service.IntList;
import service.IntListImpl;

public class Main {

    public static void main(String[] args){
        IntList intList = new IntListImpl();
        intList.add(25);
        intList.add(16);
        intList.add(14);
        intList.add(7);
        intList.add(92);
        intList.add(137);
        intList.add(204);
        intList.add(305);
        System.out.println("intList.contains(305) = " + intList.contains(305));
        System.out.println("intList.get(0) = " + intList.get(0));
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i)+" ");
        }
    }
}
