package ixigo.ixigoflight;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import ixigo.ixigoflight.adapter.FlightsAdapter;
import ixigo.ixigoflight.entity.FlightResponse;
import ixigo.ixigoflight.network.VolleyManager;
import ixigo.ixigoflight.parser.JsonParser;


public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    public final String TAG="MainActivity";
    Button submit;
    RecyclerView recyclerView;
    FlightsAdapter flightsAdapter;
    Spinner spinner;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit= (Button) findViewById(R.id.bFind);
        recyclerView= (RecyclerView) findViewById(R.id.flightList);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestFlightDetails();

            }
        });

    }

    public void requestFlightDetails(){
        String tag_json_arry = "json_array_req";

        String url = "https://firebasestorage.googleapis.com/v0/b/gcm-test-6ab64.appspot.com/o/" +
                "ixigoandroidchallenge%2Fsample_flight_api_response.json?alt=media&token=d8005801" +
                "-7878-4f57-a769-ac24133326d6";

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();
                        FlightResponse flightResponse=JsonParser.parseFlightResponse(getApplicationContext(),response);
                        if(flightResponse!=null){
                            flightsAdapter= new FlightsAdapter(MainActivity.this,flightResponse);
                            mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setAdapter(flightsAdapter);
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });
// Adding request to request queue
        VolleyManager.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq, tag_json_arry);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
