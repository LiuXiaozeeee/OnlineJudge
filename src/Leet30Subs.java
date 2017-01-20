import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liuxz on 17-1-7.
 */
public class Leet30Subs {
    public List<Integer> findSubstring(String s, String[] words) {
        int M = s.length();
        int N = words[0].length();
        List<Integer> result = new ArrayList<>();

        if (words[0].length() == 0) {
            for (int i = 0; i <= M; i++) {
                result.add(i);
            }
            return result;
        }

        if (words.length == 0) {
            return result;
        }

        if (N * words.length > M) {
            return result;
        }


        HashMap<String, Integer> maped = new HashMap<>(words.length);
        int index = 0, failvalue = 0;
        int[][] table = new int[2][words.length];
        for (int i = 0; i < words.length; i++) {
            if (maped.get(words[i]) == null) {
                maped.put(words[i], index);
                index++;
            }
            table[0][maped.get(words[i])]++;
        }
        failvalue = index;

        List<Integer> appear = new ArrayList<>();
        for (int i = 0; i < M - N + 1; i++) {
            String w = s.substring(i, i + N);
            if (maped.get(w) != null) {
                appear.add(maped.get(w));
            } else {
                appear.add(-1);
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(table[1], 0);
            int left = i, right = i;
            int currentFailvalue = failvalue;
            while (right < M - N + 1) {
                while ((currentFailvalue > 0) && (right < M - N + 1)) {
                    int target = appear.get(right);
                    if (target != -1) {
                        table[1][target]++;
                        if ((currentFailvalue > 0) && (table[1][target] == table[0][target])) {
                            currentFailvalue--;
                        }
                    }
                    right += N;
                }
                while ((currentFailvalue == 0) && (left < right)) {
                    int target = appear.get(left);
                    if (target != -1) {
                        if (table[1][target] >= table[0][target]) {
                            if ((right - left) / N == words.length) {
                                result.add(left);
                            }
                        }
                        table[1][target]--;
                        if (table[1][target] < table[0][target])
                            currentFailvalue++;
                    }
                    left += N;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leet30Subs x = new Leet30Subs();
        System.out.println(x.findSubstring("aaa", new String[]{"a", "b"}));
    }
}
