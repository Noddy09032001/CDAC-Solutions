// getting all the elements from the document

const firstname = document.getElementById("pname").value
const lastname = document.getElementById("lname").value
var email = document.getElementById("email").value
var confirmedMail = document.getElementById("confirm").value

var level = document.getElementsByName("level")
var trainingCost = document.getElementById("tc")
trainingCost.textContent = ""



// claculating the cost
document.querySelector("#btn1").addEventListener("click",() =>{
    var seminar = document.getElementById("seminarType").value
    var selectedOption;

      for (var i = 0; i < level.length; i++) {
        if (level[i].checked) {
          selectedOption = level[i].value;
          break;
        }
      }

    alert("" + seminar + "" + selectedOption)
    switch (seminar) {
        case "SOA":{
            if(selectedOption === "Introductory"){
                trainingCost.textContent = "Cost of Seminar: " + 2500; 
            }
            else if(selectedOption === "Intermediate"){
                trainingCost.textContent = "Cost of Seminar: " + 3500;
            }
            else{
                trainingCost.textContent = "Cost of Seminar: " + 6000;
            }
            break;
        }

        case "Design Patterns" :{
            if(selectedOption === "Introductory"){
                trainingCost.textContent = "Cost of Seminar: " + 4000; 
            }
            else if(selectedOption === "Intermediate"){
                trainingCost.textContent = "Cost of Seminar: " + 5500;
            }
            else{
                trainingCost.textContent = "Cost of Seminar: " + 8000;
            }
            break;
        }

        case "Business Intelligence":{
            if(selectedOption === "Introductory"){
                trainingCost.textContent = "Cost of Seminar: " + 5000; 
            }
            else if(selectedOption === "Intermediate"){
                trainingCost.textContent = "Cost of Seminar: " + 7000;
            }
            else{
                trainingCost.textContent = "Cost of Seminar: " + 10000;
            }
            break;
        }

        default:
            break;
    }
})

document.querySelector("#btn3").addEventListener("click", () =>{

    var setContent = document.getElementById("secondDiv")
    setContent.innerHTML = ""

    var fullname = firstname + "" + lastname
    alert(fullname)
    setContent.textContent = "Name: " + fullname + "Email: " + email + 
   ""

})