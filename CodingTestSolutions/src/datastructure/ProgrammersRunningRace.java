package src.datastructure;

import java.util.HashMap;
import java.util.Map;

public class ProgrammersRunningRace {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersMap = new HashMap<>();

        for(int i = 0; i < players.length; i++)
            playersMap.put(players[i], i);

        for (String calling : callings) {
            int ranking = playersMap.get(calling);

            playersMap.put(players[ranking - 1], ranking);
            playersMap.put(players[ranking], ranking - 1);

            String temp = players[ranking - 1];
            players[ranking - 1] = players[ranking];
            players[ranking] = temp;
        }

        return players;
    }
}
