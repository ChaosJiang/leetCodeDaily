/**
 * @author : chaosjiang
 * @created : AD 2021/12/16, Thursday
 * @Description:Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
 *
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 *
 **/
public class No868_BinaryGap {
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        int rShift = 0;
        while(n>> rShift > 0) {
            // Shift binary num from right to left
            if(((n>> rShift) &1) > 0) {
                if(last >= 0) {
                    ans = Math.max(ans, rShift - last);
                }
                // save the index position of '1'
                last = rShift;
            }
            rShift++;
        }
        return ans;
    }
}
