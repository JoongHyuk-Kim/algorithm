import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        System.out.println(T.solution(k, arr));
    }

    private int solution(int k, int[] arr) {
        int answer = Integer.MIN_VALUE;

        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];

            while (rt - lt + 1 >= k) {
                answer = Math.max(answer, sum);
                sum -= arr[lt];
                lt++;
            }
        }

        return answer;
    }
}
