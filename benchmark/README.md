# logw benchmark

Benchmark results for the logging wrapper.

These benchmarks measure the overhead of the logw library.
Therefore the performance of logw with slf4j logger is compared 
to the performance of slf4j logger without logw.

The `LogwBenchmark` measure the overall performance for logging 
with simple log messages. This makes the costs for determining the 
logger name and the additional static calls visible. The advantages 
resulting from less evaluated expressions are not considered. The 
formatting of the messages is not part of the benchmark.

Three variants are compared:
* `logw...()` logging with low and slf4j logger
* `slf4j...()` logging with pure slf4j logger
* `slf4jPlusGuard...()`logging with pure slf4j logger and make use of log guards 
  
All variants once with active logger (`...WithOutput()`) and once with 
deactivate logger (`...WithoutOutput()`).


## benchmark run 1
```
Benchmark                                  Mode  Cnt         Score       Error  Units
LogwBenchmark.logwWithOutput               avgt   20      9678,696 ±   322,244  ns/op
LogwBenchmark.logwWithoutOutput            avgt   20      1821,600 ±    57,244  ns/op
LogwBenchmark.nOpBenchmark                 avgt   20         0,599 ±     0,023  ns/op
LogwBenchmark.sleep10msec                  avgt   20  10169780,702 ± 18066,499  ns/op
LogwBenchmark.slf4jPlusGuardWithOutput     avgt   20      5845,190 ±   468,775  ns/op
LogwBenchmark.slf4jPlusGuardWithoutOutput  avgt   20         0,944 ±     0,022  ns/op
LogwBenchmark.slf4jWithOutput              avgt   20      5184,531 ±   103,603  ns/op
LogwBenchmark.slf4jWithoutOutput           avgt   20         0,895 ±     0,019  ns/op
```
Setup
```
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
```
* Hardware: Lenovo T570 (CPU: Intel® Core™ i7-7500U CPU @ 2.70GHz)
* OS: Fedora 31
* Java: OpenJDK 64-Bit Server VM (build 25.272-b10, mixed mode)
