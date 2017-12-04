package id.sch.smkn1bawang.iakprojecti2.model;

import java.util.List;

public class ResponsePemilik{
	private boolean error;
	private String message;
	private List<SemuapemilikItem> semuapemilik;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setSemuapemilik(List<SemuapemilikItem> semuapemilik){
		this.semuapemilik = semuapemilik;
	}

	public List<SemuapemilikItem> getSemuapemilik(){
		return semuapemilik;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePemilik{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",semuapemilik = '" + semuapemilik + '\'' + 
			"}";
		}
}