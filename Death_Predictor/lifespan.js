// Function to check if age is within the range and gender is valid
function validateAgeAndGender(event) {
    var age = document.getElementById('Age').value;
    var gender = document.getElementById('country').value;

    // Check if age is between 10 and 100
    if (age < 1 || age > 100) {
        alert('Age must be between 1 and 100.');
        event.preventDefault();  // stop form submission
        return false;
    }

    // Check if gender is either "Male" or "Female"
    if (gender !== "Male" && gender !== "Female") {
        alert('Please select a valid gender (Male or Female).');
        event.preventDefault();  // stop form submission
        return false;
    }

    return true;
}

// Function to check food checkbox selection
function validateFoodSelection(event) {
    var checkboxes = document.querySelectorAll('input[name="food"]');
    var maxSelection = 5 // Max allowed selections
    var minSelection = 1;
    var checkedCount = 0;

    // count the checked boxes
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checkedCount++;
        }
    }

    // if less than 1 item is selected
    if (checkedCount < minSelection) {
        alert('You must select at least one food item.');
        event.preventDefault();  // Stop form submission
        return false;
    }

    // If more than 5 items are selected
    if (checkedCount > maxSelection) {
        alert('You can only select up to 5 food items.');
        event.preventDefault();  // Stop form submission
        return false;
    }

    return true;
}

// form submission event
var form = document.querySelector('form');
form.addEventListener('submit', function (event) {
    if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
        form.classList.add('was-validated');
    } else if (!validateAgeAndGender(event) || !validateFoodSelection(event)) {
        event.preventDefault();  // Stop form submission
    }
});
