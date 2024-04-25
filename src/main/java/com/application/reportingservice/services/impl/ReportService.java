package com.application.reportingservice.services.impl;

import com.application.reportingservice.common.value.Report;
import com.application.reportingservice.controllers.dto.ReportViewResponseDTO;
import com.application.reportingservice.external.repository.IReportRepository;
import com.application.reportingservice.services.IReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService implements IReportService {
    private final IReportRepository reportRepository;

    public ReportService(final IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportViewResponseDTO saveReport(final Report report) {
        return new ReportViewResponseDTO(reportRepository.persistReport(report));
    }

    @Override
    public ReportViewResponseDTO getReportById(final String reportId) {
        return new ReportViewResponseDTO(reportRepository.getReportById(reportId));
    }

    @Override
    public List<ReportViewResponseDTO> getReportByPatientId(final String patientId) {
        return reportRepository.getReportsByPatientId(patientId).stream()
                .map(ReportViewResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportViewResponseDTO> getAllReports() {
        return reportRepository.getAllReports().stream()
                .map(ReportViewResponseDTO::new)
                .collect(Collectors.toList());
    }
}
