package com.example.demo.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(FuzzBuzzBenchmark.MAX_SIZE)
public class FuzzBuzzBenchmark {
    public static final int MAX_SIZE = 9999;
    static List<Integer> inputList = new ArrayList<>();

    static {
        for (int ii = 1; ii < MAX_SIZE; ii++) {
            inputList.add(ii);
        }
    }

    @Benchmark
    public void fuzzbuzz1() {
        inputList.forEach(this::calculateFuzzBuzz);
    }

    @Benchmark
    public void fuzzbuzz2() {
        inputList.forEach(this::calculateFuzzBuzz2);
    }

    public String calculateFuzzBuzz(Integer input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return "FuzzBuzz";
        } else if (input % 3 == 0) {
            return "Fuzz";
        } else if (input % 5 == 0) {
            return "Buzz";
        }
        return input.toString();
    }

    public String calculateFuzzBuzz2(Integer input) {

        String output = "";
        if (input % 3 == 0) {
            output = "Fuzz";
        }
        if (input % 5 == 0) {
            output += "Buzz";
        }
        if (output.equals("")) {
            output = input.toString();
        }
        return output;
    }
}
