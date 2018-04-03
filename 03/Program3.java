import java.util.*;

/** Program3
    reads and writes one line at a time and prints out uppercase
    @author Amanda Veldman
*/

public class Program3{
    public static void main (String [] args){

        Scanner sc = new Scanner(System.in);
        String input;

        while (sc.hasNextLine()){
            input = sc.nextLine();
            System.out.println(input.toUpperCase());
        }
    }
}
