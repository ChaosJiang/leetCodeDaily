import java.util.Arrays;

/**
 * @author : chaosjiang
 * @created : AD 2021/12/18, Saturday
 * @Description: Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.
 *
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 *
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 *
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?
 *
 **/
public class No839_SimilarStringGroup {
    static int[] f;
    public int numSimilarGroups(String[] strs) {
//        int count = 0;
//        for (int i = 0; i < strs.length ; i++) {
//            boolean isSingleGroup = true;
//            for (int j = 0; j < strs.length; j++) {
//                if(i == j) {
//                    continue;
//                }
//                if(checkSimilar(strs[i], strs[j])) {
//                    isSingleGroup = false;
//                    break;
//                }
//            }
//            // since str[i] is not similar to any other str, itself forms a group
//            if(isSingleGroup) {
//                count++;
//            }
//        }
//        return ++count;
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        // 各个节点的父元素初始化为节点自身
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                // 查看两个节点是否已经相连
                if(fi == fj) {
                    continue;
                }
                // 还未相连，检查相似度
                if(check(strs[i], strs[j], m)) {
                    f[fi] = fj;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(f[i] == i) {
                ret++;
            }
        }
        return ret;
    }
    public static int find(int x) {
        return f[x] == x ? x : (find(f[x]));
    }
    public static boolean check(String s1, String s2, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                num++;
                if(num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
//    public static boolean checkSimilar(String s1, String s2) {
//        if(s1.equals(s2)) {
//            return true;
//        }
//        boolean res = false;
//        char[] chars = s2.toCharArray();
//        for (int i = 0; i <chars.length ; i++) {
//            for (int j = i + 1; j < chars.length ; j++) {
//                char[] copyOfChars = Arrays.copyOf(chars, chars.length);
//                // switch char between chars on Index i and j
//                char tmp = copyOfChars[i];
//                copyOfChars[i] = copyOfChars[j];
//                copyOfChars[j] = tmp;
//                if(s1.equals(String.valueOf(copyOfChars))) {
//                    res = true;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
}
