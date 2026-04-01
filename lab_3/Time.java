/**
 * TASK 5 — Time class (imported from Week 2, now implements Comparable)
 *
 * Times are compared by total seconds: 09:00:00 < 14:30:00
 */
public class Time implements Comparable<Time> {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours   = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours()   { return hours; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return seconds; }

    /** Convert to total seconds for easy comparison */
    public int toTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    /** Earlier time is "less than" later time */
    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toTotalSeconds(), other.toTotalSeconds());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Time)) return false;
        Time t = (Time) obj;
        return hours == t.hours && minutes == t.minutes && seconds == t.seconds;
    }
}
