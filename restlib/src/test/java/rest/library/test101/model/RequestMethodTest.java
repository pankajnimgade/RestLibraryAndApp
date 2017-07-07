package rest.library.test101.model;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pankaj Nimgade on 7/7/2017.
 */
public class RequestMethodTest {


    @Test
    public void checkRequestMethods() {
        RequestMethod getRequestMethod = RequestMethod.GET;
        Assert.assertEquals("GET", getRequestMethod.getRequestMethod());

        RequestMethod postRequestMethod = RequestMethod.POST;
        Assert.assertEquals("POST", postRequestMethod.getRequestMethod());

        RequestMethod putRequestMethod = RequestMethod.PUT;
        Assert.assertEquals("PUT", putRequestMethod.getRequestMethod());

        RequestMethod patchRequestMethod = RequestMethod.PATCH;
        Assert.assertEquals("PATCH", patchRequestMethod.getRequestMethod());

        RequestMethod deleteRequestMethod = RequestMethod.DELETE;
        Assert.assertEquals("DELETE", deleteRequestMethod.getRequestMethod());

        RequestMethod copyRequestMethod = RequestMethod.COPY;
        Assert.assertEquals("COPY", copyRequestMethod.getRequestMethod());

        RequestMethod headRequestMethod = RequestMethod.HEAD;
        Assert.assertEquals("HEAD", headRequestMethod.getRequestMethod());

        RequestMethod optionsRequestMethod = RequestMethod.OPTIONS;
        Assert.assertEquals("OPTIONS", optionsRequestMethod.getRequestMethod());

        RequestMethod linkRequestMethod = RequestMethod.LINK;
        Assert.assertEquals("LINK", linkRequestMethod.getRequestMethod());

        RequestMethod unlinkRequestMethod = RequestMethod.UNLINK;
        Assert.assertEquals("UNLINK", unlinkRequestMethod.getRequestMethod());

        RequestMethod purgeRequestMethod = RequestMethod.PURGE;
        Assert.assertEquals("PURGE", purgeRequestMethod.getRequestMethod());

        RequestMethod lockRequestMethod = RequestMethod.LOCK;
        Assert.assertEquals("LOCK", lockRequestMethod.getRequestMethod());

        RequestMethod unlockRequestMethod = RequestMethod.UNLOCK;
        Assert.assertEquals("UNLOCK", unlockRequestMethod.getRequestMethod());

        RequestMethod propfindRequestMethod = RequestMethod.PROPFIND;
        Assert.assertEquals("PROPFIND", propfindRequestMethod.getRequestMethod());

        RequestMethod viewRequestMethod = RequestMethod.VIEW;
        Assert.assertEquals("VIEW", viewRequestMethod.getRequestMethod());

    }

}