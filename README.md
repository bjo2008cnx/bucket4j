# Bucket4j - java 令牌桶实现
[![Build Status](https://travis-ci.org/vladimir-bukhtoyarov/bucket4j.svg?branch=master)](https://travis-ci.org/vladimir-bukhtoyarov/bucket4j)
[![Join the chat at https://gitter.im/vladimir-bukhtoyarov/bucket4j](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/vladimir-bukhtoyarov/bucket4j?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Quality Gate](https://sonarqube.com/api/badges/gate?key=com.github.vladimir-bukhtoyarov:bucket4j)](https://sonarqube.com/dashboard/index/com.github.vladimir-bukhtoyarov:bucket4j)

## Bucket4j的优势
*根据众所周知的算法思想进行实施，这些算法是IT行业速率限制的事实标准。
*有效的无锁实现，Bucket4j可以很好的扩展多线程的情况。
*绝对不妥协精度，Bucket4j不使用浮点或双精度运算，所有计算均以整数运算,此功能可保护终端用户免受四舍五入所涉及的计算错误。

*能够以两行代码实现从单JVM模式切换到集群模式。 使用Bucket4j，您可以限制JVM集群中的某些内容。
从[release 1.2](https://github.com/vladimir-bukhtoyarov/bucket4j/releases/tag/1.2.0)开始，“`Bucket4j```支持与[JCache API（JSR 107）](https://www.jcp.org/en/jsr/detail?id=107)。
包括Hazelcast，Ignite，Coherence，Infinispan\或任何其他。
*能够每桶指定多个维度的宽带。 例如，您可以每小时限制1000个事件，但每分钟不能超过100个事件。

## Documentation
推荐阅读顺序：
* [Basic-usage](doc-pages/basic-usage.md) - 基本使用的例子。 
* [Brief overview of token-bucket algorithm](doc-pages/token-bucket-brief-overview.md) - 令牌桶算法的简要概述. 
* [Jcache integration](doc-pages/jcache-usage.md) -使用```Bucket4j```的文档和例子，内置支持```JCache API（JSR 107）```规范的内存实现。
* [Advanced usage](doc-pages/advanced-usage.md) - 高级使用示例.

Documentation for previous versions:
* [1.0](https://github.com/vladimir-bukhtoyarov/bucket4j/tree/release_1-0) ```10 May 2015``` 初始版本
* [1.1](https://github.com/vladimir-bukhtoyarov/bucket4j/tree/1.1) ```2 Mar 2017``` 去除对Oracle Coherence的侵扰性
* [1.2](https://github.com/vladimir-bukhtoyarov/bucket4j/tree/1.2) ```3 Mar 2017```支持 JCache 和 java 8
* [1.3](https://github.com/vladimir-bukhtoyarov/bucket4j/tree/1.3) ```23 Mar 2017``` 支持本地存储桶的不同风格的同步方式

## Get Bucket4j library

#### By direct link
[Download compiled jar, sources, javadocs](https://github.com/vladimir-bukhtoyarov/bucket4j/releases/tag/2.1.0)

#### 您可以从源代码构建Bucket4j
```bash
git clone https://github.com/vladimir-bukhtoyarov/bucket4j.git
cd bucket4j
mvn clean install
```

#### 您可以添加Bucket4j到您的项目作为Maven的依赖
Bucket4j通过[JCenter]（https://bintray.com/bintray/jcenter）和[Maven Central]（http://search.maven.org/）分发，可使用其中任何一个:
```xml
<dependency>
    <groupId>com.github.vladimir-bukhtoyarov</groupId>
    <artifactId>bucket4j-core</artifactId>
    <version>2.1.0</version>
</dependency>
```
To use JCache extension you also need to add following dependency:
```xml
<dependency>
    <groupId>com.github.vladimir-bukhtoyarov</groupId>
    <artifactId>bucket4j-jcache</artifactId>
    <version>2.1.0</version>
</dependency>
```

## Have a question?
可在[gitter chat](https://gitter.im/vladimir-bukhtoyarov/bucket4j)上进行讨论 

## License
Copyright 2015-2017 Vladimir Bukhtoyarov
Licensed under the Apache Software License, Version 2.0: <http://www.apache.org/licenses/LICENSE-2.0>.

