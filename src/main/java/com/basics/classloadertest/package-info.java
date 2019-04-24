/**
 * 双亲委派模式：
 * 优点：
 *      1. 避免重复加载,有层级关系
 *      2. 安全。
 *      3. sun.misc.Launcher$AppClassLoader->sun.misc.Launcher$ExtClassLoader->null
 *      appClassLoader ----  ExtClassLoader -----  Bootstrap
 * 缺点：
 *      1. 不能逆向委派。(spi打破)
 * Bootstrap  加载类路径: 主要用来加载 Java 核心类，
 *  eg:
 *      rt.jar、resources.jar、charsets.jar
 * ExtClassloader 加载类路径:JAVA_HOME/jre/lib/ext/
 * var0 :D:\java1.8\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext (win10)
 * {@link sun.misc.Launcher.ExtClassLoader}
 *  private static File[] getExtDirs() {
 *             String var0 = System.getProperty("java.ext.dirs");
 *             File[] var1;
 *             if (var0 != null) {
 *                 StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
 *                 int var3 = var2.countTokens();
 *                 var1 = new File[var3];
 *
 *                 for(int var4 = 0; var4 < var3; ++var4) {
 *                     var1[var4] = new File(var2.nextToken());
 *                 }
 *             } else {
 *                 var1 = new File[0];
 *             }
 *             return var1;
 *         }
 *
 * AppClassLoader 加载类路径: java.class.path系统属性,或者指定的特殊包
 * {@link sun.misc.Launcher.AppClassLoader}
 *  public static ClassLoader getAppClassLoader(final ClassLoader var0) throws IOException {
 *             final String var1 = System.getProperty("java.class.path");
 *             final File[] var2 = var1 == null ? new File[0] : Launcher.getClassPath(var1);
 *             return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction<Launcher.AppClassLoader>() {
 *                 public Launcher.AppClassLoader run() {
 *                     URL[] var1x = var1 == null ? new URL[0] : Launcher.pathToURLs(var2);
 *                     return new Launcher.AppClassLoader(var1x, var0);
 *                 }
 *             });
 * {@link java.lang.ClassLoader}
 *  ClassLoader的核心方法：loadClass
 *  protected Class<?> loadClass(String name, boolean resolve)
 *         throws ClassNotFoundException
 *     {S
 *          防止多线程竞争
 *         synchronized (getClassLoadingLock(name)) {
 *              先去内存中寻找，如果寻找到了 就直接加载
 *             Class<?> c = findLoadedClass(name);
 *             if (c == null) {
 *                 long t0 = System.nanoTime();
 *                 try {
 *                      这里如果找不到 并且父加载器不为空的话，
 *                      就托付给父加载器加载
 *                     if (parent != null) {
 *                         c = parent.loadClass(name, false);
 *                     } else {
 *                          如果没有父加载器哦，就直接给BootstrapClass加载
 *                         c = findBootstrapClassOrNull(name);
 *                     }
 *                 } catch (ClassNotFoundException e) {
 *                 }
 *
 *                  如果上边的都没有找到的话，那么就就执行自定义的加载器去找。
 *                 if (c == null) {
 *                     long t1 = System.nanoTime();
 *                     c = findClass(name);
 *                     sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
 *                     sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
 *                     sun.misc.PerfCounter.getFindClasses().increment();
 *                 }
 *             }
 *             if (resolve) {
 *                 是否在加载的时候解析
 *                 resolveClass(c);
 *             }
 *             return c;
 *         }
 *     }
 */
package com.basics.classloadertest;