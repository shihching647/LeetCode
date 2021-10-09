/**
 * 題意: 任何一個character A只有找到另一個character B, 使得B的attak跟defend都大於A, 此character A就是weak character.
 * Algorithm: 
 * 先照attack由小->大排列, 若遇到attack相同, 照defense大->小排列.
 * 紀錄maxDefense值, 在由後往前找, 當發現任何一個character的defense值小於maxDefense值時, 就是weak character.
 * 
 * 理由為: 
 * 考慮 [[7,9],[10,7],[6,9],[10,4],[7,5],[7,10]]
 * 
 * 先照attack由小->大排列, 若遇到attack相同, 照defense大->小排列. 
 *    [[6,9],[7,10],[7,9],[7,5],[10,7],[10,4]] => 得到的結果會是2個 (正確答案)
 *
 * 若改為遇到attack相同, 照defense小->大排列. 
 *    [[6,9],[7,5],[7,7],[7,10],[10,4],[10,7]] => 會得到4個. (錯誤!!)
 *
 * 因為 [10,4], [7,5], [7,10]都會被算進去, 但是他們其實是attack相同, 所以不滿足題目需求.
 * 所以應為若遇到attack相同時, 照defense大->小排列. 遇到同一個attack的group時, 
 * 須先取得此group最大的defense, 才不會把相同attack的都算進去.
 * 
 * 學習到的技巧:
 * 其實一開始的想法很接近了, 只是遇到相同的時候沒有反過來排, 這種題目就是要考你相同的時候要怎麼處理
 * ,LC常考這種遇到相同時要反過來排的題目.
 * 
 * 
 * Time complexity: O(NlogN)
 * Space complexity: O(logN)
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int count = 0;
        // 先照attack由小->大排列, 若遇到attack相同, 照defense大->小排列. 
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int maxDefend = properties[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            if (properties[i][1] < maxDefend) {
                count++;
            }
            maxDefend = Math.max(maxDefend, properties[i][1]);
        }
        return count;
        
    }
}