public static long func(int N, int K) {
    int mV = (1 << K) + 1;
    long[] dp = new long[mV];
    
    for (int i = 0; i < mV; i++) {
        dp[i] = 1;
    }
    
    for (int lth = 1; lth < N; lth++) {
        long[] newDp = new long[mV];
        
        for (int i = 0; i < mV; i++) {
            if (dp[i] > 0) {
                for (int j = 0; j < mV; j++) {
                    if ((i & j) > 0) {
                        newDp[j] += dp[i];
                    }
                }
            }
        }       
        dp = newDp;
    }
    
    long result = 0;
    for (int i = 0; i < mV; i++) {
        result += dp[i];
    }
    
    return result;
}
