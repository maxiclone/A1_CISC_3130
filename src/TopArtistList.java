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
	
	public static TopArtistList insert(TopArtistList list, TopStreamingArtist artist) {				//Method to insert elements into linked list 
		
		Node newNode = new Node(artist);
		newNode.next=null;
		
		if (list.first==null) {
			list.first=newNode;
		}
		else {
			Node last=list.first;
			while (last.next!=null) {
				last=last.next;
			}
			last.next=newNode;
		}
		return list;
	}
	
	public static void printList(TopArtistList list, PrintWriter outfile) {					//Method to print the linked list
		
		Node current = list.first;
		
		while (current !=null) {
			System.out.println(current.artist.nameToString());
			outfile.println(current.artist.nameToString());
			current=current.next;
		}
	}
	
}
