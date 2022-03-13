/**
 * Brute force:
 * 3個for loop 從len = 1 ~ 3 
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12)
            return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3 && i < n; i++) {
            for (int j = i + 1; j <= i + 3 && j < n; j++) {
                for (int k = j + 1; k <= j + 3 && k < n; k++) {
                    int p1 = Integer.parseInt(s.substring(0, i));
                    int p2 = Integer.parseInt(s.substring(i, j));
                    int p3 = Integer.parseInt(s.substring(j, k));
                    int p4 = Integer.parseInt(s.substring(k));
                    if (p1 <= 255 && p2 <= 255 && p3 <= 255 && p4 <= 255) {
                        String ip = p1 + "." + p2 + "." + p3 + "." + p4;
                        if (ip.length() == s.length() + 3)
                            result.add(ip);
                    }
                }
            }
        }
        return result;
    }
}