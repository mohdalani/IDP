import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * this class has Arraylist from type songs 
 */
public class CD {
	ArrayList<Song>cdList;
	
	
	public CD() {
		
		cdList = new ArrayList<>();
		
	}
	
	public void mainTo() throws IOException {
		
        System.out.println("What would you like to do? \nType the number of the task you want.\n1- load.\n2- Add a new song.\n3- Show your CD.\n4- Delete a song.\n5-serch songs.\n6- Save.\n7-your favorite songs are.\n8-Exit");        
       

        boolean b = true;// it is mean user enter numbers from 1 to 8
           while (b) {    
                Scanner scanner1 = new Scanner(System.in);
                int n = 0;
                boolean test = false ;// it is mean the user enter characters.
                while (! test) {
                try {
                n = Integer.parseInt(scanner1.nextLine());
                test = true;
                } catch (NumberFormatException e) {
                	System.out.println("Sorry can you write a coorect number !!");
					}
                
                
                }
                if (n>0&&n<9) {
                    b = false;
                    if(n==1){
                    	load();// calling method to load.
                    }
                    else if(n==2){
                    	addCD();// calling method to add
                    }
                    else if(n==3){
                    	printCD();//calling method to show
                    	
                    }
                    else if(n==4){
                    	System.out.println("choose the song track that you want to delete"); 
                    	Scanner scanner = new Scanner(System.in); 
                    	 int N = scanner.nextInt(); 
                    	deleteSong(N);//calling method to delete.
                    	
                    }
                    else if (n==5){
                    	System.out.println("write name of your favorite Artist");
                    	Scanner scanner = new Scanner(System.in);
                    	String search = scanner.nextLine();
                    	 searchSubstring(search);// calling method to search.
                    }
                    else if (n==6) {
                    	Save();//calling method to save.
                    }
                    else if(n==7) {
                    	searchFavorite();// calling method to search about the Favorite songs
                    }
                    else if(n==8)
                    	System.out.println("thank you good bye");
                    	break;// to stop.
                  
                } else {
                    System.out.println(n + " Isn't a valid option... please enter a number between 1 and 8");
                }
             }        
    }
		/*
		 * this method to add staff to the array
		 */
	
		public void addCD() throws IOException{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the title");
			String title = scanner.nextLine();
			
			boolean favourit = false;
			System.out.println("Is it favourit ? Y/N");
			String isFavourit = scanner.nextLine();
				if (isFavourit.toUpperCase().equals("Y"))
							favourit = true;
				else favourit = false;
				
			System.out.println("Enter the name of the Artist");
			String artistName  = scanner.nextLine();
			
			System.out.println("Enter the age of the Artist");
			int artistAge  = Integer.parseInt(scanner.nextLine());
			
			System.out.println("how many songs he have");
			int songNum  = Integer.parseInt(scanner.nextLine());
		
			Artist art = new Artist(artistName, artistAge, songNum);
			Song song = new Song(title,art , favourit);
			cdList.add(song);
			mainTo();
		
		
		}
		/*
		 * this method to delete song
		 */
		
		public void deleteSong(int index) throws IOException{
		cdList.remove(index);
		System.out.println("the song is delete");
		mainTo();
		}
	
		/*
		 * this method to save song
		 */
		public void Save() throws IOException {
	       
		 try{
			 
            FileOutputStream fileOut = new FileOutputStream("C:\\eclipse\\Muhamed\\save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cdList);
            out.close();
            fileOut.close();
            System.out.println("Tasks are saved");
            
		 	}
         catch(IOException e){
            e.printStackTrace();
         		}
		   mainTo();
		}
		/*
		 * this method to load song
		 */
		public void load() throws IOException {
	       
		 try{
			 
            FileInputStream filein = new FileInputStream("C:\\eclipse\\Muhamed\\save.ser");
            ObjectInputStream out = new ObjectInputStream(filein);
            try {
				cdList = (ArrayList<Song>) out.readObject();
				out.close();
				filein.close();
				System.out.println("Tasks are loaded");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				}

		 	}
         catch(IOException e){
            e.printStackTrace();
         	}
		    mainTo();
		}
		
		/*
		 * this method to search about the name of the artist.
		 */
		public void searchSubstring(String search) throws IOException {
		  for (Song e : cdList) {
			
			  if(e.getArtist().getName().equals(search)) {
		    
				  System.out.println(e.toString() );
		     
			  				}
		  			}
		  mainTo();
		}
		
		/*
		 * print all songs in CD.
		 */
		public void  printCD() throws IOException  {
			
			for(int i = 0; i < cdList.size(); i++) {
	            System.out.println(cdList.get(i).toString());
					}
			mainTo();
		}
	
		/*
		 * this method to search about the Favorite songs. 
		 */
		
		public void searchFavorite() throws IOException {
			  for (Song e : cdList) {
				  
				  if(e.tempFavourit().equals("favourit")) {
			    
					  System.out.println(e.toString() );
			     
				  			}
			  		}
			   mainTo();	     
		}
		
}



	