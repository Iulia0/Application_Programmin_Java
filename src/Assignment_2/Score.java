package Assignment_2;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Score {
    int score;
    private final String FILENAME = "scores.txt";

    Score(int score) throws IOException {
        this.score = score;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println();
        FileWriter fw = new FileWriter(FILENAME, true);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(String.valueOf(score) + "\t " + dateFormat.format(date) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
        topScores();
    }

    public ArrayList<Integer> topScores() throws IOException {
        ArrayList<Integer> topSc = new ArrayList<Integer>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
        String line = null;
        int sc = 0;
        int count = 0;
        while ((line = buf.readLine()) != null && count <= 10) {
            try {
                sc = Integer.parseInt(String.valueOf(line.substring(0,2)));
                topSc.add(sc);
                count ++;
            } catch (Exception e) {
            }
        }
        return topSc;
    }
    public ArrayList<Integer> topScoresAll() throws IOException {
        ArrayList<Integer> al = new ArrayList<Integer>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
        String line = null;
        int sc = 0;
        while ((line = buf.readLine()) != null) {
            try {
                sc = Integer.parseInt(String.valueOf(line.substring(0,2)));
                al.add(sc);
            } catch (Exception e) {
            }
        }
        Collections.sort(al);
        for(int i = 10; i <al.size(); i++){
            al.remove(i);
        }
        return al;
    }
}
