package ies.moviequotes;

public class MovieQuote {
    
    private final int id;
    private final String movie;
    private final String quote;

    public MovieQuote(int id, String movie, String quote){
        this.id = id;
        this.movie = movie;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public String getMovie() {
        return movie;
    }

    public String getQuote() {
        return quote;
    }

}
