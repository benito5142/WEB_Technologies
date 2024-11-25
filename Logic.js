function toggleDropdown4() {
    var dropdown = document.getElementsByClassName("dropdown-content-4")[0];
    var ex4 = document.getElementById("ex4");
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "flex";
        dropdown.style.flexDirection = "column";
        dropdown.style.gap = "6px";

        ex4.style.borderBottom = "solid";
        ex4.style.borderWidth = "5px";
        ex4.style.borderBottomColor = "black";

    } 
    else {
        dropdown.style.display = "none";
        ex4.style.borderBottom = "None";
    }
}

function toggleDropdown5() {
    var dropdown = document.getElementsByClassName("dropdown-content-5")[0];
    var ex5 = document.getElementById("ex5");
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "flex";
        dropdown.style.flexDirection = "column";
        dropdown.style.gap = "6px";

        ex5.style.borderBottom = "solid";
        ex5.style.borderWidth = "5px";
        ex5.style.borderBottomColor = "black";

    } 
    else {
        dropdown.style.display = "none";
        ex5.style.borderBottom = "None";
    }
}
