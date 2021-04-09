package io.javabrains.movieCatalogService.model;

/**
 *
 * @author Julio Campaz.
 */
public class CatalogItem
{
    private String name;

    private String description;

    public CatalogItem(final String name, final String description, final int rating)
    {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public int getRating()
    {
        return rating;
    }

    private int rating;

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public void setRating(final int rating)
    {
        this.rating = rating;
    }
}
