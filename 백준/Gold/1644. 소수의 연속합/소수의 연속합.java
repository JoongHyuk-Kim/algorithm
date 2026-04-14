import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean [] isPrime = new boolean[n + 1];

        Main T = new Main();
        System.out.println(T.solution(n, isPrime));
    }

    private int solution(int n, boolean[] isPrime) {

        boolean[] isPrimeSet = initPrime(isPrime, n);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < isPrimeSet.length; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        int sum = 0;
        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < list.size(); rt++) {
            sum += list.get(rt);

            while (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= list.get(lt);
                lt++;
            }
        }

        return count;
    }

    private boolean[] initPrime(boolean[] isPrime, int n) {
        // 초기화
        Arrays.fill(isPrime, true);

        // 소수 판별
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == false) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
