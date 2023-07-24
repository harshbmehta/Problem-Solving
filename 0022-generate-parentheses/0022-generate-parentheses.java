class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(StringBuilder tempStr, int open, int close, int max){
        if(tempStr.length() == max * 2) {
            ans.add(tempStr.toString());
            return;
        }

        if(open < max){
            tempStr.append("(");
            backtrack(tempStr, open+1, close, max);
            tempStr.deleteCharAt(tempStr.length() - 1);
        } 

        if(close < open) {
            tempStr.append(")");
            backtrack(tempStr, open, close + 1, max);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}