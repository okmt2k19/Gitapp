package git;


import java.io.IOException;

import parameters.FilePaths;

 
public class InstallGit {
	
	
	
    public static void main(String[] args) {
        
    }
    public void run () {
    	try {
    		FilePaths fp = new FilePaths();
    		String exepath = fp.getInstallerpath();
    		System.out.println("filepath :" + exepath);
            Process p1 = new ProcessBuilder(exepath).start();
            p1.waitFor(); 
            
        }catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    	
    }
}