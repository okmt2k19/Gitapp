package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import parameters.Data;
import parameters.FilePaths;

public class DeSerialize {
	public String DeSerial () {
		Data data = new Data();
		try {
			FilePaths fp = new FilePaths();
            ObjectInputStream objInStream 
              = new ObjectInputStream(
                new FileInputStream(fp.getDataDir()+"savedata.bin"));
            data = (Data) objInStream.readObject();
            
            objInStream.close();
      
            System.out.println(data.getRepository());
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return data.getRepository();
		
	}

}
