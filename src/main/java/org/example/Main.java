package org.example;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int limit = 100000;
        sequentialSquares(limit);
        simpleParalellThreadSquares(limit);
        executionServiceSquareResolution(limit);
        streamedSquareResolution(limit);
    }

    private static void streamedSquareResolution(int limit) {
        long startTime = System.nanoTime();
        StreamedSquareResolutor resolutor = new StreamedSquareResolutor(limit);
        resolutor.printSquares();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMilliseconds = duration / 1_000_000.0;
        System.out.println("Elapsed time using parallelStream: " + durationInMilliseconds + " ms");
    }

    private static void executionServiceSquareResolution(int limit) throws InterruptedException, ExecutionException {
        long startTime = System.nanoTime();
        ExecutionServiceSquareResolutor resolutor = new ExecutionServiceSquareResolutor(limit);
        resolutor.printSquares();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMilliseconds = duration / 1_000_000.0;
        System.out.println("Elapsed time for parallel calculation using ExecutionService: " + durationInMilliseconds + " ms");
    }

    private static void simpleParalellThreadSquares(int limit) throws InterruptedException {
        long startTime = System.nanoTime();
        SimpleThreadSquareResolutor threadSquareResolutor = new SimpleThreadSquareResolutor(limit);
        threadSquareResolutor.printSquares();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMilliseconds = duration / 1_000_000.0;
        System.out.println("Elapsed time for simple parallel thread calculation: " + durationInMilliseconds + " ms");
    }

    private static void sequentialSquares(int limit){
        long startTime = System.nanoTime();
        SequentialSquares sequentialSquares = new SequentialSquares(limit);
        sequentialSquares.printSquares();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMilliseconds = duration / 1_000_000.0;
        System.out.println("Elapsed time running sequential processing: " + durationInMilliseconds + " ms");
    }
}