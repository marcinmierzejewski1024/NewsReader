package pl.marcinmierzejewski;

public class Article {
	public long id;
	public String title = "";
	public String link = "";
	public String description = "";
	public String date = "";
	public int liked=0;
	
	@Override
	public String toString() {
		return title;
	}
}
