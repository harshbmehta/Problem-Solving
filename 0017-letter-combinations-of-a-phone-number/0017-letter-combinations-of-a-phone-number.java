// Time Complexity: O(n.4^n)
class Solution {
    List<String> res = new ArrayList<>();
    String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        dfs(0, digits, "");
        return res;
    }


    private void dfs(int idx, String digits, String prefix) {
        if(idx == digits.length()) {
            res.add(prefix);
            return;
        } else {
            String ltrs = KEYS[digits.charAt(idx) - '0'];
            for(int i=0; i<ltrs.length();i++) {
                dfs(idx+1, digits, prefix+ltrs.charAt(i));
            }
        }
    }
}