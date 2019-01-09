package parameters;

import java.io.File;
import java.io.IOException;

import utils.BackslashChange;

public class WhereIam {
	String dir;
	String dirforBash;
	
	public void search() {
		dir = System.getProperty("user.dir");
		setDir(dir);
		BackslashChange bc = new BackslashChange();
		String str = bc.change(dir);
		setDirforBash(str);
		
	}
	
	
	public void setup () {
		File f = new File(System.getProperty("user.home")+"\\.forGit.txt");
		if(!(f.exists())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
			   e.printStackTrace();
			}
		}
		
	}
	public String getDirforBash() {
		search();
		return dirforBash;
	}
	public void setDirforBash(String dirforBash) {
		this.dirforBash = dirforBash;
	}
	
	public String getDir() {
		return System.getProperty("user.dir");
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
}
