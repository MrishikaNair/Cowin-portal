import java.util.*;
import java.util.Arrays;
public class AP_Assignment1

{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("CoWin portal initialized....");
		
		int choice=1;
		int unique_hos_ID=100001;
		int [] Unique_hos_ID=new int[100];
		String [] Unique_ID=new String[100];
		int a=0, b=0, c=0, d=0, e=0, f=0, g=0;
		String temp="";
		String [] hos_name = new String[100];
		String [] hos_pin = new String[100];
		String [] citizen_ID=new String[100];
		String [] status = new String[100];
		int [] day = new int[100];
		int []slots=new int[100];
		int [] vac = new int[2];
		int [] qty = new int[100];
		String [] vac_done=new String[100];
		int [] dose_done=new int[100];
		String vac_name="";
		String [] vac_hos=new String[100];
		while(choice<8)
		{
			System.out.println("---------------------------------");
			System.out.println("1. Add Vaccine");
			System.out.println("2. Register Hospital");
			System.out.println("3. Register Citizen");
			System.out.println("4. Add Slot for Vaccination");
			System.out.println("5. Book Slot for Vaccination");
			System.out.println("6. List all slots for a hospital");
			System.out.println("7. Check Vaccination Status");
			System.out.println("8. Exit");
			System.out.println("---------------------------------");
			System.out.println("Enter choice");
			choice=sc.nextInt();
			if(choice==1)
			{
				Add_vaccine obj1=new Add_vaccine();
				vac_name=obj1.details1();
				if(vac_name=="Covax")
				{
					vac[0]+=1;
				}
				else
				{
					vac[1]+=1;
				}
			}
			else if(choice==2)
			{
				Reg_Hospital obj2a=new Reg_Hospital();
				hos_name[a]=obj2a.details2a();
				
				Reg_Hospital obj2b=new Reg_Hospital();
				hos_pin[a]=obj2b.details2b();
				System.out.println("Hospital Name: "+ hos_name[a]+ ", PinCode: "+hos_pin[a]+", Unique ID: "+unique_hos_ID);
				Unique_hos_ID[a]=unique_hos_ID;
				unique_hos_ID+=1;
				a++;
			}
			else if(choice==3)
			{
				Reg_citizen obj3=new Reg_citizen();
				String str=obj3.details3();
				if(str.equals("Only above 18 are allowed"))
				{
					System.out.println(str);
				}
				else
				{
					citizen_ID[c]=str;
					c++;
				}
			}
			else if(choice==4)
			{
				Add_vaccine_slot obj4=new Add_vaccine_slot();
				Unique_hos_ID[a]=obj4.details4a();
				slots[a]=obj4.details4b();
				int a_in=a;
				for(int q=0;q<slots[a_in];q++)
				{
					day[a]=obj4.details4c();
					qty[a]=obj4.details4d();
					vac_hos[a]=obj4.details4e();
				
					System.out.println("Slot added by hospital "+ Unique_hos_ID[a_in]+ " for day: "+day[a]+", Available quantity: "+qty[a]+" of vaccine "+ vac_hos[a]);
					a++;
				}
				for(int r=a_in+1;r<a;r++)
				{
					slots[r]=slots[a_in];
				}

			}
			else if(choice==5)
			{
				String value="";
				Book_vaccine_slot obj5=new Book_vaccine_slot();
				Unique_ID[d]=obj5.details5a();
				value=obj5.details5b();
				if(value.equals("Covax") || value.equals("Covi"))
				{
					for(int j=0; j<vac_hos.length;j++)
					{
						if(vac_hos[j]!="")
						{
							if(vac_hos[j].equals(value))
							{
								System.out.println(Unique_hos_ID[j] + " "+ hos_name[j]);
								break;
							}
						}
					}
				}
					
				else if(!value.equals(" "))
				{
					
					for(int k=0;k<hos_pin.length;k++)
					{
						if(hos_pin[k]!="")
						{
							if(hos_pin[k].equals(value))
							{
								System.out.println(Unique_hos_ID[k] + " "+ hos_name[k]);
								break;
							}
						}
					}
				}
				System.out.println("Enter hospital ID: ");
				int ID = sc.nextInt();
				int flag=0, slot=0;
				for(int k=0;k<Unique_hos_ID.length;k++)
				{
					if(Unique_hos_ID[k]==ID)
					{
						for(int p=0;p<slots[k];p++)
						{
							System.out.println(p+"-> Day: "+day[p+k]+" Qty: "+qty[p+k]+" Vaccine: "+vac_hos[p+k]);
						}
						System.out.println("Choose slot");
						slot=sc.nextInt();
						System.out.println(Unique_ID[d]+ " vaccinated with "+ value);
						flag=1;
						break;
					}
					if(status[d].equals("PARTIALLY VACCINATED"))
					{
						status[d]="VACCINATED";
						vac_done[d]=vac_hos[slot+k];
						dose_done[d]= 2;
							
							
					}
					else
					{
						status[d]="PARTIALLY VACCINATED";
						vac_done[d]= vac_hos[slot+k];
						dose_done[d]=1;
									
					}
				}
				if(flag==0)
				{
					System.out.println("No slots available");
				}
			}
				
				
			
			else if(choice==6)
			{
				List_slots obj6=new List_slots();
				int hos_ID=obj6.details6();
				for(int s=0;s<Unique_hos_ID.length;s++)
				{
					if(hos_ID==Unique_hos_ID[s])
					{
						for(int t=0;t<slots[s];t++)
						{
							System.out.println("Day: "+day[t+s]+" Vaccine: "+vac_hos[t+s]+" Available Qty: "+qty[t+s]);
						}
						
						break;
					}
				}
			}
			else if(choice==7)
			{
				Check_status obj7=new Check_status();
				String p_ID=obj7.details7();
				for(int u=0;u<Unique_ID.length;u++)
				{
					if(Unique_ID[u].equals(p_ID))
					{
						
					}
				}
			}
			
		}
	
				
	}
				
}


