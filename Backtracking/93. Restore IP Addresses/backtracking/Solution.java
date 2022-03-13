/**
 * Backtracking
 * 
 * Time complexity: O(n)
 * Space complexity: O(4)
 *
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        restoreIp(0, 0, s, "", result);
        return result;
    }
    
    private void restoreIp(int start, int d, String s, String ipAddress, List<String> result) {
        if (d == 4) {
            if (ipAddress.length() == s.length() + 3)
                result.add(ipAddress);
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            int ip = Integer.parseInt(s.substring(start, start + i));
            if (ip <= 255) {
                restoreIp(start + i, d + 1, s, ipAddress + (ipAddress.length() > 0 ? "." + ip : ip), result);
            }
        }
    }
}