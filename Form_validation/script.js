function submitted(event) {
    event.preventDefault();

    const nameInput = document.getElementById('userName');
    const emailInput = document.getElementById('userEmail');
    const phoneInput = document.getElementById('userPhno');
    const ageInput = document.getElementById('userAge');
    const dobInput = document.getElementById('userDob');
    const genderInput = document.getElementById('userGender');

    let isValid = true;

    // Validation for input length
    if (nameInput.value.length > 30 || emailInput.value.length > 30 || dobInput.value.length > 30) {
        alert('Inputs should not exceed 30 characters.');
        isValid = false;
    }

    // Validate name (only letters and spaces)
    if (!/^[a-zA-Z\s]+$/.test(nameInput.value)) {
        alert('Name should only contain letters and spaces.');
        isValid = false;
    }

    // Validate email format
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(emailInput.value)) {
        alert('Please enter a valid email address.');
        isValid = false;
    }

    // Validate phone number (should be at least 10 digits)
    if (phoneInput.value.length === 10 || !/^\d+$/.test(phoneInput.value)) {
        alert('Phone number must be 10 digits.');
        isValid = false;
    }

    // Validate age (positive integer)
    if (!/^\d+$/.test(ageInput.value) || ageInput.value <= 0) {
        alert('Age must be a positive integer.');
        isValid = false;
    }
    if (!ageInput.value >= 100) {
        alert('How are you still alive!!!');
        isValid = false;
    }

    // Validate date of birth (basic format check for demonstration)
    if (!/^\d{2}\/\d{2}\/\d{4}$/.test(dobInput.value)) {
        alert('Please enter Date of Birth in DD/MM/YYYY format.');
        isValid = false;
    }

    if (isValid) {
        alert('Form submitted successfully!');
    }
}