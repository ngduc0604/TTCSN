import java.util.InputMismatchException;
import java.util.Scanner;

public class Graph {

    private int[][] capacity; // Ma trận dung lượng
    private int numVertices;  // Số lượng đỉnh
    private int sink;
    private int source;

    Scanner scanner = new Scanner(System.in);

    public Graph() {

    }

    // Thêm một cạnh với dung lượng cho trước
    public void addEdge(int from, int to, int capacityValue) {
        if (from < 0 || from >= numVertices || to < 0 || to >= numVertices) {
            throw new IllegalArgumentException("Chỉ số đỉnh không hợp lệ.");
        }
        if (capacityValue < 0) {
            throw new IllegalArgumentException("Dung lượng phải là số không âm.");
        }
        this.capacity[from][to] += capacityValue;
    }

    public void inPut() {
        try {

            // Nhập số đỉnh
            System.out.print("Nhập số đỉnh của đồ thị: ");
            this.numVertices = scanner.nextInt();
            if (numVertices <= 0) {
                throw new IllegalArgumentException("Số đỉnh phải lớn hơn 0.");
            }
            this.capacity = new int[numVertices][numVertices];
            // Nhập số cạnh
            System.out.print("Nhập số cạnh của đồ thị: ");
            int numEdges = scanner.nextInt();
            if (numEdges < 0) {
                throw new IllegalArgumentException("Số cạnh phải là số không âm.");
            }

            // Nhập các cạnh
            System.out.println("Nhập các cạnh dưới dạng: from to capacity");
            for (int i = 0; i < numEdges; i++) {
                System.out.print("Cạnh " + (i + 1) + ": ");
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                int capa = scanner.nextInt();
                addEdge(from, to, capa);
            }

            // Nhập đỉnh nguồn và đỉnh đích
            System.out.print("Nhập đỉnh nguồn: ");
            this.source = scanner.nextInt();
            System.out.print("Nhập đỉnh đích: ");
            this.sink = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public int[][] getCapacity() {
        return capacity;
    }

    public void setCapacity(int[][] capacity) {
        this.capacity = capacity;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getSink() {
        return sink;
    }

    public void setSink(int sink) {
        this.sink = sink;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

}
