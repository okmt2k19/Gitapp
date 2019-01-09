package git;


import java.io.IOException;

import parameters.FilePaths;

 
public class LaunchGit {
	
	public LaunchGit() {
		
	}
	FilePaths fp = new FilePaths();
	String exepath = fp.getExepath();
    public static void main(String[] args) {
        
    }
    public void run (String script) {
    	try {
    		String cmdpath_and_executeshell = script;
            Process p1 = new ProcessBuilder(exepath,cmdpath_and_executeshell).start();
            p1.waitFor(); 
            
        }catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    	
    }
}