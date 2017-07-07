package rest.library.test101.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pankaj Nimgade on 7/7/2017.
 */
public class HeadersTest {

    @Test
    public void checkHeaderDuplication() throws Exception {
        Headers.Header headerOne = new Headers.Header("one", "two");
        Headers.Header headerTwo = new Headers.Header("one", "three");
        Headers.HeaderBuilder headerBuilder =
                new Headers.HeaderBuilder()
                        .addHeader(headerOne)
                        .addHeader(headerTwo);
        Headers headers = headerBuilder.build();
        Assert.assertEquals(1, headers.getKeyAndValueMap().size());
    }

    @Test(expected = NullPointerException.class)
    public void checkHeaderEmptyKey() throws Exception {
        Headers.Header headerOne = new Headers.Header("", "two");
        Headers.HeaderBuilder headerBuilder =
                new Headers.HeaderBuilder()
                        .addHeader(headerOne);
        Headers headers = headerBuilder.build();

    }

    @Test(expected = NullPointerException.class)
    public void checkHeaderEmptyValue() throws Exception {
        Headers.Header headerOne = new Headers.Header("one", "");
        Headers.HeaderBuilder headerBuilder =
                new Headers.HeaderBuilder()
                        .addHeader(headerOne);
        Headers headers = headerBuilder.build();

    }

}