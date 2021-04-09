package io.javabrains.movieCatalogService.model;

import java.util.List;

/**
 *
 * @author Julio Campaz.
 */
public class UserRating
{
    private List<Rating> userRating;

    public UserRating()
    {
    }

    public List<Rating> getUserRating()
    {
        return userRating;
    }

    public void setUserRating(final List<Rating> userRating)
    {
        this.userRating = userRating;
    }
}
