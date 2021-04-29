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

function isNumber(evt){
  let charCode = (evt.which) ? evt.which : evt.keyCode;
  if (charCode != 46 && charCode > 31 
    && (charCode < 48 || charCode > 57))
  return false;
  return true;
}

function checkEndDate(){
  let startDate = document.getElementById("courseStartDate").value;
  let endDate = document.getElementById("courseEndDate").value;
  if(startDate > endDate){
    alert('교육종료일이 교육시작일보다 빠릅니다. 종료일자를 확인해주세요.');
  }
}

function fileAttachment(){
  const extensions = ['hwp', 'doc', 'docx', 'txt'];
  const fileMaxSize = 5*1024*1024;
  let fileExtension = document.getElementById("attachedFile").value.split(".").pop();
  let fileSize = document.getElementById("attachedFile").files[0].size;
  if ( (extensions.includes(fileExtension)) && (fileMaxSize >= fileSize) ){
    let fileName = document.getElementById("attachedFile").value.split("\\").pop();
    document.getElementById("file-label").innerHTML = fileName;
  }else {
    alert('첨부파일 확장자 혹은 크기를 확인 후 다시 첨부해주세요.')
  }
}

const register_button = document.getElementById("register-course-btn");
const form = document.getElementById("register-course-form");

register_button.addEventListener("click", ()=>{
    let data = new FormData(form);
    
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8081/course";

    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){
      }
    };
    xhr.open("POST", url, false);
    xhr.send(data);
});
