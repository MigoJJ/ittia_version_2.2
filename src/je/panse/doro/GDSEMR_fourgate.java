package je.panse.doro;

import java.io.IOException;

import je.panse.doro.samsara.EMR_CCPIPMH.EMRPMH;

public class GDSEMR_fourgate extends GDSEMR_frame {

	public GDSEMR_fourgate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String text) throws IOException {
		System.out.println("Double-clicked on: text >>> " + text);
		if (text.contains("PMH>")) {
			EMRPMH.main(text);
		} else if (text.contains("O>")) {
			EMRPMH.main(text);
		}
	}

}