
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	ArrayList<CD>cdList;
	
	
	public Register() {
		
		cdList = new ArrayList<>();
		
	}
	public void main() throws IOException {
        boolean b = true;
        System.out.println("What would you like to do? Type the number of the task you want.\n1- Add a new song.\n2- Show your CD.\n3- Delete a song.\n4- Save.\n5- Print serch songs.\n6- load");
        
        while (b) {
            try {    
                Scanner scanner1 = new Scanner(System.in);
                int n = Integer.parseInt(scanner1.nextLine());
                if (n>0&&n<7) {
                    b = false;
                    if(n==1){
                    	addCD();
                    }
                    else if(n==2){
                    	printCD();
                    }
                    else if(n==3){
                    	System.out.println("choose the song track that you want to delete"); 
                    	Scanner scanner = new Scanner(System.in); 
                    	 int N = scanner.nextInt(); 
                    	deleteSong(N);
                    }
                    else if(n==4){
                    	Save();
                    }
                    else if (n==5){
                    	System.out.println("write name of your favorite Artist");
                    	Scanner scanner = new Scanner(System.in);
                    	String search = scanner.nextLine();
                    	 searchSubstring(search);
                    }
                    else if (n==6) {
                    	load();
                    }
                } else {
                    System.out.println(n + " Isn't a valid option... please enter a number between 1 and 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 to 5 please...");    
            }
        }        
    }
			
	
	
public void addCD() throws IOException{
		System.out.println("Enter the name of the Artist");
		Scanner scanner = new Scanner(System.in);
		String artist  = scanner.nextLine();
		System.out.println("Enter the title");
		String title = scanner.nextLine();
		CD song = new CD(artist,title);
		cdList.add(song);
		main();
		
		
	}
	
	public void deleteSong(int index) throws IOException{
		cdList.remove(index);
		main();
    }
	

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
		    main();
    }
	
	 public void load() throws IOException {
	       
		 try{
			 
            FileInputStream filein = new FileInputStream("C:\\eclipse\\Muhamed\\save.ser");
            ObjectInputStream out = new ObjectInputStream(filein);
            try {
				cdList = (ArrayList<CD>) out.readObject();
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
		    main();
    }
	 
	public void searchSubstring(String search) {
		  for (CD e : cdList) {
			  //if (contains(e.getTitle(), search))
			  if(e.getArtist().equals(search))
		    {
				  System.out.println(e.toString() );
		     //  return e;
		    }
		  }
		  //return null; // nothing found
		  
		  
		}

		
		  boolean contains(String haystack, String needle) {
		 
		  if (haystack == null)
		    return false;

		  return haystack.contains(needle);
		}
	
		
		public void  printCD() throws IOException  {
			
			for(int i = 0; i < cdList.size(); i++) {
	            System.out.println(cdList.get(i).toString());
			}
			main();
		}
	}




/*
 * public void writeToFile(String fileName) {
 	 PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File (fileName));
			for(int i=0; i<cdList.size(); i++){
				writer.println(cdList.get(i).getArtist());
				writer.println(cdList.get(i).getTitle());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file could not be opened"); 
			System.exit(1);
		}
		writer.close();
		
		
 public void Save() throws IOException {
   
	 try{
		 
        FileOutputStream fileOut = new FileOutputStream("C:\\eclipse\\Muhamed\\save.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(cdList);
        out.close();
        fileOut.close();
        System.out.println("Tasks are saved");
        
    }
     catch(IOException e){
        e.printStackTrace();
    }
	    main();
}
		 

public void Save() throws IOException{
	FileWriter writer = new FileWriter("test.csv");

	writer.append((CharSequence) cdList);
	writer.append('\n');
	writer.flush();
	writer.close();
}

*/