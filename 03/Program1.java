import java.io.*;

/** Program1.java
    Reads and writes single bytes to and from InputStream and OutputStream
    @author Amanda Veldman
*/

public class Program1 {

    public static void main ( String [] args){
        InputStream in = System.in;
        OutputStream out = System.out;
        int aByte;

        try{
            while ((aByte = in.read()) != 1){
                out.write(aByte);
            }
        } catch (IOException e){
            System.err.println("Execption Caught!");
        }
    }
}
