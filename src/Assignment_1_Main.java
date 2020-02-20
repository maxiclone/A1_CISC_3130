/*
Items 61, 91, 119, 157, and 183 ignored due to String.split() conflict with song title 
Given the role of this assignment as a refresher for Java programming, the implementation was made to focus mainly on core ideas and not edge cases like the above 5.
*/

import java.io.*;				//Used for file io. 
import java.util.*;

public class Assignment_1_Main {

	public static void main(String[] args){
		try {
		File newfile = new File("src\\topstreams.csv");			//Reads CSV into java
		Scanner input = new Scanner(newfile);					//Creates scanner for the input file
		
		String metatext = input.nextLine();						//Metatext created to ignore the first two lines of metatext in csv file.
			   metatext = input.nextLine();					
			   
		ArrayList<TopStreamingArtist> topstream = new ArrayList<TopStreamingArtist>();	
		System.out.println(String.format("%-8s %-25s %15s", "Rank","Song","Artist"));
		while(input.hasNext()) {
			String thisLine = input.nextLine();					//Reading the CSV line into a string
			String[] line = thisLine.split(",");				//Splitting the string into string array elements
			String song;										//initializing the string object song
			
			int pos = Integer.parseInt(line[0].toString());		//Song position
			
			if (line[1].toString().replace("\"", "").length()>30) {
				song = line[1].toString().replace("\"", "").substring(0, 29);
			}
			else {song = line[1].toString().replace("\"", "");}					//Song name
			String artist =  line[2].toString().replace("\"", "");				//Main artist
			int stream = Integer.parseInt(line[3].toString());	//Stream count
			String url= line[4].toString();
			
			Artist thisArtist = new Artist(pos,song,artist,stream,url);
			TopStreamingArtist newArtist = new TopStreamingArtist(thisArtist);	//Polymorphing the Artist into a topstreaming artist
			topstream.add(newArtist);
			
			System.out.println(newArtist.toString());			//Prints the read inputs to console 
		}
			ArrayList<TopStreamingArtist> topStreamL = listTopStreamers(topstream);
			TopArtistList list = sortArtistList(topStreamL);
			System.out.println(list.toString());
			
			try {
				PrintWriter outfile = new PrintWriter("src\\TopArtistsOutput.txt");												//Prints out the list of top streaming artist with formatting in output file
				outfile.println("Artist                 Songs in Top Streaming List");
				outfile.println("__________________________________________________");
				outfile.flush();
				
				for (int i =0;i<topStreamL.size();i++) {
					outfile.println(topStreamL.get(i).nameToString());
					outfile.flush();							
				}
				
				PrintWriter outfile2 = new PrintWriter("src\\ABCList.txt");													//Prints the list of streaming artists in alphabetical order
				outfile2.println();
				outfile2.println("Artist                Songs in Top Streaming List");
				TopArtistList.printList(list, outfile2);
				
				outfile.close();
				outfile2.close();
			}
			catch (IOException a){
				System.out.println("Output File Not Found");
			}
		input.close();
		}
		catch (FileNotFoundException f){
			System.out.println("File Not Found");
		}
	}	
	
	/*Method listTopStreamers
	 *input:
	 *	ArrayList of Artists
	 *Process:
	 *	Filters through the list of artists and gets rid of duplicates, while recording the number of times an artist has appeared in the list
	 *OutPut:
	 *	A new arraylist of top streaming artists with duplicates removed.   
	 */
	
	public static ArrayList<TopStreamingArtist> listTopStreamers(ArrayList<TopStreamingArtist> a) {
		ArrayList<TopStreamingArtist> newList = new ArrayList<TopStreamingArtist>(a); 		//Clones a new arraylist of topstreaming artist to leave original intact
		
		//Artists are filtered and duplicates removed
		for (int i=0;i<newList.size()-1;i++) {														//Using the outer loop to read in all the artists from the top streaming list			
			TopStreamingArtist temp = a.get(i);
			
			for (int j=1;j<newList.size();j++) {												//Using the inner loop to compare each artist to other artists
				if(temp.getName().equals(newList.get(j).getName())) {
					newList.remove(j);
					newList.get(i).addStreamCount();
				}
				
			}																				//Using the counter within the TopStreamingArtist class to account for duplicate appearances and remove them from the list.
		}
		return newList; 
	}
	/*Method sortArtistList
	 * input:
	 * 		List of top streamers
	 * Process:
	 * 		Sorts the list by Alphabetical Order
	 * 		Inserts the elements into a linked list
	 * Output:
	 * 		Linked list of top streaming artists in abc order
	 */
	public static TopArtistList sortArtistList(ArrayList<TopStreamingArtist> a) {
		TopArtistList list = new TopArtistList();
		
		for (int i=0; i<a.size()-1;i++) {													//Uses selection Sort algorithm to sort the input array
			int index=i;
			for (int j=i+1;j<a.size();i++) {
				if (a.get(j).getName().compareTo(a.get(index).getName())>0){
					index=j;
					
				Artist before =a.get(index);
				a.get(index).setArtist(a.get(i));
				a.get(i).setArtist(before);					
				}
			}
		}
		for (int i=0;i<a.size();i++) {
			TopArtistList.insert(list, a.get(i));	
		}
		
		
		return list;
	}
	
	
	/*	
	public static void sortByName(ArrayList<Artist> A) {
		int n = A.size();		
		for (int i=1;i<n;i++) {										//Sorting Algorithm used is Selection Sort		
			int j = i-1;
			
			Artist temp = A.get(j);
			Artist pointer = A.get(i);
		
			if (pointer.getName().compareTo(temp.getName())<0) {
				A.get(i).setArtist(pointer);
				A.get(j).setArtist(temp);
				
			}
		}
	}
	 */	
		
}


