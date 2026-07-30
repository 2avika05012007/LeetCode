class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            String replace = a;
            for (String root : dictionary) {
                if (a.startsWith(root) && root.length() < replace.length()) {
                    replace = root;
                }
            }
            sb.append(replace);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}