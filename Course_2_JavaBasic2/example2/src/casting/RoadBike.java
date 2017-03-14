package casting;

public class RoadBike extends Bicycle{

	public String material1 = "aluminium";
	public String material2 = "titanium";
	
	public void printMaterialType()
	{
		System.out.println("All road bicycles are made from " + material1 + "or " + material2);
	}
	
	

}
