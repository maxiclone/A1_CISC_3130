import java.io.*;
import java.util.*;

public class Assignment_1_Main {

	public static void main(String[] args) throws FileNotFoundException{
		
		File newfile = new File("C:\\Users\\maxic\\Documents\\Eclipse\\AS_1_CISC_3130\\src\\topstreams.csv");
		
		Scanner input = new Scanner(newfile);
		String metatext = input.nextLine();
			   metatext = input.nextLine();
		Artist [][] topstream = new Artist();
			  
		while(input.hasNext()) {
			String thisLine = input.nextLine();					//Reading the CSV line into a string
			String[] line = thisLine.split(",");				//Splitting the string into string array elements
			
			int pos = Integer.parseInt(line[0].toString());		//Song position
			String song = line[1].toString();					//Song name
			String artist =  line[2].toString();				//Main artist
			int stream = Integer.parseInt(line[3].toString());	//Stream count
			String url= line[4].toString();
			
			Artist thisSong = new Artist(pos,song,artist,stream,url);
			topstream.add(thisSong);
			
			System.out.println(thisSong.toString());
		}
		
	}
}


