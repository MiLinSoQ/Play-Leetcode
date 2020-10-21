
import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		int x = 345;
		
		
		
		System.out.println((new Solution()).isPalindrome(x));
		
	}
	
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
		
		int carry = 1;
		List<Integer> arr = new ArrayList<>();
		while (x != 0) {
			
			carry *= 10;
			int rem = (x % carry);
			x -= rem;
			
			arr.add(rem);
			System.out.println(x + ", " + carry);
		}
		
		int res = 0;
		int carry2 = 1;
		for (int i = arr.size() - 1; i >= 0; i--) {
			carry = carry / 10;
			
			System.out.println(arr.get(i) + " / " + carry);
			System.out.println(arr.get(i) / carry);
			
			carry2 *= 10;
		}
		
		return true;
    }
}