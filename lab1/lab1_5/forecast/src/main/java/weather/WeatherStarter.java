package weather;

//import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.StringBuilder;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //private static final int CITY_ID_AVEIRO = 1010500;
    private static int city_id = 1010500;

    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = LogManager.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {
        
        if (args.length > 0){
            try {
                city_id = Integer.parseInt(args[0]);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        IpmaConnection con = new IpmaConnection(city_id);
        IpmaCityForecast forecast = con.connection();


        if (forecast != null) {
            StringBuilder sb = new StringBuilder();
            String log = sb.append("max temp for today: ")
                            .append(forecast.getData().listIterator().next().getTMax())
                            .append('\n')
                            .append("min temp for today: ")
                            .append(forecast.getData().listIterator().next().getTMin())
                            .toString();
            logger.info(log);
        } else {
            logger.info( "No results!");
        }

    }
}
