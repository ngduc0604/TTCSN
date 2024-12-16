
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {
    private int[][] capacity; // Ma trận dung lượng
    private int[][] flow; // Cập nhật luồng
    private int numVertices; // Số lượng đỉnh

    public EdmondsKarp(Graph graph) {
        this.numVertices = graph.getNumVertices();
        this.capacity = graph.getCapacity();
        this.flow = new int[numVertices][numVertices];
    }

    // Tính luồng cực đại bằng thuật toán Edmonds-Karp
    public int findMaxFlow(int source, int sink) {
        if (source < 0 || source >= numVertices || sink < 0 || sink >= numVertices) {
            throw new IllegalArgumentException("Đỉnh nguồn hoặc đích không hợp lệ.");
        }

        int maxFlow = 0;
        while (true) {
            int[] parent = new int[numVertices];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            parent[source] = source;

            // Thực hiện BFS để tìm đường tăng luồng
            while (!queue.isEmpty() && parent[sink] == -1) {
                int current = queue.poll();

                for (int next = 0; next < numVertices; next++) {
                    if (parent[next] == -1 && capacity[current][next] - flow[current][next] > 0) {
                        parent[next] = current;
                        queue.add(next);
                        if (next == sink) {
                            break;
                        }
                    }
                }
            }

            // Nếu không tìm được đường tăng luồng
            if (parent[sink] == -1) {
                break;
            }

            // Tìm dung lượng nhỏ nhất trên đường tăng luồng
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, capacity[u][v] - flow[u][v]);
            }

            // Cập nhật luồng trên các cạnh của đường tăng luồng
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public int[][] getCapacity() {
        return capacity;
    }

    public void setCapacity(int[][] capacity) {
        this.capacity = capacity;
    }

    public int[][] getFlow() {
        return flow;
    }

    public void setFlow(int[][] flow) {
        this.flow = flow;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }


}

