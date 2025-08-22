sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'unmanagedreport/test/integration/FirstJourney',
		'unmanagedreport/test/integration/pages/AllEntitiesList',
		'unmanagedreport/test/integration/pages/AllEntitiesObjectPage'
    ],
    function(JourneyRunner, opaJourney, AllEntitiesList, AllEntitiesObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('unmanagedreport') + '/index.html'
        });

       
        JourneyRunner.run(
            {
                pages: { 
					onTheAllEntitiesList: AllEntitiesList,
					onTheAllEntitiesObjectPage: AllEntitiesObjectPage
                }
            },
            opaJourney.run
        );
    }
);