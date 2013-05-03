<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page language="java" import="java.util.*"%>
<%
String cookieName = "username";
String cookievalue= (String)session.getAttribute("name");
//Cookie cookies [] = request.getCookies ();
int ticket1[][][]=new int[2][3][9];
int ticket1_con[][]=new int[3][9];
Integer rou=(Integer)session.getAttribute("round");
int[] rowcount=new int[3];
int maxdigits[]=new int[9];
/*Cookie myCookie = null;
if (cookies != null)
{
	System.out.print("cookies not eaul to null\n");
for (int i = 0; i < cookies.length; i++) 
{
if (cookies[i].getName().equals(cookieName)&&cookies [i].getValue().equals(cookievalue))
{
myCookie = cookies[i];
System.out.print("match found\t"+myCookie.getValue());
break;
}
}
}*/

String username=(String)session.getAttribute("name");
//if(username==null) username="";
Integer round1gen=(Integer)session.getAttribute("round1gen");
Integer round2gen=(Integer)session.getAttribute("round2gen");
Integer round3gen=(Integer)session.getAttribute("round3gen");

if((round1gen==0&&rou==1)||(round2gen==0&&rou==2)||(round3gen==0&&rou==3))
	{
	
	if(round1gen==0&&rou==1)
		session.setAttribute("round1gen",1);
	if(round2gen==0&&rou==2)
		session.setAttribute("round2gen",1);
	if(round3gen==0&&rou==3)
		session.setAttribute("round3gen",1);
//generate ticket


System.out.print("i am her\n");
	
for(int z=0;z<2;z++)
{
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
int writtencount=0;
int i=0;
while(writtencount<9)
{
	int temp=10*i+(1)+(int) (Math.round(Math.random()*9 ));
	int posi=(int) Math.round(Math.random()*2+1);
	if(rowcount[posi-1]<5)
	{	
	ticket1[z][posi-1][i]=(temp);
	maxdigits[i]+=1;
	ticket1_con[posi-1][i]=1;
	rowcount[posi-1]++;
	writtencount++;
	i++;
	//int loc = '#'+q+ (posi) +'_' + (i+1);
	//$(loc).text(ticket1[posi-1][i]);
	}
	
}


int temp=0;
int aashayen=0;
writtencount=0;
while(writtencount<6)
{
	aashayen=1;
	int floor_temp;
	
		temp=1+(int) (Math.random()*89);
		if(temp%10!=0)
		{
		 floor_temp = (temp/10 );
		}
		else
			floor_temp=temp/10-1;
		
		System.out.println("temp="+temp);
		for(i=0;i<3;i++)
		{
			if(ticket1[z][i][floor_temp]==temp)
			{
				aashayen=0;
			}
		}
		if(aashayen==0)
			continue;
		/*for(int j=0;j<3;j++)
			{
			
			for(int k=0;k<9;k++)
			{
				if(ticket1[z][j][k]==(temp))
					{
						aashayen=0;
						System.out.println("temp="+temp);
						break;
					}
			}
			
			if(aashayen==0)
			break;
			}*/
		
	//if(temp==0)
	//alert(temp);
	
	for(i=0;i<3;i++)
	{
		if(rowcount[i]<5)
		{
			 System.out.println("yea");
			if((ticket1_con[i][floor_temp]==0))
			{
				ticket1[z][i][floor_temp]=(temp);
				//int loc = '#'+q+(posi)+'_' + ((floor_temp+1));
				//alert(posi+' '+(floor_temp+1)+' value '+ticket1[posi][floor_temp]);
					//$(loc).text(ticket1[posi-1][(floor_temp)]);
					maxdigits[floor_temp]++;
					ticket1_con[i][floor_temp]=1;
				rowcount[i]++;
				writtencount++;
				break;
					
			}
		}
	}
}
}
session.setAttribute("ticket",ticket1);
	}
else
{
	System.out.print("maa chud gayi\n'");
	ticket1=(int[][][])session.getAttribute("ticket");
	
}
%>

<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--<html class="no-js" lang="en"> --><!--<![endif]-->

<html>
<head>
	<title>Welcome to online tambola | Play the game</title>
	 <!-- Included CSS Files (Compressed) -->
  <link rel="stylesheet" href="/stylesheets/foundation.min.css">
  <link rel="stylesheet" href="/stylesheets/app.css">
  <link rel="stylesheet" href="/stylesheets/tambola.css">
  <link href='http://fonts.googleapis.com/css?family=Skranji' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Life+Savers' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Bubbler+One' rel='stylesheet' type='text/css'>
  
  <script src="/javascripts/modernizr.foundation.js"></script>
  
  <!-- IE Fix for HTML5 Tags -->
  <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

