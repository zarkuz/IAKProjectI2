package id.sch.smkn1bawang.iakprojecti2.model;

import java.util.List;

public class ResponseBuku{
	private boolean error;
	private String message;
	private List<SemuabukuItem> semuabuku;

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

	public void setSemuabuku(List<SemuabukuItem> semuabuku){
		this.semuabuku = semuabuku;
	}

	public List<SemuabukuItem> getSemuabuku(){
		return semuabuku;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBuku{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",semuabuku = '" + semuabuku + '\'' + 
			"}";
		}
}