package com.example.LibraryProject.service.business;

import com.example.LibraryProject.payload.business.response.ReportResponse;
import com.example.LibraryProject.payload.business.response.ResponseMessage;
import com.example.LibraryProject.repository.business.ReportRepository;
import com.example.LibraryProject.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final PageableHelper pageableHelper;


    public ResponseMessage<Map<String, Integer>> reportAll() {
    Map<String,Integer> map = new HashMap<>();
    map.put("Books",reportRepository.getBookCount());
    map.put("Authors",reportRepository.getAuthorCount());
    map.put("Publishers",reportRepository.getPublishersCount());
    map.put("Categories",reportRepository.getCategoriesCount());
    map.put("Loans",reportRepository.getLoanCount());
    map.put("UnreturnedBooks",reportRepository.getUnreturnedBookCount());
    map.put("ExpiredBooks",reportRepository.getExpiredBookCount());
    map.put("Members",reportRepository.getMemberCount());
    return ResponseMessage.<Map<String,Integer>>builder()
            .object(map)
            .httpStatus(HttpStatus.OK)
            .build();
    }


    public Page<ReportResponse> getMostPopularBooks(int page, int size, String sort, String type) {
        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
        return reportRepository.findMostPopularBooks(pageable,size);
    }
}
