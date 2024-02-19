package org.example;

import java.util.ArrayList;
import java.util.List;

public class StreamedSquareResolutor {
    private List<Integer> numbers = new ArrayList<>();
    public StreamedSquareResolutor(int limit){
        for(int i = 1; i <= limit; i++){
            numbers.add(i);
        }
    }
    public void printSquares(){
        numbers.parallelStream().map(n -> n * n).toList();
    }
}
