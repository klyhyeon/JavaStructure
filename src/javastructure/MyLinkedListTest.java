package javastructure;

/**
 *
 */

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyLinkedList<Integer>();
        mylist.addAll(list);
    }

    @Test
    public void testIndexOf() {
        assertThat(mylist.indexOf(1), is(0));
        assertThat(mylist.indexOf(2), is(1));
        assertThat(mylist.indexOf(3), is(2));
        assertThat(mylist.indexOf(4), is(-1));
    }
}

