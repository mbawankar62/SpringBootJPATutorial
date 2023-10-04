package org.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindAllSubString {


    // Function to find all distinct substrings containing exactly `k` distinct
    // characters
    public static Set<String> findDistinctSubstrings(String str, int k)
    {
        // create a set to store substrings containing exactly `k` distinct characters
        Set<String> result = new HashSet<>();
 
        // base case
        if (str == null) {
            return result;
        }
 
        // in each iteration of the loop, consider substring starting with `str[i]`
        for (int i = 0; i < str.length() - k + 1; i++)
        {
            // create a set to store distinct characters in the current substring
            Set<Character> chars = new HashSet<>();
 
            // process substring starting with `str[i]`
            for (int j = i; j < str.length() && chars.size() <= k; j++)
            {
                // insert current character `str[j]` into the hash set
                chars.add(str.charAt(j));
 
                /*
                    If current character `str[j]` is seen before in the
                    substring `str[i…j-1]`, the count remains the same since
                    the hash set only allows unique values
                */
 
                // if the count of distinct characters becomes `k`
                if (chars.size() == k)
                {
                    // add the current substring to the result
                    result.add(str.substring(i, j + 1));
                }
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        String str = "abcadce";
        int k = 4;
 
        Set<String> result = findDistinctSubstrings(str, k);
        System.out.println(result);
    }
	 
}
