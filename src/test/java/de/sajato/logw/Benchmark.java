package de.sajato.logw;

import org.junit.Test;

import java.util.logging.*;
import java.util.logging.Level;

public class Benchmark {

    @Test
    public void run500Warnings(){

        long start = System.nanoTime();
        for(int i = 0; i < 500; i++){
            Logw.warn("qwer");
        }
        long end = System.nanoTime();
        long timeLogw = (end - start);


        start = System.nanoTime();
        for(int i = 0; i < 500; i++){
            Logger.getLogger(Benchmark.class.getName()).log(Level.WARNING, "qwer");
        }
        end = System.nanoTime();
        long timeJavaLog = (end - start);


        System.out.println();
        System.out.println("Time to run LogW:     " + timeLogw + "ns");
        System.out.println("Time to run java log: " + timeJavaLog + "ns");
        System.out.println("--------------------------------------------");
        long div = (timeLogw - timeJavaLog);
        System.out.println("                 div: " + div + "ns");
        System.out.println("");
        double minus = (double)timeJavaLog / div;
        System.out.println(" LogW is " + minus + " % slower than native java logging.");

    }

}
