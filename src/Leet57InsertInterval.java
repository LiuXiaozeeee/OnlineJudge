import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by liuxz on 17-3-29.
 */


public class Leet57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int l = intervals.size();
        if(l == 0){
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0 ; i < l ; i ++){
            if ((i == 0)&&(newInterval.start<=intervals.get(0).start)){
                intervals.add(0,newInterval);
                merge(intervals,0);
                break;
            }else if ((i == l -1)&&(intervals.get(i).start<=newInterval.start)){
                intervals.add(newInterval);
                merge(intervals,i);
                break;
            }else{
                if ((intervals.get(i).start<=newInterval.start)&&
                        newInterval.start<=intervals.get(i+1).start){
                    intervals.add(i+1,newInterval);
                    merge(intervals,i);
                    merge(intervals,i+1);
                    break;
                }
            }
        }
        return intervals;
    }

    void merge(List<Interval> intervals, int index){
//        注意送进来的index需要保证为融合的开始。当融合产生移动之后，融合停止。
        while((index+1<intervals.size())&&(intervals.get(index).end >= intervals.get(index+1).start)){
            intervals.get(index).end = Math.max(intervals.get(index).end,intervals.get(index+1).end);
            intervals.remove(index+1);
        }
    }

//    void merge(List<Interval> intervals, int index){
//        while(index < intervals.size()){
//            if(((index == intervals.size()-1) || (intervals.get(index).end)<
//                    (intervals.get(index+1).start))){
//                break;
//            }else if ((intervals.get(index+1).start<=intervals.get(index).end) &&
//                        (intervals.get(index).end < intervals.get(index+1).end)){
//                    intervals.get(index).end = intervals.get(index+1).end;
//                    intervals.remove(index+1);
//            }else if (intervals.get(index+1).end<= intervals.get(index).end){
//                intervals.remove(index+1);
//            }
//        }
//    }

    public static void main(String[] args){
        Leet57InsertInterval xx = new Leet57InsertInterval();
        xx.insert(new ArrayList<>(Arrays.asList(new Interval(1,2),
                new Interval(3,5), new Interval(6,7), new Interval(8,10),new Interval(12,16))),
                new Interval(4,9)).forEach((a)->System.out.println("[" + a.start + ", " + a.end + "]"));

        System.out.println("====");

        xx.insert(new ArrayList<>(Arrays.asList(new Interval(1,5))),
                new Interval(5,7)).forEach((a) ->System.out.println("[" + a.start + ", " + a.end + "]"));

        System.out.println("====");

        xx.insert(new ArrayList<>(Arrays.asList(new Interval(1,5), new Interval(6,8))),
                new Interval(0,9)).forEach((a)->System.out.println("["+a.start+","+a.end+"]"));

        System.out.println("====");

        xx.insert(new ArrayList<>(Arrays.asList(new Interval(1,5))),
                new Interval(1,7)).forEach((a) ->System.out.println("[" + a.start + ", " + a.end + "]"));

        System.out.println("====");

        xx.insert(new ArrayList<>(Arrays.asList(new Interval(1,5), new Interval(6,8))),
                new Interval(5,6)).forEach((a) ->System.out.println("[" + a.start + ", " + a.end + "]"));

        System.out.println("====");

        xx.insert(new ArrayList<>(Arrays.asList(new Interval(0,5), new Interval(9,12))),
                new Interval(7,16)).forEach((a) ->System.out.println("[" + a.start + ", " + a.end + "]"));
    }
}
