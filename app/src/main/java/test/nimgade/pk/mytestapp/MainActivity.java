package test.nimgade.pk.mytestapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.net.HttpURLConnection;

import rest.library.test101.model.Authentication;
import rest.library.test101.model.Headers;
import rest.library.test101.model.Parameters;
import rest.library.test101.model.RequestMethod;
import rest.library.test101.model.Response;
import rest.library.test101.network.connector.DefaultRestAPI;
import rest.library.test101.network.connector.MyResultCallBack;
import rest.library.test101.network.connector.NetworkConnector;
import rest.library.test101.network.connector.Request;
import rest.library.test101.network.connector.RestAPI;
import test.nimgade.pk.mytestapp.application.SharedUtils;
import test.nimgade.pk.mytestapp.application.StartUp;
import test.nimgade.pk.mytestapp.model.APIResponse;
import test.nimgade.pk.mytestapp.model.Optimizations;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button getTidButton;
    private TextView responseTextView;
    private RestAPI restAPI = new DefaultRestAPI();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        initializeUI();
    }

    private void initializeUI() {
        getTidButton = (Button) findViewById(R.id.MainActivity_get_tid_button);
        responseTextView = (TextView) findViewById(R.id.MainActivity_response_textView);
        getTidButton.setOnClickListener(getTid_onClickListener);

        SharedUtils sharedUtils = new SharedUtils();
        if (sharedUtils.readString(SharedUtils.TID_KEY) != null && !sharedUtils.readString
                (SharedUtils.TID_KEY).contentEquals("")) {
            responseTextView.setText("TID: " + sharedUtils.readString(SharedUtils.TID_KEY));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener getTid_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: getTid_onClickListener: ");

            Request.RequestBuilder builder = new Request.RequestBuilder();
            try {

                Headers.HeaderBuilder headerBuilder = new Headers.HeaderBuilder();
                Headers headers = headerBuilder.addHeader(new Headers.Header("Content-Type", "application/json")).build();
                Request firstRequest = builder.setUrlString(StartUp.getDomainName() +
                        "####################")
                        .addParameter(new Parameters.Parameter("###", "#################"))
                        .setAuthentication(Authentication.AUTHENTICATION_OAUTH_1_01_A)
                        .setHeaders(headers)
                        .setConsumerKey(StartUp.getConsumerKey())
                        .setConsumerSecret(StartUp.getConsumerSecret())
                        .setRequestMethod(RequestMethod.POST)
                        .setBody("#########################").build();

                final NetworkConnector networkConnector = new NetworkConnector(firstRequest, new MyResultCallBack() {
                    @Override
                    public void getResponse(final Response response) {
                        Log.d(TAG, "getResponse: " + response.getResponseCode());
                        Log.d(TAG, "getResponse: " + response.getResponseMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (responseTextView != null) {
                                    responseTextView.setText("" + response.getResponseMessage().trim());
                                }
                            }
                        });

                        if (response.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            APIResponse apiResponse = (new Gson()).fromJson(response
                                    .getResponseMessage().trim(), APIResponse.class);
                            System.out.println("Status Code: " + apiResponse.getStatusCode());
                            System.out.println("TID: " + apiResponse.getTid());
                            SharedUtils sharedUtils = new SharedUtils();
                            sharedUtils.saveString(SharedUtils.TID_KEY, apiResponse.getTid());
                            Optimizations optimizations = apiResponse.getOptimizations().get(0);
                            Log.d(TAG, "getResponse: optimizations:Data        " + optimizations
                                    .getData());
                            Log.d(TAG, "getResponse: optimizations:Path        " + optimizations
                                    .getPath());
                            Log.d(TAG, "getResponse: optimizations:ResponseId  " + optimizations
                                    .getResponseId());
                            Log.d(TAG, "getResponse: optimizations:Directives  " + optimizations
                                    .getDirectives());
                            Log.d(TAG, "getResponse: optimizations:DataMimeType " + optimizations.getDataMimeType());
                        }

                    }
                });

                networkConnector.makeNetworkCall();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
