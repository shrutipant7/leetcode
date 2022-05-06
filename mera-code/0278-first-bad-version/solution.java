/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int firstBad = Integer.MAX_VALUE;
        int low = 0;
        int high = n;
        while(low <= high) {
            int mid =  low + ( high - low ) / 2 ; //To prevent TLE
            if(isBadVersion(mid)){
                firstBad = Math.min(firstBad, mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        return firstBad;
    }
}
