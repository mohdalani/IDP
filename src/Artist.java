import java.io.Serializable;

public class Artist implements Serializable {
	private String name;
	private int Age;
	private int songsNumber;
	
	public Artist(String name, int age, int songsNumber) {
		super();
		this.name = name;
		Age = age;
		this.songsNumber = songsNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getSongsNumber() {
		return songsNumber;
		/*
		 * songsNumber is mean songs number.
		 */
	}
	public void setSongsNumber(int songsNumber) {
		this.songsNumber = songsNumber;
	}
	/*
	 * to return the value of name, age and songs number.
	 */
	public String artisInfo()
	{
		return getName() + "\t" + getAge() +"\t" + getSongsNumber() + "\n"; 
		
	}

}
