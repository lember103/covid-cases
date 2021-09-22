package de.neuefische.covidcases.model;

import java.util.Objects;

public class ConfirmedByDay {

    private String date;
    private long confirmed;

    public ConfirmedByDay(String date, long confirmed) {
        this.date = date;
        this.confirmed = confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmedByDay that = (ConfirmedByDay) o;
        return confirmed == that.confirmed && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, confirmed);
    }
}
