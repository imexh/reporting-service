package com.application.reportingservice.external.repository.report;

import com.application.reportingservice.common.value.Report;
import com.application.reportingservice.external.repository.IReportRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ReportRepositoryAdapter implements IReportRepository {
    private final MongoTemplate mongoTemplate;

    public ReportRepositoryAdapter(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Report persistReport(final Report report) {
        Objects.requireNonNull(report, "Report repository required non null report, got null.");

        ReportDocument reportDocument = ReportModelMapper.toDocument(report);

        return ReportModelMapper.toReport(mongoTemplate.save(reportDocument));
    }

    @Override
    public Report getReportById(final String identity) {
        final ReportDocument reportDocument = mongoTemplate.findById(identity, ReportDocument.class);

        return reportDocument != null ? ReportModelMapper.toReport(reportDocument) : null;
    }

    @Override
    public List<Report> getAllReports() {
        List<ReportDocument> reportDocuments = mongoTemplate.findAll(ReportDocument.class);
        return ReportModelMapper.toReportList(reportDocuments);
    }

    @Override
    public List<Report> getReportsByPatientId(final String patientId) {
        List<ReportDocument> reportDocuments = mongoTemplate.find(Query.query(Criteria.where("patient_id").is(patientId)), ReportDocument.class);
        return ReportModelMapper.toReportList(reportDocuments);
    }
}
