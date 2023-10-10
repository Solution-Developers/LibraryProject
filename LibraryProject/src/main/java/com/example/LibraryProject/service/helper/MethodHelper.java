package com.example.LibraryProject.service.helper;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MethodHelper {
    private final PublisherRepository publisherRepository;

    //id kontrolu
    public Publisher isPublisherExist(Long id){
        return publisherRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_PUBLISHER,
                        id)));
    }

    public Publisher isPublisherExistByName(String name){
       Publisher publisher= publisherRepository.findByPublisherName(name);
       if (publisher.getPublisherId()==null){
           throw new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_PUBLISHERNAME));
       }
       return publisher;
    }

}
