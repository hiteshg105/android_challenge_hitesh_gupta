package ixigo.ixigoflight.entity;

/**
 * Created by hitesh on 4/1/17.
 */

public class Appendix
{
    private Providers[] providers;

    private Airports[] airports;

    private Airlines[] airlines;

    public Providers[] getProviders ()
    {
        return providers;
    }

    public void setProviders (Providers[] providers)
    {
        this.providers = providers;

    }

    public Airports[] getAirports ()
    {
        return airports;
    }

    public void setAirports (Airports[] airports)
    {
        this.airports = airports;
    }

    public Airlines[] getAirlines ()
    {
        return airlines;
    }

    public void setAirlines (Airlines[] airlines)
    {
        this.airlines = airlines;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [providers = "+providers+", airports = "+airports+", airlines = "+airlines+"]";
    }
}
