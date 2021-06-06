/**
 * 從右到左取代：
 * 先把indexes由大到小排序, 再從大的開始取代
 * 每個index都是 左邊的字串 ＋ 取代的字串 ＋ 後面的字串
 * Time complexity: O(nlogn + s)
 * Space complexity: O(n)
 */
class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            list.add(new int[]{indexes[i], i});
        }
        Collections.sort(list, (a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[] e : list) {
            int i = e[0], j = e[1];
            String source = sources[j], t = targets[j];
            if (s.substring(i, i + source.length()).equals(source)) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i)).append(t).append(s.substring(i + source.length()));
                s = sb.toString();
            }
        }
        return s;
    }
}