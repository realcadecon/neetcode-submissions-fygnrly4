class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int p : piles) {
            max = Math.max(p, max);
        }
        
        int res = max;
        int L = 1, R = max;
        while(L<=R) {
            int M = (L+R) / 2;
            System.out.printf("(%d | %d) - %d\n", L, R, M);
            if(canEatBananas(piles, h, M)) {
                res = M;
                R = M-1;
            } else {
                L = M+1;
            }
        }
        return res;
    }

    public boolean canEatBananas(int[] piles, int h, int k) {
        for(int p : piles) {
            int bananas = (int) Math.ceil(p / (k * 1.0));
            h -= bananas;
            if(h < 0) {
                return false;
            }
        }
        return true;
    }
}
