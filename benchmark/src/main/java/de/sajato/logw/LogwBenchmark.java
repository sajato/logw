package de.sajato.logw;

import org.openjdk.jmh.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(1)

//// Setup for Average Time Benchmark
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

//// Setup for Sample Time Benchmark
//@BenchmarkMode(Mode.SampleTime)
//@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
//@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)

//// Setup for Throughput Benchmark
//@BenchmarkMode(Mode.Throughput)
//@Warmup(iterations = 10)
//@Measurement(iterations = 20)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)

public class LogwBenchmark {

    static final Logger logger = LoggerFactory.getLogger(LogwBenchmark.class);

    @Benchmark
    public void nOpBenchmark() {

    }

    @Benchmark
    public void logwWithOutput(){

        Logw.info("Test");
    }

    @Benchmark
    public void logwWithoutOutput(){

        Logw.trace("Test");
    }

    @Benchmark
    public void slf4jWithOutput() {

        logger.info("Test");
    }

    @Benchmark
    public void slf4jWithoutOutput() {

        logger.trace("Test");
    }

    @Benchmark
    public void slf4jPlusGuardWithOutput() {

        if(logger.isInfoEnabled())
            logger.info("Test");
    }

    @Benchmark
    public void slf4jPlusGuardWithoutOutput() {

        if(logger.isTraceEnabled())
            logger.trace("Test");
    }

    @Benchmark
    public void sleep10msec() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(10);
    }

}
