/*
 * package com.practice.junit;
 * 
 * import static org.junit.Assert.assertArrayEquals; import static
 * org.junit.Assert.assertEquals; import static org.junit.Assert.assertNotNull;
 * 
 * import java.io.IOException; import java.util.*;
 * 
 * import org.junit.Test;
 * 
 * 
 * public class MyJunitTest {
 * 
 * 
 * @Test public void myTest() { MyEvenOdd med= new MyEvenOdd();
 * assertEquals("10 is a even number", true, med.isEvenNumber(10));
 * //assertTrue(med.isEvenNumber(23)); }
 * 
 * @Test(expected = IOException.class) public void testMyArray() { MyEvenOdd
 * med= new MyEvenOdd(); List list = new ArrayList(); list.add("abc");
 * list.add("efg"); assertNotNull(med.myArrayList(list).isEmpty()); //assume
 * that the below array represents expected result String[] expectedOutput =
 * {"apple", "mango", "grape"}; //assuem that the below array is returned from
 * the method //to be tested. String[] methodOutput = {"apple", "mango",
 * "grape"}; assertArrayEquals(expectedOutput, methodOutput); }
 * 
 * }
 */