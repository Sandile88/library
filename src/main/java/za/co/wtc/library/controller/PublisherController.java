package za.co.wtc.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.wtc.library.model.Publisher;
import za.co.wtc.library.service.PublisherService;


@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired //had to add it cause of the null pointer exception on line 23
    private PublisherService publisherService;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<Publisher> registerPublisher(@RequestBody Publisher publisher) {
        if (publisher.getIsni() != null && publisher.getIsni().length() == 16) { //validating isni and checking length
            if (!publisherService.existsByIsni(publisher.getIsni())) { //checking if isni already is present
                publisher = publisherService.registerPublisher(publisher);
                return new ResponseEntity<>(publisher, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    @RequestMapping(method = RequestMethod.GET, value = "/isni/{isni}",
        produces = {"application/json"})
    public ResponseEntity<Publisher> findByIsniNumber(@PathVariable("isni") String isni) {
      Publisher publisher = publisherService.findByIsniNumber(isni);
      if (publisher != null) {
        return new ResponseEntity<>(publisher, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      }
    }


    
    
}
