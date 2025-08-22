sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'unmanagedanalyticaltablereport/test/integration/FirstJourney',
		'unmanagedanalyticaltablereport/test/integration/pages/OrderUnmanagedList',
		'unmanagedanalyticaltablereport/test/integration/pages/OrderUnmanagedObjectPage'
    ],
    function(JourneyRunner, opaJourney, OrderUnmanagedList, OrderUnmanagedObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('unmanagedanalyticaltablereport') + '/index.html'
        });

       
        JourneyRunner.run(
            {
                pages: { 
					onTheOrderUnmanagedList: OrderUnmanagedList,
					onTheOrderUnmanagedObjectPage: OrderUnmanagedObjectPage
                }
            },
            opaJourney.run
        );
    }
);