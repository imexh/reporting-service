package com.application.reportingservice.external.repository.report;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reports")
public class ReportDocument {
    @NotNull
    @Id
    String id;

    @NotNull
    @Field(name = "patient_id")
    String patientId;

    @NotNull
    @Field(name = "doctor_name")
    String doctorName;

    @NotNull
    @Field(name = "disease")
    String disease;
}
