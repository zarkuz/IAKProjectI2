package id.sch.smkn1bawang.iakprojecti2.model;

public class SemuabukuItem{
	private String namaPemilik;
	private String buku;
	private String id;

	public void setNamaPemilik(String namaPemilik){
		this.namaPemilik = namaPemilik;
	}

	public String getNamaPemilik(){
		return namaPemilik;
	}

	public void setBuku(String buku){
		this.buku = buku;
	}

	public String getBuku(){
		return buku;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"SemuabukuItem{" + 
			"nama_pemilik = '" + namaPemilik + '\'' + 
			",buku = '" + buku + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
