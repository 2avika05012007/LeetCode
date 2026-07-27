import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        Stack<Character> st = new Stack<>();
        if (word.length() == 0) return 0;
        st.push(word.charAt(0));
        HashSet<Character> set = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                if (st.contains(Character.toUpperCase(ch))) {
                    st.remove(Character.valueOf(Character.toUpperCase(ch)));
                    set.add(ch);

                } else {
                    st.push(ch);
                }
            }
            if (Character.isUpperCase(ch)) {
                if (st.contains(Character.toLowerCase(ch))) {
                    st.remove(Character.valueOf(Character.toLowerCase(ch)));
                    set.add(Character.toLowerCase(ch));
                } else {
                    st.push(ch);
                }
            }
        }
        return set.size();
    }
}