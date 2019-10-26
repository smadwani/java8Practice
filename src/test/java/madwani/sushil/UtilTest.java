package madwani.sushil;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void testLoadFile() throws IOException {
        assertEquals("My Name is Sushil I Stay in New Jersey City",Util.loadFile("sample.txt"));
    }
}