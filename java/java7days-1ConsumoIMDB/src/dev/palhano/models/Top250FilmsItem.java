package dev.palhano.models;

public class Top250FilmsItem {
	private String id ;
	private String rank ;
	private String title ;
	private String fullTitle ;
	private String year ;
	private String image ;
	private String crew ;
	private String imDbRating ;
	private String IMDbRatingCount;
	
	@Override
	public String toString() {
		return "Filme [rank=" + rank + ", title=" + title + ", year=" + year + ", crew="
				+ crew + "]";
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getImage() {
		return image;
	}

	public String getNota() {
		return imDbRating;
	}
	
	
	
}
