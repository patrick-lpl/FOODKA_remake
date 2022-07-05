package com.swu.foodka.utils;

public class idGenerator {
    private idGenerator(){
    }

    public static long UsIDGenerator(int oriId,long time){
       String value1 = time+""+oriId;
        return Long.parseLong(value1);
    }



    public static void main(String[] args) throws Exception{

        System.out.println(UsIDGenerator(11,11));

    }
}
