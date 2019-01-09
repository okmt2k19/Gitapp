package utils;

import java.util.ArrayList;

public class BackslashChange {
	public String change (String dir) {
		String [] tempArray = dir.split("");
		ArrayList<String> array = new ArrayList <String> ();
		array.add("/");
		for (int i = 0 ;  i < tempArray.length ; i ++) {
			if(tempArray[i].equals(":")) {
			}else if(tempArray[i].equals("\\")) {
				array.add("/");
			}else {
				array.add(tempArray[i]);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0 ; i < array.size() ; i ++) {
			builder.append(array.get(i));
		}
		dir = builder.toString();
		return dir;
	}

}
