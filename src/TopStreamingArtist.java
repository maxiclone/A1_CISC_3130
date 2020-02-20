public class TopStreamingArtist extends Artist{
	private int topStreamCount;
	private Artist next;
	
	//Constructors
	public TopStreamingArtist() {
		super();
		this.setStreamCount(0);
		next=null;
	}
	public TopStreamingArtist(Artist a) {
		this.setArtist(a);
		topStreamCount=1;
		next=null;
	}
	
	//Setters
	public void setStreamCount(int a) {
		topStreamCount=a;
	}
	
	//Modifiers
	public void addStreamCount() {
		topStreamCount++;
	}
	
	//Getter
	public int getStreamCount() {
		return topStreamCount;
	}
	
	//Setter and getter for linked list
	public void setNext(Artist n) {
		next=n;
	}
	public Artist getNext() {
		return next;
	}
	
	//toString methods
	public String toString() {
		return super.toString();
	}
	public String nameToString() {
		return	String.format("%-30s%2d", super.getName().toString(),topStreamCount);
	}
}
