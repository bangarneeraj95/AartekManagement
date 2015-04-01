package Service;

import dto.DtoClass;

public class ServiceClasss {
	public int  validity(DtoClass dt)
	{
		if(dt.getUserCountry()!=null && dt.getUserCountry()!="" && dt.getUserEmail()!=null &&dt.getUserEmail()!=""&&dt.getUserPassword()!=null)
					return 1;
		else { return 0;}
	}

	public int Loginvalidity(DtoClass dt) {
		if(dt.getUserName()!=null&&dt.getUserName()!="" &&dt.getUserPassword()!=null&&dt.getUserPassword()!="")
		return 1;
		else return 0;
	}

}
