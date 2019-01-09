package git;


import java.io.IOException;

import parameters.FilePaths;

 
public class UninstallGit {
	
	FilePaths fp = new FilePaths();
	String exepath = fp.getUninstallerpath();
    public static void main(String[] args) {
        
    }
    public void run () {
    	try {
            Process p1 = new ProcessBuilder(exepath).start();
            p1.waitFor(); 
            
        }catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    	
    }
}