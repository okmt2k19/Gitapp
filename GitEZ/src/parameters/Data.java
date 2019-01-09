package parameters;

import java.io.Serializable;

import utils.DeSerialize;
import utils.Serialize;


public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	public String repository;
	

	public void setRepository(String repository) {
		this.repository = repository;
		@SuppressWarnings("unused")
		Serialize seri = new Serialize(this);
	}
	public String getRepository() {
		return repository;
		
	}
	public String getRepositoryData() {
		DeSerialize deseri = new DeSerialize();
		
		return deseri.DeSerial();
		
	}
	

}
