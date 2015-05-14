# logw

[![Build Status](https://travis-ci.org/sajato/logw.svg)](https://travis-ci.org/sajato/logw)
[![Release](https://img.shields.io/github/release/sajato/logw.svg?label=maven)](https://github.com/sajato/logw)
![GitHub license](https://img.shields.io/github/license/sajato/logw.svg?style=flat)

A simple wrapper for logging. It provides static log methods and makes log guards unnecessary.

``logw`` provides a static log method that encapsules log guards, so your code
is easier to read. ``logw`` provides bindings for different logging implementations.
Currently bindings for following log implementations are available:

* [Standard Java Logging](http://docs.oracle.com/javase/6/docs/api/java/util/logging/package-summary.html)
* [slf4j](http://www.slf4j.org/)

# Usage

```java
// Log a simple message to warning, if warning is enabled
Logw.warn("This message is only logged, if warning is enabled");

// Log a simple message with parameters
Logw.info("This message is logged to {}", "INFO");

// If you have a complex parameter or need to compute something, us lambdas.
// The lambda expression is only evaluated iff the message would be logged
Logw.trace("This message is logged to {}", () -> reallyComplexComputation());
```

# Get it

``logw`` is available at [jitpack](https://jitpack.io/) maven repository.

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

Add ``logw`` to your dependencies

```xml
<dependency>
    <groupId>com.github.sajato.logw</groupId>
    <artifactId>logw</artifactId>
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

## Gradle

Add jitpack repository to you ``build.gradle``

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

Add ``logw`` to your dependencies

```gradle
dependencies {
    compile com.github.sajato.logw:logw:VERSION
}
```

If you're using ``slf4j`` add the appropriate bindings in addition:

```gradle
dependencies {
    compile com.github.sajato.logw:logw-slf4j:VERSION
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
