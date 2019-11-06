package madwani.sushil.model;

import java.util.Objects;

public class Node {
    int n;
    String name;

    public Node(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return n == node.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
