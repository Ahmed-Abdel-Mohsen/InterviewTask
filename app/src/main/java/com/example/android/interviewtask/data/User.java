package com.example.android.interviewtask.data;

import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.ArrayList;

import com.example.android.interviewtask.data.BookContract.ReadPagesEntry;

/**
 * Created by ahmed on 6/27/2018.
 */

public class User implements Comparable<User> {
    private int id;
    private String name;
    private ArrayList<Pair<Integer, Integer>> sessions;
    private int readPages;

    public User() {
        sessions = new ArrayList<>();
    }

    public User(int id, String name, ArrayList<Pair<Integer, Integer>> sessions) {
        this.id = id;
        this.name = name;
        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pair<Integer, Integer>> getSessions() {
        return sessions;
    }

    public void addReadPages(Pair<Integer, Integer> pair) {
        sessions.add(pair);
        calculateReadPages();
    }

    public void setSessions(ArrayList<Pair<Integer, Integer>> sessions) {
        this.sessions = sessions;
    }

    public void calculateReadPages() {
        readPages = 0;
        if (sessions.size() < 1) {
            return;
        }
        readPages += sessions.get(0).second + 1 - sessions.get(0).first;
        for (int i = 1; i < sessions.size(); i++) {
            if (sessions.get(i - 1).second < sessions.get(i).second) {
                if (sessions.get(i - 1).second < sessions.get(i).first) {
                    readPages += sessions.get(i).second + 1 - sessions.get(i).first;
                } else {
                    readPages += sessions.get(i).second - sessions.get(i - 1).second;
                }
            }
        }
    }

    public int getReadPages() {
        return this.readPages;
    }

    public float getPercentage() {
        return (float) getReadPages() / (float) ReadPagesEntry.BOOK_PAGES_NUMBER;
    }

    @Override
    public int compareTo(@NonNull User user) {
        if (this.readPages > user.getReadPages()) {
            return -1;
        } else if (this.readPages < user.getReadPages()) {
            return 1;
        } else {
            return 0;
        }
    }
}
