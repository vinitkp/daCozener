package com.siolabs.tambola;
/*
 * the numbers can be generated one time for a game 
 * and then it can send the numbers by checking the index.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GenerateTicket extends HttpServlet {
	int ticket1[][]=new int[3][9];
	int ticket1_con[][]=new int[3][9];
	int[] rowcount=new int[3];
	int maxdigits[]=new int[9];
public GenerateTicket(){
	
	

for(int i=0;i<3;i++)
	{
	rowcount[i]=0;
	for(int j=0;j<9;j++)
		ticket1_con[i][j]=0;
	}


for(int j=0;j<9;j++)
	maxdigits[j]=0;

/*ticket1[1][2]=4;
int loc = '#'+ (3) +'_' + (4+1);
$(loc).text(ticket1[1][2]);
*/
for(int i=0;i<9;i++)
{
	int temp=(int) (Math.round(Math.random()*10+10*i)+1);
	int posi=(int) Math.round(Math.random()*2+1);
	if(rowcount[posi-1]<5)
	{	
	ticket1[posi-1][i]=temp;
	maxdigits[i]+=1;
	ticket1_con[posi-1][i]=1;
	rowcount[posi-1]++;
	//int loc = '#'+q+ (posi) +'_' + (i+1);
	//$(loc).text(ticket1[posi-1][i]);
	}
	
}

int i=0;
int temp=0;
int aashayen=0;
for(i=0;i<6;i++)
{
	aashayen=0;
	while(aashayen==0)
	{
		aashayen=1;
		temp=(int) (Math.random()*90+1);
		for(int j=0;j<3;j++)
			{
			for(int k=0;k<9;k++)
			{
				if(ticket1[j][k]==temp)
					{
						aashayen=0;
						break;
					}
			}
			if(aashayen==0)
			break;
			}
			if(aashayen==1)
			{
				if(maxdigits[temp/10]==3)
					aashayen=0;
				//else if(ticket_rowcount[pareseInt(temp/10)]==3)
					//aashayen=0;
			}
			
		
	}
	//if(temp==0)
	//alert(temp);
	boolean wrote=true;
	while(wrote)
	{
		int posi = (int) Math.round (Math.random()  *2+1 ) ;
		int floor_temp = (temp/10 );
		//alert("posi"+(posi-1)+"   = "+rowcount[posi-1]);
		// if(rowcount[posi-1]<5)
		{
			if((ticket1_con[posi-1][floor_temp]==0))
			{
				ticket1[posi-1][floor_temp]=temp;
				//int loc = '#'+q+(posi)+'_' + ((floor_temp+1));
				//alert(posi+' '+(floor_temp+1)+' value '+ticket1[posi][floor_temp]);
					//$(loc).text(ticket1[posi-1][(floor_temp)]);
					maxdigits[floor_temp]++;
					ticket1_con[posi-1][floor_temp]=1;
					rowcount[posi-1]++;
					wrote=false;
			}
		}
	}
}
}

//public static int count = 0;
//public  ArrayList<Integer> numbers = new ArrayList<Integer>();

public void doGet(HttpServletRequest req, HttpServletResponse resp)
throws IOException {
	resp.setContentType("text/plain");
	//String ind = req.getParameter("ind");
	//int idx = Integer.parseInt(ind);
	PrintWriter out = resp.getWriter();
	out.println(ticket1.toString());
	out.close();				
}
}