package org.example;

import java.util.ArrayList;

public class HistoryService {
    private ArrayList<String> history = new ArrayList<>();
//    had a +

    public void addRecord(String Record){
        history.add(Record);
    }

    public void showHistory(){
        if (history.isEmpty()){
            System.out.println("تاریخچه خالی می باشد / History is Empty");
        }else {
            System.out.println("Operation History / تاریخچه عملیات");
        }
        for (String item:history){
            System.out.println(item);
        }

    }

    public void clearHistory(){
        history.clear();
        System.out.println("History is empty / تاریخچه پاک شد");
    }
}
