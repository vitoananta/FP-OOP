package gamestate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreList {

	private ArrayList<Score> scoreList;

	public ScoreList() {
		scoreList = new ArrayList<>();
	}

	public ArrayList<Score> getTopFive() throws IOException {
		ArrayList<Score> scores = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader("score.txt"));
		String row;
		int count = 0;
		while ((row = reader.readLine()) != null && count != 5) {
			String[] tokens = row.split(" ");
			String username = tokens[0];
			int score = Integer.parseInt(tokens[1]);
			scores.add(new Score(username, score));
			count++;
		}
		reader.close();
		return scores;
	}
	
	public void sortScores() throws IOException {
        ArrayList<Score> scores = new ArrayList<>(); // create an ArrayList to store the scores
        BufferedReader reader = new BufferedReader(new FileReader("scores.txt")); // create a BufferedReader to read the file
        String line;
        while ((line = reader.readLine()) != null) { 
          String[] parts = line.split(" "); // split jadi bagian bagian datannya
          String playerName = parts[0]; // nama pl
          int score = Integer.parseInt(parts[1]); // skor pl
          scores.add(new Score(playerName, score)); // masukkan ke dalam arrList
        }
        reader.close(); // close the reader to finish reading the file

        // sort the scores by descending order of score
        Collections.sort(scores, new Comparator<Score>() {
          public int compare(Score s1, Score s2) {
            return Integer.compare(s2.score, s1.score); // compare the scores in descending order
          }
        });

        PrintWriter writer = new PrintWriter("scores.txt", "UTF-8"); // create a PrintWriter to write to the file
        for (Score score : scores) { // write each score to the file
          writer.println(score.username + " " + score.score);
        }
        writer.close(); // close the writer to save the file
      }
}
