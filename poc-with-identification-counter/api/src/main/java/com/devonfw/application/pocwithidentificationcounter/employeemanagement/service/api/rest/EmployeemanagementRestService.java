package com.devonfw.application.pocwithidentificationcounter.employeemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.Employeemanagement;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeCto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Employeemanagement}.
 */
@Path("/employeemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeemanagementRestService {

  /**
   * Delegates to {@link Employeemanagement#findEmployee}.
   *
   * @param id the ID of the {@link EmployeeEto}
   * @return the {@link EmployeeEto}
   */
  @GET
  @Path("/employee/{id}/")
  public EmployeeEto getEmployee(@PathParam("id") CompositeEmployeeKey id);

  /**
   * Delegates to {@link Employeemanagement#saveEmployee}.
   *
   * @param employee the {@link EmployeeEto} to be saved
   * @return the recently created {@link EmployeeEto}
   */
  @POST
  @Path("/employee/")
  public EmployeeEto saveEmployee(EmployeeEto employee);

  /**
   * Delegates to {@link Employeemanagement#deleteEmployee}.
   *
   * @param id ID of the {@link EmployeeEto} to be deleted
   */
  @DELETE
  @Path("/employee/{id}/")
  public void deleteEmployee(@PathParam("id") CompositeEmployeeKey id);

  /**
   * Delegates to {@link Employeemanagement#findEmployeeEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding employees.
   * @return the {@link Page list} of matching {@link EmployeeEto}s.
   */
  @Path("/employee/search")
  @POST
  public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Employeemanagement#findEmployeeCto}.
   *
   * @param id the ID of the {@link EmployeeCto}
   * @return the {@link EmployeeCto}
   */
  @GET
  @Path("/employee/cto/{id}/")
  public EmployeeCto getEmployeeCto(@PathParam("id") CompositeEmployeeKey id);

  /**
   * Delegates to {@link Employeemanagement#findEmployeeCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding employees.
   * @return the {@link Page list} of matching {@link EmployeeCto}s.
   */
  @Path("/employee/cto/search")
  @POST
  public Page<EmployeeCto> findEmployeeCtos(EmployeeSearchCriteriaTo searchCriteriaTo);

  @Path("/employee/cto")
  @POST
  public EmployeeCto saveEmployeePhone(EmployeeCto employee);
}
