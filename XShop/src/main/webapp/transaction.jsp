<%-- 
    Document   : transaction
    Created on : Mar 7, 2017, 7:25:00 PM
    Author     : markoiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="clientviews/head.jsp" />

    <body>
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

    </body>
</html>
