package uk.gov.companieshouse.demo.pipeline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import uk.gov.companieshouse.demo.pipeline.Controller;

public class ControllerTest {

    private Controller controller;

    @Mock
    private HttpServletRequest request;

    @Before
    public void setUp() {
         controller = new Controller();
    }

    @Test
    public void testGet() {
        ResponseEntity<HttpStatus> response = controller.get(request);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testPost() {
        ResponseEntity<HttpStatus> response = controller.post(request);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
