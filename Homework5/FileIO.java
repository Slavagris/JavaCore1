package Homework5;

import java.io.*;

public class FileIO {

    public static void save(AppData csvSave, File filename) {
        String headerString = "";
        String[] tempHeadArray;
        String dataString = "";
        int[][] tempIntArray;


        try (PrintWriter output = new PrintWriter(filename)) {
            tempHeadArray = csvSave.getHeader();
            for (String tempStr : tempHeadArray) {
                headerString = headerString + tempStr + ";";
            }
            headerString = headerString.substring(0, headerString.length() - 1);
            output.println(headerString);

            tempIntArray = csvSave.getData();
            for (int i = 0; i < tempIntArray.length; i++) {
                dataString = "";
                for (int j = 0; j < tempIntArray[0].length; j++) {
                    dataString = dataString + tempIntArray[i][j] + ";";
                }
                dataString = dataString.substring(0, dataString.length() - 1);
                output.println(dataString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void load(AppData csvLoad, File filename) {
        String intLine;
        String[] stringData;
        String[] header;
        int lineCounter = 0, itemCounter = 0;
        int fileLines = 0;

        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            fileLines = (int) input.lines().count() - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] data = new int[fileLines][];

        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            header = input.readLine().split(";");

            while ((intLine = input.readLine()) != null) {
                stringData = intLine.split(";");
                itemCounter = 0;
                data[lineCounter] = new int[stringData.length];
                for (String tempString : stringData) {
                    data[lineCounter][itemCounter] = Integer.parseInt(tempString);
                    itemCounter++;
                }
                lineCounter++;
            }

            csvLoad.setHeader(header);
            csvLoad.setData(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3", "Value4", "Value5"};
        int[][] data = {{100, 200, 123, 3333, 4444}, {300, 400, 500, 6666, 7777}, {123, 123, 123, 123, 123}};

        File csvIntsFile = new File("ints.csv");
        AppData csvForSave = new AppData(header, data);
        AppData csvForLoad = new AppData(null, null);

        save(csvForSave, csvIntsFile);

        load(csvForLoad, csvIntsFile);

        System.out.println(csvForLoad);

    }
}