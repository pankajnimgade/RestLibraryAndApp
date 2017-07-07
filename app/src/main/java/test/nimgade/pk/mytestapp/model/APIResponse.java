package test.nimgade.pk.mytestapp.model;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */

public class APIResponse {

    private String statusCode;
    private String tid;
    private String session;
    private ArrayList<Optimizations> optimizations;

    public APIResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public ArrayList<Optimizations> getOptimizations() {
        return optimizations;
    }

    public void setOptimizations(ArrayList<Optimizations> optimizations) {
        this.optimizations = optimizations;
    }
}
