package com.treshermanas.thcweb.backingbeans.invoices.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class SearchOverdueInvoiceFilter {

	private Integer day;
	private LocalDate fromDate;
	private LocalDate untilDate;
	private Integer page = 1;
	private Integer pageSize = 1000;

	public SearchOverdueInvoiceFilter(){

	}


	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(LocalDate untilDate) {
		this.untilDate = untilDate;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
