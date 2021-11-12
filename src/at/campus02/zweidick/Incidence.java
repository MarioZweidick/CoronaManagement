package at.campus02.zweidick;

import java.text.DateFormat;
import java.util.Objects;

public class Incidence
{
    private String state;
    private String date;
    private int number;

    public Incidence(String state, String date, int number)
    {
        this.state = state;
        this.date = date;
        this.number = number;
    }

    public String getState()
    {
        return state;
    }

    public String getDate()
    {
        return date;
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incidence incidence = (Incidence) o;
        return Objects.equals(state, incidence.state) && Objects.equals(date, incidence.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(state, date);
    }

    @Override
    public String toString()
    {
        return "Incidence{" +
                "state='" + state + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
                '}';
    }
}
