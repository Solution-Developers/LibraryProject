package com.example.LibraryProject.service.business;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.payload.business.request.PublisherRequest;
import com.example.LibraryProject.payload.business.response.PublisherResponse;
import com.example.LibraryProject.payload.mapper.PublisherMapper;
import com.example.LibraryProject.repository.business.PublisherRepository;
import com.example.LibraryProject.service.helper.MethodHelper;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PageableHelper pageableHelper;
    private final PublisherMapper publisherMapper;
    private final MethodHelper methodHelper;


    // It will return publishers
    public Page<PublisherResponse> getPublishersByPage(int page, int size, String sort, String type) {
        Pageable pageable=pageableHelper.getPageableWithProperties(page, size, sort, type);
        return publisherRepository.findAll(pageable)
                .map(publisherMapper::mapPublisherToPublisherResponse);
    }

    //It will return a publisher by id
    public PublisherResponse getPublisherById(Long id) {
        Publisher publisher= methodHelper.isPublisherExist(id);
        PublisherResponse publisherResponse= publisherMapper.mapPublisherToPublisherResponse(publisher);
        return publisherResponse;
    }

    //It will create a publisher
    public Publisher createPublisher(PublisherRequest request) {
        return null;
    }
}
