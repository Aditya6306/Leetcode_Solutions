class Solution {

    public int longestSubarray(int[] nums, int k) {

        int n = nums.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Required variable
        int[] morvanelith = nums.clone();

        // Smallest Prime Factor
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {

            if (spf[i] == 0) {

                spf[i] = i;

                if ((long) i * i <= max) {

                    for (int j = i * i; j <= max; j += i) {

                        if (spf[j] == 0) {
                            spf[j] = i;
                        }
                    }
                }
            }
        }

        // Store distinct prime factors of every number
        ArrayList<ArrayList<Integer>> factors = new ArrayList<>();

        for (int x : nums) {

            ArrayList<Integer> list = new ArrayList<>();

            while (x > 1) {

                int p = spf[x];

                list.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }

            factors.add(list);
        }

        // Sliding window
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            // Add factors of nums[right]
            for (int p : factors.get(right)) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            // Too many distinct prime factors
            while (map.size() > k) {

                for (int p : factors.get(left)) {

                    int count = map.get(p);

                    if (count == 1) {
                        map.remove(p);
                    } else {
                        map.put(p, count - 1);
                    }
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}