sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'unmanagedanalyticaltablereport/test/integration/FirstJourney',
		'unmanagedanalyticaltablereport/test/integration/pages/AllEntitiesList',
		'unmanagedanalyticaltablereport/test/integration/pages/AllEntitiesObjectPage'
    ],
    function(JourneyRunner, opaJourney, AllEntitiesList, AllEntitiesObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('unmanagedanalyticaltablereport') + '/index.html'
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