<br />
<br />
<br />
<!--  header -->
<div class="row color-six">
		<div class="six columns">
			<!--<div class="welcome">-->
			<h4>Hi <b><%= session.getAttribute("name") %></b>,</h4><br />
		</div>
		<div class="two columns offset-by-two">
			<a href="/logout" class="radius nice blue button">Logout</a>
		</div>
		</div >
<!-- main body -->

<div class="row color-six">
	<div class="twelve columns">
	<br />
	<p>Here is your ticket. Whenever the number appears on your screen and that number
	is present in your ticket click on that number so that it will be strike.If you complete a pattern click on the buttons besdie the ticket. If you have striked the right
	numbers. You will get a confirmation.</p>
	<p style="background:red;color:white;"><h3>Warning: Do-not Logout at any point between the game. There would be total of 6 ROUNDS and do not RELOAD</h3></p>
	<h5>Enjoy Playing.</h5>
	<br/>
	<div class="ro"><h3>Round  <b><%= session.getAttribute("round") %></b></h3></div>
	<div id="surprise" style="background:red; color:white;">round over full house has been claimed<br/></div>
	<div id="textNextNum" ><h1>The Next number is : <span id="nextNum" style="background:#fff;"></span></h1></div>
	</div>
</div>
<div class="row color-six">
		<div class="three columns offset-by-nine"><h3>
		Your Score : <span id="points"></span></h3></div>
		</div>
<div class="row  color-six">
	<div class="six columns">

	<table border="1">
		<%
			for(int i=0;i<10;i++)
			{
				out.println("<tr>");
				for(int j=0;j<9;j++)
				{
					
					out.println("<td id=\"sho"+i+j+"\" class=\"shout\">"+(10*j+i+1)+"</td>");
				}out.println("</tr>");
				
			}
		%>
	</table>
	</div>
	<div class="six columns"> 	
	<table border="1">
	<%
		/*for(int i=1;i<4;i++)
			for(int j=1;j<10;j++)
				if(ticket1[i-1][j-1]==0)
					ticket1[i-1][j-1]=;*/
		for(int i=1;i<4;i++){
			out.println("<tr>");
			for(int j=1;j<10;j++){
				 //Create a table here. 3x10 1<table> tag 3 <tr> tag 10 <td> tag
		     out.println("<td id=\"1"+i+"_"+j+"\" class=\"num1\">"+ticket1[0][i-1][j-1]+"</td>");
			}out.println("</tr>"); 
		}
	%>
	</table>
	<table borde="0">
	<tr>
		<td id="TopRow1" class=" small blue nice button">Top row</td>
		<td id="MiddleRow1" class=" small blue nice button">Middle Row</td>
		<td id="BottomRow1" class=" small blue nice button">Bottom Row</td>
		<td id="fullhouse1" class=" small blue nice button">Full House</td>
			</tr>
		</table><table border="1">
	<%
		for(int i=1;i<4;i++){
			out.println("<tr>");
			for(int j=1;j<10;j++){
				 //Create a table here. 3x10 1<table> tag 3 <tr> tag 10 <td> tag
		     out.println("<td id=\"2"+i+"_"+j+"\" class=\"num2\">"+ticket1[1][i-1][j-1]+"</td>");
			}out.println("</tr>"); 
		}
	%>
	</table>
	<div >
	<table>
	<tr>
		<td id="TopRow2" class=" small blue nice button">Top row</td>
		<td id="MiddleRow2" class=" small blue nice button">Middle Row</td>
		<td id="BottomRow2" class=" small blue nice button">Bottom Row</td>
		<td id="fullhouse2" class=" small blue nice button">Full House</td>
			</tr>
		</table>
	</div>
	
	
	</div>
	</div>
	
<div class="row color-six">
<div class="six columns centered">
	<div class="leaderboard">
	<table border="1">
	<tr>
	<th>Claims</th>
	<th>Winner</th>
	</tr>
	<tr>
	<td>top row     </td>       <td id="topr"></td> </tr>
	<tr><td>middle row </td>      <td id="midr"></td> </tr> 
	<tr><td>bottom row  </td>   <td id="botr"></td> </tr>
	<tr><td>full house </td>   <td id="fulh"></td></tr>
	
	
	</table>
	
	</div>
</div>
</div>
<!-- footer -->



<div id = "testValue"></div>
<div id = "testValue2"></div>
<div id = "testValue3"></div>

<script src="/javascripts/jquery.js"></script>
<script type="text/javascript">



<%System.out.println("helloworls");%>
$(document).ready(function(){
	$('#surprise').hide();
});
//alert("done");
//ert(hsd[2][1]);

</script>
<script src="/javascripts/tambola.js"></script>
 
</body>
</html>

