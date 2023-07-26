package com.strinadkakirill.javalabs.lab3_minesweeper.lab3.Model.Statistics;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Обрабатывает и сохраняет статистику игры
 */
public class Statistic {

    final static int MAX_RECORDS = 5;


    ArrayList<StatRecord> statRecordArrayList;

    ArrayList<String> resultListForWritingToFile;


    /**
     * Необработанная информация из файла статистики
     */
    ArrayList<String> inputDataList;

    File currentStatisticFile;

    //определим по режиму игры
    String fileName;


    /**
     * Режим игры, для которого сохраняется статистика
     */
    private GameModes currentGameMode;


    /**
     * Конструктор для записи статиситики при выигрыше
     */
    public Statistic(String fileName, GameModes currentGameMode) {
        this.fileName = fileName;
        this.currentGameMode = currentGameMode;
    }


    /**
     * Просто возвращает статистику из файла.
     */
    public ArrayList<String> getStatisticList() {
        this.inputDataList = new ArrayList<>();

        try {
            this.inputDataList = getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this.inputDataList;
    }



    /**
     * уничтожение всех записей статистики перед новой записью
     */
    public void clear() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(this.fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }


    /**
     * Добавляет новую запись в файл (не добавляет, если предыдущие 5 результатов лучше
     */
    public void addNewRecord(String timeString, String userName){

        this.currentStatisticFile = null;
        this.inputDataList = new ArrayList<>();

        try {
            this.inputDataList = getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //считали файл статистики в список


        //очистили файл статистики
        clear();

        this.statRecordArrayList = createRecordList();

        String statResult = userName + " - " + timeString;

        // эту запись попробуем добавить в списочек
        StatRecord statRecord = new StatRecord(statResult);

        this.statRecordArrayList.add(statRecord);
        //дальше соритруем этот список по секундам внутри StatRecord
        Collections.sort(this.statRecordArrayList);

        this.resultListForWritingToFile = createResultListForFile();

        addNewRecordToFile();
    }


    /**
     * Создает список StatRecord из строк входящего файла
     */
    private ArrayList<StatRecord> createRecordList () {

        ArrayList<StatRecord> statRecords = new ArrayList<>();

        for (String str: this.inputDataList) {
            String time = getTimeFromThisString(str);
            StatRecord record = new StatRecord(time);
            statRecords.add(record);
        }

        return statRecords;
    }

    private String getTimeFromThisString(String str) {
        Pattern pattern = Pattern.compile("(\\d\\d:\\d\\d)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            //System.out.printf("%s\n", matcher.group(1));
            return matcher.group(1);
        }
        return null;
    }


    /**
     * Добавляет 5 лучших записей в файл нужной статистики
     */
    private void addNewRecordToFile() {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(this.fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int n = 0;

        for (String str: this.resultListForWritingToFile) {
            n++;

            try {
                writer.write(str + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (n == MAX_RECORDS) {
                break;
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private ArrayList<String> createResultListForFile () {

        ArrayList<String> list = new ArrayList<>();

        for(StatRecord record: this.statRecordArrayList) {

            String str = record.toString();
            list.add(str);
        }

        return list;
    }



    /**
     * Узнаем в какой режим мы играли, чтобы добавить запись в статистику
     */
    public static GameModes getGameMode (int widthOfField, int heightOfField, int numberOfMines) {

        if (widthOfField == 9 && heightOfField == 9 && numberOfMines == 10) {
            return GameModes.BEGINNER;
        }
        else if (widthOfField == 16 && heightOfField == 16 && numberOfMines == 40) {
            return GameModes.INTERMEDIATE;
        }
        else if (widthOfField == 30 && heightOfField == 16 && numberOfMines == 99) {
            return GameModes.BEGINNER;
        }
        else {
            return GameModes.SPECIFIC;
        }
    }




    public static String getCurrentStatisticFileName(GameModes gameMode) {
        if (gameMode.equals(GameModes.BEGINNER)) {
            return "beginnerStatistic.txt";
        }
        else if (gameMode.equals(GameModes.BEGINNER)) {
            return "intermediateStatistic.txt";
        }
        else if (gameMode.equals(GameModes.BEGINNER)) {
            return "professionalStatistic.txt";
        }
        else return "specificStatistic.txt";
    }


    /**
     * Метод считывает файл статистики и создает необработанный список результатов String
     * @return - список String считанный с нужного файла статистики (или пустой список)
     * @throws IOException
     */
    public ArrayList<String> getText() throws IOException {


        //Если нет такого файла, то создаем файл и возвращаем пустой список
        if (!(new File(this.fileName).isFile())) {

            System.out.println("нет такой файл");
            ArrayList<String> list = new ArrayList<>();
            try {
                File file = new File(this.fileName);
                file.createNewFile();
                System.out.println("Empty File Created:- " + file.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }
        else {
            System.out.println("Есть такой файл");
        }


        //если есть файл, то считываем с него строки и пихаем в list

        ArrayList<String> list = new ArrayList<>();


        try {
            this.currentStatisticFile = new File(this.fileName);
            Scanner myReader = new Scanner(this.currentStatisticFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return list;

    }









}
