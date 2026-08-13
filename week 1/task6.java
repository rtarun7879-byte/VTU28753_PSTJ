import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() { return name; }
    int getScore() { return score; }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        // Descending by score
        if (a.getScore() != b.getScore()) {
            return b.getScore() - a.getScore();
        }
        // Ascending by name if scores tie
        return a.getName().compareTo(b.getName());
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Player[] player = new Player[n];
        for (int i = 0; i < n; i++) {
            String[] pieces = scan.nextLine().trim().split(" ");
            player[i] = new Player(pieces[0], Integer.parseInt(pieces[1]));
        }
        scan.close();

        Checker checker = new Checker();
        Arrays.sort(player, checker);

        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }
    }
}