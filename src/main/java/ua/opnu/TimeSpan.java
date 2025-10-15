package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Неправильне значення хвилин");
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan other) {
        this(other.hours, other.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    public void add(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від’ємними");
        }
        add(0, minutes);
    }

    public void add(TimeSpan other) {
        add(other.hours, other.minutes);
    }


    public void subtract(int hours, int minutes) {
        TimeSpan temp = new TimeSpan(hours, minutes);
        subtract(temp);
    }

    public void subtract(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від’ємними");
        }
        subtract(new TimeSpan(minutes));
    }

    public void subtract(TimeSpan other) {
        int totalCurrent = getTotalMinutes();
        int totalOther = other.getTotalMinutes();

        if (totalOther > totalCurrent) {
            throw new IllegalArgumentException("не можна відняти більший інтервал від меншого");
        }

        int result = totalCurrent - totalOther;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Коефіцієнт має бути більшим за 0");
        }
        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}