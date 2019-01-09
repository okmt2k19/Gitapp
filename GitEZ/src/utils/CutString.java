package utils;



import parameters.Data;

public class CutString {
	public String cutFIilename (String str) {
		/***********
		String [] strArray = str.split("");
		int length = strArray.length;
		ArrayList <String> returnArray = new ArrayList<String>();
		for(int i = length ; i == 0 ; i-- ) {
			if(strArray.equals("/")) {
				for(int j = i; j < length ; j++) {
					returnArray.add(strArray[j]);
				}
				break;
			}
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i< returnArray.size() ; i ++) {
			builder.append(returnArray.get(i));
		}
		str = builder.toString();
		***********/
		int pos = str.lastIndexOf('/');
		if (pos != -1) {
			str = str.substring(pos+1);
		}
		return str;
	}
	public String cutPath (String str) {		

		Data data = new Data();
		String reponame = data.getRepositoryData();
		BackslashChange bc = new BackslashChange();
		String str2 = bc.change(str);
		int stackpos = 0;
		

		int pos = str2.indexOf(reponame);
		if(pos != -1) {
			stackpos = pos;
		}
		while(pos != -1) {
			pos = str2.indexOf(reponame , pos+1);
			if(pos != -1) {
				stackpos = pos;
			}
		}
		if(stackpos == 0) {
			str = "e";
		}else if(stackpos != 0) {
			String [] work = str2.split("");
			StringBuilder builder = new StringBuilder();
			for (int i = stackpos; i < work.length ; i ++) {
				builder.append(work[i]);
			}
			str = builder.toString();
		}

		System.out.println("new path : "+str);
		return str;
	}
	public String cutPathforjava(String str) {
		Data data = new Data();
		String reponame = data.getRepositoryData();
		String str2 = str;
		int stackpos = 0;
		

		int pos = str2.indexOf(reponame);
		if(pos != -1) {
			stackpos = pos;
		}
		while(pos != -1) {
			pos = str2.indexOf(reponame , pos+1);
			if(pos != -1) {
				stackpos = pos;
			}
		}
		if(stackpos == 0) {
			str = "e";
		}else if(stackpos != 0) {
			String [] work = str2.split("");
			StringBuilder builder = new StringBuilder();
			for (int i = stackpos; i < work.length ; i ++) {
				builder.append(work[i]);
			}
			str = builder.toString();
		}

		System.out.println("new path : "+str);
		return str;
	}

}
