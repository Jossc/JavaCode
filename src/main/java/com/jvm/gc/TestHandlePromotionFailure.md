## 分代担保学习

~~~~ java 
private static final int DEF_MB = 1024 * 1024;

    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * DEF_MB];
        allocation2 = new byte[2 * DEF_MB];
        allocation3 = new byte[2 * DEF_MB];
        allocation4 = new byte[4 * DEF_MB];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }
~~~~
gc回收日志如下

~~~~ java
/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/java -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=56007:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/lib/tools.jar:/Users/crazy/Desktop/code/JavaCode/target/classes:/Users/crazy/.m2/repository/org/springframework/spring-aop/4.3.8.RELEASE/spring-aop-4.3.8.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/spring-beans/4.3.8.RELEASE/spring-beans-4.3.8.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/spring-core/4.3.8.RELEASE/spring-core-4.3.8.RELEASE.jar:/Users/crazy/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot-starter-aop/1.5.11.RELEASE/spring-boot-starter-aop-1.5.11.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot-starter/1.5.11.RELEASE/spring-boot-starter-1.5.11.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot-starter-logging/1.5.11.RELEASE/spring-boot-starter-logging-1.5.11.RELEASE.jar:/Users/crazy/.m2/repository/ch/qos/logback/logback-classic/1.1.11/logback-classic-1.1.11.jar:/Users/crazy/.m2/repository/ch/qos/logback/logback-core/1.1.11/logback-core-1.1.11.jar:/Users/crazy/.m2/repository/org/slf4j/slf4j-api/1.7.22/slf4j-api-1.7.22.jar:/Users/crazy/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.25/jcl-over-slf4j-1.7.25.jar:/Users/crazy/.m2/repository/org/slf4j/jul-to-slf4j/1.7.25/jul-to-slf4j-1.7.25.jar:/Users/crazy/.m2/repository/org/slf4j/log4j-over-slf4j/1.7.25/log4j-over-slf4j-1.7.25.jar:/Users/crazy/.m2/repository/org/yaml/snakeyaml/1.17/snakeyaml-1.17.jar:/Users/crazy/.m2/repository/org/aspectj/aspectjweaver/1.8.13/aspectjweaver-1.8.13.jar:/Users/crazy/.m2/repository/cglib/cglib/2.1_3/cglib-2.1_3.jar:/Users/crazy/.m2/repository/asm/asm/1.5.3/asm-1.5.3.jar:/Users/crazy/.m2/repository/cglib/cglib-nodep/2.2/cglib-nodep-2.2.jar:/Users/crazy/.m2/repository/redis/clients/jedis/2.9.0/jedis-2.9.0.jar:/Users/crazy/.m2/repository/org/apache/commons/commons-pool2/2.4.2/commons-pool2-2.4.2.jar:/Users/crazy/.m2/repository/junit/junit/4.13/junit-4.13.jar:/Users/crazy/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/Users/crazy/.m2/repository/mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar:/Users/crazy/.m2/repository/org/apache/commons/commons-lang3/3.8/commons-lang3-3.8.jar:/Users/crazy/.m2/repository/commons-codec/commons-codec/1.11/commons-codec-1.11.jar:/Users/crazy/.m2/repository/org/apache/commons/commons-math3/3.6.1/commons-math3-3.6.1.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot-devtools/1.5.17.RELEASE/spring-boot-devtools-1.5.17.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot/1.5.17.RELEASE/spring-boot-1.5.17.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/spring-context/4.3.20.RELEASE/spring-context-4.3.20.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/spring-expression/4.3.20.RELEASE/spring-expression-4.3.20.RELEASE.jar:/Users/crazy/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.5.17.RELEASE/spring-boot-autoconfigure-1.5.17.RELEASE.jar:/Users/crazy/.m2/repository/org/projectlombok/lombok/1.16.14/lombok-1.16.14.jar:/Users/crazy/.m2/repository/io/netty/netty-all/4.1.39.Final/netty-all-4.1.39.Final.jar:/Users/crazy/.m2/repository/net/jcip/jcip-annotations/1.0/jcip-annotations-1.0.jar:/Users/crazy/Downloads/mysql-binlog-connector-java-0.21.0.jar com.jvm.gc.TestHandlePromotionFailure
[GC (Allocation Failure) [DefNew: 6465K->569K(9216K), 0.0037041 secs] 6465K->4665K(19456K), 0.0037317 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
Heap
 def new generation   total 9216K, used 7035K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  78% used [0x00000007bec00000, 0x00000007bf250710, 0x00000007bf400000)
  from space 1024K,  55% used [0x00000007bf500000, 0x00000007bf58e538, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00020, 0x00000007bfa00200, 0x00000007c0000000)
 Metaspace       used 3041K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 329K, capacity 388K, committed 512K, reserved 1048576K

~~~~