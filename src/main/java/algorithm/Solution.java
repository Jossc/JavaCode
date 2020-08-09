package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * leetCode 93
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author Hikari
 * @version 1.0.0
 * @ClassName Solution.java
 * @createTime 2020年08月09日 10:12:00
 */
public class Solution {

    private final static List<String> res = new ArrayList<>();

    private final static int DEF = 4;

    private final static int MIN_SIZE = 3;



    public List<String> restoreIpAddresses(String s) {
        if (s.length() < DEF || Objects.isNull(s)) {
            return res;
        }
        for (int i = 1; i < s.length() && i <= MIN_SIZE; ++i) {
            for (int j = i; j < s.length() && j <= i + MIN_SIZE; ++j) {
                for (int k = j; k < s.length() && k <= j + MIN_SIZE; ++k) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (trueOrFalse(s1) &&
                            trueOrFalse(s2) &&
                            trueOrFalse(s3) &&
                            trueOrFalse(s4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1);
                        sb.append(".");
                        sb.append(s2);
                        sb.append(".");
                        sb.append(s3);
                        sb.append(".");
                        sb.append(s4);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }

    public static boolean trueOrFalse(String string) {
        if (string.length() == 0) {
            return false;
        }
        if (string.length() == 1) {
            return true;
        }
        if (string.length() > MIN_SIZE) {
            return false;
        }
        if (string.charAt(0) == '0') {
            return true;
        }
        if (Integer.parseInt(string) <= 255) {
            return true;
        }
        return false;
    }
}


