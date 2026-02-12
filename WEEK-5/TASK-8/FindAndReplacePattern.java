class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String encodedPattern = encode(pattern);
        for (String word : words) {
            if (encode(word).equals(encodedPattern)) {
                result.add(word);
            }
        }
        return result;
    }
    private String encode(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int id = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, id++);
            }
            sb.append(map.get(c)).append(',');
        }
        return sb.toString();
    }
}
