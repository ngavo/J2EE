<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!--   Core JS Files   -->
    <script src="<c:url value='/assets/js/jquery.3.2.1.min.js' />" type="text/javascript' >" ></script>
	<script src="<c:url value='/assets/js/bootstrap.min.js' />" type="text/javascript" ></script>

	<!--  Charts Plugin -->
	<script src="<c:url value='/assets/js/chartist.min.js' />" ></script>

    <!--  Notifications Plugin    -->
    <script src="<c:url value='/assets/js/bootstrap-notify.js' />" ></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="<c:url value='/assets/js/light-bootstrap-dashboard.js?v=1.4.0' />" ></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="<c:url value='/assets/js/demo.js' />" ></script>

	<!-- <script type="text/javascript">
    	$(document).ready(function(){
			console.log("fjgdfghdfugihd");
        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-gift',
            	message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script> -->