
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int index = 0;
        int[] arr = new int[n];
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        System.out.println(T.solution(s, arr));
    }

    private int solution(int s, int[] arr) {
        int length = Integer.MAX_VALUE;

        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];

            while (sum >= s) {
                length = Math.min(length, rt - lt + 1);
                sum -= arr[lt];
                lt++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
