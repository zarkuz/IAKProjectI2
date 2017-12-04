package id.sch.smkn1bawang.iakprojecti2.model;

public class ResponsePemilikDetail{
	private Object buku;
	private Object nama;
	private Object noHp;
	private boolean error;
	private String message;

	public void setBuku(Object buku){
		this.buku = buku;
	}

	public Object getBuku(){
		return buku;
	}

	public void setNama(Object nama){
		this.nama = nama;
	}

	public Object getNama(){
		return nama;
	}

	public void setNoHp(Object noHp){
		this.noHp = noHp;
	}

	public Object getNoHp(){
		return noHp;
	}

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

	@Override
 	public String toString(){
		return 
			"ResponsePemilikDetail{" + 
			"buku = '" + buku + '\'' + 
			",nama = '" + nama + '\'' + 
			",no_hp = '" + noHp + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
