package nextstep.ladder.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final String DELIMITER = ",";
    private static final int PLAYER_MIN_COUNT = 2;
    private List<Name> players;

    public Player(String inputPlayers) {
        this(toArray(inputPlayers));
    }

    public static String[] toArray(String inputPlayers) {
        return inputPlayers.split(DELIMITER);
    }

    public Player(String[] players) {
        if (players.length < PLAYER_MIN_COUNT) {
            throw new IllegalArgumentException("참가자 수가 부족합니다. 게임을 진행하려면 최소 " + PLAYER_MIN_COUNT + "명 이상 필요합니다.");
        }
        this.players = Arrays.stream(players)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Name> getPlayers() {
        return players;
    }
}
