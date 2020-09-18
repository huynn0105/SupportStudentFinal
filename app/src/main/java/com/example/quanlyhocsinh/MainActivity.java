package com.example.quanlyhocsinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Activity.SignupActivity;
import com.example.Activity.TkbLopActivity;
import com.example.Activity.TraCuuHSTSActivity;
import com.example.Activity.TraCuuSVActivity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

public class MainActivity extends AppCompatActivity {


//    private static final String NAMESPACE = "http://thienhaso.com/";
//    private static final String URL = "http://phanmemdaotao.com/testapi/AccountAPI.asmx?WSDL";
//
//    private static final String METHOD_NAME = "HelloWorld";
//    private static final String SOAP_ACTION = NAMESPACE+METHOD_NAME;
    Button btn_tracuutt;
    String TAG = "Response";

    String getCel;
    SoapPrimitive resultString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tracuutt = findViewById(R.id.btn_tracuutt);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        AsyncCallWS task = new AsyncCallWS();
        task.execute();
//        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
//        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//        envelope.setOutputSoapObject(request);
//        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//        try {
//            androidHttpTransport.call(SOAP_ACTION, envelope);
//
//
//            SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
//
//
//            Log.d("kiemtra",resultsRequestSOAP.toString());
//            System.out.println("Response::" + resultsRequestSOAP.toString());
//
//
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }


        btn_tracuutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TraCuuHSTSActivity.class));
            }
        });

    }

    public void tkbLop(View view) {
        startActivity(new Intent(MainActivity.this, TkbLopActivity.class));
    }

    public void DKXetTuyen(View view) {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }

    public void TracuuSV(View view) {
        startActivity(new Intent(MainActivity.this, TraCuuSVActivity.class));
    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            calculate();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(MainActivity.this, "Response" + resultString.toString(), Toast.LENGTH_LONG).show();
        }

    }


    public void calculate() {

        String METHOD_NAME = "HelloWorld";
        String NAMESPACE = "http://thienhaso.com/";
        String URL = "http://phanmemdaotao.com/testapi/AccountAPI.asmx?WSDL";
        String SOAP_ACTION = NAMESPACE+METHOD_NAME;
        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("Celsius", getCel);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            transport.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();
            Log.i(TAG, "Result Celsius: " + resultString);
        } catch (Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
    }

}