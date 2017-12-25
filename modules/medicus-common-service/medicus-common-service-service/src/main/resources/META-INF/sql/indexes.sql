create index IX_FCBB25BF on Medicus_Campus (name[$COLUMN_LENGTH:100$]);
create index IX_ACFD18E3 on Medicus_Campus (schoolId);

create index IX_B24C90A on Medicus_Interview_Request (campusId);
create index IX_E5F32C37 on Medicus_Interview_Request (partnerId);
create index IX_382EE02A on Medicus_Interview_Request (studentId);

create index IX_E9EAA60D on Medicus_Partner (userId);

create index IX_74A92F54 on Medicus_School (name[$COLUMN_LENGTH:100$]);

create index IX_735B8E3D on Medicus_Student (stundetCampusId[$COLUMN_LENGTH:75$]);
create index IX_825E51FA on Medicus_Student (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_280B4965 on Medicus_Student_Externship (studentId);

create index IX_7B05F4F6 on Medicus_User_Subscription (userId);