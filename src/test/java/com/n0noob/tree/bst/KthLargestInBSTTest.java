package com.n0noob.tree.bst;

import com.n0noob.structures.TreeNode;
import com.n0noob.utils.BSTUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestInBSTTest {

    KthLargestInBST kthLargestInBST;

    @BeforeEach
    void setUp() {
        kthLargestInBST = new KthLargestInBST();
    }

    @Test
    @DisplayName("Should find kth largest element when BST has elements greater than K")
    void givenBSTWithElementsCountGreaterThenK_whenFindKthLargestInBSTCalled_thenSuccess() {
        TreeNode root = BSTUtil.createBST(new int[]{8, 1, 3, 15, 30, 12});
        int k = 3;

        Optional<Integer> res = kthLargestInBST.findKthLargestElement(root, k);

        Assertions.assertTrue(res.isPresent(), "For given input result should exist");
        Assertions.assertEquals(12, res.get(), "Unexpected result");

    }

    @Test
    @DisplayName("Should find kth largest element when BST has elements lesser than K")
    void givenBSTWithElementsCountLesserThenK_whenFindKthLargestInBSTCalled_thenNoResult() {
        TreeNode root = BSTUtil.createBST(new int[]{8, 1, 3, 15, 30, 12});
        int k = 7;

        Optional<Integer> res = kthLargestInBST.findKthLargestElement(root, k);

        Assertions.assertTrue(res.isEmpty(), "For given input result should not exist");

    }

}