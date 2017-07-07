package rest.library.test101.model;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public class Headers {

    private Map<String, Header> keyAndValueMap;

    private Headers(HeaderBuilder headerBuilder) throws NullPointerException, Exception {
        if (headerBuilder == null) {
            throw new NullPointerException("HeaderBuilder's instance is null");
        }

        if (headerBuilder.getHeaderSet().size() > 0) {
            Iterator<Header> iterator = headerBuilder.getHeaderSet().iterator();

            keyAndValueMap = new TreeMap<>();
            while (iterator.hasNext()) {
                Header header = iterator.next();
                keyAndValueMap.put(header.getKey(), header);
            }
        } else {
            System.out.println("No Headers been added to the set");
        }

    }

    public Map<String, Header> getKeyAndValueMap() {
        return keyAndValueMap;
    }

    public static class HeaderBuilder {

        private Set<Header> headerSet;

        public HeaderBuilder() {
            headerSet = new TreeSet<>();
        }

        public HeaderBuilder addHeader(Header header) throws NullPointerException {
            if (header == null) {
                throw new NullPointerException("Header can't be null");
            }
            if (header.getKey() == null || header.getKey().equalsIgnoreCase("")) {
                throw new NullPointerException("Header's key is null or empty");
            }
            if (header.getValue() == null || header.getValue().equalsIgnoreCase("")) {
                throw new NullPointerException("Header's value is null or empty");
            }
            headerSet.add(header);
            return this;
        }

        public Headers build() throws Exception {
            Headers headers = new Headers(this);
            return headers;
        }

        public Set<Header> getHeaderSet() {
            return headerSet;
        }
    }

    public static class Header implements Comparable<Header> {
        private String key;
        private String value;

        public Header(String key, String value) {
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
                if (obj instanceof Header) {
                    if (this.key.equalsIgnoreCase(((Header) obj).getKey())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int compareTo(Header o) {
            return key.compareTo(o.getKey());
        }
    }
}
