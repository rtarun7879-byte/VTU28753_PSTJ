class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int first = 0, second = 0;

        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) first++;
        }

        for (int i = mid; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) second++;
        }

        return first == second;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}