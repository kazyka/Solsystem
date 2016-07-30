package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector3DTest {

    Vector3D A = new Vector3D(1, 2, 3);
    Vector3D B = new Vector3D(2, 3, 1);
    Vector3D C = new Vector3D(2, 2, 2);

    @Test
    public void testAdd() throws Exception {

        Vector3D temp = A.add(B);
        org.junit.Assert.assertTrue("Not equal", temp.getX() == 3);
        org.junit.Assert.assertTrue("Not equal", temp.getY() == 5);
        org.junit.Assert.assertTrue("Not equal", temp.getZ() == 4);

    }

    @Test
    public void testMul() throws Exception {

        Vector3D temp = A.mul(2);
        org.junit.Assert.assertTrue("Not equal", temp.getX() == 2);
        org.junit.Assert.assertTrue("Not equal", temp.getY() == 4);
        org.junit.Assert.assertTrue("Not equal", temp.getZ() == 6);
    }

    @Test
    public void testSub() throws Exception {

        Vector3D temp = A.sub(C);
        org.junit.Assert.assertTrue("Not equal", temp.getX() == -1);
        org.junit.Assert.assertTrue("Not equal", temp.getY() == 0);
        org.junit.Assert.assertTrue("Not equal", temp.getZ() == 1);

    }
}