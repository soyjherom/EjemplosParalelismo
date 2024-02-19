package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionServiceSquareResolutor {
    private List<Integer> numbers = new ArrayList<>();
    public ExecutionServiceSquareResolutor(int limit){
        for(int i = 1; i <= limit; i++){
            numbers.add(i);
        }
    }
    public void printSquares() throws ExecutionException, InterruptedException {
        List<Integer> firstHalf = numbers.subList(0, (numbers.size()/2) - 1);
        List<Integer> secondHalf = numbers.subList(numbers.size()/2, numbers.size() - 1);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<List<Integer>>> futures = new ArrayList<>();

        Future<List<Integer>> future = executor.submit(() -> {
            List<Integer> result = new ArrayList<>();
            for (Integer number : firstHalf) {
                result.add(number * number);
            }
            return result;
        });
        futures.add(future);

        future = executor.submit(() -> {
            List<Integer> result = new ArrayList<>();
            for (Integer number : secondHalf) {
                result.add(number * number);
            }
            return result;
        });
        futures.add(future);

        List<Integer> finalResults = new ArrayList<>();
        for (Future<List<Integer>> f : futures) {
            finalResults.addAll(f.get());
        }

        //System.out.println(finalResults);

        executor.shutdown();
    }

}
