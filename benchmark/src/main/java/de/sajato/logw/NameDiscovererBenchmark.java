package de.sajato.logw;

import org.openjdk.jmh.annotations.*;

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

public class NameDiscovererBenchmark {

    @Benchmark
    public void nOpBenchmark() {

    }

    @Benchmark
    public StackTraceElement stackTraceMethod() {

        return NameDiscoverer.getStackTraceElement(5);
    }

    @Benchmark
    public StackTraceElement stackTraceMethodWithError() throws InterruptedException {

        if(NameDiscoverer.stackTraceMethod == null) {
            Logw.error("Stack Tract Method not avalible!");
            TimeUnit.SECONDS.sleep(1);
        }

        return NameDiscoverer.getStackTraceElement(5);
    }

    @Benchmark
    public StackTraceElement throwableGetStackTrace() {

        return new Throwable().getStackTrace()[5];
    }

    @Benchmark
    public void sleep10msec() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(10);
    }

}
