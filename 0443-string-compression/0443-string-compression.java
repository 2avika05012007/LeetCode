class Solution {
    public int compress(char[] chars) {

        if (chars.length == 1) {
            return 1;
        }

        int i = 0;      
        int index = 0;  

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            chars[index++] = current;
            if (count > 1) {
                String str = String.valueOf(count);

                for (char ch : str.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}