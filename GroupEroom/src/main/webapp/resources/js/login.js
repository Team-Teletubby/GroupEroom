const id_Login_Box = document.querySelector('.id_Out_Box');
const password_Login_Box =  document.querySelector('.password_Out_Box');
const login_Id_Input_Box = document.querySelector('#Id');
const login_Password_Input_Box = document.querySelector('#Password');


login_Id_Input_Box.addEventListener('keyup', function(){
	console.log("움직인다");
    if(!login_Id_Input_Box.value == ''){
        id_Login_Box.classList.add('existence');  
    }else{  
        id_Login_Box.classList.remove('existence');  
    }
});

login_Password_Input_Box.addEventListener('keyup', function(){
    if(!login_Password_Input_Box.value == ''){
        password_Login_Box.classList.add('existence');  
    }else{  
        password_Login_Box.classList.remove('existence');  
    }
});