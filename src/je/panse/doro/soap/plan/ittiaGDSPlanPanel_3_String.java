package je.panse.doro.soap.plan;

public class ittiaGDSPlanPanel_3_String {
	public static String[] getCheckboxLabels() {
        return new String[]{
			"...Next Lab F/U with NPO",
			"...Coservative symptomatic treatment",
			"...Ophthalmologist consultation[+]", 
			"...Continie current medications or supplements",
			"...Plan to review of other clinic RC result",
			"...The patient Refused dose-adjustment", 
			"...History of surgeries or hospitalizations",
			"...Family medical history",
    		"...to refer patients to receive additional health care services.",
    		"...Gastroenterology consult in GDS clinic",
    		"...Pulmonolgy consult in GDS clinic",
			"2", "3", "2", "3", "2", "3", "4"};

	}
    public static String[] getboxs(int i) {
        String[] comboboxesLabels = {};

        switch (i) {
            case 1:
                comboboxesLabels = new String[]{"Consutation---------------------", 
                		"to refer patients to receive additional health care services.",
                		"Gastroenterology consult in GDS clinic",
                		"Pulmonolgy consult in GDS clinic",
                };
                break;
            case 2:
                comboboxesLabels = new String[]{"2", "2", "23", "2", "23", "24"};
                break;
            case 3:
                comboboxesLabels = new String[]{"1", "2", "3", "2", "3", "4"};
                break;
            case 4:
                comboboxesLabels = new String[]{"Transfer to University Hospital----------", 
                		"transfer to Severence Univ. Hospital",
                		"transfer to AMC Hospital",
                		"transfer to SMC Univ. Hospital",
                		"transfer to SNUH Seoul Hospital",
                		"transfer to SNUH BUNDang Hospital",
                		"transfer to catholic Univ. Hospital",
                		"consult to Emergency Room"
                };
                break;    
            case 5:
                comboboxesLabels = new String[]{"Consutation---------------------", 
                		"to refer patients to receive additional health care services.",
                		"Gastroenterology consult to Univ Hospital",
                		"Neurology consult to Univ Hospital",
                		"Ohthalmology consult to Univ Hospital",
                		"Nephrology consult to Univ Hospital",
                		"Endocrinology and metabolism consult to Univ Hospital",
                		"Orthopedics consult to Univ Hospital",
                		"Cardiology consult to Univ Hospital",
               			"ENT consult to Univ Hospital",

                		};
                break;

            default:
                System.out.println("ReEnter the Number !!!");
                break;
        }

        return comboboxesLabels;
    }
}