class Add_vaccine
{
	Add_vaccine()
	{
		
	}
	String details1()
	{
		Scanner sc=new Scanner (System.in);
		String name="";
		int n_dose =0;
		int gap=0;
		System.out.println("Vaccine name: ");
		name=sc.next();

		System.out.println("Number of doses: ");
		n_dose=sc.nextInt();
		if(n_dose==2)
		{
			System.out.println("Gap between doses: ");
			gap=sc.nextInt();
		}
		System.out.println("Vaccine Name: "+ name+ ", Number of Doses: "+n_dose+", Gap Between Doses: "+gap);
		return name;
	}
	
}

class Reg_Hospital
{
	Reg_Hospital()
	{
		
	}
	String details2a()
	{
		int hos_ID=100000;
		Scanner sc=new Scanner (System.in);
		String hos_name="";
		
		System.out.println("Hospital name: ");
		hos_name=sc.next();
		return hos_name;
	}
	String details2b()
	{
		Scanner sc=new Scanner (System.in);
		String pin ="";
		System.out.println("PinCode");
		pin=sc.next();

		return pin;
		
	}
	
	
}

class Reg_citizen
{
	Reg_citizen()
	{
	}
	String details3()
	{
		Scanner sc=new Scanner(System.in);
		String name="";
		System.out.println("Citizen name: ");
		name=sc.next();
		System.out.println("Age: ");
		int age=sc.nextInt();
		System.out.println("Unique ID: ");
		String unique_ID=sc.next();
		System.out.println("Citizen Name: "+ name+ ", Age: "+age+", Unique ID: "+unique_ID);
		if(age<18)
		{
			return "Only above 18 are allowed";
		}
		else
		{
			return unique_ID;
		}
		
	}
}
		

class Add_vaccine_slot
{
	Add_vaccine_slot()
	{
	}
	int details4a()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter hospital ID: ");
		int hos_ID=sc.nextInt();
		return(hos_ID);
		
	}
	int details4b()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of slots to be added: ");
		int n_slots=sc.nextInt();
		return n_slots;
	}
	int details4c()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter day number: ");
		int day=sc.nextInt();
		return day;
	}
	
	int details4d()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter quantity: ");
		int qty=sc.nextInt();
		return qty;
	}
	String details4e()
	{
		String vaccine="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Select vaccine:");
		System.out.println("0. Covax");
		System.out.println("1. Covi");
		int vac=sc.nextInt();
		if(vac==0)
		{
			vaccine="Covax";
		}
		else
		{
			vaccine="Covi";
		}
		return vaccine;
	}

}

class Book_vaccine_slot
{
	Book_vaccine_slot()
	{
		
	}
	String details5a()
	{
		Scanner sc=new Scanner(System.in);
		String unique_ID="";
		System.out.println("Enter patient unique ID: ");
		unique_ID=sc.next();
		return unique_ID;
		
	}
	String details5b()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Search by area ");
		System.out.println("2. Search by vaccine ");
		System.out.println("3. Exit ");
		System.out.println("Enter option");
		int opt=sc.nextInt();
		if(opt==2)
		{
			String vac_name="";
			System.out.println("Enter vaccine name: ");
			vac_name=sc.next();
			return(vac_name);
			
		}
		
		else if(opt==1)
		{
			String pin="";
			System.out.println("Enter pincode: ");
			pin=sc.next();
			return pin;
			
		}
		return " ";
		
	}
	
	
}

class List_slots
{
	List_slots()
	{
	}
	int details6()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Hospital ID: ");
		int hos_ID=sc.nextInt();
		return hos_ID;	
	}
	
}
class Check_status
{
	Check_status()
	{
		
	}
	String details7()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter patients Unique ID: ");
		String p_unique=sc.next();
		return p_unique;
		
	}
}










