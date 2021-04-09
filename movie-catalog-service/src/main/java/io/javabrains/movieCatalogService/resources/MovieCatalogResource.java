package io.javabrains.movieCatalogService.resources;

import com.netflix.discovery.DiscoveryClient;
import io.javabrains.movieCatalogService.model.CatalogItem;
import io.javabrains.movieCatalogService.model.Movie;
import io.javabrains.movieCatalogService.model.Rating;
import io.javabrains.movieCatalogService.model.UserRating;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Julio Campaz.
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webclientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {

        //Get all rated movie ids

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"
            +userId, UserRating.class);
        //For each movie ID, call the movie info service and get details
        return userRating.getUserRating().stream().map(rating -> {
                Movie movie =
                    restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),
                  Movie.class);
//            Movie movie =
//                webclientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            return new CatalogItem(movie.getName(), "desc", rating.getRating());
        }).collect(Collectors.toList());
        //Put them all together
    }
}
