package tiy.webapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.ServerSocket;

import static org.junit.Assert.*;

/**
 * Created by fenji on 9/13/2016.
 */
public class WebChatClientTest {
    SampleServer server = new SampleServer();
    Thread serverThread = null;
    @Before
    public void setup() throws Exception{
        serverThread = new Thread(server);
        serverThread.start();
    }

    @After
    public void teardown() throws Exception{
        serverThread.stop();
    }
    @Test
    public void sendMessage() throws Exception {
        WebChatClient client = new WebChatClient();
        String serverResponse = client.sendMessage("testing 123");

        assertEquals("testing 123",serverResponse);

    }
}

