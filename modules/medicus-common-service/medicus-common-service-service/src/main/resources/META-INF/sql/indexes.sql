create index IX_FCBB25BF on Medicus_Campus (name[$COLUMN_LENGTH:100$]);
create index IX_ACFD18E3 on Medicus_Campus (schoolId);

create index IX_4DF2EA56 on Medicus_Employer (userId);

create index IX_74A92F54 on Medicus_School (name[$COLUMN_LENGTH:100$]);

create index IX_735B8E3D on Medicus_Student (stundetCampusId[$COLUMN_LENGTH:75$]);

create index IX_280B4965 on Medicus_Student_Externship (studentId);