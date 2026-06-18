class Solution {
    public double angleClock(int hour, int minutes) {
        double hourangle=30*(hour % 12)+0.5*minutes;
        double minuteangle=6*minutes;
        double diff=Math.abs(hourangle-minuteangle);
        return Math.min(diff,360-diff);
   }
}