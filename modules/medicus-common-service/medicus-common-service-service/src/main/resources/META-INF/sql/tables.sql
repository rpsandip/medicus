create table Medicus_Campus (
	campusId LONG not null primary key,
	schoolId LONG,
	name VARCHAR(100) null,
	address1 VARCHAR(75) null,
	city VARCHAR(15) null,
	state_ VARCHAR(15) null,
	country VARCHAR(15) null,
	zipcode VARCHAR(6) null,
	contactNumber VARCHAR(15) null,
	websiteLink VARCHAR(100) null,
	contactPersonName VARCHAR(50) null,
	contactPersonPhoneNumber VARCHAR(15) null,
	contactPersonEmail VARCHAR(30) null,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Employer (
	employerId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	address1 VARCHAR(100) null,
	city VARCHAR(15) null,
	zipcode VARCHAR(15) null,
	state_ VARCHAR(15) null,
	country VARCHAR(15) null,
	contactPersonName VARCHAR(50) null,
	contactPersonEmail VARCHAR(30) null,
	contactPersonPhoneNumber VARCHAR(15) null,
	websiteLink VARCHAR(100) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Interview_Request (
	partnerId LONG not null,
	studentId LONG not null,
	schoolId LONG,
	campusId LONG,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	primary key (partnerId, studentId)
);

create table Medicus_Partner (
	partnerId LONG not null primary key,
	userId LONG,
	partnerOrgId LONG,
	address1 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	contactPersonPhoneNumber VARCHAR(75) null,
	websiteLink VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_School (
	schoolId LONG not null primary key,
	name VARCHAR(100) null,
	address1 VARCHAR(100) null,
	city VARCHAR(15) null,
	state_ VARCHAR(15) null,
	country VARCHAR(15) null,
	zipcode VARCHAR(6) null,
	contactNumber VARCHAR(15) null,
	websiteLink VARCHAR(100) null,
	contactPersonName VARCHAR(50) null,
	contactPersonPhoneNumber VARCHAR(15) null,
	contactPersonEmail VARCHAR(30) null,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	companyId LONG,
	stundetCampusId VARCHAR(75) null,
	campusId LONG,
	schoolId LONG,
	firstName VARCHAR(30) null,
	middleName VARCHAR(20) null,
	lastName VARCHAR(30) null,
	profileImageId LONG,
	dateOfBirth DATE null,
	gender VARCHAR(10) null,
	contactNumber VARCHAR(15) null,
	homePhoneNumber VARCHAR(15) null,
	emailAddress VARCHAR(30) null,
	primaryLanguage VARCHAR(500) null,
	secondaryLanguage VARCHAR(500) null,
	address VARCHAR(200) null,
	city VARCHAR(30) null,
	zipcode VARCHAR(10) null,
	state_ VARCHAR(15) null,
	pace VARCHAR(15) null,
	ethnicityDesc VARCHAR(75) null,
	gpa DOUBLE,
	resumeFileEntryId LONG,
	profession VARCHAR(100) null,
	practices VARCHAR(100) null,
	hired BOOLEAN,
	graduationDate DATE null,
	activelySeekingEmployment BOOLEAN,
	haveExternship BOOLEAN,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Student_Externship (
	studentExternshipId LONG not null primary key,
	studentId LONG,
	partnerId LONG,
	employerId LONG,
	startDate DATE null,
	endDate DATE null,
	noOfHoursPerWeek INTEGER,
	status INTEGER,
	midPointReview DATE null,
	midPointReviewComment VARCHAR(200) null,
	finalReview DATE null,
	finalReviewComment VARCHAR(200) null,
	shiftDesc VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_Subscription (
	subscriptionId LONG not null primary key,
	name VARCHAR(75) null,
	price DOUBLE,
	noOfStudents INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table Medicus_User_Subscription (
	userId LONG not null primary key,
	subscriptionId LONG,
	txnId VARCHAR(75) null,
	subscriptionDate DATE null
);