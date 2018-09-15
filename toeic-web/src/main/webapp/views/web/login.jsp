<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:url var="formUrl" value="/login.html">
    <c:param name="urlType" value="url_Login"/>
</c:url>

<c:url var="Register" value="/registerLogin.html">
    <c:param name="urlType" value="url_loginRegister"/>
</c:url>
<html>
<head>
    <title>Login Page</title>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>
</head>
<body>
<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header blue lighter bigger">
                <i class="ace-icon fa fa-coffee green"></i>
                <fmt:message key="label.test" bundle="${lang}"/>
            </h4>
            <div class="space-6"></div>
            <form action="${formUrl}" method="post">
                <fieldset>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <label class="block clearfix">
							<span class="block input-icon input-icon-right">
									    <input type="text" class="form-control" placeholder="Username" name="pojo.username"/>
							            <i class="ace-icon fa fa-user"></i>
							</span>
                    </label>
                    <label class="block clearfix">
							<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="Password" name="pojo.password"/>
										<i class="ace-icon fa fa-lock"></i>
							</span>
                    </label>
                    <div class="space"></div>
                    <div class="clearfix">
                        <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110"><fmt:message key="label.login" bundle="${lang}"/> </span>
                        </button>
                    </div>
                    <div class="space-4"></div>
                </fieldset>
            </form>
        </div><!-- /.widget-main -->
        <div class="toolbar clearfix">
            <div>
                <a href="#" data-target="#forgot-box" class="forgot-password-link">
                    <i class="ace-icon fa fa-arrow-left"></i>
                    <fmt:message key="label.login.forgotpassword" bundle="${lang}"/>
                </a>
            </div>

            <div>
                <a href="#" data-target="#signup-box" class="user-signup-link">
                    <fmt:message key="label.login.register" bundle="${lang}"/>
                    <i class="ace-icon fa fa-arrow-right"></i>
                </a>
            </div>
        </div>
    </div><!-- /.widget-body -->
</div><!-- /.login-box -->

<div id="signup-box" class="signup-box widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header green lighter bigger">
                <i class="ace-icon fa fa-users blue"></i>
                <fmt:message key="label.login.registration" bundle="${lang}" />
            </h4>

            <div class="space-6"></div>
            <p><fmt:message key="label.login.information" bundle="${lang}"/></p>

            <form action="${Register}" method="post" id="register">
                <fieldset>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" name = "pojo.username" id="username-register"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" name="pojo.password"  id="password-register" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
                    </label>

                    <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Repeat password" name="RepeatPassword" id="repeatPass-register"/>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
                    </label>

                        <p id="error"style="color:red"></p>


                    <div class="space-24"></div>


                    <div class="clearfix">
                        <button type="reset" onclick="reset" class="width-30 pull-left btn btn-sm">
                            <i class="ace-icon fa fa-refresh"></i>
                            <span class="bigger-110"><fmt:message key="label.login.resetLogin" bundle="${lang}"/></span>
                        </button>

                        <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                            <span class="bigger-110"><fmt:message key="label.login.register" bundle="${lang}"/></span>
                            <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>

        <div class="toolbar center">
            <a href="#" data-target="#login-box" class="back-to-login-link">
                <i class="ace-icon fa fa-arrow-left"></i>
                <fmt:message key="label.list.back" bundle="${lang}"/>
            </a>
        </div>
    </div><!-- /.widget-body -->
</div><!-- /.signup-box -->

<script>
    $(document).on('click', '.toolbar a[data-target]', function(e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    $(function(){
        //on keypress
        $('#repeatPass-register').keyup(function(e){
            var pass = $('#password-register').val();
            var confpass = $(this).val();

            if(confpass == "" ){
                $('#error').text("");
            }
            else if( pass != confpass){
                $('#error').text("Mật Khẩu Không Khớp");
            }
        });
    });
    function reset() {
        document.getElementById("register").reset();
    }
</script>
</body>
</html>
