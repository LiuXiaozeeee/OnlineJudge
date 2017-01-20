import java.util.HashMap;

/**
 * Created by liuxz on 17-1-9.
 */
public class Leet76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int M = s.length();
        int N = t.length();

        HashMap<Character, Integer> map = new HashMap<>(N);
        int index = 0;
        int[][] table = new int[2][N];
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), index);
                index++;
            }
            table[0][map.get(t.charAt(i))]++;
        }


        int[] ref = new int[M];
        for (int i = 0; i < M; i++) {
            if (map.containsKey(s.charAt(i))) {
                ref[i] = map.get(s.charAt(i));
            } else {
                ref[i] = -1;
            }
        }
        compu result = new compu();
        int failed = index;
        int left = 0, right = 0;
        while (right < M) {
            while ((failed > 0) && (right < M)) {
                if (ref[right] >= 0) {
                    table[1][ref[right]]++;
                    if (table[0][ref[right]] == table[1][ref[right]]) {
                        failed--;
                    }
                }
                right++;
            }
            while ((failed == 0) && (left < right)) {
                if (ref[left] >= 0) {
                    if (right - left + 1 <= result.len)
                        result.setDate(left, right, right - left + 1);
                    table[1][ref[left]]--;

                    if (table[1][ref[left]] < table[0][ref[left]]) {
                        failed++;
                    }
                }
                left++;
            }
        }

        return s.substring(result.begin, result.end);
    }

    class compu {
        int begin;
        int end;
        int len = Integer.MAX_VALUE;

        void setDate(int begin, int end, int len) {
            this.begin = begin;
            this.end = end;
            this.len = len;
        }

        void getLen() {
            this.len = begin - end + 1;
        }
    }

    public static void main(String[] args) {
        Leet76MinimumWindowSubstring x = new Leet76MinimumWindowSubstring();
        System.out.println(x.minWindow("ADOBECODEBANCB", "ABCB"));
    }
}
