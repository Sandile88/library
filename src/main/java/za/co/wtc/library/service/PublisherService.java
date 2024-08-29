package za.co.wtc.library.service;

import za.co.wtc.library.model.Publisher;

public interface PublisherService {
    
    Publisher registerPublisher(Publisher publisher);

    boolean existsByIsni(String isni);
    
}
