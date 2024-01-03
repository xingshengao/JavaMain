package com.edu.nju.test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author XsaDeleteMemory
 * @date 2023/12/27 16:01
 */
class Solution {
    static final int mod = 1000000007;

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[51][101][51]; // dp[i][max][cnt]代表序列长度为i, 最大值为max, search_cost的次数为cnt的结果

        for (int i = 0; i < 51; ++i) {
            for (int j = 0; j < 101; ++j) {
                Arrays.fill(dp[i][j], 0);
            }
        }
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int max = 0; max <= m; ++max) {
                for (int cnt = 0; cnt <= i; ++cnt) {
                    // 枚举第i个数字是x
                    for (int x = 0; x <= m; x++) {
                        if (x > max) {
                            dp[i][x][cnt + 1] += dp[i - 1][max][cnt];
                            dp[i][x][cnt + 1] %= mod;
                        } else {
                            dp[i][max][cnt] += dp[i - 1][max][cnt];
                            dp[i][max][cnt] %= mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            ans += dp[n][i][k];
            ans %= mod;
        }
        return ans;
    }
}

public class Main {
    static final int mod = 1000000007;

    public static void Fil() throws IOException {
        FileOutputStream fo = new FileOutputStream("test1.txt");
        String s1 = "dsjaiofnoasifo";
        byte[] byte1 = s1.getBytes();
        fo.write(byte1);
        fo.close();
    }
    public static void main(String[] args) throws IOException {
        Fil();

    }
}
