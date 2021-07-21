//Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
//A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
//Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter

//Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//Output: ["mee","aqq"]
//Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
//"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.


import java.util.*;

public class FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        pattern = FindandReplacePattern.identifyPattern(pattern);
        List<String> res = new ArrayList<>();
        
        for(String word : words){
            if(FindandReplacePattern.identifyPattern(word).equals(pattern)) res.add(word);
        }
        
        return res;        
    }
    
     public static String identifyPattern(String str){
        String pattern = "";
        HashMap<Character, Integer> patternMap = new HashMap<>();
        int ctr = 1;
        
        for(int ii = 0; ii < str.length(); ii++){
            if(patternMap.containsKey(str.charAt(ii))) pattern += String.valueOf(patternMap.get(str.charAt(ii)));
            else{
                patternMap.put(str.charAt(ii), ++ctr);
                pattern += String.valueOf(ctr);                  
            }
        }
        return pattern;
    }
    
    public static void main(String[] args){
        FindandReplacePattern soln = new FindandReplacePattern();
        String[] arr = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(soln.findAndReplacePattern(arr, "abb"));
    }
}
