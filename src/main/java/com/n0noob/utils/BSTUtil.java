package com.n0noob.utils;

import com.n0noob.structures.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BSTUtil {

    public static TreeNode createBST(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid inputs");
        }

        TreeNode root = new TreeNode(arr[0]);

        Arrays.stream(arr)
                .skip(1)
                .forEach(element -> {
                    insertInBST(root, element);
                });

        return root;
    }

    public static void insertInBST(TreeNode root, int item) {
        if(root == null)
            return;

        if(item < root.data) {
            if(root.left == null) {
                root.left = new TreeNode(item);
                return;
            }
            insertInBST(root.left, item);
        }
        else if(item > root.data) {
            if(root.right == null) {
                root.right = new TreeNode(item);
                return;
            }
            insertInBST(root.right, item);
        }
    }

}
