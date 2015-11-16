public class Patient {
    
    //We need the patientCount to be intialised as 1 because the first patient we creat won't be created via a method
    
    private static int patientCount = 1;
    
	private String name;
	private int age; 
	private String illness;
	private Patient nextPatient;

    
	public Patient(String name, int age, String illness) {
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
	}	

	public void addPatient(Patient newPatient) {
		if(this.nextPatient == null) {
			this.nextPatient = newPatient;
            patientCount++;
		} else {
			this.nextPatient.addPatient(newPatient);
		}
	}

	public boolean deletePatient(String name) {
		if(this.nextPatient == null) {
			return false;
		} else if(this.nextPatient.name.equals(name)) {
            System.out.println(name + " has been deleted from the system.");
            patientCount--;
			this.nextPatient = nextPatient.nextPatient;
			return true;
		} else {
			return this.nextPatient.deletePatient(name);
		}
	}

	public void printPatient() {
        System.out.println(this.name + ", " + this.age + ", " + this.illness);
		if(this.nextPatient != null) {
			this.nextPatient.printPatient();
		}

	}
    
    public void printPatientCount(){
        System.out.println("The total number of patients is " + patientCount);
    }
    
    public static void main(String[] args) {
		Patient patient1 = new Patient("Graeme", 12, "Rabies");
		patient1.addPatient(new Patient("Dan", 22, "Flu"));
		patient1.addPatient(new Patient("Phil", 21, "Broken leg"));
		patient1.addPatient(new Patient("Mark", 17, "Tummy bug"));
        patient1.printPatient();
        patient1.deletePatient("Phil");
        patient1.printPatient();
        patient1.printPatientCount();
	}

}