/*******
    The basic idea is a basic 2 pointer to left and right starting from each index
    so we start from 1 we check  if 0 & 2 are equal or not and continue so the length is now 3
    we do this for every index
    but what if instead of starting from 0 we started from the mid of the string and go left & right
    So for example string of size 5 if we start at index 3 the max we can get is 4 or 5 
    the max we can get from the 2 & 4 is either 3 or 4
    So if we find that the max length > 4 (2*mid) then there is no other index that give us bigger length
    and we return the length
**********/

class Solution {
    //Max length, max left index & max right index
    int maxL, maxR, maxLength;

    public String longestPalindrome(String s) {
        maxLength = 1;
        int n = s.length();
        
        //The mid of the string
        int mid = n / 2;
        
        // for {0,1,2,3} mid should be 1
        if (n % 2 == 0) mid--;
        
        //now check mid and we start expanding
        //first check index 3 & then check index 2 & 5
        //compare the max length always 2*mid if its bigger then break
        for (int i = 0; i <= n / 2; i++) {
            checkIndexString(mid + i, s, n);
            if (maxLength >= 2 * (mid - i + 1)) break;
            if (i == 0) continue;
            checkIndexString(mid - i, s, n);
            if (maxLength >= 2 * (mid - i + 1)) break;
        }

        return s.substring(maxL, maxR + 1);
    }

    //Get the max palindrome length around index
    public void checkIndexString(int i, String s, int n) {
        
        int l = i;
        int r = i;
        int len = 0;

        //keep checking if the left and right indices are equal
        while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
            len = r - l + 1;
            if (len > maxLength) {
                maxLength = len;
                maxL = l;
                maxR = r;
            }
            r++;
            l--;
        }

        //Assuming the biggest length is of even size
        l = i;
        r = i + 1;
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            len = r - l + 1;
            if (len > maxLength) {
                maxLength = len;
                maxL = l;
                maxR = r;
            }
            r++;
            l--;
        }
        
    }
}
