class Artist {
	private int pos;
	private String song;
	private String name;
	private int stream;
	private String url;
	
	public Artist() {
		pos=0;
		song="";
		name="";
		stream=0;
		url="";
	}
	public Artist(int a, String b, String c, int d, String e) {
		pos=a;
		song=b.toString();
		name=c.toString();
		stream=d;
		url=e.toString();
	}
	public Artist(Artist a) {
		pos=a.getPos();
		song=a.getSong();
		name=a.getName();
		stream=a.getStream();
	}
	
	public int getPos() {
		return pos;
	}
	public String getSong() {
		return song.toString();
	}
	public String getName() {
		return name.toString();
	}
	public int getStream() {
		return stream;
	}
	public String toUrl() {
		return url.toString();
	}	
	public String toString() {
		return (pos+" "+song+" "+name+" "+stream);
	}

	
}
