public class TopStreamingArtist extends Artist{
	private int topStreamCount;
	
	public TopStreamingArtist() {
		this.setName("");
		this.setPos(0);
		this.setSong("");
		this.setStream(0);
		this.setStreamCount(0);		
	}
	public TopStreamingArtist(Artist a) {
		this.setArtist(a);
		topStreamCount=1;
	}
	public void setStreamCount(int a) {
		topStreamCount=a;
	}
	public void addStreamCount() {
		topStreamCount++;
	}
	public int getStreamCount() {
		return topStreamCount;
	}
	public String toString() {
		return super.toString()+", "+topStreamCount;
	}
	public String nameToString() {
		return	String.format("%-30s%2d", super.getName().toString(),topStreamCount);
	}
}
