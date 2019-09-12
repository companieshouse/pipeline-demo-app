package uk.gov.companieshouse.demo.pipeline;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pipeline/demo")
public class Controller {

    @GetMapping
    public ResponseEntity<HttpStatus> get(HttpServletRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> post(HttpServletRequest request) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
