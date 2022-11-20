-- liquibase formatted sql
-- changeset tcb:call-billing-001 dbms:mysql
-- preconditions onFail:CONTINUE onError:HALT
-- select COUNT(*) C from user_tables where LOWER(table_name) = 'call_billing'
create table if not exists call_billing
(
    user_name varchar(255) primary key,
    call_count int,
    block_count bigint
);

-- changeset tcb:call-billing-002 dbms:mysql
-- preconditions onFail:CONTINUE onError:HALT
insert into call_billing values ('quyetbv',0,0);