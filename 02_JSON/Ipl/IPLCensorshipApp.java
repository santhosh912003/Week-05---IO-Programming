import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;



public class IPLCensorshipApp {
    public static void main(String[] args) throws Exception {
        List<IPLMatch> matches = readJSON("input.json");
        writeJSON(applyCensorship(matches), "output.json");

        List<String[]> csvData = readCSV("input.csv");
        writeCSV(applyCSVCensorship(csvData), "output.csv");
    }

    static List<IPLMatch> readJSON(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<IPLMatch>>() {});
    }

    static void writeJSON(List<IPLMatch> matches, String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), matches);
    }

    static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.team1 = censorTeam(match.team1);
            match.team2 = censorTeam(match.team2);
            match.winner = censorTeam(match.winner);
            match.player_of_match = "REDACTED";

            Map<String, Integer> newScore = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : match.score.entrySet())
                newScore.put(censorTeam(entry.getKey()), entry.getValue());
            match.score = newScore;
        }
        return matches;
    }

    static String censorTeam(String team) {
        int idx = team.indexOf(" ");
        return idx == -1 ? "***" : team.substring(0, idx) + " ***";
    }

    static List<String[]> readCSV(String path) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            return reader.readAll();
        }
    }

    static void writeCSV(List<String[]> data, String path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeAll(data);
        }
    }

    static List<String[]> applyCSVCensorship(List<String[]> data) {
        List<String[]> result = new ArrayList<>();
        result.add(data.get(0));
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            row[1] = censorTeam(row[1]);
            row[2] = censorTeam(row[2]);
            row[5] = censorTeam(row[5]);
            row[6] = "REDACTED";
            result.add(row);
        }
        return result;
    }
}
class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;
}