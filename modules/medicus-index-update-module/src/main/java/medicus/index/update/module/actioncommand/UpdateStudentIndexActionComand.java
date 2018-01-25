package medicus.index.update.module.actioncommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=medicus_index_update_module_portlet_MedicusIndexUpdateModulePortlet",
	        "mvc.command.name=/update_student_index"
	    },
	    service = MVCActionCommand.class
	)
public class UpdateStudentIndexActionComand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(UpdateStudentIndexActionComand.class.getName());

	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("lets reindex student");
		
		List<Student> studentList = StudentLocalServiceUtil.getStudents(-1, -1);
		Indexer<Student> studentIndexer = IndexerRegistryUtil.getIndexer(Student.class);
		for(Student student : studentList){
			try {
				if(student.getStatus()==0){
					studentIndexer.reindex(student);
					_log.info("Student Index updated ->" + student.getStudentId());
				}
			} catch (SearchException e) {
				_log.error("Erro while update index student -> "+ student.getStudentId() + " MSG:: " + e.getMessage());
			}
		}
	}

}
