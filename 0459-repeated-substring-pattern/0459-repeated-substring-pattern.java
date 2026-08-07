class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String d = s + s;
        String t = d.substring(1, d.length() - 1);
        return t.contains(s);
    }
}