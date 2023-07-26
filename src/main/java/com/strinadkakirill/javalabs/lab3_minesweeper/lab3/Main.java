package com.strinadkakirill.javalabs.lab3_minesweeper.lab3;

import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Field;
import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics.GameModes;
import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics.StatRecord;
import com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics.Statistic;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {


    //запускается приложение
        //работает
    //завершается

        /*Field field = new Field();

        field.printMainField();*/


        //Statistic statistic = new Statistic("beginner.txt", GameModes.BEGINNER);


        //statistic.addNewRecord("00:52", "user");

        String timeString = "user - time: 20:56";


        Pattern pattern = Pattern.compile("(\\d\\d:\\d\\d)");
        Matcher matcher = pattern.matcher(timeString);
        String resultOfMatchTime = null;
        if (matcher.find())
        {
            resultOfMatchTime = matcher.group(1);
            System.out.println(resultOfMatchTime);
        }




    }
}
