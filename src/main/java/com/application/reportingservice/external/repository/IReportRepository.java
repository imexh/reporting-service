package com.application.reportingservice.external.repository;

import com.application.reportingservice.common.value.Report;

import java.util.List;

public interface IReportRepository {
    Report persistReport(final Report report);

    Report getReportById(final String identity);

    List<Report> getAllReports();

    List<Report> getReportsByPatientId(final String patientId);
}
