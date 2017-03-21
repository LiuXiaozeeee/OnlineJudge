import java.util.*;

/**
 * Created by liuxz on 17-3-20.
 */
public class Leet68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        Queue<String> s = new LinkedList<>(Arrays.asList(words));
        List<String> temp = new LinkedList<>();
        int taken;
        while(true){
            taken = 0;
            temp.clear();
            while((s.peek()!= null )&&( (taken+s.peek().length()) <= maxWidth)){
                String r = s.poll();
                taken = taken+r.length()+1;
                temp.add(r);
            }
            if (temp.size() == 0){
                break;
            }else if (temp.size() == 1){
                StringBuilder xx = new StringBuilder();
                xx.append(temp.get(0));
                for (int i = 0; i < maxWidth-temp.get(0).length(); i ++){
                    xx.append(" ");
                }
                result.add(xx.toString());
            }else{
                int spaceNumber = temp.size()-1;
                int spaceTotal = maxWidth-String.join("",temp).length();
                double spaceOnce = 0;
                StringBuilder xx = new StringBuilder();
                if(s.peek()!=null) {
                    for (int i = 0 ; i < temp.size()-1; i ++){
                        xx.append(temp.get(i));
                        spaceOnce = Math.ceil((double)spaceTotal/spaceNumber);
                        for (int j = 0 ; j <spaceOnce; j ++){
                            xx.append(" ");
                            spaceTotal--;
                        }
                        spaceNumber--;
                    }
                    xx.append(temp.get(temp.size()-1));
                }else{
                    for (int i = 0;i < temp.size(); i ++){
                        xx.append(temp.get(i));
                        xx.append(" ");
                    }
                    spaceOnce = spaceTotal - spaceNumber;
                    for (int i = 0 ; i < spaceOnce-1; i ++){
                        xx.append(" ");
                    }
                }
                result.add(xx.toString());
            }
        }
        return result;
    }

    public static void main(String[] args){
        Leet68TextJustification xx = new Leet68TextJustification();
//        System.out.println(xx.fullJustify(new String[]{
//                "This", "is", "an", "example", "of", "text", "justification."
//        }, 16));
//        System.out.println(xx.fullJustify(new String[]{""}, 0));
        System.out.println(xx.fullJustify(new String[]{"What","must","be","shall","be"}, 12));
    }
}
