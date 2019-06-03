create table employee (
    employee_id bigserial not null,
    employee_first_name character varying(256) not null,
    employee_middle_initial character varying(256) not null,
    employee_last_name character varying(256) not null,
    employee_birth_date character varying(19) not null,
    employee_employment_date character varying(19) not null,
    constraint employee_pkey primary key (employee_id)
);

