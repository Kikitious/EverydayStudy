package com.example;

import java.util.Scanner;

/**
 * Created by du on 18/1/3.
 */

public class NodeUtils {

    public static Node create() {
        Node head = null;
        Node s = null;
        Node t = null;
        Scanner scanner = new Scanner(System.in);
        int d;
        int i = 1;
        System.out.println("建立一个单链表");
        while (true) {
            System.out.println("请输入第" + i + "个结点的值：[为0时结束]");
            d = scanner.nextInt();
            if (d == 0) break;
            if (i == 1) {
                head = new Node(d);
                head.next = null;
                t = head;
            } else {
                s = new Node(d);
                s.next = null;
                t.next = s;
                t = s;
            }
            i++;
        }
        return head;
    }

    public static Node invert(Node head) {
        Node p = null;
        Node q = null;
        Node r = null;
        if (head == null) {
            System.out.println("这是一个空链表");
            return null;
        } else {
            p = head;
            q = p.next;
            while (q != null) {
                r = q.next;
                q.next = p;
                p = q;
                q = r;
            }

            head.next = null;
            head = p;
            return head;
        }
    }

    public static void print(Node head) {
        Node p = head;
        System.out.println("输出一个单链表");
        if (p == null) {
            System.out.println("这是一个空链表");
        }
        while (p != null) {
            System.out.print(p.data + "--->");
            p = p.next;
        }
        System.out.println();
    }


}
