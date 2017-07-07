package rest.library.test101.network.connector;

import rest.library.test101.model.Response;

/**
 * Created by Pankaj Nimgade on 6/26/2017.
 */

public class NetworkConnector {

    private RestAPI restAPI = new DefaultRestAPI();
    private Request request;
    private MyResultCallBack myResultCallBack;


    public NetworkConnector(Request request, MyResultCallBack myResultCallBack) {
        this.request = request;
        this.myResultCallBack = myResultCallBack;
    }

    public void makeNetworkCall(){
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();
    }


    private class WorkerThread extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                Response response = restAPI.callRequest(request);
                myResultCallBack.getResponse(response);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
