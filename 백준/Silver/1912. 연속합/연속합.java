

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        System.out.println(T.solution(arr));
    }

    private int solution(int[] arr) {

        int max = arr[0];
        int current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(current, max);
        }

        return max;
    }
}
