package com.medicus.common.service.indexer;

import java.io.File;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchEngineHelper;
import com.liferay.portal.kernel.search.Summary;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.util.MedicusConstant;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

@Component(
		  immediate = true,
		  service = Indexer.class
)
public class StudentIndexer extends BaseIndexer<Student>{

	private static final String CLASS_NAME = Student.class.getName();
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(Student object) throws Exception {
		 deleteDocument(object.getCompanyId(), object.getUuid());
	}

	@Override
	protected Document doGetDocument(Student object) throws Exception {
		Document document = getBaseModelDocument(getClassName(), object);

		document.addKeyword(Field.UID, object.getUuid());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_FIRSTNAME, object.getFirstName());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_LASTNAME, object.getLastName());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_GENDER, object.getGender());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_EMAIL_ADDRESS, object.getEmailAddress());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_SCHOOLID, object.getSchoolId());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_CAMPUSID,object.getCampusId());
		document.addKeyword(MedicusConstant.STUDENT_IDNEX_PROFESSION, object.getProfession());
		document.addText(MedicusConstant.STUDENT_IDNEX_LANGUAGE, object.getPrimaryLanguage());
		document.addText(MedicusConstant.STUDENT_IDNEX_ZIPCODE, object.getZipcode());
		document.addNumber(Field.STATUS,object.getStatus());
		
		File file = MedicusCommonLocalServiceUtil.getStudentResumeContent((Student)object);
		if(Validator.isNotNull(file)){
			document.addFile(Field.CONTENT, file, getFileExtension(file));
		}
		
		document.addKeyword(Field.COMPANY_ID, object.getCompanyId());
		document.addDate(Field.CREATE_DATE, object.getCreateDate());
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		  Summary summary = createSummary(document);
		  return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Student student  = StudentLocalServiceUtil.getStudent(classPK);
		
		doReindex(student);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(Student object) throws Exception {

		Document document = doGetDocument(object);
		
		IndexWriterHelperUtil.updateDocument(SearchEngineHelper.SYSTEM_ENGINE_ID, object.getCompanyId(),
		        document, isCommitImmediately());
	}
	
	private String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}

}
