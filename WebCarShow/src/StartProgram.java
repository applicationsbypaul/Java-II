import java.util.List;
import java.util.Scanner;

import controller.ListCarHelper;
import model.ListCar;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListCarHelper lih = new ListCarHelper();

		private static void addACar() {
			// TODO Auto-generated method stub
			System.out.print("Enter a make: ");
			String make = in.nextLine();
			System.out.print("Enter a model: ");
			String model = in.nextLine();
			System.out.print("Enter a year: ");
			String year = in.nextLine();
			ListCar toAdd = new ListCar(make,model,year);
			// - To put the item in the database
			lih.insertCar(toAdd);
		}

		private static void deleteACar() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the year to delete: ");
			String year = in.nextLine();
			ListCar toDelete = new ListCar(make,model,year);
			lih.deleteCar(toDelete);

		}

		private static void editACar() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Year");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListCar> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the make: ");
				String carMake = in.nextLine();
				foundItems = lih.searchForCarByMake(carMake);
				
			} else if (searchBy ==2 ) {
				System.out.print("Enter the model: ");
				String carModel = in.nextLine();
				foundItems = lih.searchForCarByModel(carModel);
			}
			else {
				System.out.print("Enter the Year: ");
				String carYear = in.nextLine();
				foundItems = lih.searchForCarByYear(carYear);
			}
			
			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListCar l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnCarDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListCar toEdit = lih.searchForCarById(idToEdit);
				System.out.println("Retrieved " + toEdit.getYear() + toEdit.getMake() + " " + toEdit.getModel());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				}
				else if (update ==3) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				}

				lih.updateCar(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our car show list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a car");
				System.out.println("*  2 -- Edit a car");
				System.out.println("*  3 -- Delete a car");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addACar();
				} else if (selection == 2) {
					editACar();
				} else if (selection == 3) {
					deleteACar();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Farewell   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListCar> allCars = lih.showAllCars();
			for (ListCar singleCar : allCars) {
				System.out.println(singleCar.returnCarDetails());
			}
		}
		public String toString() {
			return null;
		}

	}
