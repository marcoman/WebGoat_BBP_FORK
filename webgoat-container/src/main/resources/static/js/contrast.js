window.addEventListener('DOMContentLoaded', (event) => {
  var xhttp = new XMLHttpRequest();
  var ele = document.getElementById("contrast_info"); 
  xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
         // Typical action to be performed when the document is ready:
         ele.innerHTML = xhttp.responseText + '<br>Please check the "In Scope Areas" from the <a href="https://bugcrowd.com/contrast-security" target="_blank">Bugcrowd Project Page</a> before subbmiting an any issues.';
      }
  };
  xhttp.open("GET", "/WebGoat/service/contrast.mvc", true);
  xhttp.send();
});