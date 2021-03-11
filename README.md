# logw

![logwlogo][logo]

[![Release](https://img.shields.io/github/release/sajato/logw.svg?label=maven)](https://github.com/sajato/logw)
![GitHub license](https://img.shields.io/github/license/sajato/logw.svg?style=flat)

A wrapper for your logging framework that makes logging easier 
by providing static log methods and makes log guards unnecessary.
It does not touch the configuration of your logging framework.

``logw`` provides a static log method that encapsules log guards, so your code
is easier to read. ``logw`` provides bindings for different logging implementations.
Currently bindings for following log implementations are available:

* [Standard Java Util Logging](http://docs.oracle.com/javase/6/docs/api/java/util/logging/package-summary.html)
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org/)
* [Apache Log4j 2](http://logging.apache.org/log4j/2.x/)

# Usage

```java
import de.sajato.logw.Logw;

[...]

// Log a simple message to warning, if warning is enabled
Logw.warn("This message is only logged, if warning is enabled");

// Log a simple message with parameters
Logw.info("This message is logged to {}", "INFO");

// If you have a complex parameter or need to compute something, use lambdas.
// The lambda expression is only evaluated iff the message will be logged
Logw.trace("This message is logged to {}", () -> reallyComplexComputation());
```

# Get it

``logw`` is available at [jitpack](https://jitpack.io/#sajato/logw) maven repository.

## Prerequisites

Your project must target ``java 8``. **Older versions are *not* supported!**

## Maven

Add jitpack repository to your ``pom.xml``

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Add ``logw-core`` to your dependencies

```xml
<dependency>
    <groupId>com.github.sajato.logw</groupId>
    <artifactId>logw-core</artifactId>
    <version>VERSION</version>
</dependency>
```

If you're using ``slf4j`` add the appropriate bindings in addition:

```xml
<dependency>
    <groupId>com.github.sajato.logw</groupId>
    <artifactId>logw-slf4j</artifactId>
    <version>VERSION</version>
</dependency>
```

If you're using ``log4j2`` add the appropriate bindings in addition:

```xml
<dependency>
    <groupId>com.github.sajato.logw</groupId>
    <artifactId>logw-log4j2</artifactId>
    <version>VERSION</version>
</dependency>
```

## Gradle

Add jitpack repository to your ``build.gradle``

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

Add ``logw-core`` to your dependencies

```gradle
dependencies {
    compile com.github.sajato.logw:logw-core:VERSION
}
```

If you're using ``slf4j`` add the appropriate bindings in addition:

```gradle
dependencies {
    compile com.github.sajato.logw:logw-slf4j:VERSION
}
```

If you're using ``log4j2`` add the appropriate bindings in addition:

```gradle
dependencies {
    compile com.github.sajato.logw:logw-log4j2:VERSION
}
```

# Versioning

``logw`` will be maintained under the [Semantic Versioning](http://semver.org) guidelines as much as possible.

Releases will be numbered with the follow format:

``<major>.<minor>.<patch>```

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

# Special Thanks

* Special thanks to [Andy](http://andreasherting.de/) who created the great logw logo.

[logo]: https://raw.githubusercontent.com/sajato/logw/develop/logw-logo.png
