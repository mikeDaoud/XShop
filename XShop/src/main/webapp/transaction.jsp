<%-- 
    Document   : transaction
    Created on : Mar 7, 2017, 7:25:00 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />
    <style>
        .overlay{
            text-align: center;
            vertical-align: central;
            position: fixed;
            display: block;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: rgba(250, 250, 250, .8);
            z-index: 1;
            transition: 1s;
        }
        .insidediv{
            position: fixed;
            top: 20%;
            left: 35%;
            right: 35%;
            background: white;
            /*background: #ecf0f1;*/
            font-size: 20px;
            padding-top: 40px;
            padding-bottom: 40px;
            border-radius: 5px;
            color: #e74c3c;
            border: solid 1px #4fbfa8;
        }
        #close{
            position: absolute;
            top: 2px;
            right: 10px;
        }

        .successoverlay{
            text-align: center;
            vertical-align: central;
            position: fixed;
            display: block;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: rgba(250, 250, 250, .8);
            z-index: 1;
            transition: 1s;
        }
        .successmsg{
            position: fixed;
            top: 15%;
            left: 35%;
            right: 35%;
            background: white;
            font-size: 20px;
            padding-top: 40px;
            padding-bottom: 40px;
            border-radius: 5px;
            color: #2ecc71;
        }
        #gohome{
            margin-top: 20px;
        }


    </style>
    <body>

        <c:set var="err" value="${requestScope.err}" />
        <c:if test="${!empty err}">
            <div class="overlay"> <div class="insidediv"><div id="close"><a href="#"><i class="fa fa-times" aria-hidden="true"></i></a></div><i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true"></i><br />${err}</div></div>

        </c:if>

        <c:set var="success" value="${requestScope.success}" />
        <%--<c:if test="${!empty success}">--%>
            <div class="successoverlay">
                <div class="successmsg">
                    <i class="fa fa-check-circle-o fa-5x" aria-hidden="true"></i>
                    <br>${success} <br> <a href="index.jsp" class="btn btn-primary" id="gohome">Continue Shopping</a>
                </div>
            </div>
        <%--</c:if>--%>

        <jsp:include page="clientviews/header.jsp" />  

        <div id="all">
            <jsp:include page="clientviews/checkout3.jsp" />
            <jsp:include page="footer" />
        </div>
        <jsp:include page="clientviews/scripts.jsp" />

        <script src="${pageContext.request.contextPath}/resources/client/js/card.js"></script>
        <script src="${pageContext.request.contextPath}/resources/client/js/jquerycard.js"></script>


        <script type="text/javascript">
            var card = new Card({
                // a selector or DOM element for the form where users will
                // be entering their information
                form: 'form', // *required*
                // a selector or DOM element for the container
                // where you want the card to appear
                container: '.card-wrapper', // *required*

                formSelectors: {
                    numberInput: 'input#number', // optional — default input[name="number"]
                    expiryInput: 'input#expiry', // optional — default input[name="expiry"]
                    cvcInput: 'input#cvc', // optional — default input[name="cvc"]
                    nameInput: 'input#name' // optional - defaults input[name="name"]
                },

                width: 300, // optional — default 350px
                formatting: true, // optional - default true

                // Strings for translation - optional
                messages: {
                    validDate: 'valid\ndate', // optional - default 'valid\nthru'
                    monthYear: 'mm/yyyy', // optional - default 'month/year'
                },

                // Default placeholders for rendered fields - optional
                placeholders: {
                    number: '•••• •••• •••• ••••',
                    name: 'Full Name',
                    expiry: '••/••',
                    cvc: '•••'
                },

                // masks: {
                //     cardNumber: '•' // optional - mask card number
                // },

                // if true, will log helpful messages for setting up Card
                debug: true // optional - default false
            });
        </script>
        <script>
            $(".fa-times").click(function () {
                $(".overlay").addClass("hidden");
            });
            
        </script>

    </body>
</html>
