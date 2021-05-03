const csrf_header = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
const csrf_token = document.querySelector('meta[name="_csrf"]').getAttribute('content');

const sending_email_buttons = document.getElementsByName("sending-email-btn");
const email_categories = document.getElementsByName("deliveredEmailCategory");
const course_no = document.getElementById("no").innerText;
const person_emails = document.getElementsByClassName("person-email");

for(let i=0; i<sending_email_buttons.length; i++){
  sending_email_buttons[i].addEventListener("click", ()=>{
    let xhr = new XMLHttpRequest();
    
    let category = email_categories[i].options[email_categories[i].selectedIndex].value;
    let person_name = document.getElementsByClassName("person-name")[i].innerText;
    let mail_title = document.getElementById(category+"_title").innerHTML;
    document.getElementById(category+"_mailto").innerText = person_name;
    let mail_message = document.getElementById(category+"_message").innerHTML;
    let person_email = person_emails[i].innerHTML;
    let url = "http://localhost:8081/api/email";
    
    const json = {
        "courseNo" : course_no,
          "address": person_email,
          "title": mail_title,
          "message" : mail_message,
          "category" : category
    };
    
    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){
        alert(mail_message);
        alert(person_name + "님께 " + category + "안내 메일이 발송되었습니다.");
      }
    };
    xhr.open("POST", url, true);
    xhr.setRequestHeader(csrf_header, csrf_token);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
    xhr.send(JSON.stringify(json));
  });
};