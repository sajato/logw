# logw
[![Build Status](https://travis-ci.org/sajato/logw.svg)](https://travis-ci.org/sajato/logw)
![GitHub license](https://img.shields.io/github/license/sajato/logw.svg?style=flat)

``logw`` provides a static log method and makes log guards unnecessary, so your code
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

``logw`` is available at [jcenter](https://bintray.com/bintray/jcenter) maven repository.

## Maven

## Gradle

Add jcenter repository to you ``build.gradle``
```
repositories {
    jcenter()
}
```

Add ``logw`` to your dependencies

```
dependencies {
    compile 'de.sajato:logw:VERSION'
}
```

If you're using ``slf4j`` add the appropriate bindings:

```
dependencies {
    compile 'de.sajato:logw-slf4j:VERSION'
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
