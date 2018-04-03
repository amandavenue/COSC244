import java.io.*;
import java.util.*;

public class BitLevel{
    public static void main(String args[]){

        String infile = "";
        String outfile = "";

        String keyString;
        byte [] key;
        int pos = 0;

        // if there are two args set them to infile and outfile
        if (args.length >0){
            infile = args[0];
            outfile = args[1];
        } else {
            System.out.println("Please enter two args");
        }

        System.out.println("Enter Key: ");
        Scanner sc = new Scanner (System.in);
        //read in the keystring
        keyString = sc.nextLine();
        //set the key to the bytes of the key string 
        key = keyString.getBytes();

        try{
            //read in the infile and outfile as input and output streams
            FileInputStream in = new FileInputStream(infile);
            FileOutputStream out = new FileOutputStream(outfile);

            // read in the first byte
            int b = in.read();

            while (b != -1){;
                // reset the key position to 0 if it reaches the end of the key
                if (pos >= keyString.length()){
                    pos = 0;
                }

                //write out the encrypted bit
                out.write(key[pos]^b);
                //increment the key position
                pos++;
                out.flush();
                //read in the next byte
                b = in.read();
            }
            //close the out file
            out.close();
        } catch (IOException e){
            System.err.println("IO Exception " + e);
        }
    }
}

