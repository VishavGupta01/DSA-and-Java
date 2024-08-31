public class interfaces {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
    }
}

interface chessMoves {
    void moves();
}

class Queen implements chessMoves {
    public void moves() {
        System.out.println("Up, Down, Left, Right, Diagonal in all 4 directions");
    }
}

class Rook implements chessMoves {
    public void moves() {
        System.out.println("Up, Down, Left, Right");
    }
}

class King implements chessMoves {
    public void moves() {
        System.out.println("Up, Down, Left, Right by 1 Step");
    }
}
