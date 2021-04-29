// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  window.addEventListener('load', function () {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation')

    // Loop over them and prevent submission
    Array.prototype.filter.call(forms, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
  }, false)
})()

const firstapp_submit_button = document.getElementById("first-app-submit");
const form = document.getElementById("first-app-form");

firstapp_submit_button.addEventListener("click", ()=>{
  let entries = new FormData(form).entries();
  let params = new URLSearchParams(entries);
  let params_entries = Object.fromEntries(params);
  let data = JSON.stringify(params_entries);
  
  let xhr = new XMLHttpRequest();
  let url = "http://localhost:8081/applicants";

  xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){
        alert(data);
        }
    };
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send(data);
  });
