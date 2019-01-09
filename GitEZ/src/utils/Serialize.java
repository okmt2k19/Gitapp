package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import parameters.Data;
import parameters.FilePaths;

public class Serialize {
	public Serialize(Object obj) {
		Data data = (Data)obj;
		System.out.println("object : "+data.getRepository());
		try {
			FilePaths fp = new FilePaths();
			ObjectOutputStream objOutStream = 
					new ObjectOutputStream(
							new FileOutputStream(fp.getDataDir()+"savedata.bin"));
			objOutStream.writeObject(data);
			objOutStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
