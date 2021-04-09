package io.javaBrains.ratingsDataService.resource;

import io.javaBrains.ratingsDataService.models.Rating;
import io.javaBrains.ratingsDataService.models.UserRating;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julio Campaz.
 */
@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource
{
    @RequestMapping("/{movieId}")
    public Rating getRaiting(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId,4);
    }
    @RequestMapping("users/{userId}")
    public UserRating getRating(@PathVariable("userId") String userId)
    {
        List<Rating> ratings =Arrays.asList(
            new Rating("1234",4),
            new Rating("5678",3));
        UserRating userRating =  new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
