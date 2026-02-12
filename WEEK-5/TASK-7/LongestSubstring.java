class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder ans=new StringBuilder();
        int max=0;
        for(int i=0;i<s.length();i++){
            char input=s.charAt(i);
            int j=ans.indexOf(String.valueOf(input));
            if (j!=-1){
                ans.delete(0,j+1);
            }
            ans.append(input);
            max=Math.max(max,ans.length());
        }
        return max;
    }
}
