package com.application.reportingservice.external.repository.report;

import com.application.reportingservice.common.value.Report;

import java.util.List;
import java.util.stream.Collectors;

public class ReportModelMapper {
    public ReportModelMapper() {
    }

    static ReportDocument toDocument(Report report) {
        ReportDocument reportDocument = new ReportDocument();

        reportDocument.id = report.getId();
        reportDocument.patientId = report.getPatientId();
        reportDocument.doctorName = report.getDoctorName();
        reportDocument.disease = report.getDisease();

        return reportDocument;
    }

    static Report toReport(ReportDocument reportDocument) {
        return new Report(reportDocument.id, reportDocument.patientId, reportDocument.doctorName, reportDocument.disease);
    }

    static List<Report> toReportList(List<ReportDocument> reportDocuments) {
        return reportDocuments.stream().map(ReportModelMapper::toReport).collect(Collectors.toList());
    }
}
