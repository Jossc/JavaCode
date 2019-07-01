/**
 * 内部分享的一些知识点
 *public Launcher()
 *       {
 *         ExtClassLoader localExtClassLoader;
 *         try
 *         {  //（1）首先创建了ExtClassLoader
 *           localExtClassLoader = ExtClassLoader.getExtClassLoader();
 *         }
 *         catch (IOException localIOException1)
 *         {
 *           throw new InternalError("Could not create extension class loader");
 *         }
 *         try
 *         {  //（2）然后以ExtClassloader作为父加载器创建了AppClassLoader
 *           this.loader = AppClassLoader.getAppClassLoader(localExtClassLoader);
 *         }
 *         catch (IOException localIOException2)
 *         {
 *           throw new InternalError("Could not create application class loader");
 *         }  //（3）这个是个特殊的加载器后面会讲到，这里只需要知道默认下线程上下文加载器为appclassloader
 *         Thread.currentThread().setContextClassLoader(this.loader);
 *       }
 */
package com.share;