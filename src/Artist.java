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
		return name.replace("\"", "");
	}
	public int getStream() {
		return stream;
	}
	public String getUrl() {
		return url.toString();
	}
	public void setPos(int a) {
		pos=a;
	}
	public void setSong(String b) {
		song=b.toString();
	}
	public void setName(String c) {
		name=c.toString();
	}
	public void setStream(int d) {
		stream=d;
	}
	public void setUrl(String e) {
		url=e.toString();
	}
	public void setArtist(Artist art) {
		pos=art.getPos();
		song=art.getSong();
		name=art.getName();
		stream=art.getStream();
		url=art.getUrl();
	}
	public String toUrl() {
		return url.toString();
	}	
	public String toString() {
		return String.format("%1$s, %2$s, %3$s", pos,song.toString(),name.toString()); //pos+" "+song.toString()+" "+name.toString());
	}
}
