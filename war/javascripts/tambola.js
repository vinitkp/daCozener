$(document).ready(function(){
	
	var loadUrl =  '/getnum?ind=1'; //url to get the numbers.
	var count1 = 0;
	var count2=0;
	var iter =1;

	strikeNum = new Array();
	strikeNum1 = new Array();
	var num;
	var numPos = new Array();
	var ticketNum = new Array();// the numbers of the ticket
	
	var totalArray = new Array();
	var totalArray1 = new Array();
	
	
	
	
	
	//make ajax request to know the numbers.
	$.get(
			loadUrl,
			function(responseText){
				num = responseText;
				num =  num.split(',',91);
				var temp = num[0];
				num[0] = temp.substr(1);
				temp = num[num.length-1];
				num[num.length-1] = temp.substr(0,temp.length-2);//getting all the values parsed in num
			}
	);
	loadurl2='/core?ind=7';
	setInterval(function(){
		$.ajax(
				
				{
					type:"GET",
					url: loadurl2,
				success: function(responseText){
					var reci=responseText;
					//alert("apnafunc " +reci);
					if(reci==1)
					{
						var loc='#surprise';
						$(loc).show();
						setInterval(function(){window.location.href = "/gamestart";},3000);
						
					}	
					
				},
				dataType:"text"}
		);
		if(iter>90)
		{
		clearInterval(interval);
		}
	},5000);
	//leaderboard
	
	//toprowdisplay
	
	setInterval(function(){
		$.ajax(
				
				{
					type:"GET",
					url: '/core?ind=11',
				success: function(responseText){
					var reci=responseText;
					//alert("apnafunc " +reci);
					var loc='#points';
					$(loc).text(reci);	
					
				},
				dataType:"text"}
		);
		
	},7000);
	setInterval(function(){
		$.ajax(
				
				{
					type:"GET",
					url: '/core?ind=8',
				success: function(responseText){
					var reci=responseText;
					//alert("apnafunc " +reci);
					var loc='#topr';
					$(loc).text(reci);	
					
				},
				dataType:"text"}
		);
		if(iter>90)
		{
		clearInterval(interval);
		}
	},1000);
	//middlerowdisplay
	setInterval(function(){
		if(iter>90)
		{
		clearInterval(interval);
		}
		$.ajax(
				
				{
					type:"GET",
					url: '/core?ind=9',
				success: function(responseText){
					var reci=responseText;
					//alert("apnafunc " +reci);
					var loc='#midr';
					$(loc).text(reci);	
				},
				dataType:"text"}
		);
		
	},1000);
	
	setInterval(function(){
		if(iter>90)
		{
		clearInterval(interval);
		}
		$.ajax(
				
				{
					type:"GET",
					url: '/core?ind=10',
				success: function(responseText){
					var reci=responseText;
					//alert("apnafunc " +reci);
					var loc='#botr';
					$(loc).text(reci);	
				},
				dataType:"text"}
		);
	},1000);

	var idx = 0;
	
	var interval = setInterval(function(){
		
			nextNum = num[idx];
			$('#nextNum').html(nextNum);
			var colum;
			var ro;
			if(nextNum%10==0)
				{colum=nextNum/10-1;
				 ro=9;}
			else
			{
			 colum=parseInt(nextNum/10);
			 ro=parseInt(nextNum)-10*colum-1;
			}
			var loc = '#sho' + ro + colum;
			$(loc).css('background','#00ffdd');
			idx = idx +1;
			iter++;
			if(iter>90)
				{
				clearInterval(interval);
				var loadurl1='/core?ind=6';
				$.ajax(
						
						{
							type:"GET",
							url: loadurl1,
							success:function(responseText){
								var reci=responseText;
								
								if(reci==1)
									{
									setInterval(function(){window.location.href = "/gamestart";},3000);
									}
								else if(reci==2)
									{
									setInterval(function(){window.location.href = "/logout";},2000);
									}
							},
						
						dataType:"text"}
				);
				}
		
	}, 1000);
	//alert(hsd[1][2]);
	
	//create the numbers striked through and what numbers are striked through
	$('.num1').click(function(){
		totalArray = num.slice(0,idx);
		//$('#testValue').text(totalArray);
		toNum();
		var ch1 = $(this).text();
		//alert(ch1);
		ch1 = parseInt(ch1);
		//alert(ch1+10);
		//alert(hsd[1][2]);
		
	
			if(ch1){
				//alert(totalArray.indexOf(ch1));
				if(totalArray.indexOf(ch1) >= 0){
					if(strikeNum.indexOf(ch1) < 0){
						$(this).css('text-decoration', 'line-through');
						$(this).css('background', '#ffaabb');
						count1 = count1 + 1;
						strikeNum[count1-1] = ch1;
						//$('#winner').text(strikeNum);
					}
				}
			}

		else{
			//code when it is blank cell		
		}
	});
	
	
	
	//functions to check the patterns.
	/*There are 5 patterns namely.
	 * 1. Top row.
	 * 2. Botton Row.
	 * 3. Middle Row.
	 * 4. Corners.
	 * 5. Full House.
	 * */
	function checkTopRow(){
		//TO check the top row check if each of the element in the figure is striked out. 
		//get all the numbers of the top row
		//
		//$('#winner').text(totalArray);
		var count =0;
		var flag = 1;
		for(var i = 1;i<10;i++){
			loc = '#11_'+i;
			//alert($(loc).text());
			var val =parseInt( $(loc).text());
			
			if(val !=0){
				//val2 = parseInt(val);
				if((strikeNum.indexOf(val)===-1 )|| (totalArray.indexOf(val)===-1)){
					flag = 0;
				}
			}	
		}//end of for
		return flag;
	}//end function
	

	/*-----------------------------------------------------------------*/
	function checkMiddleRow(){
		//TO check the top row check if each of the element in the figure is striked out. 
		//get all the numbers of the top row
		//
		var count =0;
		var flag = 1;
		for(var i = 1;i<10;i++){
			loc = '#12_'+i;
			var val = parseInt($(loc).text());
			if(val !=0){
				//val2 = parseInt(val);
				if(strikeNum.indexOf(val)===-1|| (totalArray.indexOf(val)===-1)){
					flag = 0;
				}
			}	
		}//end of for
		return flag;
	}//end function
	 
	/*-----------------------------------------------------------------*/
	
	/*-----------------------------------------------------------------*/
	function checkBottomRow(){
		//TO check the top row check if each of the element in the figure is striked out. 
		//get all the numbers of the top row
		//
		var count =0;
		var flag = 1;
		for(var i = 1;i<10;i++){
			loc = '#13_'+i;
			var val = parseInt($(loc).text());
			if(val !=0){
				//val2 = parseInt(val);
				if(strikeNum.indexOf(val)===-1|| (totalArray.indexOf(val)===-1)){
					flag = 0;
				}
			}	
		}//end of for
		return flag;
	}//end function
	 
	/*-----------------------------------------------------------------*/
	
	//code to convert totalArray to num
	function toNum(){
		for(var i in totalArray){
			totalArray[i] = +totalArray[i];
		}
	}
	
	
	
	//code to check which numbers are present in the array
	$('#TopRow1').click(function(){
		//$('#testValue').text(strikeNum);
		totalArray = num.slice(0,idx);
		toNum();
		//$('#testValue').text(totalArray);
		//$('#testValue2').text(strikeNum);
		
		if(checkTopRow()===1)
			{
			var tosend=1;
			var loadurl1='/core?ind=1';

				$.ajax(
						
						{
							type:"GET",
							url: loadurl1,
						success: function(responseText){
							var reci=responseText;
							//alert(reci);
							if(reci==1)
								alert('Congratulations you have a top row');
							else if(reci==2)
								alert('some one else has won the top row ');
							else
								alert(' you dont have a top row');
						},
						dataType:"text"}
				);
			//alert('you don\'t have a top row' );
			}else
				alert('you dont have atop row');
	});
	
	$('#MiddleRow1').click(function(){
		totalArray = num.slice(0,idx);
		toNum();
		//$('#testValue').text(totalArray);
		//$('#testValue2').text(strikeNum);
		
		if(checkMiddleRow()===1)
		{
		var tosend=1;
		var loadurl1='/core?ind=2';

			$.ajax(
					
					{
						type:"GET",
						url: loadurl1,
					success: function(responseText){
						var reci=responseText;
						//alert(reci);
						if(reci==1)
							alert('Congratulations you have a middle row');
						else if(reci==2)
							alert('some one else has won the middle row ');
						else
							alert(' dont have a middle row');
					},
					dataType:"text"}
			);
		//alert('you don\'t have a top row' );
		}else
			{
			alert('you don\'t have a middle row' );
			}
});

	$('#BottomRow1').click(function(){
		totalArray = num.slice(0,idx);
		toNum();
		//$('#testValue').text(totalArray);
		//$('#testValue2').text(strikeNum);
		
		if(checkBottomRow()===1)
		{
		var tosend=1;
		var loadurl1='/core?ind=3';

			$.ajax(
					
					{
						type:"GET",
						url: loadurl1,
					success: function(responseText){
						var reci=responseText;
						//alert(reci);
						if(reci==1)
							alert('Congratulations you have a bottom row');
						else if(reci==2)
							alert('some one else has won the bottom row ');
						else
							alert(' dont have a bottom row');
					},
					dataType:"text"}
			);
		//alert('you don\'t have a top row' );
		}
		else
			alert('you don\'t have a bottom row' );
});
	$('#fullhouse1').click(function(){
		totalArray = num.slice(0,idx);
		toNum();
		//$('#testValue').text(totalArray);
		//$('#testValue2').text(strikeNum);
		
		if(count1===15)
		{
		var tosend=1;
		var loadurl1='/core?ind=4';

			$.ajax(
					
					{
						type:"GET",
						url: loadurl1,
					success: function(responseText){
						var reci=responseText;
						//alert(reci);
						if(reci==1)
							alert('Congratulations you have a full house');
						//else if(reci==2)
							
						
					},
					dataType:"text"}
			);
		//alert('you don\'t have a top row' );
		}
		else
			alert('you don\'t have a full house' );
});
	
	
	//table 2
	
	$('.num2').click(function(){
		totalArray1 = num.slice(0,idx);
		//$('#testValue').text(totalArray);
		toNum1();
		var ch1 = $(this).text();
		//alert(ch1);
		ch1 = parseInt(ch1);
		//alert(ch1+10);
		//alert(hsd[1][2]);
		
	
			if(ch1){
				//alert(totalArray.indexOf(ch1));
				if(totalArray1.indexOf(ch1) >= 0){
					if(strikeNum1.indexOf(ch1) < 0){
						$(this).css('text-decoration', 'line-through');
						$(this).css('background', '#ffaabb');
						count2 = count2 + 1;
						strikeNum1[count2-1] = ch1;
						//$('#winner').text(strikeNum);
					}
				}
			}

		else{
			//code when it is blank cell		
		}
	});
		function checkTopRow_t(){
			//TO check the top row check if each of the element in the figure is striked out. 
			//get all the numbers of the top row
			//
			//$('#winner').text(totalArray);
			var count =0;
			var flag = 1;
			for(var i = 1;i<10;i++){
				loc = '#21_'+i;
				//alert($(loc).text());
				var val =parseInt( $(loc).text());
				
				if(val !=0){
					//val2 = parseInt(val);
					if((strikeNum1.indexOf(val)===-1 )|| (totalArray1.indexOf(val)===-1)){
						flag = 0;
					}
				}	
			}//end of for
			return flag;
		}//end function
		

		/*-----------------------------------------------------------------*/
		function checkMiddleRow_t(){
			//TO check the top row check if each of the element in the figure is striked out. 
			//get all the numbers of the top row
			//
			var count =0;
			var flag = 1;
			for(var i = 1;i<10;i++){
				loc = '#22_'+i;
				var val = parseInt($(loc).text());
				if(val !=0){
					//val2 = parseInt(val);
					if(strikeNum1.indexOf(val)===-1|| (totalArray1.indexOf(val)===-1)){
						flag = 0;
					}
				}	
			}//end of for
			return flag;
		}//end function
		 
		/*-----------------------------------------------------------------*/
		
		/*-----------------------------------------------------------------*/
		function checkBottomRow_t(){
			//TO check the top row check if each of the element in the figure is striked out. 
			//get all the numbers of the top row
			//
			var count =0;
			var flag = 1;
			for(var i = 1;i<10;i++){
				loc = '#23_'+i;
				var val = parseInt($(loc).text());
				if(val !=0){
					//val2 = parseInt(val);
					if(strikeNum1.indexOf(val)===-1|| (totalArray1.indexOf(val)===-1)){
						flag = 0;
					}
				}	
			}//end of for
			return flag;
		}//end function
		 
		/*-----------------------------------------------------------------*/
		
		//code to convert totalArray to num
		function toNum1(){
			for(var i in totalArray1){
				totalArray1[i] = +totalArray1[i];
			}
		}
		
		
		
		//code to check which numbers are present in the array
		$('#TopRow2').click(function(){
			//$('#testValue').text(strikeNum);
			totalArray1 = num.slice(0,idx);
			toNum1();
			//$('#testValue').text(totalArray);
			//$('#testValue2').text(strikeNum);
			
			if(checkTopRow_t()===1)
				{
				var tosend=1;
				var loadurl1='/core?ind=1';

					$.ajax(
							
							{
								type:"GET",
								url: loadurl1,
							success: function(responseText){
								var reci=responseText;
								//alert(reci);
								if(reci==1)
									alert('Congratulations you have a top row');
								else if(reci==2)
									alert('some one else has won the top row ');
								else
									alert(' you dont have a top row');
							},
							dataType:"text"}
					);
				//alert('you don\'t have a top row' );
				}else
					alert('you dont have top row');
		});
		
		$('#MiddleRow2').click(function(){
			totalArray1 = num.slice(0,idx);
			toNum1();
			//$('#testValue').text(totalArray);
			//$('#testValue2').text(strikeNum);
			
			if(checkMiddleRow_t()===1)
			{
			var tosend=1;
			var loadurl1='/core?ind=2';

				$.ajax(
						
						{
							type:"GET",
							url: loadurl1,
						success: function(responseText){
							var reci=responseText;
							//alert(reci);
							if(reci==1)
								alert('Congratulations you have a middle row');
							else if(reci==2)
								alert('some one else has claimed the middle row ');
							else
								alert(' dont have a middle row');
						},
						dataType:"text"}
				);
			//alert('you don\'t have a top row' );
			}else
				{
				alert('you don\'t have a middle row' );
				}
	});

		$('#BottomRow2').click(function(){
			totalArray1 = num.slice(0,idx);
			toNum1();
			//$('#testValue').text(totalArray);
			//$('#testValue2').text(strikeNum);
			
			if(checkBottomRow_t()===1)
			{
			var tosend=1;
			var loadurl1='/core?ind=3';

				$.ajax(
						
						{
							type:"GET",
							url: loadurl1,
						success: function(responseText){
							var reci=responseText;
							//alert(reci);
							if(reci==1)
								alert('Congratulations you have a bottom row');
							else if(reci==2)
								alert('some one else has claimed the bottom row ');
							else
								alert(' dont have a bottom row');
						},
						dataType:"text"}
				);
			//alert('you don\'t have a top row' );
			}
			else
				alert('you don\'t have a bottom row' );
	});
		$('#fullhouse2').click(function(){
			totalArray1 = num.slice(0,idx);
			toNum1();
			//$('#testValue').text(totalArray);
			//$('#testValue2').text(strikeNum);
			
			if(count2===15)
			{
			var tosend=1;
			var loadurl1='/core?ind=4';

				$.ajax(
						
						{
							type:"GET",
							url: loadurl1,
						success: function(responseText){
							var reci=responseText;
							//alert(reci);
							if(reci==1)
								alert('Congratulations you have a full house');
							//else if(reci==2)
								
							
						},
						dataType:"text"}
				);
			//alert('you don\'t have a top row' );
			}
			else
				alert('you don\'t have a full house' );
	});


	
});