/**
 *  spi
 *  为什么打双亲委派模式，
 *   SPI 的第三方实现代码则是作为Java应用所依赖的 jar 包被存放在classpath路径下,
 *  由于SPI接口中的代码经常需要加载具体的第三方实现类并调用其相关方法,
 *  但SPI的核心接口类是由引导类加载器来加载的，而Bootstrap类加载器无法直接加载SPI的实现类。
 *  所以Bootstrap 不能托付给AppClassLoader来加载所以需要打破。
 *  托付给ContextClassLoader来加载
 *
 *
 */
package com.basics.ClassLoaderTest.SpiTest;
