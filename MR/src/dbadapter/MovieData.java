package dbadapter;

/**
 * Contains the necessary informations about a Movie.
 * 
 * @author swe.uni-due.de
 *
 */
public class MovieData {
	private String title;
    private String director;
    private String mainactor;
    private int publishdate;

    public MovieData(String title, String director,String mainactor, int publishdate) {
        this.title = title;
        this.director = director;
        this.mainactor = mainactor;
        this.publishdate = publishdate;
        
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMainactor() {
		return mainactor;
	}

	public void setMainactor(String mainactor) {
		this.mainactor = mainactor;
	}

	public int getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(int publishdate) {
		this.publishdate = publishdate;
	}
}
