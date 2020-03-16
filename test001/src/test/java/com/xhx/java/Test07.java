package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test07 {

    /**
     * 第一题
     */
    @Test
    public void test01() {
        System.out.println(method01(4, 2));
    }

    public int method01(int a1, int a2) {
        List<Integer> rowList = new ArrayList<Integer>(a1 + 1);
        rowList.add(1);
        for (int i = 0; i < a1; i++) {
            for (int j = i; j > 0; j--) {
                //前两个数相加
                int temp = rowList.get(j) + rowList.get(j - 1);
                rowList.set(j, temp);
            }
            rowList.add(1);
        }
        return rowList.get(a2);
    }

    /**
     * 第二题
     */
    @Test
    public void test02() {

    }

    //a 黑色1表示，白色0表示， 广度优先遍历
    public int bfs(int[][] nums, int x, int y) {
        if (x < 0 || y < 0 || x >= nums.length || y >= nums[x].length) {
            return 0;
        }
        if (nums[x][y] == 0) {
            return 0;
        }
        //防止重复遍历
        nums[x][y] = 0;
        return 1 + bfs(nums, x + 1, y) + bfs(nums, x - 1, y)
                + bfs(nums, x, y + 1) + bfs(nums, x, y - 1);
    }

    //b 深度优先遍历,用一个集合存储每次遍历到的值
    public List<List<int[]>> method03(int[][] nums) {
        List<List<int[]>> groups = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 0) {
                    continue;
                }
                List<int[]> results = new ArrayList<>();
                dfs(nums, i, j, results);
                groups.add(results);
            }
        }
        return groups;
    }

    private void dfs(int[][] nums, int x, int y, List<int[]> results) {
        if (x < 0 || y < 0 || x >= nums.length || y >= nums[x].length) {
            return;
        }
        if (nums[x][y] == 0) {
            return;
        }
        nums[x][y] = 0;
        results.add(new int[]{x, y});
        int[][] dires = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dire : dires) {
            dfs(nums, x + dire[0], y + dire[1], results);
        }
    }


}

/**
 * 第三题
 * map控制访问O(1)时间复杂度
 * 链表控制删除增加O(1)时间复杂度
 */
class Lru {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public Lru(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }


    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(node);

            } else {
                setHead(node);
            }
        }
    }

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
        map.remove(n.key);
    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
        map.put(n.key, n);
    }

}

//双向链表
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

