package com.ttf.A00_review;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法：
 * 一般而言，这种题目都是贴近生活的应用题的感觉，考虑贪心算法。贪心的核心排序或堆有关。
 * 贪心算法的代码本身一般比较简单，核心就是找到正确的比较和排序函数。
 */
public class TX035_MostMeetingArrange {
    public static class Meeting{
        int start;
        int end;
        public Meeting (int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    public int mostMeetingArrange(Meeting[] meetings) {
        // sort the meetings per end time
        Arrays.sort(meetings, new MeetingComparator());

        // arrange as many as possible, then need to choose from the meetings
        // per end time as early as possible
        int current = 0;
        int count = 0;
        for(Meeting m:meetings){
            if (m.start>=current) {
                count++;
                current = m.end;
            }
        }
        return count;
    }

    private static class MeetingComparator implements Comparator<Meeting>{
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end-o2.end;
        }
    }
}
