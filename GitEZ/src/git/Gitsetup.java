package git;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Gitsetup {
	static PrintStream out;
    public static void main (String args[]) {
        try {
        	out = new PrintStream(System.out, true, "UTF-8");
        	Path tmp = Paths.get("Z:\\you\\tmp\\tmp.txt");
            ProcessBuilder pb = new ProcessBuilder("sh","/Z/you/sh/newset.sh");
            pb.redirectErrorStream(true);
            pb.redirectOutput(tmp.toFile());
            Process process = pb.start();
/*          InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            StringBuilder builder = new StringBuilder();

            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char)c);
            }
            out.println("result:\n" + builder.toString()); */
            //out.println("Command return code: " + process.waitFor());
            File file = new File("Z:\\you\\tmp\\tmp.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("\n\n"+"Command return code: " + process.waitFor());
            fw.close();
            FileReader fileReader = new FileReader(file);
            int data;
            while((data = fileReader.read()) != -1){
            	out.print((char)data);
            }
            fileReader.close();
            file.delete();
            File newfile = new File("Z:\\you\\tmp\\tmp.txt");
            newfile.createNewFile();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}