package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.exception.ResourceNotFoundException;
import com.example.LibraryProject.payload.business.request.PublisherRequest;
import com.example.LibraryProject.payload.business.response.PublisherResponse;
import com.example.LibraryProject.payload.mapper.PublisherMapper;
import com.example.LibraryProject.payload.message.ErrorMessages;
import com.example.LibraryProject.repository.business.PublisherRepository;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PageableHelper pageableHelper;
    private final PublisherMapper publisherMapper;



    // It will return publishers
    public Page<PublisherResponse> getPublishersByPage(int page, int size, String sort, String type) {
        Pageable pageable=pageableHelper.getPageableWithProperties(page, size, sort, type);
        return publisherRepository.findAll(pageable)
                .map(publisherMapper::mapPublisherToPublisherResponse);
    }


//---------------------------------------------------------


    //It will return a publisher by id
    public PublisherResponse getPublisherById(Long id) {
        Publisher publisher= isPublisherExist(id);
        PublisherResponse publisherResponse= publisherMapper.mapPublisherToPublisherResponse(publisher);
        return publisherResponse;
    }


    //id kontrolu
    private Publisher isPublisherExist(Long id){
        return publisherRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_PUBLISHER,
                        id)));
    }


//---------------------------------------------------------



    private Publisher isPublisherExistByName(String name){
       Publisher publisher= publisherRepository.findByPublisherName(name);
       if (publisher.getPublisherId()==null){
           throw new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_PUBLISHERNAME));
       }
       return publisher;
    }


    //It will create a publisher
    public Publisher createPublisher(PublisherRequest request) {
        isPublisherExistByName(request.getPublisherName());
        Publisher publisher=publisherMapper.mapPublisherRequestToPublisher(request);
        Publisher savedPublisher=publisherRepository.save(publisher);
        return savedPublisher;
    }

}
