package ies.moviequotes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
public class MovieQuoteController {
    
    private HashMap<String,ArrayList<String>> quotes = new HashMap<>();
    private ArrayList<String> movies = new ArrayList<String>();
    private Random random;
    

    public MovieQuoteController(){

        random = new Random();
        
        ArrayList<String> q1 = new ArrayList<String>();
        ArrayList<String> q2 = new ArrayList<String>();
        
        q1.add("MY MAN!");
        q1.add("By The Way, I Would Have Voted For Obama For A Third Term, If I Could.");
        q1.add("I'm TS-Motherf*****-A. We Handle S***.");
        q1.add("You Know I Can't Give You The Keys, Right, Babe?");
        q1.add("Now, You're In The Sunken Place.");
        q1.add("I Mean, I Told You Not To Go In That House.");
        q1.add("Sex Slave!");
        q1.add("Get Out!");
        q1.add("Black Is In Fashion.");
        q1.add("I Want Your Eye, Man.");
        q1.add("Behold, The Coagula.");

        q2.add("We apologize again for the fault in the subtitles. Those responsible for sacking the people who have just been sacked have been sacked.");
        q2.add("And the Lord Did Grin.");
        q2.add("Run Away! Run Away!");
        q2.add("'One Day All This Will Be Yours!' - Swamp King 'What, The Curtains?' - Herbert");
        q2.add("What Do You mean, an African or European swallow?");
        q2.add("Your Mother Was A Hamster And Your Father Smelt Of Elderberries!");
        q2.add("There Are Those Who Call Me...Tim.");
        q2.add("She Turned Me Into A Newt!... I Got Better.");
        q2.add("'You're Arm's Off!' - King Arthur 'No, It Isn't.'");
        q2.add("You Make Me Sad. So Be It. Come, Patsy.");
        q2.add("I Thought Your Son Was a Lady.");

        quotes.put("Get Out", q1);
        movies.add("Get Out");

        quotes.put("Monty Python", q2);
        movies.add("Monty Python");

    }


    @GetMapping("/api/quote")
    public MovieQuote quote(@RequestParam(value = "show", defaultValue = "-1" ) String show_id){

        int id = -1;
        
        try{
            id = Integer.parseInt(show_id);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
        
        if( id == -1){
            id = random.nextInt( movies.size());
        }

        String movie = movies.get(id);

        ArrayList<String> movie_quotes = quotes.get(movie);
        int random_quote_id = random.nextInt( movie_quotes.size());

        String quote = quotes.get(movie).get(random_quote_id);
        
        return new MovieQuote(id, movie, quote);
    }

    @GetMapping("api/shows")
    public ArrayList<String> shows(){
        return movies;
    }


}

