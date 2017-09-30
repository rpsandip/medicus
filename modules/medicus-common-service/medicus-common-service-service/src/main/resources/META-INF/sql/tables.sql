create table Medicus_Campus (
	campusId LONG not null primary key,
	schoolId LONG,
	name VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	websiteLink VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
	contactPersonPhoneNumber VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Employer (
	employerId LONG not null primary key,
	userId LONG,
	employerOrgId LONG,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	contactPersonPhoneNumber VARCHAR(75) null,
	websiteLink VARCHAR(75) null
);

create table Medicus_School (
	schoolId LONG not null primary key,
	name VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	websiteLink VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
	contactPersonPhoneNumber VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);