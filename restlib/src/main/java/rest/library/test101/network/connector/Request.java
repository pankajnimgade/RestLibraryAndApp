package rest.library.test101.network.connector;

import java.util.HashSet;
import java.util.Map;

import rest.library.test101.model.Authentication;
import rest.library.test101.model.Headers;
import rest.library.test101.model.Parameters;
import rest.library.test101.model.RequestMethod;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public class Request {

    protected String urlString;
    protected RequestMethod requestMethod = RequestMethod.GET;
    private Parameters parameters;
    private HashSet<Parameters.Parameter> parameterHashSet;
    private Headers headers;
    private HashSet<Headers.Header> headerHashSet;
    private Authentication authentication = Authentication.NO_AUTHENTICATION;
    private String consumerKey;
    private String consumerSecret;
    private String token;
    private String body;


    private Request(RequestBuilder requestBuilder) throws Exception {
        this.urlString = requestBuilder.urlString;
        this.requestMethod = requestBuilder.requestMethod;

        //add parameter set is exists
        if (requestBuilder.parameterHashSet != null) {
            this.parameterHashSet = requestBuilder.parameterHashSet;
        }
        if (requestBuilder.parameters != null) {
            if (this.parameterHashSet == null) {
                this.parameterHashSet = new HashSet<>();
            }
            for (Map.Entry entry : requestBuilder.parameters.getParameterMap().entrySet()) {
                this.parameterHashSet.add((Parameters.Parameter) entry.getValue());
            }
        }

        // add header set if exists
        if (requestBuilder.headerHashSet != null) {
            this.headerHashSet = requestBuilder.headerHashSet;
        }

        if (requestBuilder.headers != null) {
            if (this.headerHashSet == null) {
                this.headerHashSet = new HashSet<>();
            }
            for (Map.Entry entry : requestBuilder.headers.getKeyAndValueMap().entrySet()) {
                this.headerHashSet.add((Headers.Header) entry.getValue());
            }
        }

        if (requestBuilder.authentication != null) {
            this.authentication = requestBuilder.authentication;
        }

        if (requestBuilder.body != null && !requestBuilder.body.equalsIgnoreCase("")) {
            this.body = requestBuilder.body;
        }

        if (requestBuilder.consumerKey != null && !requestBuilder.consumerKey.equalsIgnoreCase("")) {
            this.consumerKey = requestBuilder.consumerKey;
        }

        if (requestBuilder.consumerSecret != null && !requestBuilder.consumerSecret.equalsIgnoreCase("")) {
            this.consumerSecret = requestBuilder.consumerSecret;
        }

        if (requestBuilder.token != null && !requestBuilder.token.equalsIgnoreCase("")) {
            this.token = requestBuilder.token;
        }

    }

    public String getUrlString() {
        return urlString;
    }


    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public HashSet<Parameters.Parameter> getParameterHashSet() {
        return parameterHashSet;
    }

    public HashSet<Headers.Header> getHeaderHashSet() {
        return headerHashSet;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getToken() {
        return token;
    }

    public String getBody() {
        return body;
    }

    public static class RequestBuilder {

        private String urlString;
        private Parameters parameters;
        private HashSet<Parameters.Parameter> parameterHashSet;
        private Headers headers;
        private HashSet<Headers.Header> headerHashSet;
        private RequestMethod requestMethod = RequestMethod.GET;
        private Authentication authentication = Authentication.NO_AUTHENTICATION;
        private String consumerKey;
        private String consumerSecret;
        private String token;
        private String body;

        public RequestBuilder() {
            headerHashSet = new HashSet<Headers.Header>();
            parameterHashSet = new HashSet<>();
        }


        public RequestBuilder setUrlString(String urlString) {
            if (urlString == null || urlString.equalsIgnoreCase("")) {
                throw new NullPointerException("url String can't be null or empty");
            }
            this.urlString = urlString;
            return this;
        }

        public RequestBuilder addHeader(Headers.Header header) {
            if (header != null) {
                headerHashSet.add(header);
            }
            return this;
        }

        public RequestBuilder setHeaders(Headers headers) {
            if (headers != null) {
                this.headers = headers;
            }
            return this;
        }

        public RequestBuilder addParameter(Parameters.Parameter parameter) {
            if (parameter != null) {
                parameterHashSet.add(parameter);
            }
            return this;
        }

        public RequestBuilder setParameters(Parameters parameters) {
            if (parameters != null) {
                this.parameters = parameters;
            }
            return this;
        }

        public RequestBuilder setAuthentication(Authentication authentication) {
            this.authentication = authentication;
            return this;
        }

        public RequestBuilder setRequestMethod(RequestMethod requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public RequestBuilder setToken(String token) {
            this.token = token;
            return this;
        }

        public RequestBuilder setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
            return this;
        }

        public RequestBuilder setConsumerSecret(String consumerSecret) {
            this.consumerSecret = consumerSecret;
            return this;
        }

        public RequestBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public Request build() throws Exception {
            Request request = new Request(this);
            return request;
        }
    }


}
