import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.NotSerializableException;
public class CD implements Serializable{
	private String artist; // artist
	private String title; // titel
	
	public CD(String artist, String title) {
			this.artist = artist;
			this.title = title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
	return title;
	}
	
	public String toString() {
	return artist + "\t" + title; 
	}
}
