package algorithm.hash;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author 一方通行
 * @version 1.0
 * @description: 1.首先要解析服务器节点对应到哈希节点上
 * 2.针对 客户端节点ip找到对应的index
 * 3.针对客户端的hash值 找到index节点的服务器
 * @date 2021/5/15 10:42
 */
public class ConsistenceHash {

    public static void main(String[] args) {
        haveNode();
    }

    /**
     * 没有虚拟节点的hash
     */
    private static void notHaveNode() {
        String[] serverIps = new String[]{"121.111.12.01", "125.11.0.01", "111.15.12.11"};
        // 直接使用有序map
        SortedMap<Integer, String> ipMapping = new TreeMap<>();
        for (String ip : serverIps) {
            // todo 这里暂时不考虑hashcode 的分散情况
            int serverHash = Math.abs(ip.hashCode());
            ipMapping.put(serverHash, ip);
        }
        String[] clientIps = new String[]{"100.111.12.01", "10.11.0.01", "10.78.12.12"};
        for (String clientIp : clientIps) {
            int clientHash = Math.abs(clientIp.hashCode());
            //这里需要顺时针往下找最近的一个ip节点
            SortedMap<Integer, String> integerStringSortedMap = ipMapping.tailMap(clientHash);
            if (integerStringSortedMap.isEmpty()) {
                String serverIp = ipMapping.get(ipMapping.firstKey());
                System.out.println("处理服务的ip :" + serverIp);
            } else {
                String serverIp = integerStringSortedMap.get(integerStringSortedMap.firstKey());
                System.out.println("处理服务的ip :" + serverIp);
            }
        }
    }

    private static void haveNode() {
        // 定义虚拟节点
        int count = 3;
        String[] serverIps = new String[]{"121.111.12.21", "125.11.0.31", "111.15.12.101"};
        // 直接使用有序map
        SortedMap<Integer, String> ipMapping = new TreeMap<>();
        for (String ip : serverIps) {
            // todo 这里暂时不考虑hashcode 的分散情况
            int serverHash = Math.abs(ip.hashCode());
            ipMapping.put(serverHash, ip);
            // 这里还需要处理一下虚拟节点
            for (int a = 0; a < count; a++) {
                //需要使用真实ip + index
                int vHash = Math.abs((ip + "#" + a).hashCode());
                ipMapping.put(vHash, "虚拟节点: " + a + "映射请求 :" + ip);
            }
        }
        String[] clientIps = new String[]{"110.111.12.01", "10.11.0.01", "10.78.12.12"};
        for (String clientIp : clientIps) {
            int clientHash = Math.abs(clientIp.hashCode());
            //这里需要顺时针往下找最近的一个ip节点
            SortedMap<Integer, String> integerStringSortedMap = ipMapping.tailMap(clientHash);
            if (integerStringSortedMap.isEmpty()) {
                String serverIp = ipMapping.get(ipMapping.firstKey());
                System.out.println("处理服务的ip :" + serverIp);
            } else {
                String serverIp = integerStringSortedMap.get(integerStringSortedMap.firstKey());
                System.out.println("处理服务的ip :" + serverIp);
            }
        }
    }
}
