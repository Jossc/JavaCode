/**
 * final 以不变应万变
 * final 语意：
 * final 写之前:
 * store_store 指令(cpu指令)
 * 读会添加load_laod指令
 *  load_load: 相当pull 把数据拉过来
 *  load_store: 遇到读操作时，他就会先检测读操作之后的任何写操作
 *  store_load: 遇到写的操作时，他就会先检测读操作之后的任何写操作
 *  store_store: push 推过去
 *  final 不能重排序 因为在return之前添加了一个store_store
 *  1.JMM禁止编译器将写final域的操作重排序到构造函数外
 *  2.编译器会在final域的写入之后，构造函数return前，
 *  插入一个StoreStore屏障，这个指令会
 *  禁止处理器把final域的写重排序到构造函数之外
 *
 * )
 */
package com.basics.juctest.Final;