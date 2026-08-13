import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {

        if (a.score > b.score) {
            return -1;
        }

        if (a.score < b.score) {
            return 1;
        }

        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (int i = 0; i < n; i++) {
            System.out.println(players[i].name + " " + players[i].score);
        }

        sc.close();
    }
}