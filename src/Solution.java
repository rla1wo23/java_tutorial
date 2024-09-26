import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Long> v = new ArrayList<>();
        long en = 0;
        for (int i = 0; i < K; i++) {
            long n = Long.parseLong(br.readLine());
            v.add(n);
            en = Math.max(en, n);
        }

        long stIdx = 1;
        long result = 0;
        while (stIdx <= en) {
            long mid = stIdx + (en - stIdx) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += v.get(i) / mid;
            }
            if (cnt >= N) {
                result = mid;
                stIdx = mid + 1;
            } else {
                en = mid - 1;
            }
        }
        System.out.println(result);
    }
}
