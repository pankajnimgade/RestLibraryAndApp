package rest.library.test101.network.connector;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import rest.library.test101.model.Authentication;
import rest.library.test101.model.Headers;
import rest.library.test101.model.Parameters;
import rest.library.test101.model.RequestMethod;
import rest.library.test101.model.Response;


/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */
public class DefaultRestAPI extends RestAPI {


    @Override
    public Response callRequest(Request request) throws Exception {

        StringBuilder currentUrlString = new StringBuilder();
        if (request.urlString == null) {
            throw new NullPointerException("url String can't be null");
        }
        currentUrlString.append(request.urlString);

        if (request.getParameterHashSet() != null && !request.getParameterHashSet().isEmpty()) {
            final Iterator<Parameters.Parameter> parameterIterator = request.getParameterHashSet().iterator();
            if (request.urlString.contains("?")) {
                while (parameterIterator.hasNext()) {
                    final Parameters.Parameter currentParameter = parameterIterator.next();
                    currentUrlString.append("&" + currentParameter.getKey() + "=" + currentParameter.getValue());
                }
            } else {
                boolean firstParameter = true;
                while (parameterIterator.hasNext()) {
                    final Parameters.Parameter currentParameter = parameterIterator.next();
                    if (firstParameter) {
                        currentUrlString.append("?" + currentParameter.getKey() + "=" + currentParameter.getValue());
                        firstParameter = false;
                    } else {
                        currentUrlString.append("&" + currentParameter.getKey() + "=" + currentParameter.getValue());
                    }
                }
            }
        }

        url = new URL(currentUrlString.toString());
        System.out.println("URL: "+url.toString()+"\n"+"urlString: "+currentUrlString.toString());

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(request.getRequestMethod().getRequestMethod());

        if (request.getHeaderHashSet() != null && !request.getHeaderHashSet().isEmpty()) {
            Iterator<Headers.Header> headerIterator = request.getHeaderHashSet().iterator();
            while (headerIterator.hasNext()) {
                Headers.Header currentHeader = headerIterator.next();
                httpURLConnection.setRequestProperty(currentHeader.getKey(), currentHeader.getValue());

            }
        }


        if (request.getRequestMethod().getRequestMethod() == RequestMethod.POST.getRequestMethod()) {
            httpURLConnection.setDoOutput(true);
        }


        if (request.getAuthentication() == Authentication.AUTHENTICATION_OAUTH_1_01_A) {
            if (request.getConsumerKey() == null || request.getConsumerKey().isEmpty()) {
                throw new Exception("Consumer_Key can't be null or empty");
            }
            if (request.getConsumerSecret() == null || request.getConsumerSecret().isEmpty()) {
                throw new Exception("Consumer_Secret can't be null or empty");
            }


            OAuthConsumer oAuthConsumer = new DefaultOAuthConsumer(request.getConsumerKey(),
                    request.getConsumerSecret());
            oAuthConsumer.sign(httpURLConnection);
        }

        if (request.getBody() != null) {
            OutputStream outputStreamWriter = httpURLConnection.getOutputStream();
            String body = request.getBody();
            outputStreamWriter.write(body.getBytes(), 0, body.length());
            outputStreamWriter.close();
        }
        httpURLConnection.connect();




        Response response = new Response();
        int responseCode = httpURLConnection.getResponseCode();
        response.setResponseCode(responseCode);
        InputStream inputStreamMessage = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            inputStreamMessage = httpURLConnection.getInputStream();
        } else {
            inputStreamMessage = httpURLConnection.getErrorStream();
        }


        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(inputStreamMessage));


        String singleLine = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((singleLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(newLine + singleLine);
        }
        response.setResponseMessage(stringBuilder.toString());
        return response;
    }
}
