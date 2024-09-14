import java.util.*;

class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        long[] times = new long[360001];
        
        for (String log : logs) {
            String[] splitLog = log.split("-");
            long startTime = ToInt(splitLog[0]);
            long endTime = ToInt(splitLog[1]);
            
            times[(int)startTime]++;
            times[(int)endTime]--;
        }
        long playTime = ToInt(play_time);
        long advTime = ToInt(adv_time);
        
        for (long i = 1; i < times.length; i++) {
            times[(int)i] += times[(int)i-1];
        }
        for (long i = 1; i < times.length; i++) {
            times[(int)i] += times[(int)i-1];
        }

        long maxCnt=times[(int)advTime-1];
        long anstime = 0;
        
        for(long i=0; i<playTime-advTime+1; i++) {
            long tmp = times[(int)advTime+(int)i] - times[(int)i];
            if (tmp > maxCnt) {
                maxCnt = tmp;
                anstime = i+1;
            }
        }
        return ToTime(anstime);
    }

    public int ToInt(String time){
        
        String[] t = time.split(":");
        
        return Integer.parseInt(t[2])+
            Integer.parseInt(t[1])*60+
            Integer.parseInt(t[0])*60*60;
    }
    
    public String ToTime(long time){
        
        long hour= time/3600;
        String sh=String.valueOf(hour);
        if(hour<10) sh="0"+sh;
        
        
        time-=hour*3600;
        
        long min= time/60;
        time-=min*60;
        String mh=String.valueOf(min);
        
        if(min<10) mh="0"+mh;
        
        String ch=String.valueOf(time);
        if(time<10) ch="0"+ch;
        
        return sh+":"+mh+":"+ch;
        
    }
}