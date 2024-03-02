const accArray = [];
var addData = document.getElementById("secondDiv")
addData.innerHTML = ""

document.querySelector(".btn1").addEventListener("click", () =>{

    var accId = document.getElementById("accountid").value;
    var accName = document.getElementById("accountName").value;
    var accType = document.getElementById("accountType").value;
    var balance = document.getElementById("balance").value;
    var createDate = document.getElementById("creationDate").value;
    
    const accObj = {
        id: accId,
        acName: accName,
        type: accType,
        amount: balance,
        date: createDate
    };

    accArray.push(accObj)

    alert("Object created as with details: " + accObj.id + " " + accObj.acName + " " + accObj.type)
    document.querySelector("#forms").reset();
})

document.querySelector(".btn2").addEventListener("click", () => {
    const table = document.createElement("table")

    const tableHead = document.createElement("thead")
    const trow = document.createElement("tr")

    // creating the headings of the table 
    Object.keys(accArray[0]).forEach(key =>{
        const th = document.createElement("th")
        th.textContent = key
        trow.appendChild(th)
    })

    tableHead.appendChild(trow);
    table.appendChild(tableHead)

    // creating the table body

    for (var i = 0; i < accArray.length; i++) {
        var row = table.insertRow(i + 1);

        for (var key in accArray[i]) {
          var cell = row.insertCell();
          cell.textContent = accArray[i][key];
        }
      }



    /*const tableBody = document.createElement("tbody")
    accArray.forEach(obj => {
        const row = document.createElement("tr")

        Object.values(obj).forEach(values => {
            const tableData = document.createElement("td")
            tableData.textContent = values
            row.appendChild(tableData)
        })

        tableBody.appendChild(row)
    })*/

    addData.appendChild(table)
})



