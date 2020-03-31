package cr.ac.ucenfotec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha {
    private int day;
    private int month;
    private int year;

    private LocalDate completeDate;

    public Fecha(){
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.completeDate = LocalDate.now();
    }

    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //Custom Setters
    public void calculateCompleteDate(int year, int month, int day){
        this.completeDate = convertToLocalDate(year, month, day);
    }

    //Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    //Custom Functionality
    public static LocalDate convertToLocalDate(int year, int month, int day) {
        // format arguments
        String dateString = year + " " + month + " " + day;
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M d");
        // create a LocalDate object
        try {
            LocalDate localDate = LocalDate.parse(dateString, formatter);
            return localDate;
        } catch (DateTimeParseException exception) {
            return null;
        }

    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.completeDate != null){
            builder.append("Date: ").append(this.completeDate).append("\n");
        }else{
            builder.append("Day ").append(this.day).append("\n");
            builder.append("Month ").append(this.month).append("\n");
            builder.append("Year ").append(this.year).append("\n");
        }
        return builder.toString();
    }
}
