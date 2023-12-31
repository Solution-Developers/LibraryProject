package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.response.ReportResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.service.business.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @GetMapping("/reports")
    public ResponseMessage<Map<String,Integer>> reportAll(){
        return reportService.reportAll();
    }


    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @GetMapping("/most-popular-books")
    public Page<ReportResponse>getMostPopularBooks(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return reportService.getMostPopularBooks(page,size,sort,type);
    }
      @PreAuthorize("hasAnyAuthority('Employee','Admin')")
      @GetMapping("/unreturned-books")
    Page<ReportResponse>getUnreturnedBooks(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type

    ){
        return reportService.getUnreturnedBooks(page,size,sort,type);
    }
    @PreAuthorize("hasAnyAuthority('Employee','Admin')")
    @GetMapping("/expired-books")
    Page<ReportResponse>getExpiredBooks(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return reportService.getExpiredBooks(page,size,sort,type);

    }

     @PreAuthorize("hasAnyAuthority('Employee','Admin')")
     @GetMapping("/most-borrowers")
    Page<ReportResponse>getMostBorrowers(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return reportService.getMostBorrowers(page,size,sort,type);

    }




}
