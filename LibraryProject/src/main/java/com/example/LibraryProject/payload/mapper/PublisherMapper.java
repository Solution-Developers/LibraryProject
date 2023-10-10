package com.example.LibraryProject.payload.mapper;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.payload.business.request.PublisherRequest;
import com.example.LibraryProject.payload.business.response.PublisherResponse;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    //request to pojo
    public Publisher mapPublisherRequestToPublisher(PublisherRequest publisherRequest){
        return Publisher.builder()
                .publisherName(publisherRequest.getPublisherName())
                .build();
    }

    //pojo to response
    public PublisherResponse mapPublisherToPublisherResponse(Publisher publisher){
        return PublisherResponse.builder()
                .publisherId(publisher.getPublisherId())
                .publisherName(publisher.getPublisherName())
                .build();
    }

}
