package com.application.reportingservice.controllers.dto;

import com.application.reportingservice.common.value.Report;

public record CreateReportRequestDTO(String patientId, String doctorName, String disease) {
    public Report toReport() {
        return new Report(null, patientId(), doctorName(), disease());
    }
}
