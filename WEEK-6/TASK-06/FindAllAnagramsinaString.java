class Solution {
   public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int ns = s.length();
    int np = p.length();
    if (ns < np) return result; // no possible anagrams
    int[] pCount = new int[26];
    int[] windowCount = new int[26];
    for (int i = 0; i < np; i++) {
        pCount[p.charAt(i) - 'a']++;
    }
    for (int i = 0; i < np; i++) {
        windowCount[s.charAt(i) - 'a']++;
    }
    if (Arrays.equals(windowCount, pCount)) {
        result.add(0);
    }
    for (int i = np; i < ns; i++) {
        windowCount[s.charAt(i) - 'a']++;
        windowCount[s.charAt(i - np) - 'a']--;
        if (Arrays.equals(windowCount, pCount)) {
            result.add(i - np + 1);
        }
    }
    return result;
}
}
