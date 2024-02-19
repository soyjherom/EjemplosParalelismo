package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimpleThreadSquareResolutor {
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> squares;
    public SimpleThreadSquareResolutor(int limit){
        for(int i = 1; i <= limit; i++){
            numbers.add(i);
        }
    }

    public void printSquares() throws InterruptedException {
        List<Integer> firstHalf = numbers.subList(0, (numbers.size()/2) - 1);
        List<Integer> secondHalf = numbers.subList(numbers.size()/2, numbers.size() - 1);

        Thread firstThread = new Thread(()->{
            for(int i = 0; i < firstHalf.size(); i++){
                final int number = firstHalf.get(i);
                final int square = number * number;
                firstHalf.set(i, square);
            }
        });

        Thread secondThread = new Thread(()->{
            for(int i = 0; i < secondHalf.size(); i++){
                final int number = secondHalf.get(i);
                final int square = number * number;
                secondHalf.set(i, square);
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        squares = new ArrayList<>(firstHalf);
        squares.addAll(secondHalf);

        //System.out.println(squares);
    }
}
