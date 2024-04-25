package com.application.reportingservice.services;

import com.application.reportingservice.common.value.Report;
import com.application.reportingservice.controllers.dto.ReportViewResponseDTO;

import java.util.List;

public interface IReportService {
    ReportViewResponseDTO saveReport(final Report report);

    ReportViewResponseDTO getReportById(final String reportId);

    List<ReportViewResponseDTO> getReportByPatientId(final String patientId);

    List<ReportViewResponseDTO> getAllReports();
}
