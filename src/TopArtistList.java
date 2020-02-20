import java.io.*;

public class TopArtistList {
	Node first;
	
	static class Node{
		TopStreamingArtist artist;
		Node next;
	
		Node(TopStreamingArtist a){
			artist = a;
			next=null;
		}
	}
	
	public void insert( TopStreamingArtist artist) {				//Method to insert elements into linked list 
		
		Node newNode = new Node(artist);
		newNode.next=null;
		
		if (this.first==null) {				//For an empty list, the newnode becomes the first item
			this.first=newNode;
		}
		else {								//Otherwise, travel through the list until the last node is reached
			Node last=this.first;
			while (last.next!=null) {		
				last=last.next;
			}
			last.next=newNode;				//The new node becomes the last node in the list
		}
	}
	
	public static void printList(TopArtistList list, PrintWriter outfile) {					//Method to print the linked list
		
		Node current = list.first;
		
		while (current !=null) {			
			outfile.println(current.artist.nameToString());
			
			current=current.next;
		}
	}
	
}
