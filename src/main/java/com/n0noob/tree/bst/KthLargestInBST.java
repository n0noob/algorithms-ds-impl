package com.n0noob.tree.bst;

import com.n0noob.structures.TreeNode;

import java.util.Optional;

public class KthLargestInBST {

    class Counter {
        public int count;
    }

    public Optional<Integer> findKthLargestElement(TreeNode root, int k) {
        return findKthLargestElement(root, k, new Counter());
    }

    private Optional<Integer> findKthLargestElement(TreeNode root, int k, Counter counter) {
        if(root == null || counter.count > k)
            return Optional.empty();

        Optional<Integer> res = findKthLargestElement(root.right, k, counter);

        if(res.isPresent())
            return res;
        counter.count++;
        if(counter.count == k)
            return Optional.of(root.data);

        return findKthLargestElement(root.left, k, counter);
    }

}
