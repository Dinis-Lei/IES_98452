package notcogniferouslda;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import notcogniferouslda.ipma_client.IpmaCityForecast;
import notcogniferouslda.ipma_client.IpmaService;

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

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_id);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
