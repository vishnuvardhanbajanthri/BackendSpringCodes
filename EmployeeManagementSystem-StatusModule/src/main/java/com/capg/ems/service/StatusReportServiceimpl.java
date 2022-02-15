package com.capg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ems.entities.StatusReport;
import com.capg.ems.exceptions.StatusReportNotFoundException;
import com.capg.ems.repositories.StatusReportRepository;

/*
 * Author : Vishnuvardhan
 * Date : 08-01-2022
 * Description : StatusReport layer Implementation
*/
@Service
public class StatusReportServiceimpl implements IStatusReportService {
	@Autowired
	public StatusReportRepository statusDao;

	/************************************************************************************
	 * Method: addStatusReport Description: It is used to add StatusReport into
	 * StatusReport table
	 ************************************************************************************/
	@Override
	public void addStatusReport(StatusReport statusreport) {
		statusDao.save(statusreport);
	}

	/************************************************************************************
	 * Method: getAllStatusReports Description: It is used to get All StatusReport
	 * into StatusReport table
	 ************************************************************************************/
	@Override
	public List<StatusReport> getAllStatusReports() {
		List<StatusReport> sts = (List<StatusReport>) statusDao.findAll();
		return sts;
	}

	/************************************************************************************
	 * Method: counts Description: It is used to count All StatusReport into
	 * StatusReport table
	 ************************************************************************************/
	@Override
	public long counts() {
		return statusDao.count();

	}

	/************************************************************************************
	 * Method: deleteStatusReport Description: It is used to deleteStatusReport by
	 * statusId from StatusReport table
	 ************************************************************************************/
	@Override
	public void deleteStatusReport(int statusId) throws StatusReportNotFoundException {
		statusDao.deleteById(statusId);
	}

	/************************************************************************************
	 * Method: updateStatusReport Description: It is used to updateStatusReport by
	 * statusReport from StatusReport table
	 ************************************************************************************/
	@Override
	public StatusReport updateStatusReport(StatusReport statusReport) throws StatusReportNotFoundException {
		if (!statusDao.existsById(statusReport.getStatusId()))
			throw new StatusReportNotFoundException("Status Not Found");
		statusDao.save(statusReport);
		return statusReport;
	}
}
