package io.javaBrains.movieInfoService.resources;

import io.javaBrains.movieInfoService.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julio Campaz.
 */
@RestController
@RequestMapping("/movies")
public class MovieResource
{

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId)
    {
        return new Movie(movieId, "Test Name");
    }

}
