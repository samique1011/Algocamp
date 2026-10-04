import java.util.ArrayList;

public class firstProgram {
    public static void main(String args[]){
        ArrayList <Integer> li = new ArrayList<Integer>();
        li.add(23);
        li.add(50);

        for(int a : li){
            System.out.print(a + " ");
        }

        ArrayList<String> ls = new ArrayList<>();
        ls.add("Hello");

        ls.add("This is an array list");

        ls.set(0 , "Hi instead of hello");

        ls.remove(1);

        for(String s : ls){
            System.out.println(s);
        }



    }
}
