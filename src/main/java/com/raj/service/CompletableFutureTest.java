package com.raj.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	long st = System.currentTimeMillis();
    	testAllOf();
    	System.out.println(System.currentTimeMillis()-st);
    }

    private static void testAllOf() throws InterruptedException, ExecutionException {
    	
    	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("1");
            return "1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("2");
            return "2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("3");
            return "3";
        });

        CompletableFuture.allOf(future1, future2,future3).isDone();
        List<String> resultList = new ArrayList<String>();
    	resultList.add(future1.get());
    	resultList.add(future2.get());
    	resultList.add(future3.get());
        System.out.println(resultList); 
    }
}
