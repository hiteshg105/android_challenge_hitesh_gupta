package ixigo.ixigoflight.entity;

/**
 * Created by hitesh on 4/1/17.
 */

public class Flights
{
    private Fares fares;

    private String destinationCode;

    private String airlineCode;

    private long arrivalTime;

    private long departureTime;

    private String originCode;


    private String classCode;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Fares getFares ()
    {
        return fares;
    }

    public void setFares (Fares fares)
    {
        this.fares = fares;
    }

    public String getDestinationCode ()
    {
        return destinationCode;
    }

    public void setDestinationCode (String destinationCode)
    {
        this.destinationCode = destinationCode;
    }

    public String getAirlineCode ()
    {
        return airlineCode;
    }

    public void setAirlineCode (String airlineCode)
    {
        this.airlineCode = airlineCode;
    }

    public long getArrivalTime ()
    {
        return arrivalTime;
    }

    public void setArrivalTime (long arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public long getDepartureTime ()
    {
        return departureTime;
    }

    public void setDepartureTime (long departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getOriginCode ()
    {
        return originCode;
    }

    public void setOriginCode (String originCode)
    {
        this.originCode = originCode;
    }


}
