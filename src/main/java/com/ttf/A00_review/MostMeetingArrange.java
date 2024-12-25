package com.ttf.A00_review;

import java.util.Arrays;
import java.util.Comparator;

public class MostMeetingArrange {
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
