package com.leetcode;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: RegularExpressionMatching
 * Creator: Chiang
 * Date: 2019/05/11
 * Description: 10. Regular Expression Matching
 */
public class RegularExpressionMatching {
    /**
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

//        if (s.equals(p)) {
//            return true;
//        } else if (s.isEmpty() || p.isEmpty()) {
//            return false;
//        }
//        //boolean signalMatched = false;
//
//        int sLength = s.length();
//        int pLength = p.length();
//        int sHead = 0, sCurrent = 0, sTail = sLength;
//        int pHead = 0, pCurrent = 0, pTail = pLength;
//        char previous = ' ';
//
//        boolean previousAll = false;
//
//        boolean result = false;
//
//        while(sCurrent < sTail && pCurrent < pTail) {
//
//            if (s.charAt(sCurrent) == p.charAt(pCurrent)) {
//
//                //signalMatched = true;
//                previous = s.charAt(sCurrent);
//                previousAll = false;
//                sCurrent ++;
//                pCurrent ++;
//
//            } else if (p.charAt(pCurrent) == '.') {
//                previousAll = true;
//                sCurrent ++;
//                pCurrent ++;
//
//            } else if (previousAll && p.charAt(pHead) == '*') {
//
//               result = true;
//               break;
//
//            } else if (s.charAt(sCurrent) == previous && p.charAt(pCurrent) == '*') {
//                sCurrent ++;
//                if (sCurrent < sTail && pCurrent < pTail-1 &&
//                        s.charAt(sCurrent) != previous && s.charAt(sCurrent) == p.charAt(pCurrent + 1)) {
//                    pCurrent ++;
//            }
//            }else {
//                //signalMatched = false;
//                sCurrent = sHead;
//                pHead ++;
//                pCurrent = pHead;
//            }
//        }
//        if (sCurrent == sTail) {
//            result = true;
//        }
//        return result;
        if (s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (state[0][j - 2])) {
                    state[0][j] = true;
                }
            }
        }
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
}
