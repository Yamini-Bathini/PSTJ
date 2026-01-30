import java.util.*;
interface PerformOperation {
    boolean check(int n);
}
public class Task2 {
    static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }
    static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }
    static PerformOperation isPalindrome() {
        return n -> {
            int o = n, r = 0;
            while (n > 0) {
                r = r * 10 + n % 10;
                n /= 10;
            }
            return o == r;
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int c = sc.nextInt();
            int n = sc.nextInt();
            if (c == 1)
                System.out.println(isOdd().check(n) ? "ODD" : "EVEN");
            else if (c == 2)
                System.out.println(isPrime().check(n) ? "PRIME" : "COMPOSITE");
            else if (c == 3)
                System.out.println(isPalindrome().check(n) ? "PALINDROME" : "NOT PALINDROME");
        }
    }
}
