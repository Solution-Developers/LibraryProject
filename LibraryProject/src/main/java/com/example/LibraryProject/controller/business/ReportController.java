package com.example.LibraryProject.controller.business;

import com.example.LibraryProject.payload.business.response.ReportResponse;
import com.example.LibraryProject.service.business.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

//    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @GetMapping("/reports")
    public Map<String, Integer> reportAll(){
        return reportService.reportAll();
    }










    //    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    @GetMapping("/most-popular-books")
    public Page<ReportResponse> mostPopularBooks(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "20") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return reportService.getMostPopularBooks(page,size,sort,type);
    }




}
