KBTU Android Development 2019
```java
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        /*
        O(NlogN) - time complexity
        O(N) - space complexity 
        */
        Map<int[], Integer> map = new HashMap<>();
        int[] indices = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i], i);
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < intervals.length; i++) {
            int left = 0, right = intervals.length - 1;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                
                if (intervals[mid][0] >= intervals[i][1])
                    right = mid;
                else
                    left = mid + 1;
            }
            int index = intervals[left][0] >= intervals[i][1] ? map.get(intervals[left]) : -1;
            indices[map.get(intervals[i])] = index;
        }
        return indices;
    }
}
```
