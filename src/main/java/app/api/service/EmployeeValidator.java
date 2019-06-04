package app.api.service;

import app.api.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidator {

    @Autowired
    private EmployeeService employeeService;

    public Boolean validateAllFields(Employee employee) {

        Boolean flag = true;

        if (employee.getStatus() == null) {
            flag = false;
        }

        if (employee.getBirthDate() == null || employee.getBirthDate().isEmpty()) {
            flag = false;
        }

        if (employee.getEmploymentDate() == null || employee.getEmploymentDate().isEmpty()) {
            flag = false;
        }

        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            flag = false;
        }

        if (employee.getId() == null || employee.getId() < 1) {
            flag = false;
        }

        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            flag = false;
        }

        if (employee.getMiddleInitial() == null || employee.getMiddleInitial().isEmpty()) {
            flag = false;
        }

        return flag;

    }

    public void validateAllFieldsAndThrowException(Employee employee) {

        if (employee.getStatus() == null) {
            throw new IllegalArgumentException("status is null");
        }

        if (employee.getBirthDate() == null || employee.getBirthDate().isEmpty()) {
            throw new IllegalArgumentException("birth date is null or empty");
        }

        if (employee.getEmploymentDate() == null || employee.getEmploymentDate().isEmpty()) {
            throw new IllegalArgumentException("employee date is null or empty");
        }

        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("first name is null or empty");
        }

        if (employee.getId() == null || employee.getId() < 1) {
            throw new IllegalArgumentException("id is null or empty");
        }

        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            throw new IllegalArgumentException("last name is null or empty");
        }

        if (employee.getMiddleInitial() == null || employee.getMiddleInitial().isEmpty()) {
            throw new IllegalArgumentException("middle initial is null or empty");
        }

    }

    public Boolean validatMandatoryFields(Employee employee) {

        Boolean flag = true;

        if (employee.getStatus() == null) {
            flag = false;
        }

        if (employee.getBirthDate() == null || employee.getBirthDate().isEmpty()) {
            flag = false;
        }

        if (employee.getEmploymentDate() == null || employee.getEmploymentDate().isEmpty()) {
            flag = false;
        }

        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            flag = false;
        }

        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            flag = false;
        }

        if (employee.getMiddleInitial() == null || employee.getMiddleInitial().isEmpty()) {
            flag = false;
        }

        return flag;

    }

    public void validatMandatoryFieldsAndThrowException(Employee employee) {

        if (employee.getStatus() == null) {
            throw new IllegalArgumentException("status is null");
        }

        if (employee.getBirthDate() == null || employee.getBirthDate().isEmpty()) {
            throw new IllegalArgumentException("birth date is null or empty");
        }

        if (employee.getEmploymentDate() == null || employee.getEmploymentDate().isEmpty()) {
            throw new IllegalArgumentException("employee date is null or empty");
        }

        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("first name is null or empty");
        }

        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            throw new IllegalArgumentException("last name is null or empty");
        }

        if (employee.getMiddleInitial() == null || employee.getMiddleInitial().isEmpty()) {
            throw new IllegalArgumentException("middle initial is null or empty");
        }

    }

    public void validateIdAndThrowException(Employee employee) {

        if (employee.getId() == null || employee.getId() < 1) {
            throw new IllegalArgumentException("id is null or empty");
        }

    }

    public void validateIdAndThrowException(Long employeeId) {

        if (employeeId == null || employeeId < 1) {
            throw new IllegalArgumentException("id is null or empty");
        }

    }

    public void validateIfEmployeeIsActiveAndThrowExecption(Long employeeId) {

        validateIdAndThrowException(employeeId);
        Employee employee = employeeService.getEmployee(employeeId);
        if (!employee.getStatus()) {
            throw new RuntimeException("user is inactive or deleted");
        }

    }

}
