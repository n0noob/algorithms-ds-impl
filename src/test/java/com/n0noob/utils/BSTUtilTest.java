package com.n0noob.utils;

import com.n0noob.structures.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTUtilTest {

    @Test
    void givenValidArray_whenCreateBST_thenSucceed() {
        TreeNode root = BSTUtil.createBST(new int[]{8, 1, 3, 15});

        Assertions.assertEquals(8, root.data);
        Assertions.assertEquals(1, root.left.data);
        Assertions.assertEquals(3, root.left.right.data);
        Assertions.assertEquals(15, root.right.data);
    }

    @Test
    void givenEmptyArray_whenCreateBST_thenFail() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            BSTUtil.createBST(new int[0]);
        });
    }

}