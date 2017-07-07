package rest.library.test101.model;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */

public class APIResponseLib {

    private String statusCode;
    private String tid;
    private String session;
    private ArrayList<OptimizationsLib> optimizations;

    public APIResponseLib() {
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

    public ArrayList<OptimizationsLib> getOptimizations() {
        return optimizations;
    }

    public void setOptimizations(ArrayList<OptimizationsLib> optimizations) {
        this.optimizations = optimizations;
    }
}
