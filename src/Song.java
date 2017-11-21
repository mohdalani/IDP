import java.io.Serializable;

public class Song implements Serializable{
	private String title; // title
	private Artist artist; // artist
	private boolean favourit;
	
	
	public Song(String title , Artist artist , boolean favourit) {
			this.artist = artist;
			this.title = title;
			this.favourit = favourit;
	}
	/*
	 * to return artist 
	 */
	public Artist getArtist() {
		return artist;
	}
	/*
	 * to return String title
	 */
	
	public String getTitle() {
	return title;
	}
	/*
	 * to return boolean favourit
	 */
	
	public boolean isFavourit() {
		return favourit;
	}
	/*
	 * to seting the value of favourit
	 */

	public void setFavourit(boolean favourit) {
		this.favourit = favourit;
	}
	/*
	 * to seting the value of artist 
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	
	/*
	 *  to seting the value of 
	 */
	}

	public void setTitle(String title) {
		this.title = title;
	
	/*
	 * to return title of song and temp if it is favourit or not favourit and the information of the artist.
	 */
	}

	public String toString() {
		String temp = "";
		if (this.favourit)
			temp = "favourit";
			
		
		else
			temp = "not favourit";
	return title +"\t" + temp  +"\t"+ artist.artisInfo()  + "\n"; 
	}
	
	/*
	 * seting of the value of favourit in variable tem.
	 */
	
	public String tempFavourit() {
		String tem="";
		if(this.favourit)
			 tem="favourit";
		return tem;
		
	}
	

}

