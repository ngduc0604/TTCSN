public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Graph graph = new Graph();
        graph.inPut();
        int source= graph.getSource();
        int sink=graph.getSink();
        // Tính luồng cực đại
        EdmondsKarp ek = new EdmondsKarp(graph);
        int maxFlow = ek.findMaxFlow(source, sink);
        System.out.println("Luồng cực đại: " + maxFlow);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime); // Thời gian tính bằng nano giây
        System.out.println("Thời gian thực thi: " + duration + " nano giây");
    }
}