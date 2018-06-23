package com.example.asus.afinal;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Change3Activity extends Activity implements LocationListener {

    Spinner citySpinner,stateSpinner;
    ArrayList<String> stringArrayState ;
    ArrayList<String> stringArrayCity = new ArrayList<String>();
    String spinnerStateValue, city;
    ArrayAdapter<String> adapterCity;
    LocationManager locationManager;
    Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change3);

        cancel_btn  = (Button) findViewById(R.id.cancel);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8) );

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        init();
    }
    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 5, this);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }
    void init() {
        citySpinner = (Spinner) findViewById(R.id.spinner2);
        stateSpinner = (Spinner) findViewById(R.id.spinner);

        stringArrayState = new ArrayList<String>();
        stringArrayCity = new ArrayList<String>();

        //set city adapter
        adapterCity = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, stringArrayCity);
        citySpinner.setAdapter(adapterCity);

        //Get state json value from assets folder
        try {
            JSONObject obj = new JSONObject(loadJSONFromAssetState());
            JSONArray m_jArry = obj.getJSONArray("statelist");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String state = jo_inside.getString("State");
                String id = jo_inside.getString("id");
                stringArrayState.add(state);
            }
            Log.d("xs", "init: " + stringArrayState.size());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout, R.id.txt, stringArrayState);
            stateSpinner.setAdapter(adapter);
        } catch (Exception e) {
            Log.d("", "init: "+e.toString());
            e.printStackTrace();
        }




        //state spinner item selected listner with the help of this we get selected value

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("xs", "init: ");

                Object item = parent.getItemAtPosition(position);
                Log.d("xs", "init: ");

                String Text = stateSpinner.getSelectedItem().toString();
                Log.d("xs", "init: ");


                spinnerStateValue = String.valueOf(stateSpinner.getSelectedItem());
                stringArrayCity.clear();

                try {
                    JSONObject obj = new JSONObject(loadJSONFromAssetCity());
                    JSONArray m_jArry = obj.getJSONArray("citylist");
                    stringArrayCity.add("Select City...");
                    for (int i = 0; i < m_jArry.length(); i++) {
                        JSONObject jo_inside = m_jArry.getJSONObject(i);
                        String state = jo_inside.getString("State");
                        String cityid = jo_inside.getString("id");

                        if (spinnerStateValue.equalsIgnoreCase(state)) {
                            city = jo_inside.getString("city");
                            stringArrayCity.add(city);
                        }

                    }

                    //notify adapter city for getting selected value according to state
                    adapterCity.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });






        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerCityValue = String.valueOf(citySpinner.getSelectedItem());
                Log.e("SpinnerCityValue",spinnerCityValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public String loadJSONFromAssetState() {
        String json = null;
        try {
            InputStream is = getAssets().open("state.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String loadJSONFromAssetCity() {
        String json = null;
        try {
            InputStream is = getAssets().open("cityState.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onLocationChanged(Location location) {
        int flag=1;
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String[] State= stringArrayState.toArray(new String[stringArrayState.size()]);
            for (int i=0;i<State.length;i++) {
                if(State[i].equals(addresses.get(0).getAdminArea())){
                    stateSpinner.setSelection(i);
                    flag=0;
                    break;
//                    int city= this.getResources().getIdentifier(addresses.get(0).getAdminArea()+"_items", "array", this.getPackageName());
//                    Log.d("kj", "onLocationChanged: "+city);
//
//                    String[] cit=getResources().getStringArray(city);
//                    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cit); //selected item will look like a spinner set from XML
//                    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                    citySpinner.setAdapter(spinnerArrayAdapter);
                }
            }
            if(flag==1){
                Toast.makeText(Change3Activity.this,addresses.get(0).getAdminArea()+" is not Available in list",Toast.LENGTH_SHORT).show();
            }
            else {
                flag = 1;
                String[] city = stringArrayCity.toArray(new String[stringArrayCity.size()]);
                for (int j = 0; j < city.length; j++) {
                    Log.d("" + city[j], "" + addresses.get(0).getLocality());
                    if (city[j].equals(addresses.get(0).getLocality())) {
                        citySpinner.setSelection(j);
                        break;
                    }
                }
                if (flag == 1) {
                    Toast.makeText(Change3Activity.this, addresses.get(0).getLocality() + " is not Available in list.Try Again", Toast.LENGTH_SHORT).show();
                }

            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(Change3Activity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
