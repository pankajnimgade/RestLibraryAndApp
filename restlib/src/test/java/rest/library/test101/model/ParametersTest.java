package rest.library.test101.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pankaj Nimgade on 7/7/2017.
 */
public class ParametersTest {

    @Test
    public void checkParameterDuplication() throws Exception {
        Parameters.Parameter parameterOne = new Parameters.Parameter("first", "second");
        Parameters.Parameter parameterTwo = new Parameters.Parameter("first", "second");
        Parameters.ParametersBuilder builder =
                new Parameters.ParametersBuilder()
                        .addParameter(parameterOne)
                        .addParameter(parameterTwo);
        Parameters parameters = builder.build();
        int size = parameters.getParameterMap().size();
        Assert.assertEquals(1, size);
    }

    @Test(expected = NullPointerException.class)
    public void checkEmptyKeyParameter() throws Exception {
        Parameters.Parameter parameterOne = new Parameters.Parameter("", "second");
        Parameters.ParametersBuilder builder =
                new Parameters.ParametersBuilder()
                        .addParameter(parameterOne);
        Parameters parameters = builder.build();
    }

    @Test(expected = NullPointerException.class)
    public void checkEmptyValueParameter() throws Exception {
        Parameters.Parameter parameterOne = new Parameters.Parameter("first", "");
        Parameters.ParametersBuilder builder =
                new Parameters.ParametersBuilder()
                        .addParameter(parameterOne);
        Parameters parameters = builder.build();
    }

}