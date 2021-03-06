import java.io.*;

/** Program2.java
    Reads and writes lines using BufferedReader and print in reverse
    @author Amanda Veldman
*/

public class Program2{

    public static void main (String[] args){

        String input;
        BufferedReader in = new BufferedReader(new
                                               InputStreamReader(System.in));
        try {
            while ((input = in.readLine()) != null){
                StringBuilder result = new StringBuilder(input);
                result.reverse();
                System.out.println(result.toString());
            }
        } catch (IOException e){
            System.err.println("Exception Caught!");
        }
    }
}
        
