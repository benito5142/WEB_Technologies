function time() {
    setInterval(updateTime, 1000);
}

function updateTime() {
    const now = new Date();
    document.getElementById('timeDisplay').textContent = now.toLocaleTimeString();
    document.getElementById('timeDisplay').style.fontSize = "3rem";
    document.getElementById('timeDisplay').style.backgroundColor = "#7827e7";
    document.getElementById('timeDisplay').style.color = "black";
    document.getElementById('timeDisplay').style.padding = "10px";
    document.getElementById('timeDisplay').style.borderRadius = "10px";
}

// Cursor hover effects
const hoverParagraph = document.getElementById('hoverParagraph');
const cursorStatus = document.getElementById('cursorStatus');

hoverParagraph.onmouseenter = () => cursorStatus.textContent = 'Cursor is on the text';
hoverParagraph.onmouseleave = () => cursorStatus.textContent = 'Cursor is away from the text';

// Image hover effects
const hoverImage = document.getElementById('hoverImage');
const hoverText = document.getElementById('hoverText');

hoverImage.onmouseenter = () => {
    hoverImage.style.transform = 'translateY(10px)';
    hoverText.style.display = 'block';
};

hoverImage.onmouseleave = () => {
    hoverImage.style.transform = 'translateY(0)';
    hoverText.style.display = 'none';
};

// Background color change
document.body.onclick = () => {
    document.body.style.background = "black";
};
