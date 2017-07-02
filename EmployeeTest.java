
abstract class Employee{
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	
	abstract void calculate_balance_leaves();
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	abstract void calculate_salary();
}



class PermenantEmp extends Employee{
	int paid_leave, sick_leave, casual_leave;
	double basic, hra,pfa;
	
	
	public PermenantEmp(int empId, String empName, double basic) {  
	// created a constructor to set leave values to employees
		this.empId=empId;
		this.empName=empName;
		this.basic = basic;
		paid_leave=12;
		sick_leave=10;
		casual_leave=8;
		total_leaves=12+10+8;

	}

	@Override
	void calculate_balance_leaves() {
		System.out.println("Total avalable leaves are: "+(paid_leave+sick_leave+casual_leave));
		
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		if (type_of_leave =='p'){
			if(paid_leave - no_of_leaves >= 0){
				total_leaves = total_leaves - no_of_leaves;
				paid_leave = paid_leave - no_of_leaves;
				System.out.println("Leave Approved!!");
				return true;
			}
			else { System.out.println("No leave Balance, Cannot Approve! ");
				return false;
			}
		}
		else if(type_of_leave=='s'){
			if(sick_leave-no_of_leaves>=0){
				total_leaves = total_leaves - no_of_leaves;
				sick_leave = sick_leave - no_of_leaves;
				System.out.println("Leave Approved!!");
				return true;
			}
			else{ System.out.println("No leave Balance, Cannot Approve! ");
			return false;
		}
		}
		else if(type_of_leave=='c'){
			if(casual_leave-no_of_leaves>=0){
				casual_leave = casual_leave - no_of_leaves;
				total_leaves = total_leaves - no_of_leaves;
				System.out.println("Leave Approved!!");
				return true;
			}
				
			else{ System.out.println("No leave Balance, Cannot Approve! ");
			return false;
		}
		}
		System.out.println("No leave Balance, Cannot Approve!  ");
		return false;
	}

	@Override
	void calculate_salary() {
		pfa = .12 * basic;
		hra = .5 * basic;
		total_salary = basic + (.5 * basic)-(.12 * basic);
		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_salary);
		
	}


	void print_leave_details(){
		System.out.println("PermenantEmp [paid_leave=" + paid_leave + ", sick_leave=" + sick_leave + ", casual_leave="
				+ casual_leave + "]");
	}
	
}



class TemporaryEmp extends Employee{
	public TemporaryEmp(int empId, String empName, double total_salary) {


		this.empId=empId;
		this.empName=empName;
		this.total_salary=total_salary;
		this.total_leaves=20; // for temporary employees fixed leaves are there.
	}

	@Override
	void calculate_balance_leaves() {
		System.out.println("Total available leaves are:"+total_leaves);
		
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		if (no_of_leaves<=total_leaves){
			total_leaves-=no_of_leaves;
			System.out.println("Leave Approved!!");
			return true;
		}
		else{
		System.out.println("No Leave Balance,Cannot Approve! ");
		return false;
		}
	}

	@Override
	void calculate_salary() {
		double total_sal = total_salary + (.5 *total_salary)-(.12*total_salary);
		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_sal);
		
	}
	
}



public class EmployeeTest {
	public static void main(String[] args) {
		PermenantEmp p=new PermenantEmp(6, "saurav", 60000);
		p.calculate_salary();
		p.avail_leave(5, 'p');
		p.print_leave_details();
		p.calculate_balance_leaves();
		
		PermenantEmp p2=new PermenantEmp(10, "Abhi", 80000);
		p2.calculate_salary();
		p2.avail_leave(11, 's');
		p2.print_leave_details();
		p2.calculate_balance_leaves();
		
		TemporaryEmp t = new TemporaryEmp(8, "Pramod", 40000);
		t.calculate_salary();
		t.avail_leave(8, 'p');
		t.calculate_balance_leaves();

		TemporaryEmp t2 = new TemporaryEmp(11, "Prithvi", 750000);
		t2.calculate_salary();
		t2.avail_leave(21, 's');
		t2.calculate_balance_leaves();
		
		
	}

}

