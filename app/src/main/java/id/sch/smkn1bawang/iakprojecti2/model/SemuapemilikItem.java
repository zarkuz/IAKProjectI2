package id.sch.smkn1bawang.iakprojecti2.model;

public class SemuapemilikItem{
	private String buku;
	private String nama;
	private String id;

	public void setBuku(String buku){
		this.buku = buku;
	}

	public String getBuku(){
		return buku;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
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
			"SemuapemilikItem{" + 
			"buku = '" + buku + '\'' + 
			",nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
