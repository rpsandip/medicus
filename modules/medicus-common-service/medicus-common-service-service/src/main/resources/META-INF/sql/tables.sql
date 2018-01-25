create table Medicus_Campus (
	campusId LONG not null primary key,
	schoolId LONG,
	name VARCHAR(75) null,
	address1 VARCHAR(75) null,
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
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
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
	name VARCHAR(75) null,
	address1 VARCHAR(75) null,
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

create table Medicus_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	companyId LONG,
	stundetCampusId VARCHAR(75) null,
	campusId LONG,
	schoolId LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	profileImageId LONG,
	dateOfBirth DATE null,
	gender VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	homePhoneNumber VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	primaryLanguage VARCHAR(75) null,
	secondaryLanguage VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	state_ VARCHAR(75) null,
	pace VARCHAR(75) null,
	ethnicityDesc VARCHAR(75) null,
	gpa DOUBLE,
	resumeFileEntryId LONG,
	profession VARCHAR(75) null,
	practices VARCHAR(75) null,
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
	midPointReviewComment VARCHAR(75) null,
	finalReview DATE null,
	finalReviewComment VARCHAR(75) null,
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