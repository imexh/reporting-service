package com.application.reportingservice.controllers;

import com.application.reportingservice.controllers.dto.CreateReportRequestDTO;
import com.application.reportingservice.controllers.dto.ReportViewResponseDTO;
import com.application.reportingservice.services.IReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReportHandler {
    private final IReportService reportService;

    public ReportHandler(IReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportViewResponseDTO>> getAllReports() {
        return new ResponseEntity<>(this.reportService.getAllReports(), HttpStatus.OK);
    }

    @GetMapping("/reports/report-id/{reportId}")
    public ResponseEntity<ReportViewResponseDTO> getReportById(
            @PathVariable String reportId) {
        return new ResponseEntity<>(this.reportService.getReportById(reportId), HttpStatus.OK);
    }

    @GetMapping("/reports/patient-id/{patientId}")
    public ResponseEntity<List<ReportViewResponseDTO>> getReportsByPatientId(
            @PathVariable String patientId) {
        return new ResponseEntity<>(this.reportService.getReportByPatientId(patientId), HttpStatus.OK);
    }

    @PostMapping("/reports")
    public ResponseEntity<ReportViewResponseDTO> donate(
            @RequestBody CreateReportRequestDTO requestDTO) {
        return new ResponseEntity<>(this.reportService.saveReport(requestDTO.toReport()), HttpStatus.CREATED);
    }
}
