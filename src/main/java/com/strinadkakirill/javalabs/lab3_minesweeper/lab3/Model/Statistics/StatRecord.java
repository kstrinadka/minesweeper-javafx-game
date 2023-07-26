package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Одна запись в таблице статистики
 */
public class StatRecord implements Comparable<StatRecord> {


    /**
     * Время игры
     */
    private String timeString;

    private String statResult;


    /**
     * Время игры в секундах
     */
    private int timeSeconds;



    public StatRecord(String statResult) {
        this.statResult = statResult;
        this.timeString = parseTimeString();
        this.timeSeconds = parseStringTimeToSeconds();
    }

    public int getTimeSeconds() {
        return this.timeSeconds;
    }


    public String parseTimeString() {

        Pattern pattern = Pattern.compile("(\\d\\d:\\d\\d)");
        Matcher matcher = pattern.matcher(this.statResult);
        String resultOfMatchTime = null;
        if (matcher.find())
        {
            resultOfMatchTime = matcher.group(1);
            System.out.println(resultOfMatchTime);
        }

        return resultOfMatchTime;
    }

    public int parseStringTimeToSeconds () {




        String[] h1=this.timeString.split(":");

        int minute=Integer.parseInt(h1[0]);
        int second=Integer.parseInt(h1[1]);

        int temp;
        temp = second + (60 * minute);

        System.out.println("seconds: " + temp);

        return temp;
    }

    @Override
    public String toString() {
        return this.statResult;
    }

    @Override
    public int compareTo(StatRecord o) {
        return Integer.compare(getTimeSeconds(), o.getTimeSeconds());
    }
}
