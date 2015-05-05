# logw
[![Build Status](https://travis-ci.org/sajato/logw.svg)](https://travis-ci.org/sajato/logw)
![GitHub license](https://img.shields.io/github/license/sajato/logw.svg?style=flat)

``logw`` provides a static log method and makes log guards unnecessary, so your code
is easier to read. ``logw`` provides bindings for different logging implementations.
Currently bindings for

* [Standard Java Logging](http://docs.oracle.com/javase/6/docs/api/java/util/logging/package-summary.html)
* [slf4j](http://www.slf4j.org/)

# Usage

``logw`` is available at [jcenter](https://bintray.com/bintray/jcenter) maven repository.

## Maven

## Gradle

Add jcenter repository to you ``build.gradle``
```
repositories {
    jcenter()
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
