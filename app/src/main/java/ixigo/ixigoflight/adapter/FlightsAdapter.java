package ixigo.ixigoflight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Util.Utils;
import ixigo.ixigoflight.R;
import ixigo.ixigoflight.entity.FlightResponse;
import ixigo.ixigoflight.preferences.IxigoSharedPreferences;

/**
 * Created by hitesh on 4/1/17.
 */

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.MyViewHolder> {

    FlightResponse flightResponse;
    Context        context;

    public FlightsAdapter(Context context, FlightResponse flightResponse) {
        this.context = context;
        this.flightResponse = flightResponse;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvdepartureTime.setText(Utils.convertmilliToString(flightResponse.getFlights().get(position).getDepartureTime()));
        holder.tvarrivalTime.setText(Utils.convertmilliToString(flightResponse.getFlights().get(position).getArrivalTime()));
        holder.tvDestinationCode.setText(flightResponse.getFlights().get(position).getDestinationCode());
        holder.tvOriginCode.setText(flightResponse.getFlights().get(position).getOriginCode());
        holder.tvClass.setText(flightResponse.getFlights().get(position).getClassCode());
        holder.tvDestinationName.setText(IxigoSharedPreferences.getString(context,flightResponse.getFlights().get(position).getDestinationCode()));
        holder.tvOriginName.setText(IxigoSharedPreferences.getString(context,flightResponse.getFlights().get(position).getOriginCode()));
        holder.tvAirlineName.setText(IxigoSharedPreferences.getString(context,flightResponse.getFlights().get(position).getAirlineCode()));
        holder.tvProvider.setText(IxigoSharedPreferences.getString(context,String.valueOf(flightResponse.getFlights().get(position).getFares().getProviderId())));
        holder.tvFare.setText(String.valueOf(flightResponse.getFlights().get(position).getFares().getFare()));



    }

    @Override
    public int getItemCount() {
        return flightResponse.getFlights().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvdepartureTime, tvarrivalTime, tvDestinationCode, tvOriginCode, tvDestinationName, tvOriginName, tvProvider,tvFare, tvClass, tvAirlineName;

        public MyViewHolder(View view) {
            super(view);
            tvdepartureTime = (TextView) view.findViewById(R.id.departureTime);
            tvarrivalTime = (TextView) view.findViewById(R.id.arrivalTime);
            tvDestinationCode = (TextView) view.findViewById(R.id.destinationCode);
            tvOriginName = (TextView) view.findViewById(R.id.originName);
            tvDestinationName = (TextView) view.findViewById(R.id.destinationName);
            tvOriginCode = (TextView) view.findViewById(R.id.originCode);
            tvClass = (TextView) view.findViewById(R.id.classType);
            tvAirlineName = (TextView) view.findViewById(R.id.airlineName);
            tvProvider=(TextView) view.findViewById(R.id.provider);
            tvFare=(TextView) view.findViewById(R.id.fare);

        }
    }

}
