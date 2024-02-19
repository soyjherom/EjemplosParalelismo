package org.example;

import java.util.ArrayList;
import java.util.List;

public class SequentialSquares {
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> squares;
    public SequentialSquares(int limit){
        for(int i = 1; i <= limit; i++){
            numbers.add(i);
        }
        squares = new ArrayList<>(numbers.size());
        numbers.stream().forEach(n ->{
            squares.add(0);
        });
    }

    public void printSquares(){
        for (int i = 0; i < numbers.size(); i++) {
            int result = numbers.get(i) * numbers.get(i);
            squares.set(i, result);
        }
        //System.out.println(squares);
    }
}
