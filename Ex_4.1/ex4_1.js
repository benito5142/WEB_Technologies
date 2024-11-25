document.getElementById('userDetailsForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nameInput = document.getElementById('userName');
    const emailInput = document.getElementById('userEmail');
    const ageInput = document.getElementById('userAge');
    const artistInput = document.getElementById('favoriteArtist');
    const genreInput = document.getElementById('userGenre');

    let isValid = true;

    if (!/^[a-zA-Z\s]+$/.test(nameInput.value)) {
        alert('Name should only contain letters and spaces.');
        isValid = false;
    }

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(emailInput.value)) {
        alert('Please enter a valid email address.');
        isValid = false;
    }

    if (ageInput.value <= 0) {
        alert('Age must be a positive number.');
        isValid = false;
    }

    if (isValid) {
        alert('Form submitted successfully!');
    }
});

// Simplified input shake effect
const inputs = document.querySelectorAll('.form-control');

inputs.forEach(input => {
    input.addEventListener('input', function() {
        // Shake effect with smoother animation
        input.style.transform = 'translateX(-5px)';
        setTimeout(() => {
            input.style.transform = 'translateX(5px)';
        }, 100);
        setTimeout(() => {
            input.style.transform = 'translateX(0)';
        }, 200);

        if (this.id === 'userName') {
            const nameMessage = document.getElementById('nameMessage');
            nameMessage.textContent = `Hi, ${this.value}! Ready to jam?`;
            nameMessage.style.display = this.value ? 'block' : 'none';
        } else if (this.id === 'favoriteArtist') {
            const artistMessage = document.getElementById('artistMessage');
            artistMessage.textContent = `Awesome choice! I love ${this.value} too!`;
            artistMessage.style.display = this.value ? 'block' : 'none';
        } else if (this.id === 'userGenre') {
            const genreMessage = document.getElementById('genreMessage');
            genreMessage.textContent = `Nice! ${this.value} is a great genre!`;
            genreMessage.style.display = this.value ? 'block' : 'none';
        }
    });
});
