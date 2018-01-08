<%@ include file="/init.jsp" %>

<liferay-ui:success key="subscription-update-success" message="subscription-update-success"/>
<liferay-ui:success key="subscription-success" message="subscription-success"/>
<liferay-ui:error key="subscription-error" message="subscription-error"/>


 <div class="page-title">
   <div class="title_left">
     <h2>Subscription</h2>
   </div>
 </div>
 <div class="clearfix"></div>
  <div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel" style="height:600px;">
        <div class="x_content">
          <div class="row">
            <div class="col-md-12">
              <!-- price element -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="pricing">
                  <div class="title">
                    <h2>${subsciptionPlan.name }</h2>
                    <h1>$${subsciptionPlan.price }</h1>
                     <span>Yearly</span>
                  </div>
                  <div class="x_content">
                    <div class="">
                      <div class="pricing_features">
                        <ul class="list-unstyled text-left">
                          <div>We have one plan to meet your every internship need.</div>
                          <div>Our plan includes the following advantages:</div>
                          <li><i class="fa fa-check text-success"></i>Real time access to students available to intern</li>
                          <li><i class="fa fa-check text-success"></i>Unlimited searches</li>
                          <li><i class="fa fa-check text-success"></i>Customization of your search by Zip code, Gender, Language, Profession, just to name a few criteria</li>
                          <li><i class="fa fa-check text-success"></i>Selection of Schools and campus nearest to you</li>
                          <li><i class="fa fa-check text-success"></i>Ability to work with the school to interview students before acceptance</li>
                          <li><i class="fa fa-check text-success"></i>Liability insurance of the student</li>
                          <li><i class="fa fa-check text-success"></i>Streamline process to select and obtain interns</li>
                          <li><i class="fa fa-check text-success"></i>Your return on investment is at least 300% in financial and positive impact</li>
                        </ul>
                      </div>
                    </div>
                    <div class="pricing_footer">
                       <c:choose>
                       	<c:when test="${ not empty userSubscription and (userSubscription.subscriptionId eq silverSub.subscriptionId)}">
                       		<a class="btn btn-success btn-block" >Subscribed</a>
                       	</c:when>
                       	<c:otherwise>
                       		<a href="javascript:void(0);" class="btn btn-success btn-block" role="button"
                       data-toggle="modal" data-formName="silverFrm" data-target="#confirmplan">Buy Plan</a>
                       	</c:otherwise>
                       </c:choose>
                       <c:if test="${isSuperAdmin }">
                        <portlet:renderURL var="editSilverSubcriptionURL">
       							 <portlet:param name="mvcRenderCommandName" value="/edit_subscription" />
       							 <portlet:param name="subscriptionId" value="${ subsciptionPlan.subscriptionId}" />
					    </portlet:renderURL>
                      	<a href="${editSilverSubcriptionURL }" class="btn btn-success btn-block" >Edit</a>
                      </c:if> 
                     </div>
                    <div class="silver-plan" style="display: none;">
                      <form action="${paypalURL }" method="post" target="_top" id="silverFrm">
						<input type="hidden" name="cmd" value="_xclick">
						<input type="hidden" name="business" value="${businessEmail }">
						<input type="hidden" name="hosted_button_id" value="${hostedButtonId }">
						<input type="image" src="https://www.sandbox.paypal.com/en_GB/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal – The safer, easier way to pay online!">
						<img alt="" border="0" src="https://www.sandbox.paypal.com/en_GB/i/scr/pixel.gif" width="1" height="1">
						<input type="hidden" name="amount" value="${subsciptionPlan.price }">
						<input type="hidden" name="custom" value="${userId },${subsciptionPlan.subscriptionId }">
						<input type="hidden" name="return" value="${returnURL }">
						<input type="hidden" name="cancel_return" value="${cancelURL }">
					   </form> 
                    </div>
                  </div>
                </div>
              </div>
              <!-- price element -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <div id="confirmplan" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-body">
	       	   <h4 class="modal-title text-center">Are you sure you want to buy this plan?</h4><br>
               <div class="form-group">
                 <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                   <input type="hidden" name="formName"  id="formName"/>
                   <button type="button" class="btn btn-success submit-paypal-form">Yes</button>
                   <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
                 </div>
               </div><br>
	      </div>
	    </div>
	  </div>
  </div>
  
 <script>
 jQuery.noConflict();
    (function($) {
      $(function() {
    	  $('#confirmplan').on('show.bs.modal', function(e) {
              //get data-id attribute of the clicked element
              var formName = $(e.relatedTarget).data('formname');
              console.log("formName->" + formName);
              //populate the textbox
              $(e.currentTarget).find('#formName').val(formName);
          });
    	  
    	  $(".submit-paypal-form").on('click', function(){
    		  var payFormName=$("#formName").val();
    		  console.log("going to submit this form ->" + payFormName);
    		  $("#"+payFormName).submit();    		  
    	  });
      });
    })(jQuery);
 </script>