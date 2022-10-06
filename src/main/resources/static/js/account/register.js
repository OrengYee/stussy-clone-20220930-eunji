const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInputs = document.querySelectorAll(".account-input");

    let user = {    
        lastName:  accountInputs[0].value,
        firstName: accountInputs[1].value,
        email:     accountInputs[2].value,
        password : accountInputs[3].value
    }

    //JSON.stringify() => js객체를 json문자열로 변환.
    //JSON.parse()     => json문자열을 js객체로 변환.

    $.ajax({    
        async: false,                      //필수
        type: "post",                      //필수
        url: "/api/account/register",      //필수
        contentType: "application/json",   //전송할 데이터가 json인 경우
        data: JSON.stringify(user),        //전송할 데이터가 있으면
        dataType: "json",                  //json외 text 등을 사용할수 있지만 js
        success: (response) => {           //성공시에 실행될 메소드            
            console.log(response);
        },
        error: (error) => {                //실패시에 실행될 메소드           
            loadErrorMessage(error.responseJSON.data);
            console.log(error.responseJSON.data);

        }
    });

    
}

function loadErrorMessage(errors) {
    const errorList = document.querySelector(".errors");
    const errorMsgs = document.querySelector(".error-msgs");
    const errorsArray = Object.values(errors);

    errorMsgs.innerHTML = "";

    errorsArray.forEach(error => {  
        errorMsgs.innerHTML += `  
            <li>${error}</li>
        `;
    })

    errorList.classList.remove("errors-invisible");

}
    