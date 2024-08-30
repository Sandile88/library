package za.co.wtc.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.wtc.library.model.Customer;
import za.co.wtc.library.model.Publisher;
import za.co.wtc.library.repository.PublisherRepository;


@Service
public class PublisherServiceImpl implements PublisherService {

    
  @Autowired
  private PublisherRepository publisherRepository;

    private static final Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);

    @Override
    public Publisher registerPublisher(Publisher publisher) {
        logger.info("Registering publisher with ISNI {}", publisher.getIsni());
        return publisherRepository.save(publisher);
    }

    @Override
    public boolean existsByIsni(String isni) {
      return publisherRepository.existsByIsni(isni);
    }

    @Override
    public Publisher findByIsniNumber(String isni) {
    logger.info("search for publisher with isni {}", isni);
    try {
      Publisher publisher = publisherRepository.findByIsniNumber(isni);
      if (publisher != null) {
        logger.info("Found publisher with isni-number {} details {}", isni, publisher);
      }
      return publisher;
    } catch (Exception exception) {
      String message = "Error while searching for publisher with isni-number " + isni
          + exception.getMessage();
      logger.error(message, exception);
      throw new RuntimeException(message, exception);
    }
    }
    
}
