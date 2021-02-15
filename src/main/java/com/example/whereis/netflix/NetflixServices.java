package com.example.whereis.netflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetflixServices {

    RestTemplate restTemplate = new RestTemplate();

    String url = "https://unogsng.p.rapidapi.com/search?orderby=relevance&query=";
    HttpHeaders headers = new HttpHeaders();


    public List<Netflix> getCountriesForMovie(String movie) {
        headers.set("x-rapidapi-key", "5ecfe71113msha84e2fa2a475fcep12394ajsn3bff7e395800");
        headers.set("x-rapidapi-host", "unogsng.p.rapidapi.co");
        url = url + movie;
        HttpEntity httpEntity = new HttpEntity(headers);
        List<Netflix> results = new ArrayList<>();
//        if (movie == "" || movie==null) {
//            List<String > abc = new ArrayList<>();
//            abc.add("Nepal");
//            results.add(new Netflix("My movie", abc, "7", "\"https://occ-0-2851-38.1.nflxso.net/dnm/api/v6/evlCitJPPCVCry0BZlEFb5-QjKc/AAAABYDAY7Malaj4klMEjUvy1YC7O6JXaUodaDIW2xyYs_huUch4quAuREHvGe6VlIj6o1K3THeI7eKXlBDuS6a-JZH7sw.jpg?r=d87\"", "8.5", "2010", "\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg\"" ));
//            return results;
//        }
        ResponseEntity<NetflixCountryResponse> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, NetflixCountryResponse.class);
        if (response.getBody().getResults() == null) {
            results.add(new Netflix(null, null, response.getHeaders().get("X-RateLimit-Requests-Remaining").get(0), null, null, null, null ));
            return results;
        }
        for (int i=0; i<5; i++) {
            if (response.getBody().getResults().length > i){
                Result result = response.getBody().getResults()[i];
                Netflix netflix = new Netflix();
                netflix.setApiCallsRemaining(response.getHeaders().get("X-RateLimit-Requests-Remaining").get(0));
                netflix.setTitle(result.getTitle());
                netflix.setImdbrating(result.getImdbrating());
                netflix.setPoster(result.getPoster());
                netflix.setImg(result.getImg());
                netflix.setYear(result.getYear());
                List<String> countryList = new ArrayList<>();
                String[] countries = response.getBody().getResults()[0].getClist().split(",");
                for (String country : countries) {
                    String countryName = country.split(":")[1].split("\"")[1];
                    if (!country.split(":")[0].split("\"")[1].equalsIgnoreCase("more")){
                        countryList.add(countryName);
                    }
                }
                netflix.setCountries(countryList);
                results.add(netflix);
            }
        }
        return results;
    }
}
