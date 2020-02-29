package com.jiker.keju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppRunner {
    private Taxi taxi;
    private String receipt = "";

    public AppRunner(Taxi taxi) {
        this.taxi = taxi;
    }

    public List<String> getTestData(String fileName) throws IOException {
        InputStreamReader isr = new InputStreamReader(AppRunner.class.getClassLoader().getResourceAsStream(fileName));
        BufferedReader br = new BufferedReader(isr);
        List<String> list = new ArrayList<String>();
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.trim().length() > 1) list.add(line);
        }
        return list;
    }

    public String execute(String fileName) throws IOException {
        String commandString = getTestData(fileName).toString();
        String[] array = commandString.split("\\D+");
        for (int i = 1; i <= array.length - 2; i = i + 2) {
            taxi.parameter(Integer.parseInt(array[i]), Integer.parseInt(array[i + 1]));
            receipt += taxi.getPrice();
        }
        return receipt;
    }

    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner(new Taxi());
        try {
            String testDataFile = args[0];
            System.out.println(appRunner.execute(testDataFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
