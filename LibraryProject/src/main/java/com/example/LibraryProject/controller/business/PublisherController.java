package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.entity.business.Publisher;
import com.example.LibraryProject.payload.business.request.PublisherRequest;
import com.example.LibraryProject.payload.business.response.PublisherResponse;
import com.example.LibraryProject.service.business.PublisherService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    // It will return publishers by page
    @GetMapping //http://localhost:8080/publishers?page=1&size=10&sort=name&type=asc
    public Page<PublisherResponse> getPublishersByPage (@RequestParam(value = "page") int page,
                                                        @RequestParam(value = "size") int size,
                                                        @RequestParam(value = "sort") String sort,
                                                        @RequestParam(value = "type") String type){
        return publisherService.getPublishersByPage(page,size,sort,type);

    }

    //---------------------------------------------------------

    //It will return a publisher by id
    @GetMapping("/{id}")
    public PublisherResponse getPublisherById(@PathVariable Long id){
        return publisherService.getPublisherById(id);
    }

    //---------------------------------------------------------

    //It will create a publisher
    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody @Valid PublisherRequest request){
      Publisher publisher=  publisherService.createPublisher(request);
        return ResponseEntity.ok(publisher);
    }



}
