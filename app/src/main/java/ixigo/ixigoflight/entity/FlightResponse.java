package ixigo.ixigoflight.entity;

import java.util.ArrayList;

/**
 * Created by hitesh on 4/1/17.
 */

public class FlightResponse
{
    private ArrayList<Flights> flights;

    private Appendix appendix;

    public ArrayList<Flights> getFlights ()
    {
        return flights;
    }

    public void setFlights (ArrayList<Flights> flights)
    {
        this.flights = flights;
    }

    public Appendix getAppendix ()
    {
        return appendix;
    }

    public void setAppendix (Appendix appendix)
    {
        this.appendix = appendix;
    }

    @Override
    public String toString()
    {
        return "FlightResponse [flights = "+flights+", appendix = "+appendix+"]";
    }
}
