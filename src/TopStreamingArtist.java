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
	public TopStreamingArtist(TopStreamingArtist a) {
		super.setArtist(a);
		topStreamCount=a.getStreamCount();
		next.setArtist(a.getNext());
	}
	
	//Setters
	public void setArtist(TopStreamingArtist a) {
		super.setArtist(a);
		topStreamCount=a.getStreamCount();
		next.setArtist(a.getNext());
	}
	public void setStreamCount(int a) {
		topStreamCount=a;
	}
	
	//Modifiers
	public void addStreamCount() {
		topStreamCount++;
	}
	
	//Getter
	public String getName() {
		return super.getName();
	}
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
		return	String.format("%-30s %2d", super.getName().toString(),topStreamCount);
	}
}
