package app.data;

public class AlbumMuzica extends Media {
	protected String artist;
	protected String titlu;
	protected String gen;
	
	public AlbumMuzica(String suport, String artist, String titlu, String gen) {
		
		this.suport = suport;
		this.artist = artist;
		this.titlu = titlu;
		this.gen = gen;
	}
	
	@Override
	public String toString() {
		
		return this.getId() +". " +  suport + "    " + artist + " " + titlu +" " + gen;		
		
	}	

}
