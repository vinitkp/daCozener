package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

@Entity
public class House {
	@Id @Index int ide;
	
	//public String name;
	public boolean toprow=false;
	public String topwin;
	public String midwin;
	public String botwin;
	public String fulwin;
	public boolean bottomrow=false;
	public boolean middlerow=false;
	public boolean fullhouse=false;
	
	
	// no arg constructor so that it can be used by objectify 
	public House(int ide){
		this.ide=ide;
		
	}
	
	//public House(String email, int points){
		//this.email = email;
		//this.points=points;
		
		
	//}
}