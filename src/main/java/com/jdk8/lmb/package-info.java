/**
 * 兰八达表达式
 * 函数式接口:
 * 1.如果一個接口只有一个抽象方法,那麼他就是一個函数式接口
 *        Note that instances of functional interfaces can be created with
 *        lambda expressions, method references, or constructor references.
 *        函数接口的实例，可以使用lambda表达式和方法引用 或者构造方式引用来创建函数式接口的实例
 * 2.如果在接口上声明了FunctionalInterface注解，那么编译器就会按函数式接口的定义来要求接口
 * 3.如果一个接口有且只有一个抽象方,但是我们并没有声明FunctionalInterface注解,jvm也会默认认为他是一个函数
 */
package com.jdk8.lmb;