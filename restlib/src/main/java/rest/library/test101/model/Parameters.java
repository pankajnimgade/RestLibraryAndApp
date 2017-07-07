package rest.library.test101.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public class Parameters {

    private Map<String, Parameter> parameterMap;

    private Parameters(ParametersBuilder parametersBuilder) throws Exception {
        if (parametersBuilder == null) {
            throw new Exception("ParametersBuilder's instance is null");
        }
        if (parametersBuilder.getParameters().size() > 0) {
            parameterMap = new TreeMap<>();
            Iterator<Parameter> parameterIterator = parametersBuilder.getParameters().iterator();
            while (parameterIterator.hasNext()) {
                Parameter currentParameter = parameterIterator.next();
                parameterMap.put(currentParameter.getKey(), currentParameter);
            }
        } else {
            System.out.println("No Headers been added to the set");
        }
    }

    public Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    public static class ParametersBuilder {

        Set<Parameter> parameters;

        public ParametersBuilder() {
            parameters = new HashSet<>();
        }

        public Set<Parameter> getParameters() {
            return parameters;
        }

        public ParametersBuilder addParameter(Parameter parameter) {
            if (parameter == null) {
                throw new NullPointerException("Parameter's instance can't be null");
            }
            if (parameter.getKey() == null || parameter.getKey().equalsIgnoreCase("")) {
                throw new NullPointerException("Parameter's key variable can't be null");
            }

            if (parameter.getValue() == null || parameter.getValue().equalsIgnoreCase("")) {
                throw new NullPointerException("Parameter's value variable can't be null");
            }
            parameters.add(parameter);
            return this;
        }

        public Parameters build() throws Exception {
            Parameters parameters = new Parameters(this);
            return parameters;
        }


    }

    public static class Parameter implements Comparable<Parameter> {

        private String key;
        private String value;

        public Parameter(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            int hasCode = 0;
            char[] chars = key.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                hasCode += Character.getNumericValue(chars[i]);
            }
            return hasCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null) {
                if (obj instanceof Parameter) {
                    if (this.key.equalsIgnoreCase(((Parameter) obj).getKey())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int compareTo(Parameter parameter) {
            return key.compareTo(parameter.getKey());
        }
    }


}
