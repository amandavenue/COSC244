import java.io.*;

public class Caesar{
    public static void main(String args[]){

        InputStream in = System.in;
        OutputStream out = System.out;

        int rot = 0;
        int count;

        // check that arguments were entered 
        if (args.length > 0){
            try{
                // set rot to the first argument 
                rot = Integer.parseInt(args[0]);
            } catch (NumberFormatException e){
                System.out.print("Argument " + args[0] + " must be an Integer");
                System.exit(0);
            }
        } else {
            System.out.print("Enter an Integer into the command line");
        }

        try{
            // set count to the next byte
            while ((count = in.read()) != -1){
                // offset count by rot
                count += rot;
                if (count > 255){
                    // modulus count 
                    count = count % 256;
                }
                // write out the encrypted byte
                out.write(count);
                out.flush();
            }
            // close the output file
            out.close();
        } catch (IOException e){
            System.out.print("IO Exception caught " + e);
        }
    }
}
