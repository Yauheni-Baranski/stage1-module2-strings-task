package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String delimitersString = String.join("", delimiters);
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(source, delimitersString);
        while (st.hasMoreTokens()){
            String token = st.nextToken();
            result.add(token);
        }

        return result;
    }

}
