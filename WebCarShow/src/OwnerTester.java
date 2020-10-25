import java.util.ArrayList;
import java.util.List;

import controller.ListCarDetailsHelper;
import controller.OwnerHelper;
import model.ListCar;
import model.ListCarDetails;
import model.Owner;

public class OwnerTester {
	public static void main(String[] args) {
		Owner susan = new Owner("Susan");
		ListCarDetailsHelper ldh = new ListCarDetailsHelper();
		
		ListCar car = new ListCar("dodge", "dart", "2020");
		ListCar truck = new ListCar("Ford", "F150", "2020");
		
		List<ListCar> susanCars = new ArrayList<ListCar>();
		susanCars.add(car);
		susanCars.add(truck);
		
		ListCarDetails susansCarList = new ListCarDetails("Susan's CarsList", susan);
		ldh.insertNewListCarDetails(susansCarList);
		
		List<ListCarDetails> allLists = ldh.getLists();
		
		for (ListCarDetails a : allLists) {
		System.out.println(a.toString());
		}
	}
}

































