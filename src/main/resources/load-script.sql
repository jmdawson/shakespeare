insert into user (id,common_name,given_name,surname,created_date) values ('234','Jacob M. Dawson','Jacob','Dawson','2014-10-27'),('1123','Tracy McElroy','Tracy','McElroy','2014-10-27');
insert into search (id,initiation_date, va_search_number,created_by,created_date) values ('234','2014-10-27','VA-000-14','1123','2014-10-27');
insert into segment(id, segment_number, search_id, created_by, created_date, last_updated_by, last_updated_date) values(2,1,234,1123,'2014-10-27',234,'2014-10-27');
insert into segment(id, segment_number, search_id, created_by, created_date, last_updated_by, last_updated_date) values(1,1,234,1123,'2014-10-27',234,'2014-10-27');
insert into pod_report(id, segment_id, search_id, added_date, added_by,pod) values('1','1','234','2014-10-31','234','60');