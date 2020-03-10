package com.xhx.java;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Test001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1, s2;
        Node node1, node2;
        Map<String, Node> nameMap = new HashMap();
        for (int i = 0; i < n; i++) {
            s1 = sc.next();
            s2 = sc.next();
            node2 = nameMap.get(s2);
            if (node2 == null) {
                node2 = new Node();
                node2.setName(s2);
                nameMap.put(s2, node2);
            }

            node1 = nameMap.get(s1);
            if (node1 == null) {
                node1 = new Node();
                node1.setName(s1);
                nameMap.put(s1, node1);
            }
            if (node1.getNextNodes() == null) {
                node1.setNextNodes(new ArrayList<>());
            }
            List<Node> nextNodes = node1.getNextNodes();
            nextNodes.add(node2);


            if (node2.getLastNodes() == null) {
                node2.setLastNodes(new ArrayList<>());
            }
            List<Node> lastNodes = node2.getLastNodes();
            lastNodes.add(node1);
        }

        //存储所有头节点
        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>(64);
        nameMap.values().stream().forEach(node -> {
            List<Node> lastNodes = node.getLastNodes();
            int num = 0;
            if (lastNodes == null) {
                num = 0;
                queue.offer(node);
            } else {
                num = lastNodes.size();
            }
            node.setNum(num);
        });

        Node max = queue.peek();
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            int num = head.getNum();
            List<Node> nextNodes = head.getNextNodes();
            if (nextNodes != null) {
                nextNodes.forEach(next -> {
                    next.setNum(next.getNum() + num);
                    next.getLastNodes().remove(head);
                    if (next.getLastNodes().size() == 0) {
                        queue.offer(next);
                    }
                });
            } else {
                if (max.getNum() < head.getNum()) {
                    max = head;
                }
            }
        }

        System.out.println(max.getName());
    }

    static class Node {
        private int num = 0;
        private List<Node> nextNodes;
        private List<Node> lastNodes;
        private String name;


        public List<Node> getNextNodes() {
            return nextNodes;
        }

        public void setNextNodes(List<Node> nextNodes) {
            this.nextNodes = nextNodes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public List<Node> getLastNodes() {
            return lastNodes;
        }

        public void setLastNodes(List<Node> lastNodes) {
            this.lastNodes = lastNodes;
        }
    }


    public void test02() {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        String str = sc.next();
        int to = sc.nextInt();
        Long otc = Long.valueOf(str, from);
        String result = Long.toUnsignedString(otc, to);
        System.out.println(result);
    }

    public void test01() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] split = str.split("/");
        List<String> listStr = new ArrayList<String>();
        for (int i = 1; i < split.length; i++) {
            if (".".equals(split[i])) {
                continue;
            }
            if ("..".equals(split[i])) {
                if (listStr.size() == 0) {
                    continue;
                }
                listStr.remove(listStr.size() - 1);
                continue;
            }
            listStr.add(split[i]);
        }
        String simpPath = "/" + listStr.stream().collect(Collectors.joining("/"));
        System.out.println(simpPath);
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public void test2() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
